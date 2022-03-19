<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>地址选择器</title>
   
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>     
    <script src="https://cdn.bootcdn.net/ajax/libs/distpicker/2.0.6/distpicker.min.js"></script>
</head>

<body>

	 <div data-toggle="distpicker" class="city">
  		<select class="dist" style="width:180px;" data-province="-- 选择省 --"></select>
 		<select class="dist" style="width:180px;" data-city="-- 选择市 --"></select>
  		<select class="dist" style="width:180px;" data-district="-- 选择区 --"></select>
	</div>


</body>
</html>