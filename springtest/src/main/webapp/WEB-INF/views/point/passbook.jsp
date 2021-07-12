<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<title>Insert title here</title>
<script>
function calc(radio){
	var pay = document.getElementById("point");
	if(radio.checked)
		point.value=parseInt(radio.value);
}

$(document).ready(function(){
	
	$('#btndeposit').click(function(){
		var pay = parseInt($('#point').val());
		var AcNum = $('#AcNum').val();
		var memberpoint = parseInt($('#memberpoint').val());
		
		if(pay <= 0)
		{
			alert("입금금액을 선택하세요" + memberpoint);
			return;
		}
		else if(AcNum == "")
		{
			alert("계좌번호를 입력하세요");
			return;
		}
		else if (memberpoint < pay)
		{
			alert("포인트가 부족합니다.");
		}
		else
		{
			document.form1.submit();
		}
	});
});
</script>

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
		margin-left: 50px;
    }
    #center {
    	float:center;
    }
</style>
</head>
<body>
<div>
	<h2>입금하실 계좌를 선택해주세요.</h2>
</div>
<hr><br/>
	<form name = form1 method="post" action = "${path}/point/pbsuc">
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
		<br/><br/><input name = "point" id = "point" size = "4" value = "0" style="margin-left: 55px;">원<br/><br/>
		<input type = "hidden" name = "id" id = "id" value= "${member.id}">
<article>
		<div class = "container">
			<div class="form-group row justify-content-center">
			<div class="w100" style="padding-right:10px">
				<select class="form-control form-control-sm" name="searchBank" id="searchType">
					<option value="sindool">신둘은행</option>
					<option value="juhui">저희은행</option>
					<option value="gaehyeob">개협은행</option>
				</select>
			</div>
			<div class="w300" style="padding-right:10px">
				<input type="text" class="form-control form-control-sm" name="AcNum" id="AcNum" placeholder="계좌번호입력">
			</div>
			<div>
				<input type = "button" name="btndeposit" id="btndeposit" value = "입금하기">
			</div>

		</div>
		</div>
</article>
<input type = "hidden" id = "memberpoint" name = "memberpoint" value = "${member.point}">

</form>
</body>
</html>