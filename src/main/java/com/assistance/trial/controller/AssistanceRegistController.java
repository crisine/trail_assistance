package com.assistance.trial.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistance.trial.account.service.IAccountService;
import com.assistance.trial.articleboard.service.IArticleBoardService;
import com.assistance.trial.assistant.service.IAssistantRegistService;
import com.assistance.trial.command.AccountVO;
import com.assistance.trial.command.AssistantRegistVO;
import com.assistance.trial.command.EvalVO;
import com.assistance.trial.eval.service.IEvalService;

@Controller
@RequestMapping("/assistant")
public class AssistanceRegistController {

	private int nums;
	private String checkedid;

	@Autowired
	private IAssistantRegistService assistantservice;

	@Autowired
	private IAccountService accountservice;

	// 나경민 0824 수정
	@Autowired
	private IEvalService evalservice;

	//나경민 0825 수정
	@Autowired
	private IArticleBoardService articleservice;

	//공고 명 변수
	private String contents;
	
	private int select;

	//0825 나경민 수정
	///조력자 공고 게시판 내용 가져오는 화면 
	@GetMapping("/articlelist")
	public String articlelist(Model model) {
		model.addAttribute("assistantarticle",articleservice.AllList());
		return "assistant/assistant_article_list";
	}
	
	
	@PostMapping("/articlelist")
	public String articlelist(HttpServletRequest request) {
		contents = request.getParameter("arti_article_title");
		return "redirect:/assistant/regist";
	}

	//신청서 화면
	@GetMapping("/regist")
	public String RegistPage(Model model) {
		model.addAttribute("contents", contents);
		return "assistant/assistant_regist";

	}

	//첫번째 화면에서 다음 버튼 클릭시
	@PostMapping("/regist")
	public String createPage(AssistantRegistVO vo,Model model,HttpSession session) {
		//현재 로그인한 계정의 account 테이블의 시퀀스 번호인(accid)를 얻기 위함
		AccountVO login=(AccountVO)session.getAttribute("login");
		int loginAccId=accountservice.selectOne(login.getAccount()).getAccId();
		//끝

		//공고 명 
		vo.setHelepr_articleboard(contents);
		
		//개인 /기관 선택한 1,or 2 값 저장되는 변수명
		vo.setHelper_cateogry_select(select);
		
		//insert할 때 account테이블의 시퀀스 키를 외래키로 사용하기 때문에 값을 셋팅함
		vo.setAcc_id(loginAccId);
		assistantservice.insert(vo);
		System.out.println("assistant regist insert  "+vo);


		//현재 assistant에 insert한 assistant테이블의 기본키 얻기
		nums=assistantservice.getAll().getAssistant_id();

		return "assistant/assistant_update";
	}

	//두번째 화면 
	@GetMapping("/update")
	public String insertPage1() {

		return "assistant/assistant_update";
	}

	//나경민 0824 수정
	//두번째 화면에서 접수 버튼 클릭시
	@PostMapping("/update")							 
	public String insertPage2(AssistantRegistVO vo,EvalVO evalvo) {

		//assistant 테이블의 기본키를 가져와서  셋팅하고 update 할때 사용 
		vo.setAssistant_id(nums);
		vo.setHelper_apply_status("접수");
		assistantservice.update(vo);
		
		//나경민 0824
		evalvo.setAssistantId(nums);
		evalservice.insertScore(evalvo);
		System.out.println("update vo +"+vo);
		return "redirect:/mypage/mypage_assistant_history";
	}

	
	
	
	   //0827 최필규 추가
	   //조력자 신청시 개인/기관 선택 화면 이동
	   @GetMapping("/category_select")
	   public void user_com_select() {
	      
	   }
	   
	   //0827 최필규 추가
	   //유저 선택시 1을 담아서 전달
	   @GetMapping("/userSelect")
	   public String userSelect(Model model) {

	      select = 1;
	      
	      model.addAttribute("select", select);
	      
	      System.out.println(model);
	      return"redirect:/assistant/articlelist";
	   }
	   
	   //0827 최필규 추가
	   //기관 선택시 2를 담아서 전달
	   @GetMapping("/comSelect")
	   public String comSelect(Model model) {
	      select = 2;
	      model.addAttribute("select", select);
	      
	      System.out.println(model);
	      return"redirect:/assistant/articlelist";
	   }





}
