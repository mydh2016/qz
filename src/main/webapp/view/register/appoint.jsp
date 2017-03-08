<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
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
    <title>预约</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/appoint.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/appoint.js"></script>
    
</head>
<body>
<div class="hs_appoint">
    <div class="container">
        <!--标题-->
        <header class="topBar">
            <a href="${base_path }/view/register/index.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

            <h1>预约</h1>
        </header>
        <!--搜索框-->
      
        <!--预约医院-->
        <c:forEach items="${requestScope.hospital}" var="hospital"> 
        <section class="hs_appoint_hos row">
                <a href="${base_path }/rest/app/depart/Qdepartment?hcode=${hospital.hcode}">
            <div class="hs_appoint_hos_img col-xs-5">
                    <img src="${base_path }/view/register${hospital.picAddr}" alt="${hospital.hospitalName }"/>
               
            </div>
                 </a>
            <div class="hs_appoint_hos_text col-xs-7">
                <h3><a href="${base_path }/rest/app/depart/Qdepartment?hcode=${hospital.hcode}">${hospital.hospitalName }</a></h3>

                <div class="hs_appoint_hos_text_nav" >
                     
                </div>
            </div>
        </section>
        </c:forEach>
        <div class="hs_appoint_line"></div>
    </div>
</div>
<script>
</script>
</body>
</html>