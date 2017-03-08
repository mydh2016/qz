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
    <meta http-equiv="refresh" content="20s" />
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医院周边</title>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/hospitalPerpheryCommon.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PISH0NzaAasfXUtdSin1mW491xV5hFH8"></script>
    <script type="text/javascript" src="js/hospitalPeriphery.js"></script>
</head>
<body>
<div class="hs_periphery">
    <div class="container">
        <!--标题-->
        <header class="topBar">
            <a href="${base_path }/rest/app/hospital/selectByHospital?hcode=${requestScope.apphp.hcode}"><i class="icon iconfont icon-fanhuijian"></i></a>
			<input style="display:none" id="longitude" value="${requestScope.apphp.longitude}" />	
            <input style="display:none" id="latitude" value="${requestScope.apphp.latitude}" />	
                   
            <h1>医院周边</h1>
        </header>
        <!--地图主体-->
        <section class="hs_periphery_main">
            <div id="l-map"></div>
            <div id="r-result"></div>
        </section>
        <!--底部导航栏-->
        <footer class="hs_periphery_nav">
            <ul class="clearfix row">
                <li class="col-xs-3 active"><a href="javascript:;">
                    <i class="icon iconfont icon-yaodian"></i>
                    药店
                </a></li>
                <li class="col-xs-3"><a href="hospitalPerpheryHotel.jsp">
                    <i class="icon iconfont icon-jiudian"></i>
                    酒店
                </a></li>
                <li class="col-xs-3"><a href="hospitalPerpheryBank.jsp">
                    <i class="icon iconfont icon-yinxing"></i>
                    银行
                </a></li>
                <li class="col-xs-3"><a href="hospitalPerpheryGas.jsp">
                    <i class="icon iconfont icon-jiayouzhan"></i>
                    加油站
                </a></li>
            </ul>
        </footer>
    </div>
</div>

</body>
</html>

