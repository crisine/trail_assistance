package com.assistance.trial.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserAuthHandler implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session=request.getSession();

		if(session.getAttribute("login") ==null) {
			response.sendRedirect(request.getContextPath()+"/account/login");
			return false; //false : 컨트롤러 진입 막음
		}





		return true;  //컨트롤러로 정상적으로 넘어감 

	}
}
