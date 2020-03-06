$(document).ready(function() {
	$("#logoutyui").click(function(event) {
		event.preventDefault();
		loginsubmission();
		
	});

});

function loginsubmission() {

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "http://localhost:9595/logmeout",
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			localStorage.setItem('app-token', JSON.stringify(""));
			localStorage.setItem("app-acc", JSON.stringify(""));
			window.location.href = "../flyGram_UI/login-form.html"
		},
		error : function(e) { 
			localStorage.setItem('app-token', JSON.stringify(""));
			localStorage.setItem("app-acc", JSON.stringify(""));
			window.location.href = "../flyGram_UI/login-form.html"
		}

	});

}