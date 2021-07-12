<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<title>Insert title here</title>


<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");

		$('#point-button').on("click", function(){
			
			window.open("${path}/point/rqpage","포인트 충전", "toolbar=yes, menubar=yes, width=500 height=400 scrollbars=yes resizable=no").focus();
		});
		
		$("#btndelete").click(function(){
			if(confirm("탈퇴하시겠습니까?"))
			{
				document.form1.action = "${path}/member/delete";
				parent.document.location.reload();
				document.form1.submit();
			}
		});

		$("#btnupdate").click(function(){
			document.form1.action = "${path}/member/memberupdate";
			document.form1.submit();
		});
		
		$('#Passbook').on("click", function(){
			
			window.open("${path}/point/passbook","계좌 입금", "toolbar=yes, menubar=yes, width=500 height=600 scrollbars=yes resizable=no").focus();
		});
	});
	
</script>
<style>
	body{
		padding-top: 70px;
		padding-left: 30px;
	}
	.charge{
		padding: 10px 210px;
	}
</style>

</head>
<body>
	<%@ include file="../menubar.jsp"%>

	<c:set var="id" value =  "${member.id}"/>
	
	<c:choose>
		<c:when test = "${id == null }">
			<p>로그인 후 사용해주세요</p>
		</c:when>
		<c:otherwise>
	<%@ include file="../member/sidebar.jsp"%>

	
	<div style="margin-left:350px">
	<form name = "form1" method = "post">
		<div>
			아이디 :<span class="tab">&#9;&#9;</span><input name = "id" size = "40" value = "${member.id}" readonly/>
		</div>
		<div>
			닉네임 :<span class="tab">&#9;&#9;</span><input name = "nickname" size = "40" value = "${dto.nickname}" readonly/>
		</div>	
		<div>
			이름 :<span class="tab">&#9;&#9;</span><input name = "name" size = "40" value = "${dto.name}" readonly/>
		</div>
		<div>
			주소 :<span class="tab">&#9;&#9;</span><input name = "address" size = "40" value = "${dto.address}" readonly/>
		</div>
		<div>
			전화번호 :<span class="tab">&#9;</span><input name = "ph" size = "40" value = "${dto.ph}" readonly/>
		</div>
		<div>
			포인트 :<span class="tab">&#9;&#9;</span><input name = "point" size = "40" value = "${dto.point}" readonly/><span class="tab">&#9;</span><button type = "button" id = "Passbook">통장입금</button>
		</div>
		<br>
		<div>
			<button type="button" id="point-button" class="charge">포인트 충전하기</button>
		</div>
		<br>
		<div>
			<button type = "button" id = "btnupdate">정보수정</button>
			<button type = "button" id = "btndelete">탈퇴하기</button>
		</div>
	</form>
	</div>
	
		</c:otherwise>
	</c:choose>
</body>
</html>