var d = JSON.parse(localStorage.getItem("app-token"));

$(document).ready(function () {
    $(".viewm").click(function (event) {
        event.preventDefault();
        viewPost();
    });
});

function viewPost() {
    var search = {}
   // search["id"] = $(".postid").val;
  //  var id = JSON.stringify(search);
    $
        .ajax({
            url: "http://localhost:9595/findPostById/" + 3,
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Bearer " + d.token);
            },
            success: function (data) {
                var post = '';
                post += '<div class="col-md-7"><img src="'
                    + 'data:image/png;base64,'
                    + data.content
                    + '" alt="" class="img-responsive" /></div>';
                $("#realimg").html(post);
                // $("#postcount").html(count + " posts ");
            },
            error: function (e) {
                console.log(e.textResponse);
            }
        });
}