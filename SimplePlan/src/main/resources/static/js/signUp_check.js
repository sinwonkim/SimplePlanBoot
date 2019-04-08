var signUpCheckBasic = false ;
//중복체크버튼
$('#member_id').on('keyup',function(){
	var memberId = $('#member_id').val();
	$.ajax({
		url:'/member/signUpCheck',
		type:'post',
		data:{'member_id':memberId},
		success:function(data){
			if(data.code==1){
				signUpCheckBasic = true;
				$('#member_idText').text(data.message);
			}else{
				signUpCheckBasic = false;
				$('#member_idText').text(data.message);
			}	
		},
		error:function(err){
			//에러났을때코드작성			
		}
	});
});


// 회원가입 벨리데이션
function signUp() {
	if(!signUpCheckBasic){
		alert("아이디를 확인해주세요.");
		return;
	}
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