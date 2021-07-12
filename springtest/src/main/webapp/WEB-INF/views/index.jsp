<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<%@ include file="../views/include/include2.jsp"%>

<link rel="stylesheet" type="text/css"
	href="../../resources/css/menuView.css" />
<style>
#footer {
	width: 100%;
	height: 100px;
	position: absolute;
	bottom: 0;
	background: #5eaeff;
	text-align: center;
	background-color: #dcdcdc;
}
</style>

</head>
<body>

	<%@ include file="menubar.jsp"%>

	<img style="margin-top: 50px; width: 100%; height: 1000"
		src="../../resources/index.png">

	<div id="footer">
	제작 : 김재력 <br/>
	이메일 : zaccon@naver.com
	</div>
</body>
</html>