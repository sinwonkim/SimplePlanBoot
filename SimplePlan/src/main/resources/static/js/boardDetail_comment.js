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
	            a += '<li>'+value.comment_writer+'</li>';
	            a += '<li>'+value.comment_content+'</li>';
	            a += '<li>'+value.comment_regdate+'</li>';
	            a += '<li><button type="button" onclick="commentDelete('+value.comment_cno+');">댓글 삭제</button></li>';
	        });
	        
	        $(".commentList").html(a);
	        }
	    });
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

$(document).ready(function(){
    commentList();
});

$("#comment_submit").click(function(){
	var form = document.commentInsertForm;
	form.submit();
});