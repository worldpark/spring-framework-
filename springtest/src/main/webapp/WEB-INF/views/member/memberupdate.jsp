<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<script>
$(document).ready(function(){
	$("#btnsave").click(function(){
		var nickname = $("#nickname").val();
		var name = $("#name").val();
		var address = $("#address").val();
		var ph = $("#ph").val();
		
		if(nickname == "")
		{
			alert("닉네임을 입력하세요");
			document.form1.subject.focus();
			return;
		}
		if(name == "")
		{
			alert("이름을 입력하세요");
			document.form1.content.focus();
			return;
		}
		if(address == "")
		{
			alert("주소를 입력하세요");
			document.form1.tradegoods.focus();
			return;
		}
		if(ph == "")
		{
			alert("전화번호를 입력하세요");
			document.form1.price.focus();
			return;
		}
		
		document.form1.action = "${path}/member/update";
		
		document.form1.submit();

	});
});
</script>
<style>
	body{
		padding-top: 70px;
		padding-left: 30px;
	}
</style>

</head>
<body>
	<%@ include file="../menubar.jsp"%>
	
	<div style="margin-left:250px">
	<form name = "form1" method = "post">
		<div>
			아이디 :<span class="tab">&#9;&#9;</span><input name="id" size="40" value="${member.id}" readonly />
		</div>
		<div>
			닉네임 :<span class="tab">&#9;&#9;</span><input name="nickname" size="40" value="${dto.nickname}" />
		</div>
		<div>
			이름 :<span class="tab">&#9;&#9;</span><input name="name" size="40" value="${dto.name}" />
		</div>
		<div>
			주소 :<span class="tab">&#9;&#9;</span><input name="address" size="40" value="${dto.address}" />
		</div>
		<div>
			전화번호 :<span class="tab">&#9;</span><input name="ph" size="40" value="${dto.ph}" />
		</div>
		<div>
			<button type="button" id="btnsave">수정완료</button>
			<button type = "button" onclick = "history.back(-1);">취소</button>
		</div>
	</form>
	</div>
</body>
</html>