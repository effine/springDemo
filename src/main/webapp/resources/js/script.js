$(function() {
	autoLogin();
});

function autoLogin() {
	$.ajax({
		type : 'POST',
		url : '/springDemo/home/isAutologin.action',
		success : function(data) {
			if ("true" == data) {
				$(".autologin").attr("checked", true);
			} else if ("false" == data) {
				$(".autologin").attr("checked", false);
			}
		}
	});
}

function login() {
	// var username = $(".username").val();
	// var password = $(".password").val();
	// var isAutologin = $(".isAutologin").is(":checked");
	$.ajax({
		type : "POST",
		url : "/springDemo/home/login.action",
		data : {
			username : $(".username").val(),
			password : $(".password").val(),
			isAutologin : $(".isAutologin").is(":checked")
		},
		success : function(data) {
			location.href = "/springDemo/" + data + ".jsp";
		}
	});
}
