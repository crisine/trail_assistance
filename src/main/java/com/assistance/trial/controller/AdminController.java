package com.assistance.trial.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assistance.trial.account.service.IAccountService;
import com.assistance.trial.admin.service.IAdminService;
import com.assistance.trial.assistant.service.IAssistantRegistService;
import com.assistance.trial.command.AccountVO;
import com.assistance.trial.command.AgencyVO;
import com.assistance.trial.command.AssistantRegistVO;
import com.assistance.trial.command.EvalVO;
import com.assistance.trial.command.FileVO;
import com.assistance.trial.command.FormVO;
import com.assistance.trial.eval.service.IEvalService;
import com.assistance.trial.file.service.IFileService;
import com.assistance.trial.util.PageCreator;
import com.assistance.trial.util.PageVO;



@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;


	@Autowired
	private IAssistantRegistService assistantService;

	@Autowired
	private IEvalService evalService;

	@Autowired
	private IAccountService accountService;
	
	//0831
	@Autowired
	private IFileService fileService;

	/* ---------------------------------------------------최필규 작성 시작--------------------------------------------------- */

	//조력자 신청기관 관리 조회
	@GetMapping("/admin_agency_list")
	public String comAdminList(PageVO vo, Model model,HttpSession session) {
		System.out.println(vo);

		PageCreator pc = new PageCreator();
		pc.setPaging(vo);
		pc.setArticleTotalCount(adminService.getComTotal(vo));

		System.out.println(pc);

		model.addAttribute("comList", adminService.getComList(vo));
		model.addAttribute("pc", pc);
		return "admin/admin_agency_list";
	}

	//조력자 신청기관 관리 상세 조회
	@GetMapping("/comAdminDetail/{comNo}")
	public String comAdminDetail(@PathVariable int comNo, Model model, 
			@ModelAttribute("p") PageVO vo,HttpSession session) {

		System.out.println(comNo);

		model.addAttribute("comDetail", adminService.getComDetail(comNo));
		return "admin/admim_agency_detail";
	}

	//기관 등록 화면 이동
	@GetMapping("/admin_agency_regist")
	public String com_admin_regist(HttpSession session) {
		return "admin/admin_agency_regist";
	}

	//기관 이름 중복확인
	@ResponseBody
	@PostMapping("/comNameCheck")
	public String comNameCheck(@RequestBody String comNameChk) {
		int result = adminService.comNameCheck(comNameChk);
		if(result == 1) {
			return "duplicated";
		} else {
			return "ok";
		}
	}

	//기관 등록
	@PostMapping("/comRegist")
	public String comRegist(AgencyVO vo, RedirectAttributes ra,HttpSession session) {
		adminService.comRegist(vo);
		ra.addFlashAttribute("msg", "기관이 정상적으로 등록되었습니다!");
		System.out.println("기관 정보 등록되었음을 확인"+vo);
		return "redirect:/admin/admin_agency_list";
	}

	//기관 수정 화면으로 이동
	@GetMapping("/comModify")
	public String comModify(int comNo, Model model, @ModelAttribute("p") PageVO vo,HttpSession session) {
		model.addAttribute("comDetail", adminService.getComDetail(comNo));
		return "admin/admin_agency_update";
	}

	//기관 정보 수정 처리
	@PostMapping("/comUpdate")
	public String comUpdate(AgencyVO vo, RedirectAttributes ra,HttpSession session) {
		adminService.comUpdate(vo);

		ra.addFlashAttribute("updateMsg", "수정이 완료되었습니다.");

		return "redirect:/admin/comAdminDetail/" + vo.getComNo();
	}

	//기관 삭제 처리
	@ResponseBody
	@PostMapping("/comDelete")
	public String comDelete(@RequestBody int comNo, RedirectAttributes ra) {
		adminService.comDelete(comNo);

		return "comDelSuccess";
	}

	//조력자 신청자 관리 조회 화면 0825 추가
	//세션값에 assistant_id 뭍혀놓기
	//mypage_assistant_history 조력자 신청 현황 조회 처리 (08.24 작성)
	@GetMapping("/manage_assistant_history")
	public String applyHistory(PageVO vo, Model model, HttpSession session) {

		//관리자 외 접근 금지 세션 처리
		//로그인 했을때 작성자와 관리자가 구분되어 메뉴를 보여준다면 필요 없음.
		//			if(session.getAttribute("login") == null) {
		//				model.addAttribute("msg", "notAdmin");
		//				return "/admin/manage_assistant_history";
		//			} else {
		//				
		//			}

		//관리자 외 접근 금지 세션 처리
		//로그인 했을때 작성자와 관리자가 구분되어 메뉴를 보여준다면 필요 없음.
		//새션에서 로그인 정보 객체로 받기
		AccountVO login = (AccountVO) session.getAttribute("login");

		//loginType에 account 테이블 type 값 넣기.
		int loginType = accountService.selectOne(login.getAccount()).getType();
		System.out.println("loginType : " + loginType);

		//로그인 계정의 타입을 확인하여 일반 회원이면 돌려보냄
		if (loginType != 1) {
			model.addAttribute("msg", "notAdmin");
			return "/admin/manage_assistant_history";
		}

		System.out.println(vo);

		PageCreator pc = new PageCreator();
		pc.setPaging(vo);
		pc.setArticleTotalCount(adminService.getAssisTotal(vo));
		System.out.println("컨트롤러 gettotal호출");

		System.out.println(pc);
		model.addAttribute("assisList", adminService.getAssisList(vo));

		System.out.println(model);

		model.addAttribute("pc", pc);
		return "admin/manage_assistant_history";

	}










	/* ---------------------------------------------------최필규 작성 끝--------------------------------------------------- */


	// 성민호 작성 시작
	
	// 2022-08-31 성민호 다운로드 기능 추가
		@GetMapping("/fileDownload")
		public void fileDownload(@RequestParam("fileId") int id,
								HttpServletResponse response) {
			
			System.out.println("파일다운로드 메서드 초입 체크");
			System.out.println("fileId 체크 : " + id);
			
			FileVO vo = fileService.selectOne(id);
			
			System.out.println("다운로드하려는 파일VO 체크 : " + vo);
			
		    Map<String, Object> fileMap = new HashMap<String, Object>();
			
		    fileMap.put("filePath", vo.getFilePath() + File.separator);
		    fileMap.put("fileSaveName", vo.getFileSaveName());
		    fileMap.put("fileOriginalName", vo.getFileOriginalName());
		    
		    System.out.println("파일다운로드 메서드 반환 직전 체크");
			
		    try {
	        	String path = vo.getFilePath() + "/" + vo.getFileSaveName();
	        	
	        	File file = new File(path);
	        	response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
	        	
	        	FileInputStream fileInputStream = new FileInputStream(path); // 파일 읽어오기 
	        	OutputStream out = response.getOutputStream();
	        	
	        	int read = 0;
	                byte[] buffer = new byte[1024];
	                while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
	                    out.write(buffer, 0, read);
	                }
	                
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
		    
		    //return new ModelAndView("fileDownload", "fileMap", fileMap);
		}
	
	
	
	// 조력자 '관리' 누를 시, 상세보기로 이동
	// 2022-08-26 성민호 추가
	@GetMapping("/manage_helper_apply/{assistant_id}")
	public String moveToManageHelperApply(@PathVariable int assistant_id,
			HttpSession session) {

		System.out.println("눌린거 얘 맞나 체크 : " + assistant_id);

		AssistantRegistVO assistantVo = assistantService.selectOne(assistant_id);
		EvalVO evalVo = evalService.selectOne(assistant_id);

		System.out.println("manage_helper_apply로 보내는 assistant 정보 : " + assistantVo);
		System.out.println("manage_helper_apply로 보내는 eval 정보 : " + evalVo);

		session.setAttribute("assistant", assistantVo);
		session.setAttribute("eval", evalVo);

		return "admin/manage_helper_apply";
	}

	/*
		 	지금 이 메서드에서 해야 하는 것.

		 	1. 현재 프론트에 뿌릴 조력자의 기본정보는 고정으로 갈 것임
		 	2. 그러나 평정기준표 점수 불러오는것은 helper_id 기준으로 가져와야 함
		 	3. helper_id는 account 기준으로 가져오므로,
		 	account 세션을 땡겨와서 account(유저아이디) 속성을 통해,
		 	helper DB에 질의를 날려야 함.
	 */
	@GetMapping("/manage_helper_apply")
	public String manageHelperApplyGet(HttpSession session,
			Model model) {
		System.out.println("/manage_helper_apply GET 요청");

		if (session.getAttribute("login") == null) {
			model.addAttribute("msg", "notLogin");
			return "/admin/manage_helper_apply";
		}

		/*
		 * // acc_id 기준으로 assistant_id 매칭시켜서 vo를 떼와야 함. 그리고 그것을 세션에 묻혀서 보내야 함. AccountVO
		 * accVo = (AccountVO)session.getAttribute("login");
		 * System.out.println("/manage_helper_apply 이동 시 세션 정보 검사 : " + accVo);
		 * 
		 * EvalVO evalVo = null; AssistantRegistVO assistVo = null; FormVO formVo =
		 * null;
		 * 
		 * // 로그인 정보가 존재 할 때에만 if (accVo != null &&
		 * assistantService.selectOne(accVo.getAccId()) != null) {
		 * 
		 * assistVo = assistantService.selectOne(accVo.getAccId()); evalVo =
		 * evalService.selectOne(assistVo.getAssistant_id()); formVo =
		 * formService.selectOne(accVo.getAccId()); }
		 * 
		 * System.out.println("프론트로 보내기 전 검사 (AssistVO) : " + assistVo);
		 * System.out.println("프론트로 보내기 전 검사 (EvalVO) : " + evalVo);
		 * System.out.println("프론트로 보내기 전 검사 (FormVO) : " + formVo);
		 * 
		 * if (evalVo != null) { session.setAttribute("eval", evalVo);
		 * session.setAttribute("assistant", assistVo); session.setAttribute("form",
		 * formVo); } else { model.addAttribute("msg", "noInfo"); }
		 */

		return "/admin/manage_helper_apply";
	}

	@ResponseBody
	@PostMapping("/manage_helper_apply")
	public String manageHelperApply(@RequestBody FormVO vo) {
		System.out.println("manage_helper_apply 이동요청");
		System.out.println("프론트에서 받아온 FormVO 출력 : " + vo);

		int assistantId = vo.getAssistantId();
		System.out.println("업데이트하려는 assistantId의 값 : " + assistantId);
		AssistantRegistVO assistantVo = assistantService.selectOne(assistantId);
		
		// 상태랑 코멘트 업데이트
		assistantVo.setHelper_apply_status(vo.getAssistantStatus());
		assistantVo.setHelper_status(vo.getRequirements());
		
		System.out.println("수정된 assistantVo의 값 : " + assistantVo);
		
		assistantService.update(assistantVo);
		

		return "/admin/manage_helper_apply";
	}

	@GetMapping("/manage_helper_assign")
	public String manageHelperAssign(HttpSession session) {
		return "/admin/manage_helper_assign_list";
	}

	// 2022-08-26 성민호 수정
	@ResponseBody
	@PostMapping("/score_update")
	public void scoreUpdate(@RequestBody EvalVO vo) {

		System.out.println("/score_update POST 요청");
		System.out.println("넘어온 점수 객체 확인차 출력 : " + vo.toString());

		// 기존 가입 시에 0점으로 꽉 채운 테이블이 생기니까, 맞는 녀석만 찾아서 업데이트 하면 됨.
		evalService.updateScore(vo);
	}
	// 성민호 작성 끝






}
























