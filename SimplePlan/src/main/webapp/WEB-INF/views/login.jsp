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
    <script>
    //로그인 폼 체크와 submit
    	function Login() {
	        var form1 = document.login_form;
	        var id = document.getElementById('member_id');
	        var password = document.getElementById('member_password');
	        if(id.value == ""){
	        	swal("아이디를 입력해야 합니다.")
	            id.focus();
	            return;
	        }
	        if(password.value == "") {
	        	swal("패스워드를 입력해야 합니다.")
	            password.focus();
	            return;
	        }
	        form1.submit();
   	 }  
    	  
    </script>
    
    <!-- 로그인 된 상태일  때 -->
    <c:if test="${sessionScope.member_id ne null }">
    	 <script>
	    	 alert('로그인  상태 입니다..');
	    	 location.href='/';
    	 </script>	
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
					<li><a href="login">로그인</a></li> 
					<c:if test="${sessionScope.member_id ne null }">	
					<li><a href="logOut">로그아웃</a></li>
					</c:if> 
					<li><a href="signUp">회원가입</a></li>
					
				</ul>
			</li>
		</ul>
	  </div>
	</nav>
<!-- 세션이 존재할 때 -->
 <c:if test="${sessionScope.member_id eq null }">	

 <div class="login">
<!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="/resources/images/signin-image.jpg" alt="sing up image"></figure>
                        <a href="signUp" class="signup-image-link">Create an account</a>
                    </div>
                   
							
					
                    <div class="signin-form">
                        <h2 class="form-title">로그인</h2>
                        <form action="loginCheck" method="POST" class="register-form" name="login_form" id="login_form">
                            <div class="form-group">
                                <label for="member_id"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="member_id" id="member_id" placeholder="Id"/>
                            </div>
                            <div class="form-group">
                                <label for="member_password"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="member_password" id="member_password" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="useCookie" id="useCookie" class="agree-term" />
                                <label for="useCookie" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="button" name="signin" id="signin" value="로그인" onclick="Login();"/>
                            </div>
                        </form>
                        <!-- <div class="social-login">
                            <span class="social-label">Or login with</span>
                            <ul class="socials">
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                            </ul>
                        </div> -->
                    </div>
                </div>
            </div>
        </section>
    </div>
    </c:if>
    
<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> <!-- sweetalert -->
</body>
</html>