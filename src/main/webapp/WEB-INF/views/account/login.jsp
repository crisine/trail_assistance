<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <style>
        .container {
            text-align: center;
        }
        #loginbox{
        vertical-align: middle;}
    </style>



    <%@ include file="/WEB-INF/views/include/header.jsp" %>

    <div class="container"  id="wrapper">
        <c:if test="${login == null}">
            <div id="loginbox" style="margin-top:50px;"
                class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">로그인</div>
                    </div>

                    <div style="padding-top:30px" class="panel-body">

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                        <form id="loginform" class="form-horizontal" role="form">

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="user_id" type="text" class="form-control" name="username" value=""
                                    placeholder="아이디 입력">
                            </div>

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="user_pw" type="password" class="form-control" name="password"
                                    placeholder="비밀번호 입력">
                            </div>



                            <div class="input-group">
                                <div class="checkbox">
                                  
                                </div>
                            </div>


                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">
                                    <a id="login_btn" class="btn btn-success">로그인 </a>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-12 control">
                                    <table class="table" style="table-layout:fixed;">
                                        <tr>
                                            <td><a href="<c:url value="/account/user_join" />">회원가입</a></td>
                                            <td><a href="<c:url value="/account/find_my_id" />">아이디 찾기</a></td>
                                            <td><a href="<c:url value="/account/find_my_password" />">비밀번호 찾기</a></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${login != null}">
        	<h1>${login.account} 로 현재 로그인 중입니다.</h1>
        	<!-- 메인 페이지로 보내는 링크 상대 링크로 변경 (c:url ...) -->
        	<a href="<c:url value='/' />">메인 페이지로</a>
        </c:if>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    <!-- 스크립트 시작 -->
    <script>
        // 제이쿼리 시작
        $(function () {
            $('#login_btn').click(function () {

                const id = $('#user_id').val();
                const pw = $('#user_pw').val();

                const member = {
                    'account': id,
                    'password': pw
                };

                $.ajax({
                    type: 'POST',
                    url: '<c:url value="/account/login"/>',
                    contentType: 'application/json',
                    dataType: 'text',
                    data: JSON.stringify(member),
                    success: function (result) {
                        if (result === 'loginSuccess') {
                            console.log('로그인 성공!');
                            location.href = '${pageContext.request.contextPath}';
                        } else if (result === 'idFail') {
                            alert('존재하지 않는 아이디입니다.');
                        } else if (result === 'pwFail') {
                            alert('비밀번호가 틀렸습니다.');
                        }

                    },
                    error: function () {
                        alert('통신 에러');
                    }
                });
            });
        });
    </script>
