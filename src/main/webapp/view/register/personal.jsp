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
    <title>个人中心</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/personal.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/personal.js"></script>
</head>
<body>
    <div class="hs_personal">
        <div class="container">
            <header class="topBar">
                <a href="index.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>个人中心</h1>
            </header>
            <section class="hs_personal_main hs_personal_account">
                <table  class="table">
                    <tr onclick="window.location.replace('accountMessage.jsp');">
                       <td  class="text-right"><i class="icon iconfont icon-zhanghao"></i></td>
                       <td>账号管理</td>
                       <td class="text-right"><i class="icon iconfont icon-icon"></i></td>
                    </tr>
                    <tr onclick="window.location.replace('accountSecurity.jsp');">
                        <td  class="text-right"><i class="icon iconfont icon-zhanghaoanquan1"></i></td>
                        <td>账号安全</td>
                        <td class="text-right"><i class="icon iconfont icon-icon"></i></td>
                    </tr>
                    </table>
            </section>
            <section class="hs_personal_main hs_personal_family">
                <table  class="table">
                    <tr onclick="window.location.replace('${pageContext.request.contextPath }/rest/app/appLinkman/select');">
                        <td class="text-right"><i class="icon iconfont icon-jiating"></i></td>
                        <td>家庭成员</td>
                        <td class="text-right"><i class="icon iconfont icon-icon"></i></td>
                    </tr>
                    <tr  onclick="window.location.replace('${pageContext.request.contextPath }/rest/app/pdGhOrder/query');">
                         <td  class="text-right"><i class="icon iconfont icon-xiaoshoujiluchaxun"></i></td>
                         <td>记录查询</td>
                         <td class="text-right"><i class="icon iconfont icon-icon"></i></td>
                    </tr>
                </table>
            </section>
            <section class="hs_systemManage_main">
                <table  class="table">
                    <tr onclick="window.location.replace('disclaimer.jsp');">
                       <td  class="text-right"><i class="icon iconfont icon-mianzeshengming"></i></td>
                       <td>免责声明</td>
                       <td class="text-right"><i class="icon iconfont icon-icon"></i></td>
                    </tr>
                    <tr onclick="window.location.replace('aboutUs.jsp');" >
                        <td  class="text-right"><i class="icon iconfont icon-guanyuwomen1"></i></td>
                        <td>关于我们</td>
                        <td class="text-right"><i class="icon iconfont icon-icon"></i></td>
                    </tr>
                </table>
            </section>
            <section class="hs_systemManage_main">
                <table  class="table">
                    <tr onclick="window.location.replace('FAQ.jsp');">
                        <td class="text-right"><i class="icon iconfont icon-changjianwenti"></i></td>
                        <td>常见问题</td>
                        <td class="text-right"><i class="icon iconfont icon-icon"></i></td>
                    </tr>
                    <tr  onclick="window.location.replace('onLine.jsp');">
                         <td  class="text-right"><i class="icon iconfont icon-zaixianbangzhu"></i></td>
                         <td>在线帮助</td>
                         <td class="text-right"><i class="icon iconfont icon-icon"></i></td>
                    </tr>
                </table>
            </section>
            <section class="hs_personal_logOff">

                <a href="${pageContext.request.contextPath }/rest/app/user/dellogin"  class="btn  btn-lg btn-danger">退出登录</a>
            </section>
        </div>
    </div>
</body>
</html>