<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>
 	<!-- Font Icon -->
    <link rel="stylesheet" href="/resources/fonts/material-icon/css/material-design-iconic-font.min.css">
	<!-- Main css -->
    <link rel="stylesheet" href="/resources/css/signUp.css">
    <!-- 로그인 된 상태일  때 -->
    <c:if test="${sessionScope.member_id eq null }">
    	 <script>
	    	  alert('로그인 이후 이용하실 수 있습니다.');
	 		  location.href='/member/login';
 		 </script>
    </c:if>
    
    <c:if test="${sessionScope.boardMsg ne null}">
        <script>alert('${sessionScope.boardMsg}');</script>	
    </c:if>
    
      <c:if test="${sessionScope.boardMsg ne null}">
         <c:remove var="boardMsg" scope="session"/>
    </c:if>
</head>
<body>
	<!-- Nav쪽 -->
	<nav class="navbar navbar-default navbar-backdefault">
	  <div class="container-fluid">
	    <div class="navbar-header">
	    	<button type="button" class="navbar-toggle collapsed" 
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expended="false">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
			</button>
			<a href="https://github.com/sinwonkim"><img src="/resources/images/unp2.PNG" alt="이미지 " style="width:50px;height:50px; font-style: lightblue">Sinwon's git</a>
	    </div>
	    <div>
	    </div>
	    <div  id="#bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav" >
	        <li><a class="navbar-brand " href="/member/main"  style="margin-left:0px;">Home</a></li> 
	        <li><a href="/board/list">게시판</a></li> 
	      </ul>
	    </div>
		
		<!-- nav DropDownBar -->  
	    <ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expended="false">접속하기<span class="caret"></span></a>
				<ul class="dropdown-menu" style="min-width: 80px;">
					<li><a href="/member/login">로그인</a></li> 		
					<c:if test="${sessionScope.member_id ne null }">
					<li><a href="/member/logOut">로그아웃</a></li>	
					</c:if> 
					<li><a href="/member/signUp">회원가입</a></li>
				</ul>
			</li>
		</ul>
	  </div>
	</nav>
	
	<!-- 게시판 -->
	<div class="container">
	    <form id="boardForm" name="boardForm" method="post">
	        <table class="table table-striped table-hover">
	            <thead>
	                <tr>
	                    <th>번호</th>
	                    <th>제목</th>
	                    <th>내용</th>
	                    <th>작성자</th>
	                    <th>글작성</th>
	                </tr>
	            </thead>
	            <tbody>	    			
	                <c:forEach var="list" items="${list}" varStatus="status">
					<tr>
						<td>${list.board_bno}</td>
						<td><b onclick="location.href='/board/detail/${list.board_bno}'">${list.board_title}</b></td>
						<td>${list.board_content}</td>
						<td>${list.board_writer}</td>
						<td>${list.board_regdate}</td>
					</tr>
					</c:forEach>
	            </tbody>
	        </table> 
	        <div>            
	            <a href="/board/write"  class="btn btn-success">글쓰기</a>	                     
	        </div>
	    </form>
	</div>
	
<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>