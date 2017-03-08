<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base_path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="${base_path }/view/register/">
    <meta charset="UTF-8">
    <meta name="keywords" content="甘肃挂号平台 挂号 甘肃"/>
    <meta name="description" content="甘肃挂号平台"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>账号管理</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/accountMessage.css"/>
    <link rel="stylesheet" href="css/familyMember.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/accountMessage.js"></script>
</head>
<body>
    <div class="hs_accontMsg">
       <header class="topBar">
            <a href="personal.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

            <h1>账号管理</h1>
        </header>
             <section class="hs_accontMsg_headPor">
           <i class="iocn iconfont icon-yonghu"></i>
        </section>
            <section class="hs_accontMsg_info">
            <form action="${pageContext.request.contextPath }/rest/app/user/update" method="post">
                <table class="formArray">
                <tr style="display:none">
                <td><i></i></td>
                        <td>I&nbsp&nbsp&nbsp&nbsp&nbsp&nbspD：</td>
                        <td>
                            <input type="text" name="userid" class="addPhone" value="${sessionScope.appUser.userid} "  />
                        </td>
                    </tr>
                    <tr>
                    <td><i>*</i></td>
                        <td>真实姓名：</td>
                        <td>
                            <input type="text" name="realname" class="addUserName" disabled value="${sessionScope.appUser.realname}"/>
                        </td>
                    </tr>
                     <tr class="hs_accontMsg_info_sex">
                     <td><i>*</i></td>
                        <td>性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别：</td>
                        <td>
                            <input type="text" class="sex" disabled value="${sessionScope.appUser.gender}"/>
                            <div class="chooseSex">
                                <label for="female">女</label><input type="radio" name="" id="female"/>
                                <label for="male">男</label><input type="radio" name="" id="male"/>
                            </div>
                        </td>
                    </tr> 
                    
                    <tr>
                    <td><i>*</i></td>
                        <td>手机号码：</td>
                        <td>
                            <input id="cellphonenumber" type="text" name="cellphonenumber" class="phone" disabled value="${sessionScope.appUser.cellphonenumber}"/>
                        </td>
                    </tr>
                    <tr>
                    <td><i></i></td>
                        <td>办公电话：</td>
                        <td>
                            <input type="text" name="officephonenumber" class="officePhone" disabled value="${sessionScope.appUser.officephonenumber}"/>
                        </td>
                    </tr>
                    <tr>
                    <td><i>*</i></td>
                        <td>身份证号：</td>
                        <td>
                            <input  type="text" name="identifynumber" class="ID" disabled value="${sessionScope.appUser.identifynumber}"/>
                        </td>
                    </tr>
                     <tr>
                     <td></td>
                     <td>提示：<i>*</i>为必填内容</td>                       
                    </tr>
                </table>
                    <footer>
                <a  href="JavaScript:;" class="hs_accontMsg_btn btn btn-primary btn-lg btn-block">修改信息</a>
                <div class="hs_accontMsg_whether ">
                    <input type="button" value="取消" class="hs_accontMsg_whether_cancel btn  btn-danger btn-lg "/>
                <input id="update" type="button" value="确认" class="hs_accontMsg_whether_confirm btn btn-primary  btn-lg "/>
                </div>
            </footer>
                </form>
            </section>
        </div>
    </div>
</body>
</html>