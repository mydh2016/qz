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
    <title>修改信息</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="css/modifyInfo.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/modifyInfo.js"></script>
</head>
<body>
<div class="hs_modifyInfo">
    <div class="container">
    <header class="topBar">
        <a href="${pageContext.request.contextPath }/rest/app/appLinkman/select"><i class="icon iconfont icon-fanhuijian"></i></a>
        <h1>修改信息</h1>
    </header>
    		<form action="${pageContext.request.contextPath }/rest/app/appLinkman/update" method="post">
    <section class="hs_modifyInfo_member">
    <!-- <section class="hs_medLabMsg_del_add"> -->
            <table class="formArray">
                <tr class="hs_modifyInfo_member_name ">
                    <td>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：</td>
                    <td>
                        <input type="text" id="name" name="linkmanname" class="userName" value="${sessionScope.linkm.linkmanname}"/>
                    </td>
                </tr>
                <tr class="hs_accontMsg_info_sex">
                    <td>性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别：</td>
                    <td>
                        <div class="chooseSex">
                        <c:if test="${sessionScope.linkm.gender=='女'}">
                                <label for="female">女</label><input type="radio" name="gender" value="女" id="female" checked="checked" />
                                <label for="male">男</label><input type="radio" name="" id="male"  />
                        </c:if>
                        <c:if test="${sessionScope.linkm.gender=='男'}">
                                <label for="female">女</label><input type="radio" name="" id="female" />
                                <label for="male">男</label><input type="radio" name="gender" value="男" id="male" checked="checked" />
                        </c:if>
                        </div>
                    </td>
                 </tr>
                <tr class="hs_modifyInfo_member_phone ">
                    <td>手机号码：</td>
                    <td><input type="text" id="cellphone" name="cellphonenumber" class="phone" value="${sessionScope.linkm.cellphonenumber}"/></td>
                </tr>
                <tr class="hs_modifyInfo_member_ID ">
                    <td>身份证号：</td>
                    <td><input type="text" id="identify" class="ID" name="identifynumber" value="${sessionScope.linkm.identifynumber}"/></td>
                </tr>
            </table>
    </section>
    <section class="hs_modifyInfo_tip"></section>
    <footer>
        <input type="button" class="btn-lg btn btn-primary btn-block hs_modifyInfo_btn" value="完成"/>
    </footer>
            </form>
    </div>
</div>
</body>
</html>