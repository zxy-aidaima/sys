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
<title>用户注册</title>
<link rel="shortcut icon" href="img/logohead.ico" type="image/x-icon">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/distpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/login/before-login.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login/loginClass.css" type="text/css" rel="stylesheet">
</head>
<body style="background-image: url(${pageContext.request.contextPath}/image/backphoto.jpg);">
<div class="divMove">
	<span><h5 class="headTitle">注册申请<s:a href="./login.jsp">点击这里</s:a>返回首页</h5></span>
	<table width="700px" border="0">
	<s:form action="registerAction!applyRegister.action" theme="simple" name="reform" onsubmit="return validateForm()" method="post">	
		<s:textfield id="sendtime" type="hidden" name="register.sendTime" value=""/>	
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">身份证号</td>
			<td><s:textfield class="inputWidth form-control" id="identifynumber" name="register.identifynumber" value="130925199653215421"/></td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">姓名</td>
			<td><s:textfield class="inputWidth form-control" id="uname" name="register.uname" value="阿萌"/></td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">性别</td>
			<td><input style="margin-left:20px;" type="radio" id="man" name="register.sex" value="0" checked="checked">女
			<input style="margin-left:50px;" type="radio" id="woman" name="register.sex" value="1" >男</td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">年龄</td>
			<td><s:textfield class="inputWidth form-control" id="age" name="register.age" value="18"/></td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">居住地址</td>
			<td width=540px>
				<div data-toggle="distpicker" class="city" width=540px>
	  				<select class="form-control" style="width:180px;float:left;" name="register.liveprovince" data-province="-- 选择省 --"></select>
	 				<select class="form-control" style="width:180px;float:left;" name="register.livecity" data-city="-- 选择市 --"></select>
	  				<select class="form-control" style="width:180px;float:left;" name="register.livecounty" data-district="-- 选择区 --"></select>
				</div>
			</td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">详细居住地址</td>
			<td><s:textfield class="inputWidth form-control" id="livetownvillage" name="register.livetownvillage"/></td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">注册地址</td>
			<td width=540px>
				<div data-toggle="distpicker" class="city" width=540px>
	  				<select class="form-control" style="width:180px;float:left;" name="register.registerprovince" data-province="-- 选择省 --"></select>
	 				<select class="form-control" style="width:180px;float:left;" name="register.registercity" data-city="-- 选择市 --"></select>
	  				<select class="form-control" style="width:180px;float:left;" name="register.registecounty" data-district="-- 选择区 --"></select>
				</div>
			</td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">详细注册地址</td>
			<td><s:textfield class="inputWidth form-control" id="registerdetail" name="register.registertownvillage"/></td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">注册原因</td>
			<td><s:textarea class="inputWidth form-control" id="reason" name="register.reason"/></td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">手机号码</td>
			<td><s:textfield class="inputWidth form-control" id="phonenumber" name="register.phonenumber" value="13231781681"/></td>
		</tr>
		<tr>
			<td width=150px class="right col-sm-2 control-label outHeight">验证码</td>
			<td><s:textfield class="inputWidth form-control" id="code" name="validateCode" autocomplete="off"/></td>
		</tr>
		<tr>
			<td width=150px><span id="codemessage"></span></td>
			<td><input class="btn btn-default buttonSms" id="btnSendCode" type="button" value="发送验证码" onclick="sendMessage()" /></td>
		</tr>
		
		<tr>
			<td width=150px><s:property value="message" /></td>
			<td class="tbHeight"><s:submit class="btn btn-info buttonLogin" value="申请注册账号"  /></td>
		</tr>
		
	</s:form>
</table>
</div>

</body>
</html> 