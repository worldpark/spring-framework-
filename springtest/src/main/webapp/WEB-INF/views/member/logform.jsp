<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>

<link rel="stylesheet" href="${path}/resources/css/loginform.css">
<title>Insert title here</title>


</head>
<body>

	<div class="container">

		<div class="col-lg-4"></div>

		<div class="col-lg-4">
				<div style="margin-top: 20px;">

			<!-- 점보트론 -->
			<div class="jumbotron" style="padding-top: 20px;" >

				<!-- 로그인 정보를 숨기면서 전송post -->
				<form name = "form1" method="post" action = "/member/login">

					<h3 style="text-align: center;">로그인</h3>
					<c:if test="${msg == false }">
						<p style="color:#ff0000;">아이디 또는 비밀번호가 다릅니다.</p>
					</c:if>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="id">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="password">
					</div>

					<input type="submit" class="btn btn-primary form-control" id="login" 
						value="Login">
				</form>
			</div>
				</div>
		</div>
	</div>
</body>
</html>