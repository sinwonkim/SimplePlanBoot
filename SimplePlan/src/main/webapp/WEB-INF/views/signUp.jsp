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
	        	swal("아이디를 입력해야 합니다.")
	            id.focus();
	            return;
	        }
	        if(password.value == "") {
	        	swal("패스워드를 입력해야 합니다.")
	            password.focus();
	            return;
	        }
	        if(name.value == "") {
	        	swal("이름을 입력해야 합니다.")
	            name.focus();
	            return;
	        }
	        if(email.value == "") {
	        	swal("이메일을 입력해야 합니다.")
	            email.focus();
	            return;
	        }
	        if(exptext.test(email.value)==false) {
	        	swal("이메일형식이 올바르지 않습니다. ex)아이디@naver.com")
	        	email.focus();
	        	return false;
	        }
	        form1.submit();
   	 }  
    	
    	 // 회원가입완료 시 문구 
        var msg = "${msg}";
        if (msg === "SIGNUP") {
        	swal("회원가입이 완료 되었습니다. 로그인 해주세요.");
        } else if (msg === "FAIL") {
        	swal("아이디와 비밀번호를 확인해주세요")
        }
    </script>

	<!-- 회원가입 실패했을 때 -->
	<c:if test="${errMsg ne null}">
		<script>
			alert('${errMsg}');
		</script>
	</c:if>
	
	<c:if test="${sessionScope.member_id ne null }">
		<script>
			alert('로그인된 상태 입니다.');
			location.href = 'main';
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

 <c:if test="${sessionScope.member_id eq null }">	
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
                            	<label for="member_password"><i class="zmdi zmdi-lock"></i></label>
                            	<input type="password" name="member_password" id="member_password" placeholder="패스워드"/>
                            </div>
                            <div class="form-group">
                                <label for="member_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="member_name" id="member_name" placeholder="이름"/>
                            </div>
                            <div class="form-group">
                                <label for="member_email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="member_email" id="member_email" placeholder="이메일"/>
                            </div>
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
        </c:if>
        
       
<script
  src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
 <script src="/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> <!-- sweetalert -->
</body>
</html>