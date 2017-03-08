<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head lang="en">
	<base href="${base_path }/view/register/">
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃 登陆"/>
    <meta name="description" content="甘肃挂号平台登陆"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医生介绍</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/doctor.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/doctor.js"></script>
</head>
<body>
    <div class="doctor">
        <div class="container">
            <!--标题-->
            <header class="topBar">
                <a href="${base_path }/rest/app/depart/Qdepartment?hcode=${requestScope.hcode}"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>医生介绍</h1>
            </header>
            <!--搜索框-->
            <div class="doctor_search">
                <form >
                    <input type="text" class="doctor_search_inp"/>
                </form>
            <i class="icon iconfont icon-msnui-find-bold "></i>
            </div>
            <!--医生介绍-->
            <c:forEach var="se" items="${requestScope.appDoctor}">
            <section class="doctor_info row">
            <a href="${pageContext.request.contextPath }/rest/app/docter/queryById?userId=${se.doctorId }">
                <div class="col-xs-4">
                    <img src="${base_path }/view/register${se.picturePath }" alt="医生" class="img-circle "/>
                </div>
                <ul class="col-xs-8">
                    <li>
                        <b>${se.doctorName }&nbsp</b>
                        <span>${se.departName}&nbsp</span>
                        <span>${se.expert}&nbsp</span>
                    </li>
                    <li>${se.hospitalName}</li>
                    <li>${se.specialty }</li>
                </ul></a>
            </section>
            </c:forEach>
        </div>
    </div>
</body>
</html>