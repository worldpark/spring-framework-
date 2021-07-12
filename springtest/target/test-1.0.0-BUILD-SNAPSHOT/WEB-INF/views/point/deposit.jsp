<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<title>Insert title here</title>

<style>
    body {
        background: #f8f8f8;
        padding: 60px 60px;
    }
    #wrqp {
    	width: 100px;
    	height: 100px;
    }
    #inline {
    	width: 90px;
    	height: 20px;
    	display: inline-block;
		font-size: large;
		margin:5px;
    }
    #center {
    	float:center;
    }
</style>
<script>
function calc(radio){
	var pay = document.getElementById("rpoint");
	if(radio.checked)
		rpoint.value=parseInt(radio.value);
}

$(document).ready(function(){
	
	$('#requestpoint').click(function(){
		var pay = $('#rpoint').val();
		if(pay <= 0)
		{
			alert("결제금액을 선택하세요");
			return;
		}
		else
		{
			document.form1.submit();
		}
	});
});
</script>
</head>
<body>

	<c:set var="id" value =  "${member.id}"/>
	<c:choose>
		<c:when test = "${id == null }">
			<p>로그인 후 사용해주세요</p>
		</c:when>
		<c:otherwise>
	
	<form name = form1 method="post" action = "${path}/point/payment">
		<div>
			<div id = "inline"><input type = "radio" name = "pay" value = "50000" onclick="calc(this)">50000원</div>
			<div id = "inline"><input type = "radio" name = "pay" value = "10000" onclick="calc(this)">10000원</div>
		</div>
		<div>
			<div id = "inline"><input type = "radio" name = "pay" value = "5000" onclick="calc(this)">5000원</div>
			<div id = "inline"><input type = "radio" name = "pay" value = "3000" onclick="calc(this)">3000원</div>
		</div>
		<div>
			<div id = "inline"><input type = "radio" name = "pay" value = "1000" onclick="calc(this)">1000원</div>
		</div>
		<br/><br/><input name = "rpoint" id = "rpoint" size = "4" value = "0">원<br/><br/>
		<input type = "button" name = "requestpoint" id = "requestpoint" value = "요청하기">
		<input type = "hidden" name = "id" id = "id" value= "${member.id}">
	</form>
	
		</c:otherwise>
		</c:choose>
</body>
</html>