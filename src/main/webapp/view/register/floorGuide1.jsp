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
	<div class="hs_flowerGuide">
        <div class="container">
            <!--标题-->
            <header class="topBar">
                <a href="index.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>楼层导航</h1>
            </header>
            <!--楼层导航-->
            <section class="hs_flowerGuide_del">
                <ul>
                	<c:forEach items="${appNavigationList }" var="appNavigation">
	                    <li>
	                        <h2><a href="${base_path }/rest/app/navigation/floorGuide?floorPhotoPath=${appNavigation.floorPhotoPath }">${appNavigation.buildName }</a></h2>
	                        <ul class="hs_flowerGuide_del_depart">
                            	<li></li>
                        	</ul>
	                    </li>
                	</c:forEach>
                </ul>
            </section>
        </div>
    </div>
</body>
</html>