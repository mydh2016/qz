<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head lang="en">
	<base href="${base_path }/view/register/">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医院公告</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/hospitalBulletin.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/hospitalBulletin.js"></script>
</head>
    <body>
    <div class="hs_bulletin">
        <div class="container">
            <header class="topBar">
                <a href="index.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>医院公告</h1>
            </header>
            <main class="hs_bulletin_main">
                <ul>
                	 <c:forEach items="${requestScope.notice }" var="notice">
                    <li><a href="${pageContext.request.contextPath }/rest/app/Notice/selectBynotice?publicNoticeId=${notice.publicNoticeId}">
                        <h4>${notice.publicNoticeName }</h4>
                        <p class="hs_bulletin_main_time">${notice.publishedTime1 }</p>
                        <i class="icon iconfont icon-icon"></i>
                    	</a>
                    </li>
                    </c:forEach>
                </ul>
            </main>
        </div>
    </div>
    </body>
</html>