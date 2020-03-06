var d = JSON.parse(localStorage.getItem("app-token"));
$(document).ready(function () {

    $("#btnsendmsg").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {}
    //var id =  $("#accid").val();
    var id = 2;
    search["messageDescription"] = $("#msgtext").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:9595/messagecomposer/"+id,
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        beforeSend : function(xhr) {
            xhr.setRequestHeader("Authorization", "Bearer " + d.token);
        },
        success: function (data) {
           alert("message Sent succefully");
        },
        error: function (e) {
           alert("Something is wrong "+e.responseText+" "+id);
        }
    });

}