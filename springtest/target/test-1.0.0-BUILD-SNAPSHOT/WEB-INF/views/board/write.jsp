<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	$(document).ready(function(){
		$("#btnsave").click(function(){
			var subject = $("#subject").val();
			var content = $("#content").val();
			var tradegoods = $("#tradegoods").val();
			var price = $("#price").val();
			
			if(subject == "")
			{
				alert("제목을 입력하세요");
				document.form1.subject.focus();
				return;
			}
			if(content == "")
			{
				alert("내용을 입력하세요");
				document.form1.content.focus();
				return;
			}
			if(tradegoods == "")
			{
				alert("판매물품을 입력하세요");
				document.form1.tradegoods.focus();
				return;
			}
			if(price == "")
			{
				alert("금액을 입력하세요");
				document.form1.price.focus();
				return;
			}
			
			document.form1.submit();
			
		});
		
		$("#gdsImg").change(function(){
			   if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) 
				{
					$(".select_img img").attr("src", data.target.result).width(800);        
			    }
			    reader.readAsDataURL(this.files[0]);
			}
		});
	});
</script>
<style>
	body{
		padding-top: 70px;
		padding-left: 30px;
	}
</style>

<style>
	.select_img img{
		margin:20px 0;
	}
</style>

</head>
<body>
	<%@ include file="../menubar.jsp"%>
	<div style="margin-left:250px">
	<!-- 파일 업로드의 경우  enctype="multipart/form-data"의 선언이 필요함-->
	<form name = "form1" method = "post" action = "${path}/board/insert" enctype="multipart/form-data">
		<input type = "hidden" name = "id" value = "${member.id}"/>
		<div>
			글쓴이<span class="tab">&#9;</span><input name = "nickname" size = "40" value = "${member.nickname}" readonly/>
		</div>
		<div>
			제목<span class="tab">&#9;&#9;</span><input name = "subject" size = "40" placeholder="제목을 입력해주세요">
		</div>
		<div>
			판매물품<span class="tab">&#9;</span><input name = "tradegoods" size = "40" placeholder="판매물품을 입력해주세요">
		</div>
		<div>
			판매가격<span class="tab">&#9;</span><input name = "price" type = "number" size = "40" placeholder="판매가격을 입력해주세요">
		</div>
		<div>
			내용<br/>
			<textarea rows="10" name="content" cols="100" placeholder="내용을 입력해주세요"></textarea>
		</div>
		
		<div>
			<label for="gdsImg">이미지</label>
			<input type = "file" id = "gdsImg" name = "file"/>
			<div class = "select_img"><img src = ""/></div>
		</div>
		
		<div style = "width:650px; text-align:center;">
			<button type = "button" id = "btnsave">확인</button>
			<button type = "button" onclick = "history.back(-1);">취소</button>
		</div>
	</form>
	</div>
</body>
</html>