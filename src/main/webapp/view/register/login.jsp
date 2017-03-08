<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head lang="en">
	<base href="${base_path }/view/register/">
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃 登陆"/>
    <meta name="description" content="甘肃挂号平台登陆"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>登陆页面</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="./css/base.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css"/>
    
    <link rel="stylesheet" href="css/login.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/login.js"></script> 
</head>
<body>
    <div class="hs_login">
    	<div class="container">
    	<header class="topBar">
            <a href="index.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>
        </header>
    		<div class="user">
        		<h2>用户登录</h2>
        	</div>
        	<form action="${pageContext.request.contextPath }/rest/app/user/login" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><i class="icon iconfont icon-yonghuming"></i></div>
                            <input id="userName" class="form-control userName" name="username" type="text" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><i class="icon iconfont icon-mima"></i></div>
                            <input id="psd" class="form-control psw" type="password" name="userpassword" placeholder="输入6-16位密码">

                        </div>
                    </div>
               
                <input type="button" id="hs_login_btn" class="hs_login_btn" value="登录"/>
        	</form>
            <section id="hs_login_tip"></section>
       	 	<footer>
        		还没有账号？<a href="${pageContext.request.contextPath }/view/register/register.jsp">注册</a>
        	</footer>
        </div>
    </div>
</body>
</html>