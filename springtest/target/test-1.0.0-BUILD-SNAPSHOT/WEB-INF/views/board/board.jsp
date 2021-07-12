<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="../include/include2.jsp"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script>
	$(document).ready(function()
	{
		$("#btnWrite").click(function()
		{
			location.href = "${path}/board/write";
		});
	});

	$(document).ready(function()
	{
		$("#back").click(function()
		{
			location.href = "${path}/index";
		});
	});
	
	function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "${path}/board/board";

		url = url + "?page=" + page;
		url = url + "&range=" + range;

		location.href = url;
	}
	
	//페이지 번호 클릭
	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		
		var url = "${path}/board/board";
		url = url + "?page=" + page;
		url = url + "&range=" + range;

		location.href = url;
	}
	
	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize) {

		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		var url = "${path}/board/board";
		
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
	//검색
	$(document).on('click', '#btnSearch', function(e){

		e.preventDefault();
		var url = "${path}/board/board";

		url = url + "?searchType=" + $('#searchType').val();
		url = url + "&keyword=" + $('#keyword').val();
		location.href = url;
		console.log(url);
	});
</script>
<title>Insert title here</title>
<style>
	body{
		padding-top: 70px;
		padding-bottom: 30px;
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
	<article>
		<div class = "container">
			<div class = "table-responsive">
	<table class = "table table-striped table-sm">
		<colgroup>
			<col style="width:10%;" />
			<col style="width:auto;" />
			<col style="width:20%;" />
			<col style="width:20%;" />
			<col style="width:10%;" />
		</colgroup>

		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>닉네임(아이디)</th>
				<th>판매물품</th>
				<th>가격</th>
				<th>작성일</th>
			</tr>
		</thead>

		<tbody>
			<c:choose>
				<c:when test="${empty boardList }" >
					<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
				</c:when> 
				<c:when test="${!empty boardList}">
					<c:forEach var="row" items="${boardList}">
						<input type="hidden" name = "id" value="${row.id}">
						<tr>
							<td>${row.bid}</td>
							<td><a href = "${path}/board/view?bid=${row.bid}">${row.subject}</a></td>
							<td>${row.nickname}(${row.id})</td>
							<td>${row.tradegoods}</td>
							<td>${row.price}</td>
							<td>
								<fmt:formatDate value="${row.createdate}" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>
	
			</div>
			<div>
				<button type = "button" class="btn btn-sm btn-primary" id = "btnWrite">글쓰기</button>
			</div><br/><br/>
			
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
	<div class="form-group row justify-content-center">
			<div class="w100" style="padding-right:10px">
				<select class="form-control form-control-sm" name="searchType" id="searchType">
					<option value=tradegoods>판매물품</option>
					<option value="reg_id">작성자아이디</option>
				</select>
			</div>
			<div class="w300" style="padding-right:10px">
				<input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
			</div>
			<div>
				<button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
			</div>

		</div>
		</div>
	</article>
		</c:otherwise>
	</c:choose>
</body>
</html>