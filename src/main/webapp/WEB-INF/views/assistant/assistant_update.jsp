<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../include/header.jsp"%>
<style>
.modal-backdrop {
 
    z-index: 0;
     background-color: #fff;
}
</style>
  <div class="container-fluid">

        <div class="row">
            <div class="col-md-2"></div> <!--왼쪽 aside공간 -->

    














            <div class="col-md-8"><!-- 중앙 공간-->
           
                <h2>조력자 신청</h2>
                
<!-- 
                <form action="./tt.html" method="post"> < -->

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
                            <tbody class="info_insert">
                                <!-- <tr>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="file" name="" id=""></td>
                                </tr>
                         -->
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
              
                        
                    
            
                    <br><br>

                    <div>
                        <h3>근무 경력 사항</h3>
                        <div class="text-right">
                            <button type="button" class="career_info">근무 경력 사항 입력</button>
                                <!--data-toggle="modal" data-target="#myModal"-->
                        </div>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <td>회사명</td>
                                    <td>기간</td>
                                    <td>수행업무</td>
                                    <td>부서</td>
                                    <td>직책</td>
                                    <td>관리</td>
                                </tr>
                            </thead>
                            <tbody class="career_insert">
                                <!-- <tr>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                </tr> -->

                            </tbody>
                        </table>
                        
                        <br>
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td>증명 파일</td>
                                    <td><input type="file" name="hepler_career_file"></td>   
                                </tr>
                            </tbody>
                          
                        </table>
                    </div>

                    
                    <br><br>
                    
                    <!--자격 및 면허 사항-->
                    <div>
                        <h3>자격 면허사항</h3>
                        <div class="text-right">
                            <button type="button" class="license_info">자격 및 면허사항 입력</button>
                                <!--data-toggle="modal" data-target="#myModal"-->
                        </div>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <td>자격/면허명</td>
                                    <td>발급기관</td>
                                    <td>자격번호</td>
                                    <td>발급일</td>
                                    <td>관리</td>
                                </tr>
                            </thead>
                            <tbody class="license_insert">
                                <!-- <tr>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                    <td><input type="text" class="form-control"></td>
                                </tr> -->

                            </tbody>
                        </table>
                        
                        <br>
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td>증명 파일</td>
                                    <td><input type="file" name="hepler_license_file"></td>   
                                </tr>
                            </tbody>
                          
                        </table>
                    </div>


                    <div class="submit_btn_div text-center">
                        <button class="btn btn-log submin_before">이전</button>
                        <button class="btn btn-log submit_btn">신청</button>
                    </div>

                <!-- </form> -->
            </div>




  

            <!-- 학력 사항 모달  -->
            <!-- Modal -->
           
          
            <div class="modal fade" id="edu_info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4>학력사항 입력</h4>
                    </div>


                    <div class="modal-body">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td>학교명</td>
                                    <td colspan="3">
                                        <input type="text" name="helper_school_name" id="helper_school_name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>학과(전공)</td>
                                    <td><input type="text" name="helper_school_major" id="helper_school_major"></td>
                                    <td>학위</td>
                                    <td>
                                        <select name="helper_education" id="helper_education">
                                            <option value="" selected>최종 학위</option>
                                            <option value="">대학교 수료</option>
                                            <option value="">대학원 졸업</option>
                                            <option value="">석사 수료</option>
                                            <option value="">석사 졸업</option>
                                            <option value="">박사 수료</option>
                                            <option value="">박사 졸업</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>입학 년월</td>
                                    <td><input type="text" name="helper_school_admission" id="helper_school_admission"></td>
                                    <td>졸업 년월</td>
                                    <td><input type="text" name="helper_school_graduate" id="helper_school_graduate"></td>
                                    
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



            <!--수정용 모달 -->
             
            <div class="modal fade" id="edu_modify_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4>수정모달 입력</h4>
                    </div>


                    <div class="modal-body">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td>학교명</td>
                                    <td colspan="3">
                                        <input type="text" name="modi_helper_school_name" id="modi_helper_school_name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>학과(전공)</td>
                                    <td><input type="text" name="modi_helper_school_major" id="modi_helper_school_major"></td>
                                    <td>학위</td>
                                    <td>
                                        <select name="modi_helper_education" id="modi_helper_education">
                                            <option value="">최종 학위</option>
                                            <option value="">대학교 수료</option>
                                            <option value="">대학원 졸업</option>
                                            <option value="">석사 수료</option>
                                            <option value="">석사 졸업</option>
                                            <option value="">박사 수료</option>
                                            <option value="">박사 졸업</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>입학 년월</td>
                                    <td><input type="text" name="modi_helper_school_admission" id="modi_helper_school_admission"></td>
                                    <td>졸업 년월</td>
                                    <td><input type="text" name="modi_helper_school_graduate" id="modi_helper_school_graduate"></td>
                                    
                                </tr>

                            </tbody>
                        </table>
                        <div class="text-center">
                            <button type="button" class="modi_edu_btn">입력</button>
                        </div>
                    </div>


                </div>
                </div>
            </div>
        <!-- 학력 사항 모달   끝-->




            <!-- 경력  사항 모달  -->
            <div class="modal fade" id="career_info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4>학력사항 입력</h4>
                    </div>


                    <div class="modal-body">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td>회사명/활동기관명</td>
                                    <td colspan="3">
                                        <input type="text" name="helper_career_name" id="helper_career_name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>기간</td>
                                    <td>
                                        <input type="text" name="helper_career_period" id="helper_career_period">
                                    </td>
                                    <td>수행업무</td>
                                    <td>
                                        <input type="text" name="helper_career_wrok" id="helper_career_wrok"></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>부서</td>
                                    <td><input type="text" name="helper_career_department" id="helper_career_department"></td>
                                    <td>직책</td>
                                    <td><input type="text" name="helper_career_position" id="helper_career_position"></td>
                                    
                                </tr>

                            </tbody>
                        </table>
                        <div class="text-center">
                            <button type="button" class="career_btn">입력</button>
                        </div>
                    </div>


                </div>
                </div>
            </div>

        <!-- 경력사항 수정용 모달 -->
                    
        <div class="modal fade" id="modi_career_info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4>학력사항 입력</h4>
                </div>

                <div class="modal-body">
                    <table class="table table-bordered">
                        <tbody>
                            <tr>
                                <td>회사명/활동기관명</td>
                                <td colspan="3">
                                    <input type="text" name="modi_helper_career_name" id="modi_helper_career_name">
                                </td>
                            </tr>
                            <tr>
                                <td>기간</td>
                                <td>
                                    <input type="text" name="modi_helper_career_period" id="modi_helper_career_period">
                                </td>
                                <td>수행업무</td>
                                <td>
                                    <input type="text" name="modi_helper_career_wrok" id="modi_helper_career_wrok"></td>
                                </td>
                            </tr>
                            <tr>
                                <td>부서</td>
                                <td><input type="text" name="modi_helper_career_department" id="modi_helper_career_department"></td>
                                <td>직책</td>
                                <td><input type="text" name="modi_helper_career_position" id="modi_helper_career_position"></td>
                                
                            </tr>

                        </tbody>
                    </table>
                    <div class="text-center">
                        <button type="button" class="modi_career_btn">수정</button>
                    </div>
                </div>


            </div>
            </div>
        </div>
    <!-- 경력  사항 모달 끝  -->



        <!--자격 및 면허 사항 모달-->

            <div class="modal fade" id="license_info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4>학력사항 입력</h4>
                    </div>


                    <div class="modal-body">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td>종목/등급 명</td>
                                    <td>
                                        <input type="text" name="helper_license_name" id="helper_license_name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>발급기관</td>
                                    <td>
                                        <input type="text" name="helper_license_agency" id="helper_license_agency">
                                    </td>
                                </tr>
                                <tr>
                                    <td>자격/면허 번호</td>
                                    <td>
                                        <input type="text" name="helper_license_num" id="helper_license_num"></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>발급일</td>
                                    <td><input type="text" name="helper_license_date" id="helper_license_date"></td>
                                </tr>

                            </tbody>
                        </table>
                        <div class="text-center">
                            <button type="button" class="license_btn">입력</button>
                        </div>
                    </div>


                </div>
                </div>
            </div>

            <!-- 경력사항 수정용 모달 -->
                    
            <div class="modal fade" id="modi_license_info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4>학력사항 입력</h4>
                </div>

                <div class="modal-body">
                    <table class="table table-bordered">
                        <tbody>
                            <tr>
                                <td>종목/등급 명</td>
                                <td>
                                    <input type="text" name="modi_helper_license_name" id="modi_helper_license_name">
                                </td>
                            </tr>
                            <tr>
                                <td>발급기관</td>
                                <td>
                                    <input type="text" name="modi_helper_license_agency" id="modi_helper_license_agency">
                                </td>
                            </tr>
                            <tr>
                                <td>자격/면허 번호</td>
                                <td>
                                    <input type="text" name="modi_helper_license_num" id="modi_helper_license_num"></td>
                                </td>
                            </tr>
                            <tr>
                                <td>발급일</td>
                                <td><input type="text" name="modi_helper_license_date" id="modi_helper_license_date"></td>
                            </tr>

                        </tbody>
                    </table>
                    <div class="text-center">
                        <button type="button" class="modi_license_btn">수정</button>
                    </div>
                </div>


            </div>
            </div>
            </div>

<!--자격 및 면허사항 모달 끝-->


<script>
    //jquery 시작
    $(document).ready(function(){



        // 학력 사항 입력할 때 동적으로 여러개 입력 할 수 있게 하였음 
        $('.insert_edu').click(function(){
        
            var code=$('.info_insert').html().trim();
            
            $('#edu_info').modal('show'); 

            $('.edu_btn').click(function(){
             

                
       
               
                var select = document.getElementById('helper_education');
                var selected_text = [...select.selectedOptions].map(option => option.text);
                console.log(selected_text)
                //code=code+"<tr><td>"+$('#helper_school_name').val()+"</td><td>"+$('#helper_school_major').val()+"</td><td>"+selected_text+"</td><td>"+$('#helper_school_admission').val()+"</td><td>"+$('#helper_school_graduate').val()+"</td><td><input type='radio' name='final_edu'></td><td><button type='button' class='edu_modi'>수정</button><button type='button' class='edu_del'>삭제</button></td></tr>";
                code=code+"<tr><td>"+$('#helper_school_name').val()+"</td><td>"+$('#helper_school_major').val()+"</td><td>"+selected_text+"</td><td>"+$('#helper_school_admission').val()+"</td><td>"+$('#helper_school_graduate').val()+"</td><td><input type='radio' name='final_edu'></td><td><button class='edu_modi'>수정</button><button type='button' class='edu_del'>삭제</button></td></tr>";

                //화면에 컬럼 추가  
 
                $('.info_insert').html(code);
                 
             
              //모달 숨기기
              $('#edu_info').modal('hide');
            

            });
             //모달 값 초기화
             $('#helper_school_name').val(''); 
              $('#helper_school_major').val(''); 
              $('#helper_education').val('');
              $('#helper_school_admission').val('');
              $('#helper_school_graduate').val('');

            
        });




        //////////////////////////////////////////////////////////////
        //직업 경력 입력 사항
        $('.career_info').click(function(){
        
        var code=$('.career_insert').html().trim();
        
        $('#career_info').modal('show'); 

        $('.career_btn').click(function(){
        

            
            code=code+"<tr><td>"+$('#helper_career_name').val()+"</td><td>"+$('#helper_career_period').val()+"</td><td>"+$('#helper_career_wrok').val()+"</td><td>"+$('#helper_career_department').val()+"</td><td>"+$('#helper_career_position').val()+"</td><td><button class='career_modi'>수정</button><button type='button' class='career_del'>삭제</button></td></tr>";

            //화면에 컬럼 추가  

            $('.career_insert').html(code);
             
         
          //모달 숨기기
          $('#career_info').modal('hide');
        

        });
         //모달 값 초기화
         $('#helper_carrer_name').val(''); 
          $('#helper_career_period').val(''); 
          $('#helper_career_wrok').val('');
          $('#helper_career_department').val('');
          $('#helper_career_position').val('');

        
    });

    ///////////////////////////////////////////////////
    //자격 면허사항 입력사항
    $('.license_info').click(function(){
        
        var code=$('.license_insert').html().trim();
        
        $('#license_info').modal('show'); 

        $('.license_btn').click(function(){
        

            
            code=code+"<tr><td>"+$('#helper_license_name').val()+"</td><td>"+$('#helper_license_agency').val()+"</td><td>"+$('#helper_license_num').val()+"</td><td>"+$('#helper_license_date').val()+"</td><td><button class='license_modi'>수정</button><button type='button' class='license_del'>삭제</button></td></tr>";

            //화면에 컬럼 추가  

            $('.license_insert').html(code);
             
         
          //모달 숨기기
          $('#license_info').modal('hide');
        

        });
         //모달 값 초기화
         $('#helper_license_name').val(''); 
          $('#helper_license_agency').val(''); 
          $('#helper_license_num').val('');
          $('#helper_license_date').val('');


        
    });







    });//jquery 끝








       //학력 수정 버튼 클릭시
       $(document).on('click','.edu_modi',function(e){
        //    console.log('zzzz')
        //    console.log($(this).closest('tr')[0]);
 

            
            //수정 모달 열기
              $('#edu_modify_modal').modal('show');
            
            //처음 학력 사항 입력했을때의 값을 수정 모달로 가져오기
              $('#modi_helper_school_name').val($(this).closest('tr')[0].children[0].textContent); 
              $('#modi_helper_school_major').val($(this).closest('tr')[0].children[1].textContent); 
              $('#modi_helper_education').val($(this).closest('tr')[0].children[2].textContent.select); 
              $('#modi_helper_school_admission').val($(this).closest('tr')[0].children[3].textContent); 
              $('#modi_helper_school_graduate').val($(this).closest('tr')[0].children[4].textContent); 


            //변수에 테이블에 저장되어 있는 컬럼 위치 지정 
            // console.log($(this).closest('tr')[0].children[0].textContent);
            let a0=$(this).closest('tr')[0].children[0];
            let a1=$(this).closest('tr')[0].children[0];
            let a2=$(this).closest('tr')[0].children[1];
            let a3=$(this).closest('tr')[0].children[2];
            let a4=$(this).closest('tr')[0].children[3];
            let a5=$(this).closest('tr')[0].children[4];



         

            //수정 모달의 수정 버튼 클릭시 테이블 값 변경
            $('.modi_edu_btn').on('click',function(){
                var  select= document.getElementById('modi_helper_education');
                var modi_selected_text = [...select.selectedOptions].map(option => option.text);

                a1.textContent=$('#modi_helper_school_name').val();
                a2.textContent=$('#modi_helper_school_major').val();
                a3.textContent=modi_selected_text[0];
                a4.textContent=$('#modi_helper_school_admission').val();
                a5.textContent=$('#modi_helper_school_graduate').val();
              
                //수정 모달 닫기
                $('#edu_modify_modal').modal('hide');
            });

        });
            




        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //경력 사항 수정 버튼 클릭시
        $(document).on('click','.career_modi',function(e){
        //    console.log('zzzz')
        //    console.log($(this).closest('tr')[0]);
 

            
            //수정 모달 열기
              $('#modi_career_info').modal('show');
            
            //처음 학력 사항 입력했을때의 값을 수정 모달로 가져오기
              $('#modi_helper_career_name').val($(this).closest('tr')[0].children[0].textContent); 
              $('#modi_helper_career_period').val($(this).closest('tr')[0].children[1].textContent); 
              $('#modi_helper_career_wrok').val($(this).closest('tr')[0].children[2].textContent); 
              $('#modi_helper_career_department').val($(this).closest('tr')[0].children[3].textContent); 
              $('#modi_helper_career_position').val($(this).closest('tr')[0].children[4].textContent); 


            //변수에 테이블에 저장되어 있는 컬럼 위치 지정 
            // console.log($(this).closest('tr')[0].children[0].textContent);

            let a1=$(this).closest('tr')[0].children[0];
            let a2=$(this).closest('tr')[0].children[1];
            let a3=$(this).closest('tr')[0].children[2];
            let a4=$(this).closest('tr')[0].children[3];
            let a5=$(this).closest('tr')[0].children[4];



         

            //수정 모달의 수정(입력) 버튼 클릭시 테이블 값 변경
            $('.modi_career_btn').on('click',function(){
 
                a1.textContent=$('#modi_helper_career_name').val();
                a2.textContent=$('#modi_helper_career_period').val();
                a3.textContent=$('#modi_helper_career_wrok').val();
                a4.textContent=$('#modi_helper_career_department').val();
                a5.textContent=$('#modi_helper_career_position').val();
              
                //수정 모달 닫기
                $('#modi_career_info').modal('hide');
            });

        });



        ///////////////////////////////////////////////////////////////////////
        //자격 민 면허사항 수정 버튼 클릭시
        $(document).on('click','.license_modi',function(e){
        //    console.log('zzzz')
        //    console.log($(this).closest('tr')[0]);
 

            
            //수정 모달 열기
              $('#modi_license_info').modal('show');
            
            //처음 학력 사항 입력했을때의 값을 수정 모달로 가져오기
              $('#modi_helper_license_name').val($(this).closest('tr')[0].children[0].textContent); 
              $('#modi_helper_license_agency').val($(this).closest('tr')[0].children[1].textContent); 
              $('#modi_helper_license_num').val($(this).closest('tr')[0].children[2].textContent); 
              $('#modi_helper_license_date').val($(this).closest('tr')[0].children[3].textContent); 


            //변수에 테이블에 저장되어 있는 컬럼 위치 지정 
            // console.log($(this).closest('tr')[0].children[0].textContent);
          
            let a1=$(this).closest('tr')[0].children[0];
            let a2=$(this).closest('tr')[0].children[1];
            let a3=$(this).closest('tr')[0].children[2];
            let a4=$(this).closest('tr')[0].children[3];




         

            //수정 모달의 수정(입력) 버튼 클릭시 테이블 값 변경
            $('.modi_license_btn').on('click',function(){
 
                a1.textContent=$('#modi_helper_license_name').val();
                a2.textContent=$('#modi_helper_license_agency').val();
                a3.textContent=$('#modi_helper_license_num').val();
                a4.textContent=$('#modi_helper_license_date').val();
              
                //수정 모달 닫기
                $('#modi_license_info').modal('hide');
            });

        });




        //학력 삭제

        //학력 삭제 버튼 클릭시
        $(document).on('click','.edu_del',function(e){
         
          $(this).closest('tr')[0].textContent='';
        });


        //경력 삭제

        //학력 삭제 버튼 클릭시
        $(document).on('click','.career_del',function(e){
         
         $(this).closest('tr')[0].textContent='';
       });

       //자격 및 면허사항 삭제
       $(document).on('click','.license_del',function(e){
         
         $(this).closest('tr')[0].textContent='';
       });




       ///////////////////////////////////////////////////////////


       //이전 버튼 클릭
       $(document).on('click','.submit_before',function(e){
                
        history.back();
            });


        //신청 버튼 클릭
        $(document).on('click','.submit_btn',function(e){
                
            if($('.info_insert').children().length===0){
                alert('학력 사항을 입력하세요');
                return
            }else if($('.career_insert').children().length===0){
                alert('근무 경력 사항을 입력하세요');
                return
            }else if($('.license_insert').children().length===0){
                alert('자격 / 면허 사항을 입력하세요');
                return
            }else{
                //$('form').submit();
            }
          
           
              
            });








</script>










            <div class="col-md-2"></div>
            </div>
            </div>
            

</body>
</html>