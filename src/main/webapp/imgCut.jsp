<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<style type="text/css">
		.crop-img{
				width: 500px; height: 375px; position: relative; background-color: black;
			}
		.crop_preview {
				position: absolute;
				left: 650px;
				top: 50px;
				width: 120px;
				height: 120px;
				overflow: hidden;
			}
	</style>
</head>
<html>
<body>

	<div class="img-cut" style="margin:50px;">
		<div class="img_pos">
                	<img id="J_imgCut" class="crop-img" src="/springDemo/resources/imgs/pic.jpg" />
                	<span id="preview_box" class="crop_preview">
                		<img id="crop_preview" src="/springDemo/resources/imgs/pic.jpg" />
                	</span>
                    <br />
                    	<p>
                    		x1: <input type="text" size="4" id="x1" />
                    		y1: <input type="text" size="4" id="y1" />
                    	<p>
                    		x2: <input type="text" size="4" id="x2" />
                    		y2: <input type="text" size="4" id="y2" />
                    	<p>
                    		w: <input type="text" size="4" id="w" />
                    		h: <input type="text" size="4" id="h" />
                    		<a id="upload">剪切并上传图片</a>
          </div>
	</div>

</body>
<!-- Css file -->
<link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>" type="text/css" />
<link rel="stylesheet" 	href="<c:url value='/resources/js/Jcrop/jquery.Jcrop.css'/>" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/demos.css'/>"  type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/mymain.css'/>" type="text/css" />

<!-- Js file -->
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/js/Jcrop/jquery.Jcrop.js'/>"></script>
<script src="<c:url value='/resources/js/script.js'/>"></script>
<script>
	$(function(){
		$("#J_imgCut").Jcrop({
			setSelect:[50,50,250,250],
			allowSelect: false,
			onChange:showCoords,
			onSelect:showCoords
		});
		
		function showCoords(obj){
			$("#x1").val(obj.x);
			$("#y1").val(obj.y);
			$("#x2").val(obj.x2);
			$("#y2").val(obj.y2);
			$("#w").val(obj.w);
			$("#h").val(obj.h);
			if(obj.w > 0){
				//计算预览区域图片缩放的比例，通过计算显示区域的宽度(与高度)与剪裁的宽度(与高度)之比得到
				var rx = $("#preview_box").width() / obj.w; 
				var ry = $("#preview_box").height() / obj.h;
				//通过比例值控制图片的样式与显示
				$("#crop_preview").css({
					width:Math.round(rx * $("#J_imgCut").width()) + "px",	//预览图片宽度为计算比例值与原图片宽度的乘积
					height:Math.round(rx * $("#J_imgCut").height()) + "px",	//预览图片高度为计算比例值与原图片高度的乘积
					marginLeft:"-" + Math.round(rx * obj.x) + "px",
					marginTop:"-" + Math.round(ry * obj.y) + "px"
				});
			}
		}
		
		$("#upload").click(function(){
			var x = $("#x1").val();
			var y = $("#y1").val();
			var w = $("#w").val();
			var h = $("#h").val();
			$.ajax({
				url:"/springDemo/home/cutImg",
				type: "post",
				data: {
					"x": x,
					"y": y,
					"width": w,
					"height": h,
					"srcFilename": "C://pic.jpg",
					"dstFilename": "D://cutImg.jpg"
				},success: function(msg){
					console.log("返回值："+msg);
				}
				
			});
		});
		
	});
</script>
</html>