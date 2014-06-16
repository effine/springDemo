<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<h3>js验证案列</h3>

	<div>
		文本框是否为空：<input type="text" class="t1"> 
		<input type="button" value="验证" onclick="ck1()">
	</div>
	<br>
	<div>
		手机号格式验证：<input type="text" class="t2"> 
		<input type="button" value="验证" onclick="ck2()">
	</div>
		<br>
	<div>
		邮箱验证：<input type="text" class="t3"> 
		<input type="button" value="验证" onclick="ck3()">
	</div>

	<br><br><br><br>
	常用正则表达式汇总：
	<div style="font-size: 14;">
		<ul>
			<li>邮箱：	/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/</li>
			<li>手机号(11位)：	/^[1][3-8]+\d{9}$/</li>
			<li>固话号(区号+座机号码+分机号码)： /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/</li>
		</ul>
	</div>
</body>
</html>

<!-- Js file -->
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script>
	function ck1(){
		var value = $(".t1").val().trim();
		if(value == null || value == ""){
			alert("文本框为空");
		}else{
			alert("通过验证");
		}
	}
	
	function ck2(){
		var value = $(".t2").val().trim();
		
		//js中正则表达式的使用
		var reg = /^[1][3-8]+\d{9}$/;	
		if(reg.test(value)){
			alert("通过验证");
		}else{
			alert("手机号格式不对");
		}
	}
	
	function ck3(){
		var value = $(".t3").val().trim();
		 var reg =  /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(reg.test(value)){
			alert("通过验证");
		}else{
			alert("邮箱格式不对");
		}
	}

</script>
