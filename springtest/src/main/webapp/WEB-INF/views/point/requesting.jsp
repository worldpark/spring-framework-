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
    div {
    	background: #FFFFFF;
    	font-size: large;
    }
</style>
</head>
<body>
<h2>포인트 요청 처리가 되었습니다.</h2>
<p>아래 계좌로 충전금액만큼 입금해주시면 확인후 포인트를 충전시켜 드리겠습니다.</p>
<div>
	<p>신둘 은행 : 111-555-555555</p>
	<p>저희 은행 : 111-6564-54564</p>
	<p>개협 은행 : 12-6544-5264</p>
</div>
<button type="button" class="form-control btn btn-primary" id = "regist-button" onclick="parent.window.close();">닫기</button>
</body>
</html>