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
	var url = "${path}/point/pointlist";

	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

//페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
	
	var url = "${path}/point/pointlist";
	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

//다음 버튼 이벤트
function fn_next(page, range, rangeSize) {

	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;
	var url = "${path}/point/pointlist";
	
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
			url : "/point/processpoint",
			type : "post",
			data : {
				chbox : checkArr
			},
			success : function() {
				
				window.parent.location.href = "../index";
			}
		});
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
	
	<div style="margin-left:350px">
	
	<ul>
		<li>

			<div class="delBtn">
				<button type="button" class="selectDelete_btn">요청 처리</button>
			</div>

		</li>
	</ul>
	<table border="1" width="600px">
		<tr>
			<th>
				<div class="allCheck">
					<input type="checkbox" name="allCheck" id="allCheck" /><label
						for="allCheck">모두 선택</label>
				</div>
			</th>
			<th>아이디</th>
			<th>요청포인트</th>
		</tr>
		
		
		<c:forEach var="rprow" items="${rqlist}">
			<tr>
				<td>
					<input type="checkbox" name="chBox" class="chBox" value="${rprow.rid}" data-Num = "${rprow.rid};${rprow.id};${rprow.rpoint}"/>
				</td>
				<td>
					<input name = "id" id = "id" size = "20" value = "${rprow.id}" readonly>
				</td>
				<td>
					<input name = "rpoint" id = "rpoint" size = "20" value = "${rprow.rpoint}" readonly>
					
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
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
</body>
</html>