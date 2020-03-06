var d = JSON.parse(localStorage.getItem("app-token"));

$(document).ready(function() {
	viewPost();
});

function viewPost() {
	var count = 0;
	$
			.ajax({
				url : "http://localhost:9595/viewAllPostByAccount",
				type : "GET",
				dataType : 'json',
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Authorization", "Bearer " + d.token);
				},
				success : function(data) {
					var post = '';
					$
							.each(
									data,
									function(i, item) {
										post += '<div class="col-md-4 col-sm-6"> <div class="template-thumb"><a class="viewm" target="_blank" data-toggle="modal" data-target="#imageVideomodal"><div class="img-wrapper"><img src="'
												+ 'data:image/png;base64,'
												+ item.content 
												+ '" alt="" class="img-responsive" /><input class="postcommentid" type="hidden" value="'+ item.id +'"></div></a><div class="page-link"><a href="index.html" target="_blank"> </a></div></div></div>';
										count++;
									});
					$("#postcontent").html(post);
					$("#postcount").html(count + " posts ");
				},
				error : function() {
					console.log(data);
				}
			});
}