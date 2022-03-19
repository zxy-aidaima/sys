<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="shortcut icon" href="<%=basePath%>/img/logohead.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="<%=basePath%>/css/global.css" type="text/css" rel="stylesheet" charset="utf-8"> 

</head>
<body>
	<!-- 在这里控制全局的页面，定义div的id是"global" -->
	<div id="global">
	    <div id="heading">
			<jsp:include page="../common/header.jsp" flush="true" >
            		<jsp:param name="userType" value="${typeuser }" />
            </jsp:include>
		</div>
	    <div id="content_menu">
	        <jsp:include page="../common/menu.jsp" flush="true" >
	    		<jsp:param name="userType" value="${typeuser }" />
	    	</jsp:include>
	     </div>
	     <div id="content_body">
			<iframe name="mainArea" src="welcome.jsp" height="100%" width="100%" 
			 frameborder="0" border="1px" marginwidth="0" marginheight="0" scrolling="no" allowfullscreen></iframe>
	     </div>
	     <div id="floor">
			<jsp:include page="../common/footer.jsp"></jsp:include>
		 </div>
	</div>
		
    </body>
</html>