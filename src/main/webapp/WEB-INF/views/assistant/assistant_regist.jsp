<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>

/*맨 마지막 신청 버튼*/
.submit_btn_div {
	text-align: center;
}

/* 테이블의 로우스팬3인 주소 글자 중앙(세로의 중앙)위치*/
.table>tbody>tr>td.add_rowspan {
	vertical-align: middle;
}
</style>
	<%@ include file="../include/header.jsp"%>

		<!--     text-center 적용하면 col크기의 중간에 텍스트 작성-->
		<div class="container-fluid">
			<div class="row">

				<!--왼쪽 aside공간 -->
				<div class="col-md-2"></div>

				<!-- 중앙 공간-->
				<div class="col-md-8">

					<h2>조력자 신청</h2>

					<form action="<c:url value='/assistant/regist'/>" method="post">
						<br> <br>



						<!--  감정 분야 선택 -->
						<div>
							<h3>감정분야 및 세부 구분 선택</h3>
							<hr>
							<span>감정 분야 선택</span>
							 <select name="mid" id="mid">
								<option value="sel" selected>중 분류</option>
								<option value="general">일반감정인</option>
								<option value="inter">통번역인</option>
								<option value="agency">기관추천조력자</option>
							</select> <select name="small" id="small">
								<option value="sel" selected>소 분류</option>
							</select>
							<hr>
						</div>

						<br>


						<!-- 희망 법원 선택 -->
						<div>
							<h3>희망 법원 선택</h3>
							<hr>
							<span>법원 목록</span> <span>희망 법원</span>

							<div>
								<span> 희망 법원 선택</span> <select name="law" multiple="multiple"
									id='law' size="10">
									<option>대법원</option>
									<option>서울고등법원</option>
									<option>서울고등법원(춘천)</option>
									<option>대구고등법원</option>
									<option>부산고등법원</option>
									<option>인천고등법원</option>
									<option>광주고등법원</option>
									<option>대전고등법원</option>
								</select>
								<button type="button" id='btn_add'>법원 선택</button>
								<button type="button" id='btn_minus'>법원 빼기</button>
								<select name="law2" multiple="multiple" id='law2' size="10">
								</select>
							</div>
							<hr>

						</div>


						<div>
							<h3>신청인 기본정보</h3>
							<hr>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<td>조력자명</td>
										<td>
											<input type="text" name="helper_name" id="helper_name" class="form-control">
										</td>
										<td>주민등록번호</td>
										<td>
											<input type="text" name="helper_ssn_number"	id="helper_ssn_number" class="form-control">
										</td>
									</tr>
									<tr>
										<td>휴대전화번호</td>
										<td>
											<input type="text" name="helper_phone_tel" id="helper_phone_tel" class="form-control">
										</td>
										<td>전화번호</td>
										<td>
											<input type="text" name="helper_home_tel" id="helper_home_tel" class="form-control">
										</td>
									</tr>

									<tr>
										<td>이메일</td>
										<td>
											<input type="text" name="helper_email_address" id="helper_email_address" class="form-control">
										</td>
										<td>직업</td>
										<td>
										<input type="text" name="helper_job" id="helper_job" class="form-control">
										</td>
									</tr>
									
									<tr>
										<td rowspan="3" class="add_rowspan">주소</td>
										<td>우편주소</td>
										<td colspan="2">
											<div class="row">
												<div class="col-md-4">
													<input type="text" name="helper_zipcode" id="helper_zipcode" class="form-control">
												</div>
												<button type="button" class="btn" onclick="goPopup()">주소찾기</button>
											</div>
										</td>
									</tr>
									<tr>
										<td>주소</td>
										<td colspan="2">
											<input type="text" name="helper_address1" id="helper_address1" class="form-control">
										</td>
									</tr>
									<tr>
										<td>상세주소</td>
										<td colspan="2">
											<input type="text" name="helper_address2" id="helper_address2" class="form-control">
										</td>
									</tr>
								</tbody>
							</table>
							<hr>

						</div>


						<div>
							<h3>사무소 정보</h3>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<td>사무소명</td>
										<td>
											<input type="text" name="helper_office_name" id="helper_office_name" class="form-control">
										</td>
										<td>사업자등록번호</td>
										<td>
											<input type="text" name="helper_bussiness_reg_num" id="helper_bussiness_reg_num" class="form-control">
										</td>
									</tr>

									<tr>
										<td>사무소전화번호</td>
										<td>
											<input type="text" name="helper_offic_tel" id="helper_offic_tel" class="form-control">
										</td>
										<td>사무소펙스번호</td>
										<td>
											<input type="text" name="helper_offic_fax_tel" id="helper_offic_fax_tel" class="form-control">
										</td>
									</tr>
									<tr>
										<td rowspan="3" class="add_rowspan">주소</td>
										<td>우편주소</td>
										<td colspan="2">
											<div class="row">
												<div class="col-md-4">
													<input type="text" name="helper_office_zipcode"	id="helper_office_zipcode" class="form-control">
												</div>
												<button type="button" class="btn office_add" onclick="goPopup2()" >주소찾기</button>
											</div>
										</td>
									</tr>
									<tr>
										<td>주소</td>
										<td colspan="2">
											<input type="text" name="helper_office_address1" id="helper_office_address1"	class="form-control">
										</td>
									</tr>
									<tr>
										<td>상세주소</td>
										<td colspan="2">
											<input type="text" name="helper_office_address2" id="helper_office_address2" class="form-control">
										</td>
									</tr>
								</tbody>
							</table>

						</div>

						<br>

						<div>
							<h3>추가 정보</h3>
							<table class="table table-bordered">
								<thead>
									<tr>
										<td>경력명</td>
										<td>경력 유무</td>
										<td>경력 내용</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>소송사건 당사자 경력</td>
										<td>
											<label class="radio-inline"> 
												<input type="radio" name="helper_sosong" value="yes"> 예
											</label> 
												<label class="radio-inline"> <input type="radio" name="helper_sosong" value="no"> 아니오
											</label>
										</td>
										<td>
											<textarea name="helper_sosong_content" id="helepr_sosong_content" rows="1" style="resize: none;" class="form-control"></textarea>
										</td>
									</tr>
									<tr>
										<td>보험업계 자문 경력</td>
										<td>
											<label class="radio-inline"> 
												<input	type="radio" name="helper_bohum" value="yes"> 예
											</label> 
											<label class="radio-inline"> 
												<input type="radio"name="helper_bohum" value="no"> 아니오
											</label>
										</td>
										<td>
											<textarea name="helper_bohum_content" id="helper_bohum_content" rows="1" style="resize: none;"	class="form-control"></textarea>
										</td>
									</tr>
									<tr>
										<td>형사처벌 받은 경력</td>
										<td>
											<label class="radio-inline"> 
												<input	type="radio" name="helper_hyungsa" value="yes"> 예
											</label>
											<label class="radio-inline"> 
												<input type="radio"	name="helper_hyungsa" value="no"> 아니오
											</label>
										</td>
										<td>
											<textarea name="helper_hyungsa_content"	id="helper_hyungsa_content" rows="1" style="resize: none;"	class="form-control"></textarea>
										</td>
									</tr>
								</tbody>
							</table>

						</div>







						<br> <br>
						<div class="submit_btn_div text-center">
							<button class="btn btn-lg submit_btn" type="submit">신청</button>
						</div>

					</form>
					<!-- 서버로 전송 끝-->


				</div>
				<!-- 중앙 공간 끝-->

				<!--오른쪽 aside 공간-->
				<div class="col-md-2"></div>

			</div>
			<!-- div class=row 끝-->


		</div>
		<!-- div class=container-fluid 끝-->






<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>

	$(document).ready(function(){
		
		
		/* 감정 분야 중 분류 선택에 따른  소 분류 선택*/
		$('#mid').change(function(){
		
			
			if($('#mid').val()==='general'){
	    		$('#small').html("<option >선택</option><option>측량</option><option>문서</option>");
	    	}else if($('#mid').val()==='inter'){
	    		$('#small').html("<option >선택</option><option >통역인</option><option >번역인</option>");
	    	}else{
	    		$('#small').html("<option >선택</option><option >의사</option><option >회계사</option>");
	    	}
		});
		
		
		/*접수 신청 버튼 클릭시 */
		$('.submit_btn').click(function(){
			
			if($('#mid').val()==='sel'){
				if($('#small').val()==='sel'){
					alert('조력자 분야를 다시 설정하세요');
					return
				}
			}
			
			if($('#mid').val()!=='sel' && $('#small').val()==='sel'){
				alert('조력자 소분야를 다시 설정하세요');
				return
			}
		});
		
		/*희망 법원 선택*/
		var wovks={0:"대법원",1:"서울고등법원",2:"서울고등법원(춘천)",3:"대구고등법원",4:"부산고등법원",5:"인천고등법원",6:"광주고등법원",7:"대전고등법원"}

		var arr=[];
		var arr2=[];
		
		$('#btn_add').click(function(){
			var select = document.getElementById('law');
			var selected_value = [...select.selectedOptions].map(option => option.value);
			var selected_text = [...select.selectedOptions].map(option => option.text);
			
			//select_value == a1,a2,a3....  selected_text == 대법원,서울고등법원,서울고등법원(춘천)....
			/*
			console.log(selected_value)   ::배열 값 확인용
			console.log(selected_text)		::배열 값 확인용
			console.log(selected_value[0]);  ::해당 인덱스의 값 확인
			console.log(selected_text[0]);  ::해당 인덱스의 값 확인
		 	*/
		 	
		 	
		 	var code=$('#law2').html().trim();   //누적 코드를 저장하는 공간
		 	var dd=[];
		 	for(var n=0;n<selected_value.length;n++){
				code=code+"<option>"+selected_text[n]+"</option>"
				dd="<option>"+selected_text[n]+"</option>"
				
				
				//희망법원을 배열에 저장하는데 ,그저장한 배열안에 중복되어 있는지 확인  밑에 코드가 더나음 
				if(arr.includes(selected_text[n])){
					alert('중복된 희망 법원입니다');
					return
				}
				//중복되지 않았을 시에 배열에 저장 됨
				arr.push(selected_text[n]); //법원 이름만 저장됨
				

				arr2.push(dd);  //<option>~~~</option>의 형태로 배열에 저장됨

		}
		
			$('#law2').html(code); 
			
			
			/* 
			console.log($('#law2').html());
			console.log($('#law2').text().trim());
			console.log($('#law2').val());
			console.log(arr);
			 */
			 

			 
			 
			 
			 
			 
			 
			 
			
		
		})
		
		//희망 법원 빼기 
		$('#btn_minus').click(function(){
			var select = document.getElementById('law2');
			var selected_value = [...select.selectedOptions].map(option => option.value);
			var selected_text = [...select.selectedOptions].map(option => option.text);
			//console.log(selected_text);
			
			
			var code=$('#law2').html();   //누적 코드를 저장하는 공간
			//console.log(code); //<option>~!~~ </option>의 형태로 나옴 
			
			/* 	
			console.log(arr);
			console.log(arr2);
			console.log(code);
			*/
			
			for(var aabb=0;aabb<selected_text.length;aabb++){
				if(arr.includes(selected_text[aabb])){
					arr2.pop(arr.indexOf(selected_text[aabb]));  //<option></option>의 형태로 저장되어 있는 배열에서 삭제함
					arr.pop(selected_text[aabb]);  //법원 이름만 적혀있는 배열에서 삭제함
				}
				
			}
			$('#law2').html(arr2); 
			
			if(selected_text.length ===0){
				alert('희망 법원이 아닌 것을 선택하세요.')
			}
		
		})
		
		
		

		
	
	
		
	    }) //JQuery 종료
	    

	    //주소 찾기 API 사용
	 	function goPopup(){
			//주소 찾기 버튼을 누르면 절대경로로 팝업창을 오픈
			var pop = window.open("${pageContext.request.contextPath}/resources/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 

		}


		function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
			//콜백 방식으로 받아온 데이터를 가입 폼에 자동 완성.
			document.getElementById('helper_address1').value=roadAddrPart1;
			document.getElementById('helper_address2').value=addrDetail;
			document.getElementById('helper_zipcode').value=zipNo;
				
		}
		function goPopup2(){
			//주소 찾기 버튼을 누르면 절대경로로 팝업창을 오픈
			var pop = window.open("${pageContext.request.contextPath}/resources/popup/jusoPopup2.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 

		}


		function jusoCallBack2(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
			document.getElementById('helper_office_address1').value=roadAddrPart1;
			document.getElementById('helper_office_address2').value=addrDetail;
			document.getElementById('helper_office_zipcode').value=zipNo;
			
				
		}
		
		  //다음 페이지로 전달
        $(document).on('click','.submit_btn',function(e){
       
         
          //공백 검사 
          if( $('input[name=helper_name]').val()===''){
                   alert('이름을 입력해 주세요');
                   return
               }else if ($('input[name=helper_ssn_number]').val()===''){
                   alert('주민등록번호를 입력해 주세요')
                   return
               }else if($('input[name=helper_phone_tel]').val()===''){
                  alert('핸드폰 번호를 입력해 주세요');
                  return
              }else if($('input[name=helper_home_tel]').val()===''){
                  alert('전화번호를 입력해 주세요');
                  return
              }else if($('input[name=helper_email_address]').val()===''){
                  alert(' 이메일을 입력해 주세요');
                  return
              }else if($('input[name=helper_job]').val()===''){
                  alert('직업을 입력해 주세요');
                  return
              }else if($('input[name=helper_zipcode]').val()===''){
                  alert('우편번호를 주소 찾기 버튼을 통하여 입력해 주세요');
                  return
              }else if($('input[name=helper_address2]').val()===''){
                  alert('상세 주소를 입력해 주세요');
                  return
              }else if($('input[name=helper_office_name]').val()===''){
                  alert('사무소명을 입력해 주세요');
                  return
              }else if($('input[name=helper_bussiness_reg_num]').val()===''){
                  alert('사업자등록번호를 입력해 주세요');
                  return
              }else if($('input[name=helper_offic_tel]').val()===''){
                  alert('사무소전화번호를 입력해 주세요');
                  return
              }else if($('input[name=helper_offic_fax_tel]').val()===''){
                  alert('사무소 펙스 번호를 입력해 주세요');
                  return
              }else if($('input[name=helper_office_zipcode]').val()===''){
                  alert('사무소 우편번호를 주사 찾기 버튼을 통하여 입력해 주세요');
                  return
              }else if($('input[name=helper_office_address2]').val()===''){
                  alert('사무소 상세주소를 입력해 주세요');
                  return
              }else if(!$('input[name=helper_sosong]').is(":checked")){
                  alert('소송 경력이 있는지 체크해 주세요');
                  return
              }else if($('input[name=helper_sosong]:checked').val()==='yes'){
                  if($('textarea[name=helper_sosong_content]').val()===''){
                      alert('소송 경력 내용을 입력해 주세요');
                      return
                      }
              } else if(!$('input[name=helper_bohum]').is(":checked")){
                  alert('보험업계 자문 경력이 있는지 체크해 주세요');
                  return
              }else if($('input[name=helper_bohum]:checked').val()==='yes'){
                  if($('textarea[name=helper_bohum_content]').val()===''){
                      alert('보험업계 경력 내용을 입력해 주세요');
                      return
                      }
              } else if(!$('input[name=helper_hyungsa]').is(":checked")){
                  alert('형사처벌 받은 경력이 있는지 체크해 주세요');
                  return
              }else if($('input[name=helper_hyungsa]:checked').val()==='yes'){
                  if($('textarea[name=helper_hyungsa_content]').val()===''){
                      alert('형사처벌 받은 내용을 입력해 주세요');
                      return
                      }
              } 
              else{
                  $('form').submit();
              }


              
             });
	    
	    

</script>