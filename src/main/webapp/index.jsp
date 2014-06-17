<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<form class="imgUpload" action="/springDemo/home/upload.action" enctype="multipart/form-data" method="post"  >
		<input class="selfile" type="file" name="selfile" onchange="upload(this)" >
	</form>

	<br>
	<br>
	<br>
	<!-- <img alt="Preview" src="resources/imgs/pic.jpg" /> -->

	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="jc-demo-box">
					<c:choose>
						<c:when test="${!empty filename }">
							<div id="preview">
								<img src="resources/upload/${filename}" id="target" class="mainImg" />
							</div>
							<div id="preview-pane">
								<div class="preview-container">
									<img src="resources/upload/${filename}" class="jcrop-preview" />
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div id="preview">
								<img src="resources/imgs/pic.jpg" id="target" class="mainImg" />
							</div>
							<div id="preview-pane">
								<div class="preview-container">
									<img src="resources/imgs/pic.jpg" class="jcrop-preview" />
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

				<br />
				<form>
					<b>x1</b><input type="text" size="4" id="x1" />
					<b class="ml5">y1</b><input type="text" size="4" id="y1" /> 
					<b class="ml5">x2</b><input type="text" size="4" id="x2" /> 
					<b class="ml5">y2</b><input type="text" size="4" id="y2" /> 
					<b class="ml5">w</b><input type="text" size="4" id="w" /> 
					<b class="ml5">h</b><input type="text" size="4" id="h" />
				</form>
				
				<br>
				<input type="button" value="上传" onclick="cutImg()">
				
			</div>
		</div>
	</div>

</body>
</html>


<!-- Css file -->
<link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/jquery.Jcrop.css'/>" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/demos.css'/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/mymain.css'/>"
	type="text/css" />

<!-- Js file -->
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.Jcrop.js'/>"></script>
<script src="<c:url value='/resources/js/script.js'/>"></script>
<script>
	$(function() {
		if (location.href.indexOf("?xyz=") < 0) {
			location.href = "/springDemo/index.jsp?xyz=" + Math.random();
		}
	});
</script>

