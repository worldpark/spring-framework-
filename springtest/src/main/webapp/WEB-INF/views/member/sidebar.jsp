<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<%@ include file="../include/include2.jsp"%>
<link rel="stylesheet" type="text/css" href="../../resources/css/sidebar.css"/>

<script>
$(function () {
    $('.navbar-toggle').click(function () {
        $('.navbar-nav').toggleClass('slide-in');
        $('.side-body').toggleClass('body-slide-in');
        $('#search').removeClass('in').addClass('collapse').slideUp(200);

        
    });
});
</script>
</head>
<body>
<div class="row">

    <div class="side-menu">
    
    <nav class="navbar navbar-default" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <div class="brand-wrapper">
            <!-- Hamburger -->
            <button type="button" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <!-- Search body -->
            <div id="search" class="panel-collapse collapse">
                <div class="panel-body">
                    <form class="navbar-form" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default "><span class="glyphicon glyphicon-ok"></span></button>
                    </form>
                </div>
            </div>
        </div>

    </div>

    <!-- Main Menu -->
    <div class="side-menu-container">
        <ul class="nav navbar-nav">

            <li><a href="${path}/member/mypage"><span class="glyphicon glyphicon-send"></span> 정보관리</a></li>
            <li><a href="${path}/trade/tradehistory"><span class="glyphicon glyphicon-plane"></span> 거래내역</a></li>
            <li><a href="${path}/trade/tradelist"><span class="glyphicon glyphicon-cloud"></span> 거래관리</a></li>
           <li><a href="${path}/trade/rqtradelist"><span class="glyphicon glyphicon-signal"></span> 거래요청관리</a></li>

        </ul>
    </div>
</nav>
    
    </div>

</div>
</body>
</html>