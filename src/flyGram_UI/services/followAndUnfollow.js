var d = JSON.parse(localStorage.getItem("app-token"));

$(document).ready(function() {
	// alert("I am there");
	viewAccounts();
//	viewPosts();
});

/*
 * $(document).ready(function () { $("#sharePost").click(function (event) {
 * event.preventDefault(); viewPost(); }); });
 */

function viewAccounts() {
	var count = 0;
	$
			.ajax({
				url : "http://localhost:9595/viewAccountProfiles",
				type : "GET",
				dataType : 'json',
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Authorization", "Bearer " + d.token);
				},
				success : function(data) {
				
					var suggestedAccount = '';
					$
							.each(
									data,
									function(i, item) {
										var name = item.user.fullName;
										var accountId = item.accountId;
										var action = 'Follow';
										var urlLink = 'http://localhost:9595/follow/' + accountId;
										var profileLink = 'profile.html/' + accountId;
										var murl = "../flyGram_UI/newsfeed.html"
									 suggestedAccount += '<form action="'+urlLink+'" method="post"> <div class="follow-user"> <img src="'+ 'data:image/png;base64,'+ item.profilePic +'" alt="" class="profile-photo-sm pull-left" /> <div> <h5> <a href="'+profileLink+'">'+name+'</a> </h5> <button onSubmit=" location.href = '+ murl +'; return false; " class="btn" style="background: #f8fef1; color: #94c961; cursor: pointer">Follow</button> </div> </div></form>';
										
									});
					$("#suggestions").html(suggestedAccount);
				},
				error : function() {						
					alert("fail")
					console.log(data);
				}
			});
}
