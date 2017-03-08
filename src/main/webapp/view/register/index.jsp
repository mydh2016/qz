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
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>甘肃挂号平台</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/index.js"></script>
</head>
<body>
<div class="hs_layout">
    <div class="container">
        <!--头部-->
        <header class="col-blue ">
            <h1>甘肃挂号平台</h1>
        </header>
        <!--轮播图-->
        <section class="hs_layout_carousel ">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <a href="javascript:;"><img src="img/u1152.jpg" alt="..."></a>
                    </div>
                    <div class="item">
                        <a href="javascript:;"><img src="img/u1152.jpg" alt="..."></a>
                    </div>
                    <div class="item">
                        <a href="javascript:;"><img src="img/u1152.jpg" alt="..."></a>
                    </div>
                </div>
            </div>
        </section>
        <!--预约查询-->
        <section class="hs_layout_reg ">
            <ul class="row ">
                <li class="reg_appoint col-xs-6">
                    <a href="${pageContext.request.contextPath }/rest/app/hospital/appoint?status=0">
                        <i class="icon iconfont icon-yuyue"></i>
                        <p>预约挂号</p>
                    </a>
                </li>
                <li class="reg_refer col-xs-6"><a href="${pageContext.request.contextPath }/rest/app/hospital/appoint?status=1">
                    <i class="icon iconfont icon-chaxun"></i>
                    <p>号源查询</p>
                </a></li>
            </ul>
        </section>
        <!--体检信息-->
        <section class="hs_layout_phyExamInfo">
            <ul class="row">
                <li  class="col-xs-4 order"><a href="javascript:;">
                    <i class="icon iconfont icon-tijianyuyue"></i>
                    <p>预约体检</p>
                </a></li>
                <li class="col-xs-4 report"><a href="javascript:;">
                    <i class="icon iconfont icon-tijianbaogao"></i>
                    <p>查看体检报告</p>
                </a></li>
                <li class="col-xs-4 record"><a href="javascript:;">
                    <i class="icon iconfont icon-jilu"></i>
                    <p>查看诊疗记录</p>
                </a></li>
            </ul>
        </section>
        <!--百科服务-->
        <section class="hs_layout_cycloServise">
            <ul class="row">
                <li class="col-xs-6 "><a href="${pageContext.request.contextPath }/rest/app/medpedia/getMedpediaList?publish_module_sn=gs_yybk" class="clearfix">
                    <div>
                        <i class="icon iconfont icon-11baikeicon"></i>
                    </div>
                    <div>
                        <p>医疗百科</p>
                        <p>知识</p>
                    </div>
                </a></li>
                <li class="col-xs-6"><a href="${pageContext.request.contextPath }/rest/app/medpedia/getMedpediaList?publish_module_sn=gs_sqfw" class="clearfix">
                    <div >
                        <i class="icon iconfont icon-jinlingyingcaiwangtubiao40"></i>
                    </div>
                    <div>
                        <p>社区服务</p>

                        <p>指南</p>
                    </div>
                </a></li>
            </ul>
        </section>
        <!--个人信息-->
        <section class="hs_layout_personInfo">
            <ul class="row">
                <li class="col-xs-6"><a href="${pageContext.request.contextPath }/rest/app/user/querySession">
                    <i  class="icon iconfont icon-gerenzhongxin"></i>
                    <span>个人中心</span>
                </a></li>
                 <li class="col-xs-6"><a href="${pageContext.request.contextPath }/rest/app/Notice/queryAll">
                    <i  class="icon iconfont icon-gonggao1">
                    </i>
                    <span>医院公告</span>
                </a></li>
            </ul>
        </section>
    </div>
</div>
</body>
</html>