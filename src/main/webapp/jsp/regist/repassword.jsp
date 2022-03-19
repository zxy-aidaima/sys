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
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login/loginClass.css" type="text/css" rel="stylesheet">
</head>
<body style="background-image: url(${pageContext.request.contextPath}/image/backphoto.jpg);">
<div class="divMove">
	<table width="300px" border="0">
		<s:form action="loginAction!rePassword.action" theme="simple" name="reform" onsubmit="return validateForm()" method="post">
			<s:textfield id="sendtime" type="hidden" name="user.sendTime" value=""/>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">账户</td>
				<td width=50%><s:textfield class="form-control" id="rid" name="user.registerid" value="1" /></td>
			</tr>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">手机号码</td>
				<td width=50%><s:textfield class="form-control" id="mobile" name="user.phonenumber" value="13231781681" /></td>
			</tr>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">密码</td>
				<td width=50%><s:textfield class="form-control" id="upwd" name="user.upassword" /></td>
			</tr>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">确认密码</td>
				<td width=50%><s:textfield class="form-control" id="surepwd" name="sureupassword" /></td>
			</tr>
			<tr>
				<td width=50% class="right col-sm-2 control-label outHeight">验证码</td>
				<td width=50%><s:textfield class="form-control" id="code" name="validateCode" /></td>
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
	<script>
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
			var mobile = document.getElementById("mobile").value;
			$.ajax({
				asynch : "false",
				type : "POST", //用POST方式传输     　　
				url : 'reAction.action?mt=' + Math.random(), //目标地址.
				dataType : "json", //数据格式:JSON
				//data: "dealType=" + dealType +"&uid=" + uid + "&code=" + code,
				data : "&phonenumber=" + mobile,
				success : function(data) {
					//console.log(data);
					var remessage = eval("(" + data + ")");
					//alert(remessage.message);
					//alert(remassage.time +"---"+ remassage.code);
					$("#codemessage").html(remessage.message);
					$("#sendtime").val(remessage.time);
					$("#code").val(remessage.code);
					vcode = remessage.code;
					vtime = remessage.time;
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
		// 表单验证
		function validateForm(){
			debugger;
			var mobile = $("#mobile").val().trim();
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
			if(vcode != code){
				alert("验证码输入错误！");
				return false;
			}
			
			var timestamp = (new Date()).getTime();
			//console.log(timestamp);
			//1609944046642
			var times = vtime + 60000;
			if(timestamp >= times){
				alert("验证码过期！");
				return false;
			}

		}
		
		
		
		
		
		
	</script>
</body>
</html>