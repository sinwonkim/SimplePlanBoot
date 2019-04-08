var bno = $(".comment_bno").val();

//댓글 리스트
function commentList(){
	$.ajax({
	    url : '/comment',
	    async: true,
	    type : 'GET',
	    data : {'bno':bno},
	    success : function(data){
	        var a =''; 
	        
	        $.each(data, function(key, value){ 
	            a += '<li>'+'작성자: '+value.comment_writer+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+value.comment_regdate+'</li>';
	            a += '<p style="margin:10px; width:925px;">'+value.comment_content+'<p>';	            
	            if($('input[name=comment_writer]').val()==value.comment_writer){
	            	a += '<li><button type="button" onclick="commentDelete('+value.comment_cno+');">댓글 삭제</button></li>';	
	            }	            
	            a += '<br>';	            
	        });      
	        $(".commentList").html(a);
	        }
	    });
}

function commentInsert(){
	var formData = $('#commentInsertForm').serialize();
	$.ajax({
		url:'/board/comment',
		type: 'POST',
		data : formData,
		success : function(data){
			console.log(data)
			var a ='';
			var dateNow = new Date(Date.now()).toLocaleString();
			if(data != null){
				a += '<li>'+'작성자: '+data.comment_writer+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+ dateNow +'</li>';
	            a += '<p style="margin:10px; width:925px;">'+data.comment_content+'<p>';	            
	            a += '<li><button type="button" onclick="commentDelete('+data.comment_cno+');">댓글 삭제</button></li>';	
	            a += '<br>';
	            $(".commentList").append(a);
				alert('글작성이 완료되었습니다.')
			}else{
				alert('실패했습니다.');
			}
		}
	})	
}

function commentDelete(cno){
    $.ajax({
        url : '/comment',
        async: true,
        type : 'DELETE',
        data : {'cno':cno},
        success : function(data){
            commentList(bno);
        }
    });
}

$("#comment_submit").click(function(){
	var form = document.commentInsertForm;
	form.submit();
});