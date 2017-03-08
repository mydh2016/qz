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
    <link rel="stylesheet" href="css/healthInquiryDel.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
</head>
    <body>
        <div class="hs_healthDel">
            <div class="container">
                <header class="topBar">
                    <a href="${pageContext.request.contextPath }/rest/app/medpedia/getMedpediaList?publish_module_sn=gs_sqfw"><i class="icon iconfont icon-fanhuijian"></i></a>
                </header>
                <section class="hs_healthDel_title">
                    <h4>社区服务</h4>
                    <div class="hs_healthDel_title_time">${requestScope.med.publishDate}</div>
                </section>
                <section class="hs_healthDel_main">
                <p>
                ${requestScope.med.description}
                </p>
                 <p>
                </p>
                </section>
            </div>
        </div>
    </body>
</html>