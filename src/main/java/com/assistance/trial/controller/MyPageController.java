package com.assistance.trial.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assistance.trial.account.service.IAccountService;
import com.assistance.trial.command.AccountVO;
import com.assistance.trial.command.AssistantRegistVO;
import com.assistance.trial.eval.service.IEvalService;
import com.assistance.trial.mypage.service.IMyPageService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	private IMyPageService service;

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IEvalService evalService;

	//마이페이지 접근 확인 및 회원탈퇴를 위한 것
	//	@Autowired
	//	private IUserService userService;


	//mypage_assistant_history 조력자 신청 현황 조회 처리
	//	@GetMapping("/mypage_assistant_history")
	//	public String applyHistory(PageVO vo, Model model, HttpSession session) {
	//
	//		System.out.println(vo);
	//
	//		//세션 
	//		AccountVO login = (AccountVO) session.getAttribute("login");
	//		int loginAcc = accountService.selectOne(login.getAccount()).getAccId();
	//		System.out.println(loginAcc);
	//
	//
	//		PageCreator pc = new PageCreator();
	//		pc.setPaging(vo);
	//		pc.setArticleTotalCount(service.getTotal(vo));
	//		System.out.println("컨트롤러 gettotal호출");
	//
	//		System.out.println(pc);
	//		vo.setAcc_id(loginAcc);
	//		System.out.println("규명용 : "  +  vo);
	//		model.addAttribute("mypageList", service.getList(vo));
	//		model.addAttribute("pc", pc);
	//		return "mypage/mypage_assistant_history";
	//
	//		//세션에서 로그인 정보 가져오기
	//		AccountVO login = (AccountVO) session.getAttribute("login");
	//
	//		//loginAcc에 acc_id 값 넣기.
	//		int loginAcc = accountService.selectOne(login.getAccount()).getAccId();
	//		System.out.println("loginAcc : " + loginAcc);
	//
	//		model.addAttribute("mypageList", service.test(loginAcc));
	//		model.addAttribute("test", service.test(loginAcc).getAssistantRegist());
	//
	//		System.out.println("매퍼의 리턴값 : " + model);
	//		return "mypage/mypage_assistant_history";
	//	}

	//mypage_assistant_history 조력자 신청 현황 조회 처리
	@GetMapping("/mypage_assistant_history")
	public String test(Model model, HttpSession session) {

		//세션 처리
		AccountVO login = (AccountVO) session.getAttribute("login");

		//loginAcc에 acc_id 값 넣기.
		int loginAcc = accountService.selectOne(login.getAccount()).getAccId();
		System.out.println("loginAcc : " + loginAcc);

		AccountVO vo = service.getList(loginAcc);

		model.addAttribute("mypageList", vo);

		System.out.println("controlloer vo "+vo);

		return "mypage/mypage_assistant_history";
	}

	//0825 최필규 수정
	//mypage_assistant_detail  조력자 신청 현황 상세보기 처리
	@GetMapping("/getApplyDetail/{assistant_id}") 
	public String getApplyDetail(@PathVariable int assistant_id, Model model,HttpSession session) {


		model.addAttribute("mypageDetail", service.getApplyDetail(assistant_id));


		model.addAttribute("eval", evalService.selectOne(assistant_id));

		return "mypage/mypage_assistant_detail";
	}


	//0825 최필규 수정
	//메인페이지 비밀번호 확인페이지 이동
	@GetMapping("/mypagePasswordAuth")
	public String mypagePasswordAuth(Model model, HttpSession session) {

		//loginId에 account 테이블 아이디 값 넣기.
		//			String loginId = accountService.selectOne(login.getAccount()).getAccount();
		//			System.out.println("loginId : " + loginId);

		//로그인 정보를 가저오기 위한 세션
		AccountVO login = (AccountVO) session.getAttribute("login");

		//userId에  세션의 account값 저장
		String userId = login.getAccount();


		model.addAttribute("loginId", userId);

		//아이디값 마이페이지 비밀번호 확인 페이지에 넘겨주기
		return "mypage/mypage_password_auth";
	}

	//0825 최필규 수정
	//메인페이지 비밀번호 체크
	@ResponseBody
	@PostMapping("/pwCheck")
	public String pwCheck(@RequestBody AccountVO vo,HttpSession session) {

		int result = accountService.pwCheck(vo);

		if(result == 1) {
			return "ok";
		} else {
			return "duplicated";
		}
	}
	//0825 최필규 수정
	//비밀번호 일치시 마이페이지 이동처리
	@PostMapping("/pwSuccess")
	public String pwSuccess(HttpSession session) {

		return "redirect:/mypage/mypage_assistant_history";

	}


	// 회원 정보 얻어오기
	@GetMapping("/mypage_update_info/{assistant_id}")
	public String getInfo(Model model, HttpSession session, @PathVariable int assistant_id) {
		
		System.out.println(assistant_id);
		
		//세션 처리
		AccountVO login = (AccountVO) session.getAttribute("login");

		//loginAcc에 acc_id 값 넣기.
		int loginAcc = accountService.selectOne(login.getAccount()).getAccId();

		AccountVO vo = service.getHelperInfo(loginAcc);

		model.addAttribute("helper", vo);
		
		AssistantRegistVO astVo = service.getAstInfo(assistant_id);

		model.addAttribute("astVo", astVo);
		return "mypage/mypage_update_info";
	}


	// 회원 정보 수정
	@PostMapping("/mypage_update_fin")
	public String updateInfo(AssistantRegistVO vo, RedirectAttributes ra,HttpSession session) {
		System.out.println("메서드 호출");
		System.out.println("업데이트 정보 : " + vo);
		service.updateInfo(vo);
		return "redirect:/mypage/mypage_assistant_history";
	}

}





























