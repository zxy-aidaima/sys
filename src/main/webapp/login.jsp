<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户登录</title>
<link rel="shortcut icon" href="img/logohead.ico" type="image/x-icon">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login/loginClass.css" type="text/css" rel="stylesheet">
</head>

<body style="background-image: url(${pageContext.request.contextPath}/image/backimage.jpg);">
<div class="moveTo">
<div style="padding-top:100px;"></div>
<div class="loginClass" >
	<h1 class="headTitle">志愿者管理系统</h1>
	<div style="height:15px;">
		<span class="errorDanger"><s:property value="message" /></span>
	</div>
	<table class="tableForm">
		<s:form action="loginAction!findUserLogin.action" theme="simple" name="form" onsubmit="return validateForm()" method="post">
			<tr>
				<td width=50% class="outHeight" class="right col-sm-2 control-label" >用户名</td>
				<td width=50% ><s:textfield class="form-control" id="registerid" value="1" name="user.registerid" /></td>
			</tr>
			<tr>
				<td width=50% class="outHeight" class="right col-sm-2 control-label">密码</td>
				<td width=50%><s:textfield class="form-control" id="upassword" name="user.upassword" type="password" value="1234"/></td>
			</tr>
			<tr>
				<td width=50% class="outHeight" class="right col-sm-2 control-label">验证码</td>
				<td width=50%><s:textfield class="form-control" id="validateCode" value="1234" name="user.validateCode"/></td>
			</tr>
			<tr>
				<!-- <td ><input type="reset" onclick="reCheckcode(img);reset();" value="重置" class="tableWidth control-label resetButton" /></td> -->
				<td></td>
				<td><img src="randomAction.action" class="toPointer" onclick="reCheckcode(this)" id="img" /></td>
			</tr>
			<tr>
				<td colspan="2" class="right outHeight" >
				<input type="radio" id="admin" name="user.roletype" value="0" checked="checked"> 管理员&nbsp;&nbsp;&nbsp;
				<input type="radio" id="volunteer" name="user.roletype" value="1"> 志愿者&nbsp;&nbsp;&nbsp;
				<input type="radio" id="uuser" name="user.roletype" value="2"> 用户&nbsp;&nbsp;&nbsp;</td>
			</tr>
<%-- 			<tr>
				<td width=50%><input type="checkbox" id="remember">记住密码</td>
				<td width=50%><s:a href="loginAction!toRepassword.action">忘记密码</s:a></td>
			</tr> --%>
			<tr>
				<td colspan="2" class="right"><s:submit class="btn btn-info buttonLogin" value="登  录" /></td>
			</tr>
			<tr>
				<td colspan="2" class="outHeight"></td>
			</tr>
		</s:form>
	</table>
</div>
<div class="bubbleMove">
<div class="bubbleBig">
	<table class="bubbleCenter">
		<tr>
			<td><s:a href="loginAction!toRepassword.action">忘记密码</s:a></td>
		</tr>
		<tr>
			<td><s:a href="loginAction!toRegister.action">立即注册</s:a></td>
		</tr>
		<tr>
			<td><s:a href="loginAction!resultRegister.action">查看注册结果</s:a></td>
		</tr>
	</table>
</div>
<div class="bubbleMiddle">
</div>
<div class="bubbleSmall">
</div>
</div>
</div>
<script type="text/javascript">
	function reCheckcode(img) {
		img.src = "randomAction.action?t=" + Math.random();
	}

	// 表单验证
	function validateForm() {
		var registerid = $("#registerid").val().trim();
		var upwd = $("#upassword").val().trim();
		var code = $("#validateCode").val().trim();

		if (null == registerid || registerid == "") {
			alert("账号不能为空！");
			return false;
		}
		if (null == code || code == "") {
			alert("验证码不能为空！");
			return false;
		}
		if (null == upwd || upwd == "") {
			alert("密码不能为空！");
			return false;
		}

	}

	function reset(){
		$("#registerid").val("");
		$("#upassword").val("");
		$("#validateCode").val("");
	}
</script>

</body>
</html>