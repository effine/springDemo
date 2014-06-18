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
				location.href = "/springDemo/WEB-INF/views/pageSuccess.jsp";
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
			px : $("#x1").val(),
			py : $("#y1").val(),
			pwidth : $("#w").val(),
			pheight : $("#h").val()
		},
		success : function() {
			location.href = "/springDemo/WEB-INF/views/success.jsp";
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
			location.href = "/springDemo/WEB-INF/views/" + data + ".jsp";
		}
	});
}

jQuery(function($) {
	// Create variables (in this scope) to hold the API and image size
	var jcrop_api, boundx, boundy,

	// Grab some information about the preview pane
	$preview = $('#preview-pane'), $pcnt = $('#preview-pane .preview-container'), $pimg = $('#preview-pane .preview-container img'),

	xsize = $pcnt.width(), ysize = $pcnt.height();

	console.log('init', [ xsize, ysize ]);
	$('#target').Jcrop({
		onChange : updatePreview,
		onSelect : updatePreview,
		 allowSelect : false,
		bgOpacity : 0.5,
		aspectRatio : xsize / ysize,
		setSelect: [0,0,200,200]
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

		$("#x1").val(c.x);
		$("#y1").val(c.y);
		$("#x2").val(c.x2);
		$("#y2").val(c.y2);
		$("#w").val(c.w);
		$("#h").val(c.h);

		if (parseInt(c.w) > 0) {
			var rx = xsize / c.w;
			var ry = ysize / c.h;

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
