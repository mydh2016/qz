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
    <title>家庭成员</title>
    <link rel="stylesheet" href="${base_path }/view/register/lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="${base_path }/view/register/css/base.css"/>
    <link rel="stylesheet" href="${base_path }/view/register/css/familyMember.css"/>
    <script src="${base_path }/view/register/lib/jquery.js"></script>
    <script src="${base_path }/view/register/lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="${base_path }/view/register/js/familyMember.js"></script>
</head>
<body>
<div class="hs_familyMeb">
    <div class="container">
        <header class="topBar">
            <a href="personal.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

            <h1>家庭成员</h1>
        </header>

        <!--家庭成员信息-->
        <div class="familyInfo">
        <form id="jvform" action="${pageContext.request.contextPath }/rest/app/appLinkman/select" method="post">
            	<c:forEach items="${requestScope.linkm }" var="user">
            <section class="hs_familyMeb_info one">
            	
                <table>
                    <th class="hs_familyMeb_info_name">
                    <td style="color: #4068a5">${user.linkmanname }</td>
                    </th>
                    <tr class="row hs_familyMeb_info_sex">
                        <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                        <td>${user.gender }</td>
                    </tr>
                    <tr class="hs_familyMeb_info_phone row">
                        <td>手机号码：</td>
                        <td>${user.cellphonenumber }</td>
                    </tr>
                    <tr class="hs_familyMeb_info_ID row">
                        <td>身份证号：</td>
                        <td>${user.identifynumber }</td>
                    
	                
                	</tr>
                </table>
	                <div class="hs_familyMeb_info_mod">
	                	<input type="hidden" name="linkmanid" id="${user.linkmanid}" />
						<a type="button" class="btn btn-danger first del" data-toggle="modal" data-target="#myModal">删除</a>
		                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath }/rest/app/appLinkman/query?linkmanid=${user.linkmanid }" class="modify">修改</a>
		            </div>
            </section>
                </c:forEach>
				</form>
        </div>
         <!--提示信息-->
       <!--提示信息-->
          <section class="hs_familyMeb_tip">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">提示！</h4>
                            </div>
                            <div class="modal-body">
                                	您确认要删除信息吗？
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary confirm">确认</button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        <footer>
        <footer>
            <!--增加用户-->
                <a href="addFamilyMember.jsp" class="hs_familyMeb_btn btn btn-primary btn-block btn-lg">增加家庭成员</a>
        </footer>
</div>
</div>
</body>
</html>