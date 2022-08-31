<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>




<link
	href="${pageContext.request.contextPath }/resources/css1/view_style.css"
	rel="stylesheet">






	<%@ include file="../include/header.jsp"%>


	<div class="container-fluid" id="wrapper">

		<div class="row">



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

			<div class="col-md-8 board-table">

				<div class="col-xs-12 col-md-12 write-wrap">

					<div class="titlebox">
						<h3>FAQ 상세</h3>
					</div>
					<form>
						<c:if test="${login.type == 1}">

							<div>
								<label>DATE</label>
								<c:if test="${faq_updatedate == null}">
									<p>${faq.faq_regdate}</p>
								</c:if>
								<c:if test="${faq_updatedate != null}">
									<p>${faq.faq_updatedate}</p>
								</c:if>

							</div>
						</c:if>

						<div class="form-group">
							<label>FAQ 유형</label> <input class="form-control" name='faq_type'
								value="${faq.faq_type}" readonly>

						</div>


						<div class="form-group">
							<label>번호</label> <input class="form-control" name='faq_id'
								value="${faq.faq_id}" readonly>
						</div>

				

						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="10" name='faq_content'
								readonly>${faq.faq_content}</textarea>
						</div>





					</form>



					<div class="butt">
						<c:if test="${login.type ==1 }">
							<button type="button" class="btn btn-primary"
								onclick="location.href='<c:url value="/faqboard/write_corr?faq_id=${faq.faq_id}&faq_type=${faq.faq_type}" />'">변경</button>
						</c:if>
						<button type="button" class="btn btn-dark"
							onclick="location.href='${pageContext.request.contextPath}/faqboard/list?pageNum=${p.pageNum}&cpp=${p.cpp}&condition=${p.condition}&keyword=${p.keyword}'">목록</button>
					</div>

				</div>

			</div>

	<div class="col-md-2"></div>
		</div>
	</div>




	<script>
	const msg = '${msg}';
	if(msg !== ''){
		alert(msg);
	}
</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
