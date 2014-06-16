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
	$.ajax({
		url : '/springDemo/home/upload.action',
		type : 'POST',
		enctype : 'multipart/form-data',
		data : obj,
		success : function(data) {
			$(".jcrop-preview").attr("src", "resources/upload/" + data);
			$(".mainImg").attr("src", "resources/upload/" + data);
		}
	});
}

function showImg(obj) {
	alert(obj.value);
	// $(".mainImg").attr("src",obj.value);
}

// 图片上传预览 IE是用了滤镜。
function previewImage(file) {
	var MAXWIDTH = 260;
	var MAXHEIGHT = 180;
	var div = document.getElementById('preview');
	if (file.files && file.files[0]) {
		div.innerHTML = '<img id=target>';
		var img = document.getElementById('target');
		img.onload = function() {
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			img.width = rect.width;
			img.height = rect.height;
			// img.style.marginLeft = rect.left+'px';
			img.style.marginTop = rect.top + 'px';
		}
		var reader = new FileReader();
		reader.onload = function(evt) {
			img.src = evt.target.result;
		}
		reader.readAsDataURL(file.files[0]);
	} else // 兼容IE
	{
		var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
		file.select();
		var src = document.selection.createRange().text;
		div.innerHTML = '<img id=target>';
		var img = document.getElementById('target');
		img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
		var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
				img.offsetHeight);
		status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width + ',' + rect.height);
		div.innerHTML = "<div id=divhead style='width:" + rect.width
				+ "px;height:" + rect.height + "px;margin-top:" + rect.top
				+ "px;" + sFilter + src + "\"'></div>";
	}
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

function savaImg() {
	$.ajax({

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
		// allowSelect : false,
		bgOpacity : 0.5,
		aspectRatio : xsize / ysize
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
