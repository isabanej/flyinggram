var d = JSON.parse(localStorage.getItem("app-token"));

$(document).ready(function() {
	// alert("I am there");
	viewFollowingPost();
	 $("#idComment1").click(function (event) {

	        //stop submit the form, we will post it manually.
	        event.preventDefault();

	        createComment(1);

	    });
	 $("#idComment2").click(function (event) {

	        //stop submit the form, we will post it manually.
	        event.preventDefault();

	        createComment(2);

	    });
//	viewPosts();
});

/*
 * $(document).ready(function () { $("#sharePost").click(function (event) {
 * event.preventDefault(); viewPost(); }); });
 */

function viewFollowingPost() {
	var count = 0;
	$
			.ajax({
				url : "http://localhost:9595/viewAllFollowing",
				type : "GET",
				dataType : 'json',
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Authorization", "Bearer " + d.token);
				},
				success : function(data) {
					var suggestedPost = '';
					$
							.each(
									data,
									function(i, item) {									
										suggestedPost = '<div class="post-content" style="background-color: white"> <img src="'+ 'data:image/png;base64,'+ item.content +'" alt="post-image"'
											+'class="img-responsive post-image" /> <div class="post-container"> <img src="' + 'data:image/png;base64,'+ item.account.profilePic +'" alt="user" class="profile-photo-md pull-left" />'
											+'<div class="post-detail"> <div class="user-info"> <h5> <a href="profile.html" class="profile-link">'+ item.account.user.fullName +'</a> <span class="following">following</span> </h5> </div> <a class="btn text-green"><i class="glyphicon glyphicon-heart-empty"></i>134 </a> <a'
													+'class="btn text-green"><i class="glyphicon glyphicon-comment"></i> 4</a> </br> <a class="btn text"> View all 4 comments</a> <div class="post-text"> <p> '+ item.caption +'<i class="em em-anguished"></i> <i class="em em-anguished"></i> <i class="em em-anguished"></i>'
													+'</p> <p class="text-muted">3 mins ago</p> </div> <div class="line-divider"></div> <div class="post-comment"> <img src="images/users/user-11.jpg" alt="" class="profile-photo-sm" />'
													+'<p> <a href="profile.html" class="profile-link">Diana </a><i class="em em-laughing"></i> Diana Comments </p> </div> <div class="post-comment"> <img src="images/users/user-4.jpg" alt=""	class="profile-photo-sm" /> <p> <a href="profile.html" class="profile-link">John</a> John Comments' 
													+'</p> </div> <div class="post-comment"> <img src="images/users/user-1.jpg" alt="" class="profile-photo-sm" /> <input id="realcomment" type="text" class="form-control" placeholder="Add a comment"/> <button class="btn btn-primary" id="idComment1">Comment1</button>'
												+'</div>'
											+'</div>'
										+'</div>'
									+'</div>'
									
									
									
									});
					$("#followingPost").append(suggestedPost);
				},
				error : function() {						
					alert('fail')
					console.log(data);
				}
			});
}

function createComment(id){
	alert("Testing "+id);
//	var search = {}
//    search["description"] = $("#realcomment").val();
//    $.ajax({
//        type: "POST",
//        contentType: "application/json",
//        url: "http://localhost:9595/createPostComment/"+id,
//        data: JSON.stringify(search),
//        dataType: 'json',
//        cache: false,
//		timeout: 600000,
//		beforeSend : function(xhr) {
//			xhr.setRequestHeader("Authorization", "Bearer " + d.token);
//		},
//        success: function (data) {
//          // var json = "<div class='alert alert-success alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Success! </strong>" + JSON.stringify(data.fullName, null, 4) + " Account Created</div>";
//			//$('#feedback').html(json);
//			alert("Done successfully "+id);
//        },
//        error: function (e) {
//          /*  var json ="<div class='alert alert-danger alert-dismissable'><a class='panel-close close' data-dismiss='alert'>×</a> <i class='fa fa-coffee'></i> <strong>Oops! </strong>"
//            + e.textResponse + "</div>";
//			$('#feedback').html(json); */
//			alert(e.textResponse);
//        }
//    });
}


