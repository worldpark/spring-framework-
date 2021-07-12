<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<title>Insert title here</title>

<script>
	$(document).ready(function(){
		
		$("#btndelete").click(function(){
			if(confirm("삭제하시겠습니까?"))
			{
				document.form1.action = "${path}/board/delete";
				document.form1.submit();
			}
		});
		
		
		$("#btnupdate").click(function(){
			document.form1.action = "${path}/board/update_write";
			document.form1.submit();
		});
		
		$("#rqtrade").click(function(){
			
			var tradepoint = parseInt($('#tradepoint').val());
			var point = parseInt($('#point').val());

			if(tradepoint > point)
			{
				alert("포인트가 부족합니다.");
			}
			else
			{
				document.form1.action = "${path}/trade/rqtrade";
				document.form1.submit();
				parent.document.location.reload();
			}
		});
	});
</script>

<style>
	.oriImg{
		width:800px;
		height: auto;
		margin: 20px 0;
	}
	.thumbImg{
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
	<form name = "form1" method = "post">
		<div>
			게시물번호 :<span class="tab">&#9;</span><input name = "bid" size = "40" value = "${dto.bid}" readonly/>
		</div>
		<div>
			작성일자 :<span class="tab">&#9;</span><fmt:formatDate value = "${dto.createdate}" pattern = "yyyy-MM-dd"/>
		</div>
		<div>
			글쓴이<span class="tab">&#9;&#9;</span><input name = "sellernickname" size = "40" value = "${dto.nickname}" readonly/>
		</div>
		<div>
			제목<span class="tab">&#9;&#9;&#9;</span><input name = "subject" size = "40" value = "${dto.subject}" readonly>
		</div>
		<div>
			판매물품<span class="tab">&#9;&#9;</span><input name = "tradegoods" size = "40" value = "${dto.tradegoods}" readonly>
		</div>
		<div>
			판매가격<span class="tab">&#9;&#9;</span><input name = "tradepoint" id = "tradepoint" size = "40" value = "${dto.price}" readonly>
		</div>
		<div>
			내용<br/>
			<textarea rows="10" name="content" cols="100" readonly>${dto.content}</textarea>
		</div>
		<div>
			<img src = "../img${dto.gdsImg}" class = "oriImg"/>
		</div>
		<input type = "hidden" name = "sellerid" value = "${dto.id}">
		<input type = "hidden" name = "buyerid" value = "${member.id}">
		<input type = "hidden" name = "buyernickname" value = "${member.nickname}">
		<input type = "hidden" name = "point" id = "point" value = "${member.point}">
		
		
		<c:set var="id" value = "${member.id}"/>
		<c:set var="creater" value = "${dto.id}"/>
		<c:set var="rqcount" value = "${rqcount}"/>
		
		<c:choose>
			<c:when test = "${creater == null }">
				creater 안가져옴 
    		</c:when>
			<c:when test = "${id == null }">
				id 안가져옴
    		</c:when>
    		
			<c:when test = "${id == creater }">
				<div style = "widht:650px; margin-left:250px;">
					<input type = "hidden" name = "bid" value= "${dto.bid}">
					<button type = "button" id = "btnupdate">수정</button>
					<button type = "button" id = "btndelete">삭제</button>
				</div>
    		</c:when>
    		
    		<c:when test="${rqcount >= 1}">
    			<div>
    				구매요청중...
    			</div>
    		</c:when>
    		
    		<c:otherwise>
					<button type = "button" id = "rqtrade">구매요청</button>
    		</c:otherwise>
    		
		</c:choose>
		
		
	</form>
	</div>

</body>
</html>