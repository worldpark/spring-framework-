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
	var url = "${path}/trade/rqtradelist";

	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

//페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
	
	var url = "${path}/trade/rqtradelist";
	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

//다음 버튼 이벤트
function fn_next(page, range, rangeSize) {

	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;
	var url = "${path}/trade/rqtradelist";
	
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	
	location.href = url;
}

$(document).ready(function(){
	$("#allCheck").click(function() {
		
		var chk = $("#allCheck").prop("checked");
		if (chk) {
			$(".chBox").prop("checked", true);
		} else {
			$(".chBox").prop("checked", false);
		}
	});

	$(".chBox").click(function() {
		
		$("#allCheck").prop("checked", false);
	});
	
	$(".selectDelete_btn").click(function() {
		var checkArr = new Array();

		$("input[class='chBox']:checked").each(function() {
			checkArr.push($(this).attr("data-Num"));
		});

		$.ajax({
			url : "/trade/cancletrade",
			type : "post",
			data : {
				chbox : checkArr
			},
			success : function() {
				location.href = "/trade/rqtradelist";
			}
		});
	});
	
});
</script>
<style>
	body{
		padding-top: 70px;
		padding-bottom: 30px;
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
<ul>
		<li>
			<div class="delBtn">
				<button type="button" class="selectDelete_btn">거래취소</button>
			</div>
		</li>
	</ul>
			<div class = "table-responsive">
	<table class = "table table-striped table-sm">
		<colgroup>
			<col style="width:20%;" />
			<col style="width:10%;" />
			<col style="width:30%;" />
			<col style="width:20%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
		</colgroup>
		
		<thead>
		<tr>
			<th>
				<div class="allCheck">
					<input type="checkbox" name="allCheck" id="allCheck" />
					<label for="allCheck">모두 선택</label>
				</div>
			</th>
			<th>거래번호</th>
			<th>구매자아이디(닉네임)</th>
			<th>판매물품</th>
			<th>판매가격</th>
			<th></th>
		</tr>
		</thead>
		
		
		<tbody>
		<c:forEach var="rqrow" items="${rqlist}">
			<form name = "form${rqrow.tid}" method = "get" action = "${path}/trade/trade?tid=${rqrow.tid}">
			<tr>
				<td>
					<input type="checkbox" name="chBox" class="chBox" value="${rqrow.tid}" data-Num = "${rqrow.tid};${rqrow.buyerid};${rqrow.tradepoint}"/>
				</td>
				<td>
					${rqrow.tid}
					<input type = "hidden" name = "tid" id = "tid" size = "10" value = "${rqrow.tid}" readonly>
				</td>
				<td>
					${rqrow.buyerid}(${rqrow.buyernickname})
					<input type = "hidden" name = "id" id = "id" size = "10" value = "${rqrow.buyerid}(${rqrow.buyernickname})" readonly>
					<input type = "hidden" name = "buyerid" id = "buyerid" value = "${rqrow.buyerid}">
					<input type = "hidden" name = "sellerid" id = "sellerid" value = "${rqrow.sellerid}">
					<input type = "hidden" name = "check" id = "check" value = "1">
				</td>
				<td>
					${rqrow.tradegoods}
					<input type = "hidden" name = "rpoint" id = "rpoint" size = "10" value = "${rqrow.tradegoods}" readonly>
				</td>
				<td>
					${rqrow.tradepoint}
					<input type = "hidden" name = "rpoint" id = "rpoint" size = "10" value = "${rqrow.tradepoint}" readonly>
				</td>
				<td>
					<input type = "submit" name = "btnapprove" id = "btnapprove" value = "거래승낙">
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