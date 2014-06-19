<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<style type="text/css">
.start {
	color: red;
}
</style>

<!-- Js file -->
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.validate.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.validate.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.validate.message.cn.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$().ready(function() {
			$("#commentForm").validate();
		});
	});
</script>
</head>

<body>

	<h2>jquery.validation.js验证表单</h2>
	<div id="main">
		<form class="cmxform" id="commentForm" method="get" action="">
			<fieldset>
				<p>
					<label for="cname">姓名</label>
					<input id="cname" name="name"  type="text" class="required" />
					<span class="start" >*</span>
				<p>
					<label for="cemail">邮箱 </label>
					<input id="cemail" type="email" name="email" class="required email"  />
					<span class="start" >*</span>
				</p>
				<p>
					<label for="ccomment">文本域内容</label>
					<textarea id="ccomment" name="comment" class="required"></textarea>
					<span class="start" >*</span>
				</p>
				<p>
					<input class="submit" type="submit" value="Submit"/>
					
				</p>
			</fieldset>
		</form>
	</div>
	
	
	<br><br><br><br>
	<h2>自己写js用正则验证表单</h2>
	<div>
		邮箱正则验证：<input type="text" class="t3"> 
		<input type="button" value="验证" onclick="ck()">
	</div>
	
	<div style="font-size: 14;">
		常用正则表达式汇总：
		<ul>
			<li>邮箱：	/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/</li>
			<li>手机号(11位)：	/^[1][3-8]+\d{9}$/</li>
			<li>固话号(区号+座机号码+分机号码)： /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/</li>
		</ul>
	</div>
	
</body>
</html>




<script type="text/javascript">


	function ck() {
		var value = $(".t3").val().trim();
		var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (reg.test(value)) {
			alert("通过验证");
		} else {
			alert("邮箱格式不对");
		}
	}
</script>

