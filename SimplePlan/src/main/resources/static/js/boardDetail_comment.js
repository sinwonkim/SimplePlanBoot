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