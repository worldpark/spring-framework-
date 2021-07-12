<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<title>Insert title here</title>

<script type="text/javascript">

$(document).ready(function(){
	$('#login').click(function(){
		window.opener.location.reload();
		window.close();
	})
})
</script>

</head>
<body>
${member.nickname}님이 로그인 하셧습니다.
<button type="button" class="form-control btn btn-primary" name = "close-button" id = "login">닫기
</button>
</body>
</html>