<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<body>
	<h2>success页面</h2>

	<a href="/springDemo/home/logout.action">注销登录</a>

</body>
</html>
