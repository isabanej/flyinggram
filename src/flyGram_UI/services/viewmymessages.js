var d = JSON.parse(localStorage.getItem("app-token"));

$(document).ready(function () {
    viewList();
});

function viewList() {
    var count = 0;
    $
        .ajax({
            url: "http://localhost:9595/viewChatList",
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Bearer " + d.token);
            },
            success: function (data) {
                var post = '';
                $
                    .each(
                        data,
                        function (i, item) {
                            post += '<li value="'+item.id+'">'
                                + '<a href="#" id="id1" value="'+item.id+'" data-toggle="modal" data-target="#mymessagesend"><div class="contact">'
                                + '<img src="data:image/png;base64,'+item.profilePic +'" alt="" class="profile-photo-sm pull-left"/>'
                                + '<div class="msg-preview">'
                                + '<h6>'+item.user.fullName+'</h6><p class="text-muted">User</p>'
                                + '<div class="seen"><i class="icon ion-checkmark-round"></i></div>'
                                + '</div>'
                                + '</div>'
                                + '</a>'
                                + '</li>'

                        });
                $("#chatcontent").html(post);
            },
            error: function () {
                console.log(data);
            }
        });
}