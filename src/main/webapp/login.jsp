<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<body>

	<h2>测试自动登录页面</h2>

		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" class="username"></td>
			</tr>
			<tr>
				<td>密 码：</td>
				<td><input type="password" class="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="登录" onclick="login()"></td>
			</tr>
		</table>
		<input type="checkbox" class="isAutologin"> 
		<span>是否自动登录 </span>
</body>
</html>

<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/js/script.js'/>"></script>
