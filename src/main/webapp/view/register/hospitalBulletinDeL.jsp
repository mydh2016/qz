<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!doctype html>
<html lang="en">
<head>
<base href="${base_path }/view/register/">
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医院公告详细情况</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/hospitalBulletinDeL.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <%-- <script src="${base_path }/view/register/js/hospitalBulletinDeL.js"></script> --%>
</head>
    <body>
        <div class="hs_bulletinDel">
            <div class="container">
                <header class="topBar">
                    <a href="${pageContext.request.contextPath }/rest/app/Notice/queryAll"><i class="icon iconfont icon-fanhuijian"></i></a>
                </header>
                <section class="hs_bulletinDel_title">
                    <h4>${requestScope.notice.publicNoticeName }</h4>
                    <div class="hs_bulletinDel_title_time">${requestScope.notice.publishedTime1 }</div>
                </section>
                <section class="hs_bulletinDel_main">
                <p>
                ${requestScope.notice.description }
                </p>
                </section>
            </div>
        </div>
    </body>
</html>