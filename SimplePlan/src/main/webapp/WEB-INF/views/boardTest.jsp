<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="/resources/css/bootstrap.css">
<title>Insert title here</title>
<script type="text/javascript">
	    function boardWrite() {
	    	var form1 = document.write_form;
	    	var title = document.getElementById('board_title');
	    	var content = document.getElementById('board_content');
	    	if(title.value == "") {
	    		swal("제목을 입력해야 합니다.")
	    		title.focus();
	    		return;
	    	}
	    	if(content.value == "") {
	    		swal("내용을 입력하세요")
	    		content.focus();
	    		return;
	    	}
	    	form1.submit();
	    }
	    
	    
	    /* 글 작성 취소  */
	    function goPage() {location.href="/board/list";} 
    </script>
</head>
<body>
<!-- 게시판 -->
	<div class="container">
		<form action="/board/modify" id="boardForm" name="boardForm" method="post">
			<div class="form-group">
				<label>제목</label>
				<p>ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ</p>
			</div>
			<div class="form-group">
				<label>작성자</label>
				<p>${detail.board_writer}</p>
			</div>
			<div class="form-group">
				<label>작성날짜</label>
				<p>${detail.board_regdate}</p>
			</div>
			<div class="form-group">
				<label>내용</label>
				<p>${detail.board_content}</p>
			</div>
			<button type="submit" class="btn btn-success">글 수정</button>
		</form>
	</div>

<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>