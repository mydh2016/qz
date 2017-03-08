<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="${base_path }/view/register/">
	<meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>楼层导航</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/flowerGuide.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/flowerGuide.js"></script>
</head>
<body>
<ul>
	<li>
	    <h2>1F</h2>
	    <ul class="hs_flowerGuide_del_depart">
	        <li>挂号处</li>
	        <li>收费处</li>
	        <li>导医台</li>
	        <li>中药房</li>
	        <li>西药房</li>
	        <li>急诊科</li>
	    </ul>
	</li>
	<li>
	    <h2>2F</h2>
	    <ul class="hs_flowerGuide_del_depart">
	        <li>内科</li>
	        <li>骨科</li>
	        <li>妇产科</li>
	        <li>儿科</li>
	        <li>转诊处</li>
	    </ul>
	</li>
	<li>
	    <h2>3F</h2>
	    <ul class="hs_flowerGuide_del_depart">
	        <li>外科</li>
	        <li>内科</li>
	        <li>骨科</li>
	        <li>妇产科</li>
	    </ul>
	</li>
</ul>
</body>
</html>