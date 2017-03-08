<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head lang="en">
	<base href="${base_path }/view/register/">
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医院详情</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/hospital.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/hospital.js"></script>
</head>
<body>
<div class="hs_hospital">
    <header class="topBar">
        <a href="${base_path }/rest/app/hospital/selectByHospital?hcode=${requestScope.apphp.hcode}"><i class="icon iconfont icon-fanhuijian"></i></a>

        <h1>医院详情</h1>
    </header>
    <section class="hs_hospital_img">
        <img src="${base_path }/view/register${requestScope.apphp.picAddr }" alt="医院"/>
        <h4>${requestScope.apphp.hospitalName }</h4>
    </section>
    <section class="hs_hospital_info">
        <h4>医院介绍</h4>
        <div class="hs_hospital_info_text">
            <p> ${requestScope.apphp.hospitalintroduce }</p>
        </div>
        <div class="hs_hospital_info_open">展开</div>
    </section>
    <section class="hs_hospital_address">
        <a href="#">
            <i class="icon iconfont icon-ditu"></i>
            <p><span>地址：</span>${requestScope.apphp.hospitalAddress }</p>
        </a>

    </section>
</div>
</body>
</html>