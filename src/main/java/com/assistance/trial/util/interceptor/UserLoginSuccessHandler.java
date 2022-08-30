package com.assistance.trial.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class UserLoginSuccessHandler implements HandlerInterceptor{
 

	//컨트롤러 동작 이후에 실행되는 핸들러 (postHandle) 오버라이딩
	//  /login 요청으로 들어올 때 실행되도록 xml 파일에 빈으로 등록 후 매핑
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		
	}
}
