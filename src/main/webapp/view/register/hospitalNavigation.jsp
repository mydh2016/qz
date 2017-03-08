<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
	<base href="${base_path }/view/register/">
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医院导航</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/hospitalNavigation.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/hospitalNavigation.js"></script>
</head>
<body>
    <div class="hs_nav">
        <div class="container">
           <header class="topBar">
               <a href="index.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>
               <h1>${requestScope.apphp.hospitalName }</h1>
           </header>
            <!--图片-->
            <section  class="hs_nav_img">
                <img src="${base_path }/view/register${requestScope.apphp.picAddr }" alt="${requestScope.apphp.hospitalName }" class="img-responsive"/>
            </section>
            <!--分类-->
            <section class="hs_nav_classify">
                <ul class="clearfix row">
<<<<<<< .mine
                    <li class="col-xs-4 text-center"><a href="hsInNavigation.jsp" >院内导航</a></li>
                    <li class="col-xs-4 text-center"><a href="hospitalMap.jsp"  >院外导航</a></li>
                    <li class="col-xs-4 text-center"><a href="hospitalPeriphery.jsp"  >医院周边</a></li>
                    <li class="col-xs-4 text-center"><a href="${base_path }/rest/app/navigation/building?hospitalId=${hospitalId}" class="hs_nav_classify_top">楼层导航</a></li>
                    <li class="col-xs-4 text-center"><a href="hospital.jsp" class="hs_nav_classify_top">医院介绍</a></li>
=======
                    <li class="col-xs-4 text-center"><a href="${base_path }/rest/app/hospital/selectById?id=${requestScope.apphp.hospitalId}&status=3" >院内导航</a></li>
                    <li class="col-xs-4 text-center"><a href="${base_path }/rest/app/hospital/selectById?id=${requestScope.apphp.hospitalId}&status=2"  >院外导航</a></li>
                    <li class="col-xs-4 text-center"><a href="${base_path }/rest/app/hospital/selectById?id=${requestScope.apphp.hospitalId}&status=1"  >医院周边</a></li>
                    <li class="col-xs-4 text-center"><a href="${base_path }/rest/app/hospital/selectById?id=${requestScope.apphp.hospitalId}&status=4" class="hs_nav_classify_top">楼层导航</a></li>
                    <li class="col-xs-4 text-center"><a href="${base_path }/rest/app/hospital/selectById?id=${requestScope.apphp.hospitalId}&status=0" class="hs_nav_classify_top">医院介绍</a></li>
>>>>>>> .r749
                    <li class="col-xs-4 text-center"><a href="${base_path }/rest/app/depart/alldepart?hcode=${requestScope.apphp.hcode}" class="hs_nav_classify_top department">科室介绍</a></li>
                    
                </ul>
            </section>
            <!--具体路线-->
            <section class="hs_nav_route">
                <h2>交通工具</h2>
                <div class="hs_nav_route_content">
                    地铁6号线或123、345、567、789路公交车，到嘉泰大厦下车
                </div>
            </section>
        </div>
    </div>
</body>
</html>