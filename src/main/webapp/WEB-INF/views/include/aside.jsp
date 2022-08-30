<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>header</title>
    <script src="https://kit.fontawesome.com/89b715172c.js" crossorigin="anonymous">
    </script>


	  <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>

</head>
<body>
	 
       <div class="col-md-2" id="menu-nav">
            <!-- 사이드 바 메뉴-->
            <!-- 패널 타이틀1 -->
            
            
            
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"></h3>
                    <i class="glyphicon glyphicon-leaf"></i>
                    <span>고객 센터</span>
                </div>
                <!-- 사이드바 메뉴목록1 -->
                <ul class="list-group">
                    <li class="list-group-item"><a href="<c:url value='/noticeboard/list' />">>공지사항</a></li>
                    <li class="list-group-item"><a href="<c:url value='/faqboard/list' />">>FAQ</a></li>
                    <li class="list-group-item"><a href="<c:url value='/oneboard/list' />">>1:1 문의</a></li>
                </ul>
            </div>





  </div>
 


</body>
</html>