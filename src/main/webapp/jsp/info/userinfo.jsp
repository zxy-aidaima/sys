<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户信息</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<style>
	.tableWidth{
		width: 95px;
	}
	.col-sm-10{
		width: 280px;
	}
	.table>tbody>tr>td{
		border-top: 0px;
	}
</style>
</head>
<body>

	<div class="row clearfix" style="width:1000px;margin:30px 10px 10px 100px;">
		<form class="form-horizontal clearfix" action="registerInfo!updateRegisterInfo.action" 
			theme="simple" name="form" method="post"><!-- onsubmit="return validateForm()" -->
		<table class="table table-hover">
			<tr>
			<td>
			<div>
				<label for="inputEmail3" class="tableWidth col-sm-2 control-label">账号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputEmail3" name="registerInfo.registerid" value="${registerInfoResult.registerid}" readonly="readonly"/>
				</div>
			</div>
			</td>
			<td>
			<div >
				<label for="inputPassword3" class="tableWidth col-sm-2 control-label">姓名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputPassword3" name="registerInfo.uname" value="${registerInfoResult.uname}"/>
				</div>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div >
				<label for="inputEmail3" class="tableWidth col-sm-2 control-label">手机号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputEmail3" name="registerInfo.phonenumber" value="${registerInfoResult.phonenumber}"/>
				</div>
			</div>
			</td>
			<td>
			<div >
				<label for="inputPassword3" class="tableWidth col-sm-2 control-label">身份证号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputPassword3" name="registerInfo.identifynumber" value="${registerInfoResult.identifynumber}"/>
				</div>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div >
				<label for="inputEmail3" class="tableWidth col-sm-2 control-label">性别</label>
				<div class="col-sm-10">
				<select class="form-control tableWidth2" id="inputEmail3" readonly="readonly">
					<option value="0" <c:if test="${registerInfoResult.sex =='0'}">selected="selected"</c:if>>女</option>
					<option value="1" <c:if test="${registerInfoResult.sex =='1'}">selected="selected"</c:if>>男</option>
					<%-- <c:if test="${registerInfoResult.sex =='0'}">
						<input type="text" class="form-control tableWidth2" id="inputEmail3" name="registerInfoResult.registerid" value="女"/>
					</c:if>
					<c:if test="${registerInfoResult.sex =='1'}">
						<input type="text" class="form-control tableWidth2" id="inputEmail3" name="registerInfoResult.registerid" value="男"/>
					</c:if>
					<c:if test="${registerInfoResult.sex == null}">
						<input type="text" class="form-control tableWidth2" id="inputEmail3" value=""/>
					</c:if> --%>
				</select>
					
				</div>
			</div>
			</td>
			<td>
			<div >
				<label for="inputPassword3" class="tableWidth col-sm-2 control-label">年龄</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputPassword3" name="registerInfo.age" value="${registerInfoResult.age}"/>
				</div>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div >
				<label for="inputEmail3" class="tableWidth col-sm-2 control-label">审核人</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputEmail3"  value="${registerInfoResult.approvename}" readonly="readonly"/>
				</div>
			</div>
			</td>
			<td>
			<div >
				<label for="inputPassword3" class="tableWidth col-sm-2 control-label">注册时间</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputPassword3" value="${registerInfoResult.registerdate}" readonly="readonly"/>
				</div>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div >
				<label for="inputEmail3" class="tableWidth col-sm-2 control-label">户籍地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputEmail3" value="${registerInfoResult.liveprovince}${registerInfoResult.livecity}${registerInfoResult.livecounty}${registerInfoResult.livetownvillage}" readonly="readonly"/>
				</div>
			</div>
			</td>
			<td>
			<div>
				<label for="inputPassword3" class="tableWidth col-sm-2 control-label">注册地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control tableWidth2" id="inputPassword3" value="${registerInfoResult.registerprovince}${registerInfoResult.registercity}${registerInfoResult.registecounty}${registerInfoResult.registertownvillage}" readonly="readonly"/>
				</div>
			</div>
			</td>
			</tr>
			<tr>
				<td colspan="2" class="right"><s:submit class="btn btn-success buttonLogin" value="修改个人信息" /></td>
			</tr>
		</table>
		</form>
</div>

</body>


</html>