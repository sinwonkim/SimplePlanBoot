<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="/resources/css/bootstrap.css">
  <!-- Font Icon -->
 <link rel="stylesheet" href="/resources/fonts/material-icon/css/material-design-iconic-font.min.css">
<!-- Main css -->
 <link rel="stylesheet" href="/resources/css/signUp.css">
</head>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>
    <script src="https://cdn.ckeditor.com/4.11.3/standard/ckeditor.js"></script>
    <script type="text/javascript">
	    /* function boardWrite() {
	    	var form1 = document.write_form;
	    	var title = document.getElementById('board_title');	
	    	if(title.value == "") {
	    		swal("제목을 입력해야 합니다.")
	    		title.focus();
	    		return;
	    	}
	    	form1.submit(); 
	    } */	    
	    /* 글 작성 취소  */	
	    function goPage() {location.href="/board/list";}
	    
	    function boardWrite(){
	    	/* var form1 = document.write_form;
	    	 */
	    	var formData = $('#write_form').serialize();
	    	
	    	$.ajax({
	    		url : '/board/write',
	    		type: 'POST',
	    		data: formData,
	    		success : function(data){
	    			if(data = true){
	    				alert('글작성완료');
	    				goPage();
	    			}
	    		}
	    	})
	    	/* 
	    	form1.submit();	 */
	    }
	    
	   
    </script>
    
     <!-- 로그인 된 상태일  때 -->
	<c:if test="${sessionScope.member_id ne null }">
		<script>
			
		</script>
	</c:if>
	
	<!-- 회원가입 실패했을 때 -->
	<c:if test="${errMsg ne null}">
		<script>
			alert('${errMsg}');
		</script>
	</c:if>

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
	        <li><a class="navbar-brand " href="/"  style="margin-left:0px;">Home</a></li>
	        <!-- <li><a href="#">2번 메뉴</a></li> --> 
	        <li><a href="/board/list">게시판</a></li> 
	      </ul>
	    </div>
	    <!-- 로그인  되었을 때 view,로그인 되지 않았을 때 view -->
	  
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
	
	<!-- 게시판 글쓰기  -->
	<div class="container">
			<h2 class="mt-sm-5">글 작성</h2>
			<form action="" method="POST" name="write_form" id="write_form">
				<input type="hidden" class="form-control w-50 mb-sm-1" name="board_writer" id="board_writer" value="${id}" />
				<input type="text" class="form-control w-50 mb-sm-1" name="board_title" id="board_title" placeholder="제목">
				 <textarea name="board_content" class="ckeditor" rows="20" cols="200" name="board_content" id="board_content" placeholder="내용" ></textarea>
         		<script>
                        CKEDITOR.replace( 'board_content' );
                </script>
                <div class='right-box' style="float: right;">
                <button type="button" class="btn btn-primary btn-input" style="width: 50px;" name="writeCancel" value="취소" onclick="goPage();">취소</button>
				<button type="button" class="btn btn-primary btn-input" style="width: 50px;" name="boardWritein" value="등록" onclick="boardWrite();">등록</button>
				</div>
			</form>
	</div>


	
<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> <!--  sweetalert-->
</body>
</html>