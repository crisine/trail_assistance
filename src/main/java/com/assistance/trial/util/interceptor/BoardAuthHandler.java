
  package com.assistance.trial.util.interceptor;
 
  import java.io.PrintWriter;
  
  import javax.servlet.http.HttpServletRequest; import
  javax.servlet.http.HttpServletResponse; import
  javax.servlet.http.HttpSession;
  
  import org.springframework.web.servlet.HandlerInterceptor;
  
  import com.assistance.trial.command.AccountVO;
  
  public class BoardAuthHandler implements HandlerInterceptor {
  
  @Override public boolean preHandle(HttpServletRequest request,
  HttpServletResponse response, Object handler) throws Exception {
  

  String one_writer = request.getParameter("writer");
  HttpSession session = request.getSession();
  AccountVO vo = (AccountVO) session.getAttribute("login");
  

  
  if(vo != null) {
	  //  if(article_type.equals(vo.getType() ==1))
	    return true;
  
	   
  

 }
	  response.setContentType("text/html; charset=UTF-8"); 
  PrintWriter out = response.getWriter(); out.print("<script> \r\n");
  out.print("alert('로그인이 필요합니다.'); \r\n"); 
  out.print("history.back(); \r\n");
  out.print("</script>");
  
  out.flush();
  
  return false;
 
 

 
 }
  
  
  }
  

