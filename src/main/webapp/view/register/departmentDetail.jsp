<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>科室介绍</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/departmentDetail.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/departmentDetail.js"></script>
</head>
<body>
    <div class="hs_depDetail">
        <header class="topBar">
            <a href="${base_path }/rest/app/depart/alldepart?hcode=${requestScope.dota.hospitalSn}"><i class="icon iconfont icon-fanhuijian"></i></a>

            <h1>${requestScope.dota.departmentName }介绍</h1>
        </header>
        <section class="hs_depDetail_img">
            <!-- <img src="img/doctors.jpg " alt=""/> -->
            <img src="${base_path }/view/register${requestScope.dota.picturePath} " alt=""/> 
        </section>
        <section class="hs_depDetail_info">
            <p>${requestScope.dota.specialDescription }</p>
        </section>
    </div>
</body>
</html>