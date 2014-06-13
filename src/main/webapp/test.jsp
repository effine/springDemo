<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<img src="resources/imgs/pic.jpg" class="imgT" />

	<div id="preview-pane">
		<div class="preview-container">
			<img src="resources/imgs/pic.jpg" class="jcrop-preview" />
		</div>
	</div>

	<form>
		<b>x1</b><input type="text" size="4" id="x1" /> <b class="ml5">y1</b><input
			type="text" size="4" id="y1" /> <b class="ml5">x2</b><input
			type="text" size="4" id="x2" /> <b class="ml5">y2</b><input
			type="text" size="4" id="y2" /> <b class="ml5">w</b><input
			type="text" size="4" id="w" /> <b class="ml5">h</b><input
			type="text" size="4" id="h" />
	</form>

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
		$(".imgT").Jcrop({
			onChange : showCoords,
			onSelect : showCoords
		});
	});

	function showCoords(c) {
		$("#x1").val(c.x);
		$("#y1").val(c.y);
		$("#x2").val(c.x2);
		$("#y2").val(c.y2);
		$("#w").val(c.w);
		$("#h").val(c.h);
	}
</script>