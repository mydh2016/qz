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
    <title>在线帮助</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/onLine.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/zepto/zepto.min.js"></script>
    <script src="lib/zepto/touch.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/onLine.js"></script>
</head>
    <body>
        <div class="hs_onLine">
            <div class="container">
                <!-- 标题 -->
                <header class="topBar">
                    <a href="personal.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

                    <h1>在线帮助</h1>
                </header>
                <!-- 在线帮助内容 -->
                <main class="hs_onLine_main">
                 <div class="hs_onLine_main_others ">
                  <img src="./img/headerimg.jpg" class="img-circle hs_onLine_main_others_header" alt="头像">
                        <div class="bs-example bs-example-popover hs_onLine_main_others_content height" data-example-id="static-popovers">
                            <div class="popover right">
                                <div class="arrow"></div>
                                <div class="popover-content">
                                    <p>
                                    你好！
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>   
                    <div class="hs_onLine_main_self">
                        <img src="./img/headerimg.jpg" class="img-circle hs_onLine_main_self_header" alt="头像">
                        <div class="bs-example bs-example-popover hs_onLine_main_self_content height" data-example-id="static-popovers">
                            <div class="popover left">
                                <div class="arrow"></div>
                                <div class="popover-content content">
                                    <p>
                                    你好世
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                           
                </main>
                <!-- 提示框 -->
                <section class="hs_onLine_tip">请输入正确的用户名</section>
                <!-- 发送框 -->
                <footer>
                <form action="#">
                    <input type="text" placeHolder="在线服务" class="hs_onLine_content">
                    <button class="btn btn-primary btn-sm">发送</button>
                </form>
                </footer>
            </div>
        </div>
   
    </body>
</html>