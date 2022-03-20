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
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login/loginClass.css" type="text/css" rel="stylesheet">
</head>
<body style="background-image: url(${pageContext.request.contextPath}/image/backphoto.jpg);">
<div class="divMove">
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

<script type="text/javascript">
	
	var timeController; //timer变量，控制时间
	var count = 5; //间隔函数，1秒执行
	var remainCount;//当前剩余秒数
	var vcode = "";
	var vtime = "";
	function sendMessage() {
		remainCount = count;
		//设置button效果，开始计时
		$("#btnSendCode").attr("disabled", "true");
		$("#btnSendCode").val("请在" + remainCount + "秒内输入验证码");//加上这一句不会出现延迟，否则倒计时延迟1s
		timeController = setInterval("SetRemainTime()", 1000); //启动计时器，1秒执行一次
		//向后台发送处理数据
		var mobile = document.getElementById("phonenumber").value;
		$.ajax({
			asynch : "false",
			type : "POST", //用POST方式传输     　　
			url : 'reAction.action?mt=' + Math.random(), //目标地址.
			dataType : "json", //数据格式:JSON
			data : "&phonenumber=" + mobile,
			success : function(data) {
				var remessage = eval("(" + data + ")");
				$("#codemessage").html(remessage.codemessage);
				$("#code").val(remessage.code);
			},
			error : function() {
				$("#codemessage").html("发送失败请重试");
			}
		});
	}
	//timer处理函数
	function SetRemainTime() {
		if (remainCount == 0) {
			clearInterval(timeController);//停止计时器
			$("#btnSendCode").removeAttr("disabled");//启用按钮
			$("#btnSendCode").val("重新发送验证码");
		} else {
			remainCount--;
			$("#btnSendCode").val("请在" + remainCount + "秒内输入验证码");
		}
	}
	
</script>		
</body>
</html> 