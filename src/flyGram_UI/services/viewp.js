$(document).ready(function () {
    // alert("I am there");
    findAll();
});
function findAll() {
    $.ajax({
        type: 'GET',
        url: "http://localhost:9595/testview",
        dataType: "json", // data type of response
        success: function (data) {
			$("#postcontent").append("ndiyo pe!!");
        },
        error : function(data) {
            console.log(data.textResponse);
            $("#postcontent").append("wapi kbsa");
            $("#postcontent").append(data.textResponse);
        }

    });
}