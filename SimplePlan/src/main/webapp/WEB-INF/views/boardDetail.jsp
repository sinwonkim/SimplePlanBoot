<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/boardDetail.css">
<link rel="stylesheet" href="/resources/css/signUp.css">
<link rel="stylesheet" href="/resources/fonts/material-icon/css/material-design-iconic-font.min.css">
<!-- bootStrap Grid -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <title>boardDetail</title>
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
    <script>
     /* 글 작성 취소  */
	    function goPage() {location.href="/board/list";}
	</script>
	
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
	      <ul class="nav navbar-nav" style="margin-top: -10px;">
	        <li><a class="navbar-brand " href="/"  style="margin-left:0px;">Home</a></li> 
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
	<div class="container" style="margin-left: 190px;">
		
			<div class="form-group">
				
				<p>작성자: ${detail.board_writer}</p>
			</div>
			<div class="form-group">
				
				<p>제목: ${detail.board_title}</p>
			</div>
			<div class="form-group">
				
				<p>내용: ${detail.board_content}</p>
			</div>
			
			<div class="form-group">
				
				<p>작성날짜: ${detail.board_regdate}</p>
			</div>
		
		<div style="float:right">
		
		<c:if test="${sessionScope.member_id eq detail.board_writer}">
		<button type="button" class="btn btn-success" style="width: 75px;" onclick="location.href='/board/update/${detail.board_bno}'">글 수정</button>
		<button type="button" class="btn btn-success" style="width: 75px;" onclick="location.href='/board/delete/${detail.board_bno}'">글 삭제</button>
		</c:if>
		</div>			
	</div>
	<!-- comment start -->
	
	<!-- 게시판 리스트 글의 댓글 리스트 -->
	<div class="commentList">
	</div>	
	
	<!-- 게시판 리스트 글의 댓글  -->
	<form action="" method="POST" name="commentInsertForm" id="commentInsertForm">
		<div>
			<input type="hidden" value="${detail.board_bno}" class="comment_bno" name="comment_bno"/>
			<input type="hidden" value="${sessionScope.member_id}" class="comment_writer" name="comment_writer">		
		</div>
		<div class="comment_box">
			<div>
				<textarea rows="5" cols="200" name="comment_content" class="comment_content"></textarea>
			</div>
			<div>
				<!-- <button type="button" id="comment_submit" class="comment_btn">등록</button>
				 --><button type="button" onclick="commentInsert();" style="text-decoration:none; margin-left:5px;">등록</button>
				<button type="button" class=" btn-input" style="width: 75px;" name="writeCancel" value="돌아가기" onclick="goPage();">돌아가기</button>
			</div>
		</div>	
	</form>
	
	
	<!-- comment end -->
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/boardDetail_comment.js"></script>
</body>
</html>