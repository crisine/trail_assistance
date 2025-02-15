<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



    
    <!--개인 디자인 추가-->
   
 
    <link href="${pageContext.request.contextPath }/resources/css1/list_style.css" rel="stylesheet">
 



<%@ include file="../include/header.jsp" %>

  
        <div class="container-fluid" id="wrapper">
            <div class="row">
            	
    
<div class="col-md-2" id="menu-nav">
            	 <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"></h3>
                    <i class="glyphicon glyphicon-leaf"></i>
                    <span>고객 센터</span>
                </div>
                <!-- 사이드바 메뉴목록1 -->
                <ul class="list-group">
                    <li class="list-group-item"><a href="<c:url value='/noticeboard/list' />">>공지사항</a></li>
                   <li class="list-group-item"><a
					href="<c:url value='/faqboard/list' />">>FAQ</a></li>
                    <li class="list-group-item"><a href="<c:url value='/oneboard/list' />">>1:1 문의</a></li>
                </ul>
            </div>
            	
            	</div>
   
            	
                <div class="col-md-8 board-table">
                   <div class="titlebox">
                            <h3>1:1문의</h3>
                        </div>


                    <form action="<c:url value='/oneboard/list' />">
                        <div class="sear-wrap ">
                          <div class="md1"> <button type="submit"  class="btn btn-info sear-btn">검색</button> </div>
                           <div class="md2"> <input type="text" name="keyword" class="form-control search-input" value="${pc.paging.keyword}" > </div>
                            <div class="md3"><select class="form-control search-select" name="condition">
                                <option value="one_title" ${pc.paging.condition == 'one_title' ? 'selected' : '' }>제목</option>
                                <option value="one_content" ${pc.paging.condition == 'one_content' ? 'selected' : '' }>내용</option>
                            	<option value="one_writer" ${pc.paging.condition == 'one_writer' ? 'selected' : '' }> 작성자 </option>
                            	<option value="one_cate_one" ${pc.paging.condition == 'one_cate_one' ? 'selected' : '' }> 문의 유형  </option>
                            </select>
                        </div>
                        
                        </div>
                      </form>
                        <table class="table table-bordered table-hover">
                            <thead>
                            
                                <th>문의 유형</th>
                                
                                <th>작성자</th>
                                <th class="one_title">제목</th>
                               
                                 <c:if test="${login.type == 1}">
                                <th>등록 날짜</th>
                                <th>수정 날짜</th>
                              </c:if>
                            </thead>
                            <tbody>
                            <c:forEach var ="vo" items="${oneList}">
                             <c:if test="${login.type == 1 || login.account == vo.one_writer}">
                                <tr>
                               
                                    
                                  
                                    
                                     <td>${vo.one_cate_one}</td>

                                     <td>${vo.one_writer}</td>
                                    
                                    <td>
                                    <a href="<c:url value='/oneboard/view/${vo.one_id}${pc.makeURI(pc.paging.pageNum)}' />"> ${vo.one_title}</a>
                                    &nbsp;&nbsp;&nbsp;
                                   
                                    </td>
                                  
                                    <c:if test="${login.type == 1 }">
                                     <td><fmt:formatDate value="${vo.one_regdate}" pattern="yyyy-MM-dd HH:mm" /></td>
                                     <td><fmt:formatDate value="${vo.one_updatedate}" pattern="yyyy-MM-dd HH:mm" /></td>
                                        </c:if>
								
                                </tr>
                                </c:if>
                             </c:forEach>
                            </tbody>
                        </table>
						
						      <form action="<c:url value='/oneboard/list' />" name="pageForm">
                        <div class="text-center clearfix">
                            <hr>
                            <ul id="pagination" class="pagination pagination-sm">
                            <c:if test="${pc.prev}">
                                <li><a href="#" data-pagenum="${pc.beginPage-1}">이전</a></li>
                                </c:if>
							
							<c:forEach var="num" begin="${pc.beginPage}" end="${pc.endPage}">
                                <li class="${pc.paging.pageNum == num ? 'active' : '' }"><a href="#" data-pagenum="${num}">${num}</a></li>
                              </c:forEach>  
                              
                                <c:if test="${pc.next}">
                                <li><a href="#" data-pagenum="${pc.endPage+1}">다음</a></li>
                                </c:if>
                            </ul>
                          
                          <c:if test="${login != null && login.type == 0 }">
                            <button type="button" class="btn btn-info" onclick="location.href='<c:url value="/oneboard/write" />'">글 등록</button>
          						 </c:if>
                        </div>
				
				<!-- 페이지 관련 버튼(이전 , 다음, 페이지번호)을 클릭 시 같이 숨겨서 보내줄 공통 값 선언  -->
				<input type="hidden" name="pageNum" value="${pc.paging.pageNum}">
				<input type="hidden" name="cpp" value="${pc.paging.cpp}">
				<input type="hidden" name="condition" value="${pc.paging.condition}">
				<input type="hidden" name="keyword" value="${pc.paging.keyword}"> 
				
			   </form>
                  
                  
                </div>
                <div class="col-md-2"></div>
            </div>
      </div>
      
   
  
 <script>
	
 $(function() {
 		
 		 const msg = '${msg}';
 		if(msg !== ''){
 			alert(msg);
 		} 
 	

 		
 		$('#pagination').on('click', 'a', function(e){
 			e.preventDefault(); //a태그의 고유기능 중지.
 			
 			
 			const value = $(this).data('pagenum'); 
 			console.log(value);
			 
 		
 			document.pageForm.pageNum.value = value;
 			document.pageForm.submit();
 		
 		});
 		$('keywordInput').keydown(function(e){
 			if(e.keyword === 13) {
 				$('#pagination').click();
 			}
 		});
 		
 		
 		}); //end jQuery
		

 </script>
 
 
 

    


<%@ include file="../include/footer.jsp" %>


   

</body>
</html>



 

 
 
 
 
 
 
 
 
 
 
 
 
 
 