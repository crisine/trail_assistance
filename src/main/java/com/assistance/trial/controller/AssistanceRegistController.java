package com.assistance.trial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assistance.trial.assistant.service.IAssistantRegistService;
import com.assistance.trial.command.AssistantRegistVO;

@Controller
@RequestMapping("/assistant")
public class AssistanceRegistController {

	
	@Autowired
	private IAssistantRegistService service;
	
	//신청서 화면
	@GetMapping("/regist")
	public String RegistPage() {
		return "assistant/assistant_regist";
	}
	
	//첫번째 화면에서 다음 버튼 클릭시
	@PostMapping("/regist")
	public String createPage(AssistantRegistVO vo) {
		service.insert(vo);
		
		return "redirect:/assistant/update";
	}
	//두번째 화면 
	@GetMapping("/update")
	public String insertPage() {
	
		return "assistant/assistant_update";
	}
	
	//두번째 화면에서 접수 버튼 클릭시
	@PostMapping("/update")
	public String insertPage(AssistantRegistVO vo) {
		service.update(vo);
		return "assistant/success";
	}
	
	@GetMapping("/test")
	public String tt() {
		return "assistant/test";
	}
	
}
