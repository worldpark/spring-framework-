<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include.jsp"%>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$('#close-button').click(function(){
		opener.parent.location.reload();

		self.close();
	})
})
</script>
<style>
	body {
        background: #f8f8f8;
        padding: 60px 60px;
    }
</style>
</head>
<body>
<div>
	은행명 : ${searchBank}
</div>
<div>
	계좌번호 : ${AcNum}
</div>
<div>
	입금이 완료되었습니다.
</div>
<button type="button" class="form-control btn btn-primary" name = "close-button" id = "close-button">닫기</button>
</body>
</html>