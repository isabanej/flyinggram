var d = JSON.parse(localStorage.getItem("app-token"));

$(document).ready(function () {
    getMyFollowers();
    getMyFollowing();
});

function getMyFollowers() {
    var count = 0;
    $
        .ajax({
            url: "http://localhost:9595/myFollowers",
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Bearer " + d.token);
            },
            success: function (data) {
                var follower = '';
                $
                    .each(
                        data,
                        function (i, item) {
                            follower += '<div class="follow-user"><a href="#" class="btn btn-primary pull-right" style="width: 25%;">Following</a> <img src="'+ 'data:image/png;base64,'+ item.profilePic +'" alt="" class="profile-photo-sm pull-left" /> <div style="width: 70%"><h5> <a href="profile.html">'+item.user.userName+'</a> </h5> <h6>'+item.user.fullName+'</h6> </div> </div>'
                            count++;

                        });
                $("#followerscontent").html(follower);
                $("#followingcount").html(count+" Follower");
                
            },
            error: function () {
                alert('fail')
                console.log(data);
            }
        });
}

function getMyFollowing() {
    var count = 0;
    $
        .ajax({
            url: "http://localhost:9595/myFollowing",
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Bearer " + d.token);
            },
            success: function (data) {
                var follower = '';
                $
                    .each(
                        data,
                        function (i, item) {
                            follower += '<div class="follow-user"><a href="#" class="btn btn-primary pull-right" style="width: 25%;">Following</a> <img src="'+ 'data:image/png;base64,'+ item.profilePic +'" alt="" class="profile-photo-sm pull-left" /> <div style="width: 70%"><h5> <a href="profile.html">'+item.user.userName+'</a> </h5> <h6>'+item.user.fullName+'</h6> </div> </div>'
                            count++;

                        });
                $("#followship").html(follower);
                $("#followingcount2").html(count+" Following");
                
            },
            error: function () {
                alert('fail')
                console.log(data);
            }
        });
}


