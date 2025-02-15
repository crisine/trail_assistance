package com.assistance.trial.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assistance.trial.account.service.IAccountService;
import com.assistance.trial.articleboard.service.IArticleBoardService;
import com.assistance.trial.assistant.service.IAssistantRegistService;
import com.assistance.trial.command.AccountVO;
import com.assistance.trial.command.AssistantRegistVO;
import com.assistance.trial.command.EvalVO;
import com.assistance.trial.command.FileVO;
import com.assistance.trial.eval.service.IEvalService;
import com.assistance.trial.file.service.IFileService;

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

   
   
   // 성민호 0831 수정
   @Autowired
   private IFileService fileService;
   
   
   
   //공고 명 변수
   private String contents;
   
   private String select;
   



   //0830 최필규 수정
   //0825 나경민 수정
   ///조력자 공고 게시판 내용 가져오는 화면 
   @GetMapping("/articlelist")
   public String articlelist(Model model,HttpSession session, RedirectAttributes ra) {

      System.out.println("select : " + select);

      //개인/기관시 각각 해당되는 리스트 가져오기
      if(select == "개인") {

         //0901 최필규 추가
         if(articleservice.getSelectUserList().size() == 0) {
            System.out.println("개인 리턴한 사이즈 : " + articleservice.getSelectUserList().size());
            ra.addFlashAttribute("msg", "현재 모집중인 개인 조력자 공고가 없습니다!");
            return "redirect:/";
         } else {
            model.addAttribute("assistantarticle", articleservice.getSelectUserList());
            System.out.println(model);
            return "assistant/assistant_article_list";
         }

      } else {
         if(articleservice.getSelectAgencyList().size() == 0) {
            System.out.println("기관 리턴한 사이즈 : " + articleservice.getSelectAgencyList().size());
            ra.addFlashAttribute("msg", "현재 모집중인 기관 조력자 공고가 없습니다!");
            return "redirect:/";
         } else {
            model.addAttribute("assistantarticle", articleservice.getSelectAgencyList());
            System.out.println(model);
            return "assistant/assistant_article_list";
         }

      }

   }

   
   
   @PostMapping("/articlelist")
   public String articlelist(HttpServletRequest request,HttpSession session) {
	   System.out.println((AccountVO)session.getAttribute("login"));
      contents = request.getParameter("arti_article_title");
      return "redirect:/assistant/regist";
   }

   //신청서 화면
   @GetMapping("/regist")
   public String RegistPage(Model model,HttpSession session) {
	   
	   System.out.println((AccountVO)session.getAttribute("login"));
      model.addAttribute("contents", contents);
      return "assistant/assistant_regist";

   }
   

   //첫번째 화면에서 다음 버튼 클릭시
   @PostMapping("/regist")
   public String createPage(AssistantRegistVO vo,Model model,HttpSession session) {
	   System.out.println((AccountVO)session.getAttribute("login"));
      //현재 로그인한 계정의 account 테이블의 시퀀스 번호인(accid)를 얻기 위함
	  AccountVO login=(AccountVO)session.getAttribute("login");
	
      int loginAccId=accountservice.selectOne(login.getAccount()).getAccId();
      
      System.out.println("accid"+login.getAccId());
      System.out.println("getaccount"+login.getAccount());
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
   public String insertPage1(HttpSession session) {
	   System.out.println((AccountVO)session.getAttribute("login"));
      return "assistant/assistant_update";
   }

   //나경민 0824 수정
   //두번째 화면에서 접수 버튼 클릭시
   @PostMapping("/update")                      
   public String insertPage2(AssistantRegistVO vo,EvalVO evalvo,HttpSession session) {
	   System.out.println((AccountVO)session.getAttribute("login"));
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
      public void user_com_select(HttpSession session) {
   	   System.out.println((AccountVO)session.getAttribute("login"));
      }
      
      //0827 최필규 추가
      //유저 선택시 1을 담아서 전달
      @GetMapping("/userSelect")
      public String userSelect(Model model,HttpSession session) {
   	   System.out.println((AccountVO)session.getAttribute("login"));

         select = "개인";
         
         model.addAttribute("select", select);
         
         System.out.println(model);
         return"redirect:/assistant/articlelist";
      }
      
      //0827 최필규 추가
      //기관 선택시 2를 담아서 전달
      @GetMapping("/comSelect")
      public String comSelect(Model model,HttpSession session) {
   	   System.out.println((AccountVO)session.getAttribute("login"));
         select = "기관";
         model.addAttribute("select", select);
         
         System.out.println(model);
         return"redirect:/assistant/articlelist";
      }
    //0830 최필규 추가(파일 업로드)
    	//helper_edu_file 파일 업로드
    	@PostMapping("/upload1")
    	@ResponseBody
    	public String upload1(MultipartFile file) {
    		System.out.println("num->assistant_id : " + nums);
    		
    		//파일 업로드 hepler_edu_file
    		//날짜별로 폴더를 생성해서 파일을 관리
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    		Date date = new Date();
    		String fileloca = sdf.format(date);

    		//저장할 폴더 경로
    		String uploadPath = "/var/upload/" + fileloca;

    		File folder = new File(uploadPath);
    		if(!folder.exists()) {
    			folder.mkdirs(); //폴더가 존재하지 않는다면 생성하라.
    		}

    		//원본 파일명.
    		String fileRealName = file.getOriginalFilename();

    		//파일명을 고유한 랜덤 문자로 생성.
    		UUID uuid = UUID.randomUUID();
    		String uuids = uuid.toString().replaceAll("-", "");

    		//확장자를 추출합니다.
    		String fileExtension = fileRealName.substring(fileRealName.indexOf("."), fileRealName.length());

    		System.out.println("저장할 폴더 경로: " + uploadPath);
    		System.out.println("실제 파일명: " + fileRealName);
    		System.out.println("폴더명: " + fileloca);
    		System.out.println("확장자: " + fileExtension);
    		System.out.println("고유랜덤문자: " + uuids);

    		String fileName = uuids + fileExtension;
    		System.out.println("변경해서 저장할 파일명: " + fileName);

    		//업로드한 파일을 서버 컴퓨터 내의 지정한 경로에 실제로 저장.
    		File saveFile = new File(uploadPath + "/" + fileName);
    		try {
    			file.transferTo(saveFile);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    	// 성민호 20220831 추가
    		nums = assistantservice.getAll().getAssistant_id();	// 여기선 안 얻어와져서 넣었습니다
    		FileVO vo = new FileVO();
    		
    		vo.setFileSaveName(fileName);
    		vo.setFileOriginalName(fileRealName);
    		vo.setFilePath(uploadPath); // 이거 문제생길 수 있으니 잘 살필 것
    		
    		System.out.println("파일 넣기 전에 검사 : " + vo);

    		fileService.insertFile(vo);
    		
    		vo = fileService.selectOneBySaveName(fileName);
    		
    		System.out.println("넣고난 후의 파일 얻어와지는지 검사 : " + vo);
    		
    		AssistantRegistVO assistantVO = assistantservice.selectOne(nums);
    		assistantVO.setHepler_edu_file_id(vo.getFileId());
    		
    		System.out.println("조력자 번호 기준으로 얻어와지는지 검사 : " + assistantVO);
    		System.out.println("조력자 파일 id 번호 저장되었는지? : " + assistantVO.getHepler_career_file_id());
    		
    		/*
    		 * 그리고 이제 바뀐 assistantVO 내용을 업데이트 해줄 것. fileId는 커밋이 안 되었으므로.
    		 */
    		
    		System.out.println("해당 assistant의 edu 파일 아이디 업뎃 전 : " + assistantVO);
    		assistantservice.updateEduFileId(assistantVO);
    		System.out.println("해당 assistant의 edu 파일 아이디 업뎃 후 : " + assistantVO);
    		// 성민호 22-08-31 추가작성 종료

    		//DB에 insert 작업을 실행.
    		//DB에 저장할 이름 설정
    		String saveFileName = uploadPath + "/" + fileName;

    		assistantservice.upload1(saveFileName);

    		return "success";
    	}

    	//0830 최필규 추가(파일 업로드)
    	//파일 업로드 hepler_career_file
    	@PostMapping("/upload2")
    	@ResponseBody
    	public String upload2(MultipartFile file) {
    		System.out.println("num->assistant_id : " + nums);

    		//파일 업로드 hepler_edu_file
    		//날짜별로 폴더를 생성해서 파일을 관리
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    		Date date = new Date();
    		String fileloca = sdf.format(date);

    		//저장할 폴더 경로
    		String uploadPath = "/var/upload/" + fileloca;

    		File folder = new File(uploadPath);
    		if(!folder.exists()) {
    			folder.mkdirs(); //폴더가 존재하지 않는다면 생성하라.
    		}

    		//원본 파일명.
    		String fileRealName = file.getOriginalFilename();

    		//파일명을 고유한 랜덤 문자로 생성.
    		UUID uuid = UUID.randomUUID();
    		String uuids = uuid.toString().replaceAll("-", "");

    		//확장자를 추출합니다.
    		String fileExtension = fileRealName.substring(fileRealName.indexOf("."), fileRealName.length());

    		System.out.println("저장할 폴더 경로: " + uploadPath);
    		System.out.println("실제 파일명: " + fileRealName);
    		System.out.println("폴더명: " + fileloca);
    		System.out.println("확장자: " + fileExtension);
    		System.out.println("고유랜덤문자: " + uuids);

    		String fileName = uuids + fileExtension;
    		System.out.println("변경해서 저장할 파일명: " + fileName);

    		//업로드한 파일을 서버 컴퓨터 내의 지정한 경로에 실제로 저장.
    		File saveFile = new File(uploadPath + "/" + fileName);
    		try {
    			file.transferTo(saveFile);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// 성민호 20220831 추가
    		nums = assistantservice.getAll().getAssistant_id();	// 여기선 안 얻어와져서 넣었습니다
    		FileVO vo = new FileVO();
    		
    		vo.setFileSaveName(fileName);
    		vo.setFileOriginalName(fileRealName);
    		vo.setFilePath(uploadPath); // 이거 문제생길 수 있으니 잘 살필 것
    		
    		System.out.println("파일 넣기 전에 검사 : " + vo);

    		fileService.insertFile(vo);
    		
    		vo = fileService.selectOneBySaveName(fileName);
    		
    		System.out.println("넣고난 후의 파일 얻어와지는지 검사 : " + vo);
    		
    		AssistantRegistVO assistantVO = assistantservice.selectOne(nums);
    		assistantVO.setHepler_career_file_id(vo.getFileId());
    		
    		System.out.println("조력자 번호 기준으로 얻어와지는지 검사 : " + assistantVO);
    		System.out.println("조력자 파일 id 번호 저장되었는지? : " + assistantVO.getHepler_career_file_id());
    		
    		/*
    		 * 그리고 이제 바뀐 assistantVO 내용을 업데이트 해줄 것. fileId는 커밋이 안 되었으므로.
    		 */
    		
    		System.out.println("해당 assistant의 career 파일 아이디 업뎃 전 : " + assistantVO);
    		assistantservice.updateCareerFileId(assistantVO);
    		System.out.println("해당 assistant의 career 파일 아이디 업뎃 후 : " + assistantVO);
    		// 성민호 22-08-31 추가작성 종료
    		
    		//DB에 insert 작업을 실행.
    		//DB에 저장할 이름 설정
    		String saveFileName = uploadPath + "/" + fileName;

    		assistantservice.upload2(saveFileName);

    		return "success";
    	}

    	//0830 최필규 추가(파일 업로드)
    	//파일 업로드 hepler_license_file
    	@PostMapping("/upload3")
    	@ResponseBody
    	public String upload3(MultipartFile file) {
    		System.out.println("num->assistant_id : " + nums);

    		//파일 업로드 hepler_edu_file
    		//날짜별로 폴더를 생성해서 파일을 관리
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    		Date date = new Date();
    		String fileloca = sdf.format(date);

    		//저장할 폴더 경로
    		String uploadPath = "/var/upload/" + fileloca;

    		File folder = new File(uploadPath);
    		if(!folder.exists()) {
    			folder.mkdirs(); //폴더가 존재하지 않는다면 생성하라.
    		}

    		//원본 파일명.
    		String fileRealName = file.getOriginalFilename();

    		//파일명을 고유한 랜덤 문자로 생성.
    		UUID uuid = UUID.randomUUID();
    		String uuids = uuid.toString().replaceAll("-", "");

    		//확장자를 추출합니다.
    		String fileExtension = fileRealName.substring(fileRealName.indexOf("."), fileRealName.length());

    		System.out.println("저장할 폴더 경로: " + uploadPath);
    		System.out.println("실제 파일명: " + fileRealName);
    		System.out.println("폴더명: " + fileloca);
    		System.out.println("확장자: " + fileExtension);
    		System.out.println("고유랜덤문자: " + uuids);

    		String fileName = uuids + fileExtension;
    		System.out.println("변경해서 저장할 파일명: " + fileName);

    		//업로드한 파일을 서버 컴퓨터 내의 지정한 경로에 실제로 저장.
    		File saveFile = new File(uploadPath + "/" + fileName);
    		try {
    			file.transferTo(saveFile);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    	// 성민호 20220831 추가
    		nums = assistantservice.getAll().getAssistant_id();	// 여기선 안 얻어와져서 넣었습니다
    		FileVO vo = new FileVO();
    		
    		vo.setFileSaveName(fileName);
    		vo.setFileOriginalName(fileRealName);
    		vo.setFilePath(uploadPath); // 이거 문제생길 수 있으니 잘 살필 것
    		
    		System.out.println("파일 넣기 전에 검사 : " + vo);

    		fileService.insertFile(vo);
    		
    		vo = fileService.selectOneBySaveName(fileName);
    		
    		System.out.println("넣고난 후의 파일 얻어와지는지 검사 : " + vo);
    		
    		AssistantRegistVO assistantVO = assistantservice.selectOne(nums);
    		assistantVO.setHepler_license_file_id(vo.getFileId());
    		
    		System.out.println("조력자 번호 기준으로 얻어와지는지 검사 : " + assistantVO);
    		System.out.println("조력자 파일 id 번호 저장되었는지? : " + assistantVO.getHepler_career_file_id());
    		
    		/*
    		 * 그리고 이제 바뀐 assistantVO 내용을 업데이트 해줄 것. fileId는 커밋이 안 되었으므로.
    		 */
    		
    		System.out.println("해당 assistant의 license 파일 아이디 업뎃 전 : " + assistantVO);
    		assistantservice.updateLicenseFileId(assistantVO);
    		System.out.println("해당 assistant의 license 파일 아이디 업뎃 후 : " + assistantVO);
    		// 성민호 22-08-31 추가작성 종료

    		//DB에 insert 작업을 실행.
    		//DB에 저장할 이름 설정
    		String saveFileName = uploadPath + "/" + fileName;

    		assistantservice.upload3(saveFileName);

    		return "success";
    	}


}