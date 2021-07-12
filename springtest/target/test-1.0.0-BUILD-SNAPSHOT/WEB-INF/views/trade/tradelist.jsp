<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include2.jsp"%>
<title>Insert title here</title>

<script>
function fn_prev(page, range, rangeSize) {
	var page = ((range - 2) * rangeSize) + 1;
	var range = range - 1;
	var url = "${path}/trade/tradelist";

	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

//페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
	
	var url = "${path}/trade/tradelist";
	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

//다음 버튼 이벤트
function fn_next(page, range, rangeSize) {

	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;
	var url = "${path}/trade/tradelist";
	
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	
	location.href = url;
}

</script>
<style>
    .btn-link {
    border: none;
    outline: none;
    background: none;
    cursor: pointer;
    color: #0000EE;
    padding: 0;
    text-decoration: underline;
    font-family: inherit;
    font-size: inherit;
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
	<%@ include file="../member/sidebar.jsp"%>
	
	<div style="margin-left:350px">
	<article>
		<div class = "container">
			<div class = "table-responsive">
	<table class = "table table-striped table-sm">
		<colgroup>
			<col style="width:10%;" />
			<col style="width:25%;" />
			<col style="width:25%;" />
			<col style="width:20%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
		</colgroup>
		<thead>
		<tr>
			<th>거래번호</th>
			<th>판매자아이디(닉네임)</th>
			<th>구매자아이디(닉네임)</th>
			<th>판매물품</th>
			<th>판매가격</th>
			<th>거래상태</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach var="trrow" items="${trlist}">
			<form name = "form${trrow.tid}" method = "get" action = "${path}/trade/trade?tid=${trrow.tid}">
			<tr>
				<td>
					<button type = "submit" class = "btn-link" id = "btnapprove" name = "btnapprove">${trrow.tid}</button>
					<input type = "hidden" name = "tid" id = "tid" size = "10" value = "${trrow.tid}">
				</td>
				<td>
					${trrow.sellerid}(${trrow.sellernickname})
					<input type = "hidden" name = "id" id = "id" size = "10" value = "${trrow.sellerid}(${trrow.sellernickname})" readonly>
					<input type = "hidden" name = "buyerid" id = "buyerid" value = "${trrow.buyerid}">
					<input type = "hidden" name = "sellerid" id = "sellerid" value = "${trrow.sellerid}">
					<input type = "hidden" name = "check" id = "check" value = "0">
					<input type = "hidden" name = "tid" id = "tid" size = "10" value = "${trrow.tid}">
				</td>
				<td>
					${trrow.buyerid}(${trrow.buyernickname})
					<input type = "hidden" name = "id" id = "id" size = "10" value = "${trrow.buyerid}(${trrow.buyernickname})" readonly>
				</td>
				<td>
					${trrow.tradegoods}
					<input type = "hidden" name = "rpoint" id = "rpoint" size = "10" value = "${trrow.tradegoods}" readonly>
				</td>
				<td>
					${trrow.tradepoint}
					<input type = "hidden" name = "rpoint" id = "rpoint" size = "10" value = "${trrow.tradepoint}" readonly>
				</td>
				<td>
					${trrow.status}
					<input type = "hidden" name = "rpoint" id = "rpoint" size = "10" value = "${trrow.status}" readonly>
				</td>
			</tr>
			</form>
		</c:forEach>
		</tbody>
		
	</table>
			</div>
	
	<div id="paginationBox">
		<ul class="pagination">
			<c:if test="${pagination.prev}">
				<li class="page-item">
					<a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">
						Previous
					</a>
				</li>
			</c:if>
			
			<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
				<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
					<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> 
						${idx} 
					</a>
				</li>
			</c:forEach>
			
			<c:if test="${pagination.next}">
				<li class="page-item">
					<a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')" >
						Next
					</a>
				</li>
			</c:if>
		</ul>
	</div>
		</div>
	</article>
	</div>

</body>
</html>