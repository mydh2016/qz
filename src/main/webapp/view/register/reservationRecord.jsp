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
    <title>预约记录查询</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.5-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="lib/iconfont/iconfont.css">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/reservationRecord.css"/>
    <script src="lib/jquery.js"></script>
    <script src="lib/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
    <script src="js/reservationRecord.js"></script>
    <script type="text/javascript">
    $(function(){
        $("#img1").click(function(){
            var width = $(this).width();
            if(width==100)
            {
                $(this).width(400);
               // $(this).height(300);
            }
            else
            {
                $(this).width(100);
                //$(this).height(150);
            }
        }); 
    });

            /* function img(th){
            	var id=th.id;
            	 $.ajax({
                	type:"GET",
                	url:"/qazitem/rest/app/pdGhOrder/queryById",
            		data:{"id":id},
            		dataType:"json",
            		async:false,
            		success : function(data){
            			var list=data.data;
            			hm='<img  src="http://qr.topscan.com/api.php?text=就诊人:'+${list.realName }+'%0A医生:'+${list.doctorName }+'%0A科室:'+${list.hospitalName }+'-'+${list.departName }+'%0A时间:'+${list.time }+''+${list.timeSolt }+'"/>';
                		$("#topImg").html(hm);
                     },
            		error: function (request){
            			console.log(request);
            		}
                })
            } */
    </script>
    
</head>
<body>
    <div class="hs_resRecord">
        <div class="container">
            <header class="topBar">
                <a href="personal.jsp"><i class="icon iconfont icon-fanhuijian"></i></a>

                <h1>预约记录</h1>
            </header>
            <c:forEach items="${requestScope.ghOrder}" var="list">
            <section class="hs_resRecord_info ">
                    <table class="table">
                        <tr>
                            <td class="text-right"><h2>${list.realName }</h2></td>
                        </tr>
                        <tr>
                            <td class="text-right  ">科&nbsp&nbsp&nbsp室：</td>
                            <td><span>${list.hospitalName }</span>-<span>${list.departName }</span></td>
                        </tr>
                        <tr>
                            <td class="text-right">医&nbsp&nbsp&nbsp生：</td>
                            <td>${list.doctorName }</td>
                        </tr>
                        <tr>
                            <td class="text-right">时&nbsp&nbsp&nbsp间：</td>
                            <td>${list.time }</span>-<span>${list.timeSolt }</td>
                        </tr>
                        <tr>
                            <td class="text-right">挂号费：</td>
                            <td>${list.surplus }元</td>
                        </tr>
                        <tr>
                            <td class="text-right">二维码：</td>
                            <td><img id="img1" src="http://qr.topscan.com/api.php?text=就诊人:${list.realName }%0A医生:${list.doctorName }%0A科室:${list.hospitalName }-${list.departName }%0A时间:${list.time }${list.timeSolt }"/></td>
                        </tr>
                    </table>
                    
                    <div class="hs_resRecord_info_btn ">
                     <!--    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal" >取消预约</button>
                     --></div>
                </section>
                </c:forEach>
            <section class="hs_resRecord_tip">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">提示！</h4>
                            </div>
                            <div class="modal-body">
                                您确认要取消预约吗？
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary confirm">确认</button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</body>
</html>