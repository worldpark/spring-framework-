<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<title>Insert title here</title>
<style type ="text/css">

    body {
        background: #f8f8f8;
        padding: 60px 0;
    }
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #f1f1f1;
}
li a.active {
    background-color: #4CAF50;
    color: white;
}
li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}
li a:hover:not(.active) {
    background-color: #555;
    color: white;
}
	</style>
</head>
<body>
	<ul>
      <li><a class="active">결제방식</a></li>
      <li><a href="${path}/point/deposit" target="rp_main">무통장입금</a></li>
    </ul>
</body>
</html>