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
    <title>增加家庭成员</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/addFamilyMember.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/addFamilyMember.js"></script>
    
</head>
<body>
<div class="hs_addFamMem">
    <div class="container">
        <header class="topBar">
            <a href="${pageContext.request.contextPath }/rest/app/appLinkman/select"><i class="icon iconfont icon-fanhuijian"></i></a>

            <h1>增加家庭成员</h1>
        </header>
        <section class="hs_addFamMem_member">
        <form action="${pageContext.request.contextPath }/rest/app/appLinkman/add" id="form"  method="post">
                <table class="formArray">
                    <tr class="hs_addFamMem_member_name ">
                        <td>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：</td>
                        <td>
                            <input type="text" name="linkmanname" class="userName"/>
                        </td>
                    </tr>
                    <tr class="hs_addFamMem_member_sex">
                        <td>性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别：</td>
                        <td>
                            <div class="chooseSex">
                           		<label for="female">女</label><input type="radio" name="gender" value='女' id="female" checked="checked"/>
                           		<label for="male">男</label><input type="radio" name="gender" value='男' id="male"/>
                            </div>
                        </td>
                    </tr>
                    <tr class="hs_addFamMem_member_phone ">
                        <td>手机号码：</td>
                        <td><input type="text" name="cellphonenumber" class="phone"/></td>
                    </tr>
                    <tr class="hs_addFamMem_member_ID ">
                        <td>身份证号：</td>
                        <td><input type="text" name="identifynumber" class="ID"/></td>
                    </tr>
                </table>
            
            <section class="hs_addFamMem_tip"></section>
            <footer>
               <button type="button" class=" btn-lg btn btn-primary btn-block">确认增加</button>
            </footer>
            </form>
        </section>

    </div>
</div>
</body>
</html>