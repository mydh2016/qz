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
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医院科室</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/medicalLab.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
     <script src="${base_path }/view/register/js/common.js"></script>
    <script src="${base_path }/view/register/js/template-native.js"></script>
    <script src="${base_path }/view/register/js/qu_medicalLab.js"></script>
</head>
<body>
<div class="hs_medLab">
    <div class="container">
        <header class="topBar">
			  <a href="${base_path }/rest/app/hospital/appoint?status=1"><i class="icon iconfont icon-fanhuijian"></i></a>

            <h1>医院科室</h1>
        </header>
        
        <section class="hs_medLab_hos">
            <div class="hs_medLab_hos_img col-xs-5">
                <a href="javascript:;">
                    <img src="${base_path }/view/register${requestScope.dota.selectbyHospital.picAddr}" alt="${requestScope.dota.selectbyHospital.hospitalName}"/>
                </a>
            </div>
            <div class="hs_medLab_hos_text col-xs-7">
                <h3><a href="javascript:;">${requestScope.dota.selectbyHospital.hospitalName}</a></h3>
					<input style="display:none" id="hospitalId" value="${requestScope.dota.selectbyHospital.hospitalId}" />	
                         <p><a href="${base_path }/rest/app/docter/all?hcode=${requestScope.dota.selectbyHospital.hcode}">查看医生</a></p>
                    <input id="hcode" style="display:none" value="${requestScope.dota.selectbyHospital.hcode}"/>
                <div class="hs_medLab_hos_text_nav">
                    <a href="javascript:;" class="thridHos">三甲</a>
                    <a href="javascript:;" class="healthIns">医保</a>
                    <a href="${base_path }/rest/app/hospital/selectByHospital?hcode=${requestScope.dota.selectbyHospital.hcode}" class="hosNav">医院导航</a>
                </div>
            </div>
        </section>
       
        <!--医院科室-->
        
        <main class="hs_medLab_main">
            <div class="hs_medLab_item clearfix">
                <section class="hs_medLab_item_med">
                    <ul>
                         
                          <c:forEach items="${requestScope.dota.selectByhospitalSn}" var="depart">
                          <li ><a id="${depart.departmentTypeSn}" href="javascript:;" >${depart.departmentTypeName }</a></li>
                      	 </c:forEach> 
                    </ul>
                    
                </section>
                <section class="hs_medLab_item_det">
                    <ul id="ul">
                    	<c:forEach items="${requestScope.dota.selectdepartment}" var="part">
                        <li><a id="${part.departmentId }" href="javascript:;">${part.departmentName }</a></li>
                        </c:forEach>
                    </ul>
                </section>
                 </div>
        </main>
		<section class="hs_medLab_tip"></section>
    </div>
</div>
</body>
</html>