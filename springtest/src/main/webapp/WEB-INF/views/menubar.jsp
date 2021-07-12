<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../views/include/include2.jsp"%>
<link rel="stylesheet" type="text/css" href="../../resources/css/menuView.css"/>
	
	<div style="margin-top:100px">
<nav class="navbar fixed-top navbar-expand-md flex-nowrap navbar-new-top">
		<a href="/index" class="navbar-brand">
			중고마켓</a>
		<ul class="nav navbar-nav mr-auto"></ul>
		
		<c:set var="id" value =  "${member.id}"/>
		<c:choose>
		
		<c:when test = "${id == null }">
		
		<!-- 로그인전 화면 -->	
		<ul class="navbar-nav flex-row">
			<li class="nav-item">
				<a class="nav-link px-2" href="/logform" onclick="window.open(this.href,'로그인' ,'width=500, height=400'); return false">
					login
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link px-2" href="/regist" onclick="window.open(this.href,'회원가입' ,'width=500, height=800'); return false">regist</a>
			</li>
		</ul>
		</c:when>
		
		<c:otherwise>
		<!-- 로그인 화면 -->
			<ul class="navbar-nav flex-row">
			<li class="nav-item">
				<a class="nav-link px-5">${member.point} point</a>
			</li>
			<li class="nav-item">
				<a class="nav-link px-2">${member.nickname}</a>
			</li>
			<li class="nav-item">
				<a class="nav-link px-2" href = "/logout">logout</a>
			</li>
			</ul>
		</c:otherwise>
		</c:choose>
		
		
		<button class="navbar-toggler ml-auto" type="button"
			data-toggle="collapse" data-target="#navbar2">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<nav class="navbar fixed-top navbar-expand-md navbar-new-bottom">
		<div class="navbar-collapse collapse pt-2 pt-md-0" id="navbar2">

			<ul class="navbar-nav w-100 justify-content-center px-3">
				<li class="nav-item">
					<a class="nav-link" href="../board/board">거래게시판</a>
				<li class="nav-item">
					<a class="nav-link" href="../member/mypage">마이페이지</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${path}/point/rqpage" onclick="window.open(this.href,'포인트충전' ,'width=500, height=400'); return false">포인트충전</a>
				</li>
				
				<!-- 회원의 rank데이터가 1이면 관리자로 구분 -->
				<c:if test = "${member.rank == 1}">
					<li class="nav-item">
						<a class="nav-link" href = "${path}/point/pointlist">포인트요청리스트</a>
					</li>
				</c:if>
			</ul>
		</div>
	</nav>
	</div>