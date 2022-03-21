<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<link rel="shortcut icon" href="img/logohead.ico" type="image/x-icon">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/login/before-login.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login/loginClass.css" type="text/css" rel="stylesheet">
</head>
<body style="background-image: url(${pageContext.request.contextPath}/image/backphoto.jpg);">
<div class="divMove">
	<span><h5 class="headTitle">修改密码<s:a href="./login.jsp">点击这里</s:a>返回首页</h5></span>
	<table width="300px" border="0">
		<s:form action="loginAction!rePassword.action" theme="simple" name="reform" onsubmit="return validateForm()" method="post">
			<s:textfield id="sendtime" type="hidden" name="user.sendTime" value=""/>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">账户</td>
				<td width=50%><s:textfield class="form-control" id="rid" name="user.registerid" value="1" /></td>
			</tr>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">手机号码</td>
				<td width=50%><s:textfield class="form-control" id="phonenumber" name="user.phonenumber" value="13231781681" /></td>
			</tr>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">密码</td>
				<td width=50%><s:password class="form-control" id="upwd" name="user.upassword" /></td>
			</tr>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">确认密码</td>
				<td width=50%><s:password class="form-control" id="surepwd" name="sureupassword" /></td>
			</tr>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">验证码</td>
				<td width=50%><s:textfield class="form-control" id="code" name="user.validateCode" /></td>
			</tr>
			<tr>
				<td width=50%><span id="codemessage"></span></td>
				<td width=50%><input class="btn btn-default buttonSms" id="btnSendCode" type="button" value="发送验证码" onclick="sendMessage()" /></td>
			</tr>
			<tr>
				<td width=50%><s:property value="message" /></td>
				<td width=50% class="tbHeight"><s:submit class="btn btn-info buttonLogin" value="修改密码"  /></td>
			</tr>
			
		</s:form>
	</table>
</div>
<script type="text/javascript">
	// 表单验证
	function validateForm(){
		var mobile = $("#phonenumber").val().trim();
		var code = $("#code").val().trim();
		var upwd = $("#upwd").val().trim();
		var surepwd = $("#surepwd").val().trim();

		if(null == mobile || mobile == ""){
			alert("手机号不能为空！");
			return false;
		}
		if(null == code || code == ""){
			alert("验证码不能为空！");
			return false;
		}
		if(null == upwd || upwd == ""){
			alert("密码不能为空！");
			return false;
		}
		if(null == surepwd || surepwd == ""){
			alert("确认密码不能为空！");
			return false;
		}
		if(upwd != surepwd){
			alert("密码与确认密码输入不一致！");
			return false;
		}
	}
</script>
</body>
</html>