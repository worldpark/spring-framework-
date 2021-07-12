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
			
			document.form1.action = "${path}/board/update"
			
			document.form1.submit();
			
		});
		
		$("#gdsImg").change(function(){
			   if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) 
				{
					$(".select_img img").attr("src", data.target.result).width(500);        
			    }
			    reader.readAsDataURL(this.files[0]);
			}
		});
	});
</script>

<style>
	.select_img img{
		margin:20px 0;
		width:800px;
		height: auto;
	}
</style>
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
	<form name = "form1" method = "post" enctype="multipart/form-data">
		<div>
			글쓴이<span class="tab">&#9;</span><input name = "nickname" size = "40" value = "${member.nickname}" readonly/>
		</div>
		<div>
			제목<span class="tab">&#9;&#9;</span><input name = "subject" size = "80" placeholder="제목을 입력해주세요" value = "${dto.subject}">
		</div>
		<div>
			판매물품<span class="tab">&#9;</span><input name = "tradegoods" size = "80" placeholder="판매물품을 입력해주세요" value = "${dto.tradegoods}">
		</div>
		<div>
			판매가격<span class="tab">&#9;</span><input name = "price" size = "40" value = "${dto.price}">
		</div>
		<div>
			내용<br/>
			<textarea rows="10" name="content" cols="100">${dto.content}</textarea>
		</div>
		<div>
			<label for="gdsImg">이미지</label>
			<input type = "file" id = "gdsImg" name = "file"/>
			<div class = "select_img">
				<img src = "../img${dto.gdsImg}"/>
				<input type = "hidden" name = "gdsImg" value = "${dto.gdsImg}"/>
				<input type = "hidden" name = "gdsThumbImg" value = "${dto.gdsThumbImg}"/>
			</div>
		</div>
		<div style = "width:650px; text-align:center;">
			<input type = "hidden" name = "bid" value = "${dto.bid}">
			<button type = "button" id = "btnsave">확인</button>
			<button type = "button" onclick = "history.back(-1);">취소</button>
		</div>
	</form>
	</div>
</body>
</html>