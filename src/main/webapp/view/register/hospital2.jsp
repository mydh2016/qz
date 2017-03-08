<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!doctype html>
<html lang="en">
<head>
	
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医院详情</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/hospital2.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/hospital2.js"></script>
</head>
<body>
<div class="hs_hospital">
    <header class="topBar">
        <a href="#"><i class="icon iconfont icon-fanhuijian"></i></a>

        <h1>医院详情</h1>
    </header>
    <section class="hs_hospital_img">
        <img src="${base_path }/view/register/img/u271.jpg " alt="医院"/>
        <h4>${requestScope.apphp.hospitalName }</h4>
    </section>
    <section class="hs_hospital_info">
        <h4>医院介绍</h4>
        <div class="hs_hospital_info_text">
        <p>${requestScope.apphp.hospitalintroduce }</p>
         <!--    <p> XX医院是国家卫生计生委委管的集医疗、教学、科研和预防保健为一体的现代化综合性三级甲等医院。现有在岗职工4767人，开放床位1752张。医院设有36个临床科室、10个医技科室。拥有28个博士点、1个临床博士后流动站。在岗博士生导师55人，中科院院士1人、国家自然科学基金杰出青年基金获得者3人、科技部“973”首席科学家1人、教育部“长江学者特聘教授”2人，1人入选国家级“新世纪百千万人才工程”，国家卫生计生委突出贡献专家7人。</p>
            <p> 医院连续多年荣获多项荣誉。荣获全国文明单位、全国卫生文化建设先进单位、全国医药卫生系统先进集体，全国医药卫生系统创先争优活动先进集体；被中华全国总工会授予“模范职工之家”称号。被卫生部评为2010年全国优质护理服务考核优秀医院，荣获卫生部全国公立医院“2011年度医院改革创新奖”。继2010年“建立科学的医院预算管理体系，提高医院管理水平”项目荣获中国医院协会首届“医院创新科技奖”三等奖</p>
         --></div>
        <div class="hs_hospital_info_open">展开</div>
    </section>
    <section class="hs_hospital_address">
        <a href="#">
            <i class="icon iconfont icon-ditu"></i>
            <p><span>地址：</span>${requestScope.apphp.hospitalAddress }</p>
        </a>

    </section>
</div>
</body>
</html>