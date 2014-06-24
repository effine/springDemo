$(function() {
	autoLogin();
});

function autoLogin() {
	$.ajax({
		type : 'POST',
		url : '/springDemo/home/isAutologin.action',
		success : function(data) {
			if ("true" == data) {
				$(".isAutologin").attr("checked", true);
				location.href = "/springDemo/pageSuccess.jsp";
			} else if ("false" == data) {
				$(".isAutologin").attr("checked", false);
			}
		}
	});
}

function upload(obj) {
	$(".imgUpload").submit();
}

function cutImg() {
	$.ajax({
		url : '/springDemo/home/cutImg',
		type : 'POST',
		data : {
			x : parseInt($("#x1").val(), 10),
			y : parseInt($("#y1").val(), 10),
			width : parseInt($("#w").val(), 10),
			height : parseInt($("#h").val(), 10)
		},
		success : function() {
			location.href = "/springDemo/success.jsp";
		}
	});
}

function login() {
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

$(function() {

	// Create variables (in this scope) to hold the API and image size
	var jcrop_api, boundx, boundy,

	// Grab some information about the preview pane
	$preview = $('#preview-pane'), $pcnt = $('#preview-pane .preview-container'), $pimg = $('#preview-pane .preview-container img'),

	xsize = $pcnt.width(), ysize = $pcnt.height();

	$('#target').Jcrop({
		onChange : updatePreview,
		onSelect : updatePreview,
		allowSelect : false,
		bgOpacity : 0.5,
		aspectRatio : xsize / ysize,
		setSelect : [ 0, 0, 200, 200 ]
	}, function() {
		// Use the API to get the real image size
		var bounds = this.getBounds();
		boundx = bounds[0];
		boundy = bounds[1];
		// Store the API in the jcrop_api variable
		jcrop_api = this;

		// Move the preview into the jcrop container for css positioning
		$preview.appendTo(jcrop_api.ui.holder);
	});

	function updatePreview(c) {

		/* 将选择框坐标和长宽显示到页面 */
		$("#x1").val(parseInt(c.x));
		$("#y1").val(parseInt(c.y));
		$("#x2").val(parseInt(c.x2));
		$("#y2").val(parseInt(c.y2));
		$("#w").val(parseInt(c.w));
		$("#h").val(parseInt(c.h));

		if (parseInt(c.w) > 0) {
			var rx = xsize / c.w;
			var ry = ysize / c.h;

			/* 预览图随选择框移动动态显示 */
			$pimg.css({
				width : Math.round(rx * boundx) + 'px',
				height : Math.round(ry * boundy) + 'px',
				marginLeft : '-' + Math.round(rx * c.x) + 'px',
				marginTop : '-' + Math.round(ry * c.y) + 'px'
			});
		}
	}
	;
});

/** ************************* 测试method ************************************ */
function t1() {
	var user = new Object();
	user.name = "verphen";
	user.passwd = "test111";
	
	$.ajax({
		type : "POST",
		url : "home/t1",
		data : user,
		success : function(data) {
			alert("成功返回参数：" + data);
		}
	});

}
