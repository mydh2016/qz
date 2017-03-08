<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>科室介绍</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/department.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/js/common.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/department.js"></script>
</head>
<body>
    <div class="hs_deparment">
        <div class="container">
            <header class="topBar">
                <a href="${base_path }/rest/app/hospital/selectByHospital?hcode=${requestScope.dota.selectbyHospital.hcode}"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>科室介紹</h1>
            </header>
            <section class="hs_deparment_search">
                <div class="search">
                    <form>
                        <input type="text" class="hs_deparment_search_inp"/>
                    </form>
                    <a href="#"><i class="icon iconfont icon-msnui-find-bold"></i></a>
                    <input style="display:none" id="hospitalId" value="${requestScope.dota.selectbyHospital.hospitalId}" />
                    <input id="hcode" style="display:none" value="${requestScope.dota.selectbyHospital.hcode}"/>
                </div>
            </section>
            <main class="hs_deparment_main">
                <div class="hs_deparment_item clearfix">
                	<!-- 左侧栏 -->
                    <section class="hs_deparment_item_med">
                        <ul>
                         <c:forEach items="${requestScope.dota.selectByhospitalSn}" var="depart">
                          <li ><a id="${depart.departmentTypeSn}" href="javascript:;" >${depart.departmentTypeName }</a></li>
                      	 </c:forEach>
                        </ul>
                    </section>
                    <!-- 右侧栏 -->
                    <section class="hs_deparment_item_det">
                        <ul id="ul">
                    	<c:forEach items="${requestScope.dota.selectdepartment}" var="part">
                        <li><a id="${part.departmentId }" href="${base_path }/rest/app/depart/departmentX?departmentId=${part.departmentId }&hcode=${requestScope.dota.selectbyHospital.hcode}" >${part.departmentName }</a></li>
                        </c:forEach>
                    </ul>
                    </section>
                </div>
            </main>
        </div>
    </div>
</body>
</html>