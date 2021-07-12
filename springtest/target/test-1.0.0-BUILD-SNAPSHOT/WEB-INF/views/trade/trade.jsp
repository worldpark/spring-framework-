<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<title>Insert title here</title>
<script>

$(document).ready(function(){
	$('#finishtrade').click(function(){
		document.form1.action = "${path}/trade/fintrade";
		document.form1.submit();
	});
	
	$('#cancletrade').click(function(){
		document.form1.action = "${path}/trade/cancletrading";
		document.form1.submit();
	});
});
</script>
<style>
    body {
        background: #f8f8f8;
		padding-top: 70px;
		padding-left: 30px;
    }
    .sadiv {
		background: #669999;
        padding: 20px 20px;
		margin: 15px;
    }
    .badiv {
		background: #6699ff;
        padding: 20px 20px;
		margin: 15px;
    }
    .btn {
		margin-left: 200px;
    }
</style>
</head>
<body>

	<%@ include file="../menubar.jsp"%>
	<%@ include file="../member/sidebar.jsp"%>
	
	<div style="margin-left:350px">
	
	<form name = "form1" method = "post">
	<div>판매자 : ${tdto.sellerid}(${tdto.sellernickname})</div>
	<div>구매자 : ${tdto.buyerid}(${tdto.buyernickname})</div>
	<div>판매 물품 : ${tdto.tradegoods}</div>
	<div>판매 가격 : ${tdto.tradepoint}</div>
	<div>
		<div class = "sadiv">
			<div>판매자 : ${smdto.id}(${smdto.nickname})</div>
			<div>판매자 전화번호 : ${smdto.ph}</div>
		</div>
		<div class = "badiv">
			<div>구매자 : ${bmdto.id}(${bmdto.nickname})</div>
			<div>구매자 전화번호 : ${bmdto.ph}</div>
			<div>배송지 주소 : ${bmdto.address}</div>
		</div>
	</div>
	<input type = "hidden" name = "tid" id = "tid" value = "${tdto.tid}">
	<input type = "hidden" name = "sellerid" id = "sellerid" value = "${tdto.sellerid}">
	<input type = "hidden" name = "buyerid" id = "buyerid" value = "${tdto.buyerid}">
	<input type = "hidden" name = tradepoint id = "buyerid" value = "${tdto.tradepoint}">
	
	<c:set var="id" value = "${member.id}"/>
	<c:set var="sellerid" value  = "${smdto.id}"/>
	<c:set var="buyerid" value = "${bmdto.id}"/>
	<c:set var="status" value = "${tdto.status}"/>
	
	<c:choose>
		<c:when test = "${id == sellerid and status == '거래중'}">
			<div class = "btn"><input type = "button" id = "cancletrade" name = "cancletrade" value = "거래취소"></div>
		</c:when>
		<c:when test = "${id == buyerid and status == '거래중'}">
			<div class = "btn"><input type = "button" id = "finishtrade" name = "finishtrade" value = "거래완료"></div>
		</c:when>
	</c:choose>
	</form>
	</div>
</body>
</html>