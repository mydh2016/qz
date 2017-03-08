<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html >

<html lang="en">
<head>
	<base href="${base_path }/view/register/">
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>院内导航</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/hsInNavigation.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/hsInNavigation.js"></script>
</head>
<body>
    <div class="hs_inNav">
        <div class="container">
            <header class="topBar">
                <a href="${base_path }/rest/app/hospital/selectByHospital?hcode=${requestScope.apphp.hcode}"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>院内导航</h1>
            </header>
            <section class="hs_inNav_img">
                <img src="img/u471.jpg" alt="院内导航"/>
            </section>
        </div>
    </div>
</body>
</html>