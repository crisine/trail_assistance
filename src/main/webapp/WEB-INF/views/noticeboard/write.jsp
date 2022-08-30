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
								<h3>공지사항 작성</h3>
							</div>

							<form action="<c:url value='/noticeboard/registForm'/>"
								name="registForm" method="post">

								<div class="contenIn">
									<table class="tableVer table-bordered">

										<tbody>
											<tr>
												<c:if test="${login.type==1 }">
													<th>번호</th>
													<td>${notice.notice_id}</td>
												</c:if>


												<th>작성자</th>
												<td><input class="form-control input-sm"
													name="notice_writer" value="${login.account}" readonly>
												</td>

												<th class="title">제목</th>
												<td colspan="6"><input class="form-control input-sm"
													name="notice_title"></td>

											</tr>

											<tr>
												<th>기관 종류</th>
												<td><select class="form-control input-sm sel"
													name="notice_type">
														<option>일반</option>
														<option>기관</option>


												</select>
											</tr>

											<tr>
												<th class="t-file">첨부 파일</th>

												<td colspan="8"><a href="#" class="" name="notice_file">파일목록</a></td>
											</tr>


										</tbody>

										<tr>

											<td class="t-text" colspan="9"><textarea
													class="form-control" name="notice_content" rows="15"
													cols="150" style="resize: none;"></textarea></td>
										</tr>


									</table>

								</div>

							</form>
							<div class="titlefoot  text-right">
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
		$(function() {
			$('#registBtn').click(function() {
				if ($('input[name=notice_title]').val() === '') {
					alert('제목은 필수 항목입니다.');
					$('input[name=notice_title]').focus();
					return;
				} else if ($('textarea[name=notice_content]').val() === '') {
					alert('내용은 필수 항목입니다.');
					$('textarea[name=notice_content]').focus();
					return;
				} else {
					document.registForm.submit();
				}

			});
			$('#listBtn').click(function() {
				if (confirm('목록으로 돌아가시겠습니까?')) {
					location.href = '<c:url value="/noticeboard/list" />'
				} else
					return;

			})

		});
	</script>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>
















