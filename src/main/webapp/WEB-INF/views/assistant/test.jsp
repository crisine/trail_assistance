<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	  <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>

<style>
.modal-backdrop {
 
    z-index: 0;
     background-color: #fff;
}
</style>
</head>
<body>

	<div>
					<h3>학력 사항</h3>
					<div class="text-right">
						<button type="button" class="insert_edu">학력 사항 입력</button>
						<!--data-toggle="modal" data-target="#myModal"-->
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>학교명</td>
								<td>학과전공</td>
								<td>학위</td>
								<td>입학일</td>
								<td>졸업일</td>
								<td>최종학력</td>
								<td>관리</td>
							</tr>
						</thead>
						<tbody class="info_insert" name="info_insert">
							<!--     <tr>
                                    <td><input type="text" class="form-control" name="a"></td>
                                    <td><input type="text" class="form-control" name="b"></td>
                                    <td><input type="text" class="form-control" name="c"></td>
                                    <td><input type="text" class="form-control" name="d"></td>
                                    <td><input type="text" class="form-control" name="e"></td>
                                    <td><input type="file" name="" id=""></td>
                                </tr> -->
						</tbody>

					</table>

					<br>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td>증명 파일</td>
								<td><input type="file" name="hepler_edu_file"></td>
							</tr>
						</tbody>

					</table>
				</div>
				
		<div class="modal fade" id="edu_info" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4>학력사항 입력</h4>
					</div>


					<div class="modal-body">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td>학교명</td>
									<td colspan="3"><input type="text"
										name="helper_school_name" id="helper_school_name"></td>
								</tr>
								<tr>
									<td>학과(전공)</td>
									<td><input type="text" name="helper_school_major"
										id="helper_school_major"></td>
									<td>학위</td>
									<td><select name="helper_education" id="helper_education">
											<option value="" selected>최종 학위</option>
											<option value="">대학교 수료</option>
											<option value="">대학원 졸업</option>
											<option value="">석사 수료</option>
											<option value="">석사 졸업</option>
											<option value="">박사 수료</option>
											<option value="">박사 졸업</option>
									</select></td>
								</tr>
								<tr>
									<td>입학 년월</td>
									<td><input type="text" name="helper_school_admission"
										id="helper_school_admission"></td>
									<td>졸업 년월</td>
									<td><input type="text" name="helper_school_graduate"
										id="helper_school_graduate"></td>

								</tr>

							</tbody>
						</table>
						<div class="text-center">
							<button type="button" class="edu_btn">입력</button>
						</div>
					</div>


				</div>
			</div>
		</div>
<Script>

$(document).on('click','.insert_edu',function(){



    // 학력 사항 입력할 때 동적으로 여러개 입력 할 수 있게 하였음 
    $('.insert_edu').click(function(){
    
        var code=$('.info_insert').html().trim();
        
        $('#edu_info').modal('show'); 

    });
});
</Script>
</body>
</html>