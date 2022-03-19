<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!-- 左列表逻辑 -->


<div class="col-md-4 column" style="width:100%;">

	<div class="panel-group" id="panel-198547">
		<div class="panel panel-default">
			<div class="panel-heading">
				 <a class="panel-title" data-toggle="collapse" data-parent="#panel-198547" href="#panel-element-732805">个人信息</a>
			</div>
			<div id="panel-element-732805" class="panel-collapse in">
				<div class="panel-body">
					<td><a href="registerInfo!findRegisterInfoResult.action?registerid=${registerid }&amp;roletype=${typeuser }" target="mainArea">查看信息</a></td>
				</div>
			</div>
		</div>
		<c:if test="${typeuser eq '0' }" >
		<div class="panel panel-default">
			<div class="panel-heading">
				 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-198547" href="#panel-element-290822">人员管理</a>
			</div>
			<div id="panel-element-290822" class="panel-collapse collapse">
				<div class="panel-body">
					志愿者管理
				</div>
				<div class="panel-body">
					用户管理
				</div>
				<div class="panel-body">
					管理员管理
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${typeuser eq '0' }">
		<div class="panel panel-default">
			<div class="panel-heading">
				 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-198547" href="#panel-element-290833">任务管理</a>
			</div>
			<div id="panel-element-290833" class="panel-collapse collapse">
				<div class="panel-body">
					活动管理
				</div>
				<div class="panel-body">
					答疑
				</div>
				<div class="panel-body">
					发布公告
				</div>
				<div class="panel-body">
					申请处理
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${typeuser eq '0' }" >
		<div class="panel panel-default">
			<div class="panel-heading">
				 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-198547" href="#panel-element-290452">积分管理</a>
			</div>
			<div id="panel-element-290452" class="panel-collapse collapse">
				<div class="panel-body">
					积分信息
				</div>
				<div class="panel-body">
					礼品管理
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${typeuser eq '0' }" >
		<div class="panel panel-default">
			<div class="panel-heading">
				 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-198547" href="#panel-element-296622">权限管理</a>
			</div>
			<div id="panel-element-296622" class="panel-collapse collapse">
				<div class="panel-body">
					权限查询
				</div>
				<div class="panel-body">
					权限分配
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${typeuser eq '1' || typeuser eq '2' }" >
		<div class="panel panel-default">
			<div class="panel-heading">
				 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-198547" href="#panel-element-246422">活动信息</a>
			</div>
			<c:if test="${typeuser eq '1' }">
			<div id="panel-element-246422" class="panel-collapse collapse">
				<div class="panel-body">
					活动项目
				</div>
				<div class="panel-body">
					活动记录
				</div>
			</div>
			</c:if>
			<c:if test="${typeuser eq '2' }">
			<div id="panel-element-246422" class="panel-collapse collapse">
				<div class="panel-body">
					发起活动
				</div>
				<div class="panel-body">
					活动历史
				</div>
			</div>
			</c:if>
		</div>
		</c:if>
		<c:if test="${typeuser eq '1' }" >
		<div class="panel panel-default">
			<div class="panel-heading">
				 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-198547" href="#panel-element-296652">任务信息</a>
			</div>
			<div id="panel-element-296652" class="panel-collapse collapse">
				<div class="panel-body">
					签到活动
				</div>
				<div class="panel-body">
					积分兑换
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${typeuser eq '1' }" >
		<div class="panel panel-default">
			<div class="panel-heading">
				 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-198547" href="#panel-element-122652">问题答疑</a>
			</div>
			<div id="panel-element-122652" class="panel-collapse collapse">
				<div class="panel-body">
					提出问题
				</div>
				<div class="panel-body">
					问题列表
				</div>
			</div>
		</div>
		</c:if>
	</div>
</div>