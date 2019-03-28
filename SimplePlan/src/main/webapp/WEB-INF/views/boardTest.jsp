<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="/resources/css/bootstrap.css">
<title>Insert title here</title>
  <script src="https://cdn.ckeditor.com/4.11.3/standard/ckeditor.js"></script>
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





           
              
                <textarea name="editor1" style="width:100%; border:1;overflow:visible;text-overflow:ellipsis; display: block;" rows=30 ></textarea>
         		<script>
                        CKEDITOR.replace( 'editor1' );
                </script>
        


<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>