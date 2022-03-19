<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/header-style.css" type="text/css" rel="stylesheet">

<div class="header">
	<h1 class="hh1" > <small class="small">Volunteer Management System</small>
	<c:if test="${typeuser eq '0' }" >
		<span class="small">(管理员)</span>
	</c:if>
	<c:if test="${typeuser eq '1' }" >
		<span class="small">(志愿者)</span>
	</c:if>
	<c:if test="${typeuser eq '2' }" >
		<span class="small">(用户)</span>
	</c:if>
	
	</h1>
</div>
