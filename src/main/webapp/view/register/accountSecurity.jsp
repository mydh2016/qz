<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html >

<html lang="en">
<head>
	<base href="${base_path }/view/register/">

    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>账号安全</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/accountSecurity.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/accountSecurity.js"></script>
    
</head>
<body>
<div class="hs_security">
    <div class="container">
        <header class="topBar">
            <a href="personal.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>
            <h1>账号安全</h1>
        </header>
         
        	<form action="${pageContext.request.contextPath }/rest/app/appUserVO/update" id="id_iframe1" method="post">
       		<input type="hidden" name="userid" value="${sessionScope.appUser.userid }" />
        <section class="hs_security_info">
         
            <table class="formArray table">
                <tr class="hs_security_info_email ">
                    <td class="text-center">邮箱：</td>
                    <td>
                    	<div class="input-group">
                       	
                        <input id="email" type="text" name="email" class="form-control email" value="${sessionScope.appUser.email }" disabled/>
                         <span class="input-group-addon change" >修改</span>
                   		 </div>
                    </td>
                </tr>
                <tr class="hs_security_info_phone ">
                    <td class="text-center">手机：</td>
                    <td>
                    	<div class="input-group">
                        <input id="cellphonenumber" type="text"  name="cellphonenumber" class="form-control phone" value="${sessionScope.appUser.cellphonenumber }" disabled/>
                        <span class="input-group-addon change" >修改</span> 
                   		</div>
                    </td>
                </tr>
            </table>
       
        </section>
            <section class="hs_security_tip"></section>
            <footer class="hs_security_submit">
                    <input type="button" class="btn btn-primary btn-lg btn-block" value="提交">
            </footer>
            </form>
    </div>
</div>
</body>
</html>