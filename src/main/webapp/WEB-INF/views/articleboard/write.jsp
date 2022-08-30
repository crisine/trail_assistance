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

			<div class="col-md-2"></div>
			<div class="row">


				<div class="board-hon">
					<div class="col-md-8 board-table">






						<div class="col-xs-12 col-md-12 write-wrap">

							<div class="titlebox">
								<h3>
									공고글 등록
									</p>
							</div>

							<form action="<c:url value='/articleboard/registForm'/>"
								name="registForm" method="post">

								<div class="contenIn">
									<table class="tableVer table-bordered">
										<caption style="display: none">공고 게시글 상세정보 표</caption>
										<tbody>
											<tr>

												<th class="title">제목</th>
												<td colspan="6"><input class="form-control input-sm"
													name="article_title"></td>

											</tr>

											<tr>
												<th>개인/기관 분류</th>
												<td><select class="form-control input-sm sel"
													name="article_type">
														<option>개인</option>
														<option>기관</option>


												</select></td>
												<th class="c-date">공고 모집 시작일	</th>
												<td colspan="2"><input type="datetime-local" class="form-control" name="start_date"></td>
												<th>공고 모집 마감일	</th>
												<td><input type="datetime-local" class="form-control" name="expired_date"></td>


											</tr>

											<tr>
												<th class="t-file">첨부 파일</th>

												<td colspan="8"><a href="#" class="">파일목록</a></td>
											</tr>


										</tbody>

										<tr>
											<th>내용</th>
											<td class="t-text" colspan="9"><textarea
													name="article_content" class="form-control" rows="15"
													cols="150" style="resize: none;"></textarea></td>
										</tr>


									</table>

								</div>



							</form>
							
						<div class="butt">
							<button class="btn" id="registBtn">등록</button>
							<button class="btn" id="listBtn">목록</button>
						</div>
						</div>


					</div>
				</div>
			</div>
		</div>


		<div class="col-md-2"></div>
	</section>
	<script>
 	$(function(){
 		$('#registBtn').click(function(){
 			if($('input[name=article_title]').val() === ''){
 				alert('제목은 필수 항목입니다.');
 				$('input[name=article_title]').focus();
 				return;
 			} else if($('textarea[name=article_content]').val() ===''){
 				alert('내용은 필수 항목입니다.');
 				$('textarea[name=article_content]').focus();
 				return;
 			}else{
 				document.registForm.submit();
 			}
 			
 			
 		});
 		$('#listBtn').click(function(){
 			if(confirm('목록으로 돌아가시겠습니까?')){
 				location.href='<c:url value="/articleboard/list" />'	
 			}else return;
 			
 			
 		})
 		
 		
 	});
 </script>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>
















