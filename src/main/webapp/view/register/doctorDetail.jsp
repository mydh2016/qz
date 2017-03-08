<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃 登陆"/>
    <meta name="description" content="甘肃挂号平台登陆"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>医生详情页面</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/doctorDetail.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/doctorDetail.js"></script>
</head>
<body>
    <div class="hs_doctorDel">
        <div class="container">
            <header class="topBar">
                <a href="${base_path }/rest/app/docter/all?hcode=${dD.hospitalSn}"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>医生详情</h1>
            </header>
            <section class="hs_doctorDel_info row">
                <div class="col-xs-4">
                    <img src="${base_path }/view/register${dD.picturePath }" class="img-circle" alt=""/>
                </div>
                <ul class="col-xs-8">
                    <li><h4>${dD.doctorName }</h4></li>
                    <li><p>${dD.departName }&nbsp${dD.expert }</p></li>
                    <li><p>${dD.hospitalName }</p></li>
                </ul>
            </section>
            <section class="hs_doctorDel_perfile">
                <h4>个人介绍</h4>
                <p>${dD.specialty }</p>
            </section>
            <section class="hs_doctorDel_perfileDel">
                <h4>擅长及研究介绍</h4>
                <p>${dD.specialtyDescription}</p>
                <!-- <p>在诊治胃肠及肝胆、胰腺疾病方面有丰富的临床经验，熟练通过胃镜对消化道疾病进行诊断及治疗、精通各种胃肠动力检测方法。</p>
                <p>多年来对胃肠运动及其运动障碍相关性疾病进行了大量的基础与临床研究工作。功能性消化不良胃运动及其相关因素的研究曾获北京市科技进步奖。参与国家自然科学基金项目“糖尿病胃轻瘫发病机制的研究”的研究。对胃肠功能障碍性疾病，如功能性消化不良、胃食管反流病、便秘及Hp相关疾病良好的治疗效果。</p> -->
            </section>
            <!-- <section class="hs_doctorDel_prize">
                <h4>学术研究成果、获奖介绍</h4>
                <p>近年来发表文章80余篇，参与编写著作10余部，译著(文)10余篇。 </p>
            </section> -->
        </div>
    </div>

</body>
</html>