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
    <title>健康咨询</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/healthInquiry.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
   <script src="js/Medpedia.js"></script>
</head>
    <body>
    <div class="hs_health">
        <div class="container">
            <header class="topBar">
                <a href="index.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>医疗百科知识</h1>
            </header>
            <main class="hs_health_main">
                <ul>
            	<c:forEach items="${requestScope.medped}" var="med">
                    <li><a href="${base_path }/rest/app/medpedia/getMedpediaInfo?id=${med.publish_content_id }&publish_module_sn=gs_yybk">
                        <h4>${med.publish_content_name }</h4>
                        <p class="hs_health_main_time">${med.publishDate }</p>
                        <i class="icon iconfont icon-icon"></i>
                    </a></li>
                    </c:forEach>
                </ul>
            </main>
        </div>
    </div>
    </body>
</html>