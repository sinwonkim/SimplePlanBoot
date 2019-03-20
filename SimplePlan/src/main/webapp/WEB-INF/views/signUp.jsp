<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<title>Sign Up Form by Colorlib</title>
 <!-- Font Icon -->
    <link rel="stylesheet" href="/resources/fonts/material-icon/css/material-design-iconic-font.min.css">
<!-- Main css -->
    <link rel="stylesheet" href="/resources/css/signUp.css">
    <script>
    	function signUp() {
	        var form1 = document.sign_up;
	        var id = document.getElementById('member_id');
	        var password = document.getElementById('member_password');
	        var name = document.getElementById('member_name');
	        var email = document.getElementById('member_email');
	        var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	        if(id.value == ""){
	            alert("아이디를 입력해야 합니다.")
	            id.focus();
	            return;
	        }
	        if(password.value == "") {
	            alert("패스워드를 입력해야 합니다.")
	            password.focus();
	            return;
	        }
	        if(name.value == "") {
	            alert("이름을 입력해야 합니다.")
	            name.focus();
	            return;
	        }
	        if(email.value == "") {
	            alert("이메일을 입력해야 합니다.")
	            email.focus();
	            return;
	        }
	        if(exptext.test(email.value)==false) {
	        	alert("이메일형식이 올바르지 않습니다. ex)아이디@naver.com")
	        	email.focus();
	        	return false;
	        }
	        form1.submit();
   	 }  
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
	      <ul class="nav navbar-nav" >
	        <li><a class="navbar-brand " href="main"  style="margin-left:0px;">Home</a></li>
	        <li><a href="#">2번 메뉴</a></li> 
	        <li><a href="boardList.jsp">게시판</a></li> 
	      </ul>
	    </div>
	    <!-- 로그인  되었을 때 view,로그인 되지 않았을 때 view -->
	  
	    <ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expended="false">접속하기<span class="caret"></span></a>
				<ul class="dropdown-menu" style="min-width: 80px;">
					<li><a href="login">로그인</a></li> 
					<li><a href="signUp">회원가입</a></li>
				</ul>
			</li>
		</ul>
		
		
			<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expended="false">회원관리<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="logoutAction.jsp">로그아웃</a></li> 
				</ul>
			</li>
		</ul>
	
	  </div>
	</nav>

    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">회원가입</h2>
                        <form action="signUp" method="POST" class="register-form" name="sign_up" id="sign_up">
                            <div class="form-group">
                                <label for="member_id"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="member_id" id="member_id" placeholder="아이디"/>
                            </div>
                            <div class="form-group">
                            	<label for="member_password"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            	<input type="password" name="member_password" id="member_password" placeholder="패스워드"/>
                            </div>
                            <div class="form-group">
                                <label for="member_name"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="member_name" id="member_name" placeholder="이름"/>
                            </div>
                            <div class="form-group">
                                <label for="member_email"><i class="zmdi zmdi-lock"></i></label>
                                <input type="email" name="member_email" id="member_email" placeholder="이메일"/>
                            </div>
                          <!--   <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
                            </div> -->
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="form-group form-button">
                                <input type="button" name="signup" id="signup" value="회원가입" onclick="signUp();"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="/resources/images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="/member/login" class="/resources/images/signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>

        </div>
<script
  src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
 <script src="resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</body>
</html>