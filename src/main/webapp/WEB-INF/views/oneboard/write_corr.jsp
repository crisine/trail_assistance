<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<link
	href="${pageContext.request.contextPath }/resources/css1/view_style.css"
	rel="stylesheet">




</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<section>


		<div class="container-fluid">

			<div class="col-md-2" id="menu-nav">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title"></h3>
						<i class="glyphicon glyphicon-leaf"></i> <span>고객 센터</span>
					</div>
					<!-- 사이드바 메뉴목록1 -->
					<ul class="list-group">
						<li class="list-group-item"><a
							href="<c:url value='/noticeboard/list' />">>공지사항</a></li>
						<li class="list-group-item"><a
							href="<c:url value='/faqboard/list' />">>FAQ</a></li>
						<li class="list-group-item"><a
							href="<c:url value='/oneboard/list' />">>1:1 문의</a></li>
					</ul>
				</div>

			</div>
			<div class="row">


				<div class="board-hon">
					<div class="col-md-8 board-table">
				





						<div class="col-xs-12 col-md-12 write-wrap">

							<div class="titlebox">
								<h3>1:1문의 글 수정</h3>
							</div>

							<form action="<c:url value='/oneboard/oneUpdate' />"
								method="post" name="updateForm">

								<div>
									<label>DATE</label>
									<c:if test="${one.one_updatedate == null}">
										<p>${one.one_regdate}</p>
									</c:if>
									<c:if test="${one.one_updatedate != null}">
										<p>${one.one_updatedate}</p>
									</c:if>
								</div>
								<div class="form-group">
									<label>작성자</label> <input class="form-control"
										name='one_writer' value="${one.one_writer}" readonly>
								</div>



								<div class="form-group">
									<label>문의 유형 1</label> <input class="form-control"
										name='one_cate_one' value="${one.one_cate_one}">
								</div>



								<div class="form-group">
									<label>문의 제목</label> <input class="form-control"
										name='one_title' value="${one.one_title}">
								</div>

								<div class="form-group">
									<label>문의 내용</label>
									<textarea class="form-control" style="resize: none;" rows="10" name='one_content'>${one.one_content}</textarea>
								</div>


								<div class="form-group">
									<label>번호</label> <input class="form-control" name='one_id'
										value="${one.one_id}" readonly>
								</div>

								<div class="form-group">
									<label>파일</label> <input type="file" class="gallery-file"
										name="one_file" multiple />
								</div>

								<div class="text-right ">
									<button type="button" id="listBtn" class="btn btn-dark">목록</button>
									<button type="button" id="updateBtn" class="btn btn-primary">변경</button>
									<button type="button" id="delBtn" class="btn btn-info">삭제</button>

								 </div>
							</form>


						</div>

					</div>



				</div>

			</div>

		</div>




		<div class="col-md-2"></div>

	</section>

	<script>
 	
 	$(function(){
 		//목록 이동 처리
 		$('#listBtn').click(function(){
 			location.href="<c:url value='/oneboard/list' />"
 		});
 	
 	$('#updateBtn').click(function() {
		if($('input[name=one_title]').val() === ''){
			alert('제목은 필수 항목입니다.');
			$('input[name=one_title]').focus();
			return;
		}else if($('textarea[name=one_content]').val()=== ''){
			alert('내용은 필수 항목 입니다.');
			$('textarea[name=one_content]').focus();
			return;
		}else{
			document.updateForm.submit();
		}
	});
 	$('#delBtn').click(function(){
 		if(confirm('정말 삭제하시겠습니까?')){
 			$('form[name=updateForm]').attr('action', '<c:url value="/oneboard/oneDelete" />');
 			$('form[name=updateForm]').submit(); 	
	 		}	
 	});
 	
 		
 	});
 </script>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>
















