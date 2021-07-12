<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="../include/include2.jsp"%>

<style>
    body {
        background: #f8f8f8;
        padding: 60px 0;
    }
    
    #login-form > div {
        margin: 15px 0;
    }

</style>

<script type="text/javascript">
var checkid = false;
var checknick = false;

$(document).ready(function(){
	
	$("#reg_submit").click(function(){
		var password = $("#password").val();
		var repassword = $("#repassword").val();

		if(password != repassword)
		{
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		}
		else if(checkid == true && checknick == true)
		{
			document.form1.submit();
		}
		else
		{
			alert("아이디와 닉네임이 중복되거나 공백입니다.");
		}
		
		
	});
});

	$(function(){
		$('#id').on('blur', function(){
			var id = $("#id").val();
			
			$.ajax({
				async : true,
				type : 'POST',
				data : id,
				url : "idcheck",
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data)
				{
					if(id == "")
					{
						$("#id_check").text("아이디를 입력하세요");
						$("#id_check").css("color", "red");
						checkid = false;
					}
					else if(data.cnt > 0)
					{
						$("#id_check").text("사용중인 아이디");
						$("#id_check").css("color", "red");
						checkid = false;
					}
					else
					{
						$("#id_check").text("사용가능한 아이디");
						$("#id_check").css("color", "blue");
						checkid = true;
					}
				},
				error : function(request,status,error)
				{
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		});
	});
		
	$(function(){
		$('#nickname').on('blur', function(){
			var nickname = $("#nickname").val();
			
			$.ajax({
				async : true,
				type : 'POST',
				data : nickname,
				url : "nickcheck",
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data)
				{
					if(nickname == "")
					{
						$("#nick_check").text("닉네임을 입력하세요");
						$("#nick_check").css("color", "red");
						checknick = false;
					}
					else if(data.cnt > 0)
					{
						$("#nick_check").text("사용중인 닉네임");
						$("#nick_check").css("color", "red");
						checknick = false;
					}
					else
					{
						$("#nick_check").text("사용가능한 닉네임");
						$("#nick_check").css("color", "blue");
						checknick = true;
					}
				},
				error : function(request,status,error)
				{
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		});
	});
	
</script>

</head>
<body>
<div class="container">
	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-success">
            <div class="panel-heading">
                <div class="panel-title">회원가입</div>
            </div>
            <div class="panel-body">
                <form id="login-form" name = "form1" action = "memberjoinpro.do" method = "POST">
                    <div>
						회원 ID : <input type="text" id = "id" class="form-control" name="id" placeholder="회원ID" autofocus>
                    	<div id = "id_check"></div>
                    </div>
                    <div>
						비밀번호 : <input type="password" class="form-control" id = "password" name="password" placeholder="Password">
                    </div>
                    <div>
						비밀번호 확인 : <input type="password" class="form-control" id = "repassword" name="repassword" placeholder="비밀번호 확인">
                    </div>
                    <div>
						이름 : <input type="text" class="form-control" name="name" placeholder="이름">
                    </div>
                    <div>
						닉네임 : <input type="text" class="form-control" id = "nickname" name="nickname" placeholder="사용할 닉네임">
                    	<div id = "nick_check"></div>
                    </div>
                    <div>
						주소 : <input type="text" class="form-control" name="address" placeholder="주소">
                    </div>
                    <div>
						휴대전화 : <input type="text" class="form-control" name="ph" placeholder="휴대폰 번호">
                    </div>
                    <div>
                        <button type="button" id = "reg_submit" class="form-control btn btn-primary">회원가입</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>