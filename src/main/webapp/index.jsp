<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>

	<br>
	<br>

	<a href="/springDemo/home/test">图片剪切</a>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<form enctype="multipart/form-data" method="post">
		<input type="file">
	</form>
	<img alt="Preview" src="resources/imgs/pic.jpg" />

	<input type="button" value="测试js" onclick="test()">

</body>
</html>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery.Jcrop.js"></script>
<script src="resources/js/script.js"></script>