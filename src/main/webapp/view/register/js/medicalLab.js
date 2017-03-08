$(function () {
	//左侧盒子滑动
    var parentBoxLeft = $(".hs_medLab_item_med");
    var childBoxLeft = $(".hs_medLab_item_med ul");
    var itemMedsLeft = $(".hs_medLab_item_med ul li");
    var flagLeft=true;
    swipe(parentBoxLeft,childBoxLeft,flagLeft,itemMedsLeft);
    //右侧盒子滑动
    var parentBoxRight=$(".hs_medLab_item_det");
    var childBoxRight=$(".hs_medLab_item_det ul");
    var flagRight=false;
    swipe(parentBoxRight,childBoxRight,flagRight);
    //点击跳转页面
    
    var medLabDateSlef = '<div class="hs_medLabDate clearfix">' +
        '<div class="you">></div>'+
        '<section class="hs_medLabDate_date">' +     
        '<ul class="clearfix">' +
        '<li class="active"><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '<li ><a href="javascript:;">' +
        '<p class="week"></p>' +
        '<p class="date"></p>' +
        '</a></li>' +
        '</ul>' +    
        '</section>' +
        '<div class="zuo"><</div>'
        
        var medLabDate = '<div class="content">'+
        	'<%for(var l=0;l<result.length; l++) {%>'+
    '<div class="hs_medLabDate">' +
        '<section class= "hs_medLabDate_doc clearfix">' +
        '<div class= "hs_medLabDate_doc_img">' +
        '<img  src = "img/u1162.png " alt = "" />' +
        '</div>' +
        '<div class= "hs_medLabDate_doc_info">' +
        '<ul>' +
        '<li>' +
        '<span> '+'<%= result[l].departName %>'+'：</span >' +
        '<span> '+'<%= result[l].productType %>'+' </span>'
        +'<%if(result[l].surplus == 0) {%>'   
        +'                   <a  href = "javascript:;"> 约满</a>'
        +'                <% }else{ %>'
        +'                   <a href = "javascript:;" id="'+'<%= result[l].productId %>'+'" class="hs_medLabDate_doc_info_appoint"> 预约</a>'
        +'                <% } %></li>' 
        +
        '<li>' +
        '<span> 医生：</span >' +
        '<span> '+'<%= result[l].userName %>'+' </span>' +
        '</li>' +
        '<li>' +
        '<span class = "time"> '+'<%= result[l].strDate %>'+'&nbsp'+'<%if(result[l].timeSolt == "1") {%>'   
        +'                    上午'
        +'                <% }else{ %>'
        +'                    下午'
        +'                <% } %>'
        +'&nbsp'+'<%= result[l].consRoom %>'
        +'号诊室</span>' +
        '<span class= "money">'+'<%= result[l].plantPrice %>'+' 元 </span>' +
        '</li>' +
        '</ul>' +
        '</div>' +
        '</section>'+
        '<%}%>'+
        '</div>'
        var dlistrender = template.compile(medLabDate);
    var medLabDet = '<div class="hs_deparmentInfo">'+
    	'<div class="hs_deparment">' +
        '<section class="hs_deparment_sure">' +
        '<h1>确认信息</h1>' +
        '</section>' +
        '<section class="hs_deparment_del">' +
        '<ul>' +
        '<li>' +
        '医生：<span>'+'<%= result.AppPdGh.userName %>'+'</span>' +
        '</li>' +
        '<li>' +
        '科室：<span>'+'<%= result.AppPdGh.departName %>'+'</span>' +
        '</li>' +
        '<li> 号别：<span>'+'<%= result.AppPdGh.productType %>'+'</span></li>' +
        '<li> 时间：<span>'+'<%= result.AppPdGh.strDate %>'
        +' '
        +'<%if(result.AppPdGh.timeSolt == "1") {%>'   
        +'                    上午'
        +'                <% }else{ %>'
        +'                    下午'
        +'                <% } %>'
        +'</span></li>' 
        +
        '<li>费用：<span>'+'<%= result.AppPdGh.plantPrice %>'+'元</span></li>' +
        
        '<span id="pdd" style="display:none"> '+'<%= result.AppPdGh.productId %>'+'</span >' +
        
        '<li>  就诊人：<select>' +
        '<option selected value="0"  id="'+'<%= result.Appuser.userid %>'+'">'+'<%= result.Appuser.realname %>'+'</option>' +
        '<%for(var l=0;l<result.lsit.length; l++) {%>'+
        '<option value="1"  id="'+'<%= result.lsit[l].linkmanid %>'+'">'+'<%= result.lsit[l].linkmanname %>'+'</option>' 
        +'<%}%>'+
        '</select>' +
        ' <a href="javascript:;" class="addBtn">添加</a>' +
        '</li>' +
        '<li>' +
        '<section class="hs_deparment_del_add">' +
        '<ul>' +
        '<li>' +
        '姓名：<input id="userName" disabled class="addName" type="text" value="'+'<%= result.Appuser.realname %>'+'" >' +
        '</li>' +
        '<li> 手机：<input id="phone" disabled class="addPhone" type="text" value="'+'<%= result.Appuser.cellphonenumber %>'+'" >' +
         '</li>' +
        '<li> 身份证：<input id="IDcard" disabled class="addID" type="text" value="'+'<%= result.Appuser.identifynumber %>'+'" >' +
         '</li>' +
        '<li class="text-right hs_deparment_del_add_confirm"> ' +
        '<button type="button" class="btn btn-default btn-sm quite">取消添加</button>'+
        '<button type="button" class="btn btn-warning btn-sm sure">确定添加</button>'+
         '</li>' +
        '</section>' +
        '</li>' +
        '</ul>' +
        '</section>' +
        '<section class="hs_deparment_pay">' +
        '<a href="javascript:;" class="addB">确定</a>' +
        '</section>' +
        '</div>'+
        '</div>'
        var yuyue = template.compile(medLabDet);
    for (var x = 0; x < itemMedsLeft.length; x++) {
   		 var getId=itemMedsLeft[x];
   		$(itemMedsLeft[0]).addClass("active");
   		 $.each(getId,function(index,value){
   			 getId.onclick=function(){
    			itemMedsLeft.removeClass("active")
   				var leixing=$(this).children("a").attr("id");
    			var hcode=$("#hcode").val();
    			$(this).addClass("active");
    			$.ajax({
    				type:"get",
    				url:"/qazitem/rest/app/depart/department",
    				data:{"departmentTypeSn":leixing,"hcode":hcode},
    				dataType:"json",
    				success:function(data){
    					var list=data.data;
    					var html="";
    					for(var i=0;i<list.length;i++){
    						html+="<li><a id='"+list[i].departmentId+"' href='javascript:;'>"+list[i].departmentName+"</a></li>"
    					}
    					$("#ul").html(html);
                    	var is=$(".hs_medLab_item_det ul li a");
            			chushi(is);
            			parentBoxRight=$(".hs_medLab_item_det");
            		    childBoxRight=$(".hs_medLab_item_det ul");
            		    swipe(parentBoxRight,childBoxRight);
    					
    				},
    				error:function(){
    					
    				}
    				
    			})
				
   	        }
   	        })
   	        
   	 
   	 }
    	function chushi(is){
    		if(is==null){
    			var itemDels= $(".hs_medLab_item_det ul li a");
    			sel(itemDels);
    		}else{
    			sel(is);
    		}
    	}
    var itemDels=chushi();
    function sel(itemDels){
    	for (var x = 0; x < itemDels.length; x++) {
    		itemDels[x].onclick = function () {
        	 //加载初始内容
        	var hospitalId=$("#hospitalId").val();
        	var departmentId=this.id;
        	var html="";
        	$.ajax({
            	type:"GET",
            	url:"/qazitem/rest/app/pdGh/query",
        		data:{"departmentId":departmentId,"hospitalId":hospitalId},
        		dataType:"json",
        		async:false,
        		success : function(json){
        			html = dlistrender({
        			result : json.data
        			});
        			//document.getElementById("tab-contanier").innerHTML = html;
        		},
        		error: function (request){
        			console.log(request);
        		}
            })
            

           
            //加载排版日期
           // $(".hs_medLab_main").html(medLabDate);
        	 $(".hs_medLab_main").html("");
             $(".hs_medLab_main").append("<div class='hs_medLab_main_date'></div>").append("<div class='hs_medLab_main_detail'></div>");
             var mainDate=$(".hs_medLab_main_date");
             var mainDetail=$(".hs_medLab_main_detail");
            mainDate.html(medLabDateSlef);
            //mainDetail.html(medLabDate);
            mainDetail.html(html);
         // 给预约医生信息加滑动事件
            var doctorParent=$(".hs_medLab_main_detail");
            swipe(doctorParent,$(".content"));
            var dates = $(".hs_medLabDate_date ul li");
            for (var f = 0; f < dates.length; f++) {
                dates[f].onclick = function () {
                	//点击日期
                	this.className = "active";
                    $(this).siblings().removeClass('active');
                	//点击日期查询当天的预约
                    var dateNow=$(this).find('.date').html();
                    var monthNow=Number(dateNow.split("-")[0]);
                    var yearNow=new Date().getFullYear();
                    if((new Date().getMonth()+1)==12){
                        if(monthNow===1){
                            yearNow++;
                        }
                        
                    }
                    var dateNowIs=yearNow+"-"+dateNow;
                	//var html="";
                	$.ajax({
                    	type:"GET",
                    	url:"/qazitem/rest/app/pdGh/query",
                		data:{"data":dateNowIs,"departmentId":departmentId,"hospitalId":hospitalId},
                		dataType:"json",
                		async:false,
                		success : function(json){
                			html = dlistrender({
                				result : json.data
                			});
                			
                			
                		},
                		error: function (request){
                			console.log(request);
                		}
                    })
                     
                    mainDetail.html(html);
                	$.each($(".hs_medLabDate_doc_info_appoint"),function(index,value){
                		value.onclick=function(){
                			_this=this
                			appoint(_this)
                		}
                	})
                	doctorParent=$(".hs_medLab_main_detail");
                    swipe(doctorParent,$(".content"));
                }
            }
           
            //点击预约跳转
            var docAppoint = $(".hs_medLabDate_doc_info_appoint");
            $.each(docAppoint,function(index,value){
            	value.onclick=function(){
            		var _this=this
            		appoint(_this);
            	}
            })
            function appoint(is){
            	//加载确认信息
            	var productId = is.id;
            	 var hm="";
                 $.ajax({
                 	type:"GET",
                 	url:"/qazitem/rest/app/pdGh/yuyue",
             		data:{"productId":productId},
             		dataType:"json",
             		async:false,
             		success : function(data){
             			if(data.resultCode=="1"){
             				window.location.href="/qazitem/view/register/login.jsp";
             			}else{
             			hm = yuyue({
             			result : data.data
             			
             			});
             			}
             		},
             		error: function (request){
             			console.log(request);
             		}
                 })
                 $(".hs_medLab_main").html(hm);
                var inputs=$(".hs_deparment_del_add input");
                var confirm=$(".hs_deparment_del_add_confirm")
                addNumber(inputs,confirm);
            }
            	
          
            // 左右键
            var keyLeft=$(".zuo");
            var keyRight=$(".you");
            var parentNodeWidth=$(".hs_medLabDate_date").width();
            var childNode=$(".hs_medLabDate_date ul");
            var childLis=$(".hs_medLabDate_date ul li")
            // 点击右键
            var pic=0;
            keyRight.on("click",function(){
                 pic++;
                var target=-pic*parentNodeWidth;
                if(pic==childLis.length/6-1){                                    
                        animate(childNode,-5*parentNodeWidth);            
                }else if(pic>childLis.length/6-1) {
                    pic=childLis.length/6-1;
                        return false; 
                }    
            
                animate(childNode,target);
            })
            // 点击左键
            keyLeft.on("click",function(){              
                if(pic==0){
                        keyLeft.css("background",'rgba("+0+","+0+","+0+","+0.4)');               
                }else{
                    pic--;    
                    var target=-pic*parentNodeWidth;    
                    animate(childNode,target);
                }         
            
            })
            
            //预约日期
            var liWeeks=$(".week");
            var liDates=$(".date");
            date(liWeeks,liDates);

        }
    }
    }

    //点击添加跳转
    function addNumber(inputs,confirm) {
        $(".addBtn").on("click", function () {
            $.each(inputs,function(value,item){
                item.value="";
                $(item).removeAttr("disabled");
            })
            // 添加滑动事件
            $(".hs_deparment").addClass('now');
            confirm.fadeIn(500);
        })
        // 取消添加
            var quite=$(".quite");
            quite.on("click",function(){
                quiteAdd();
                confirm.fadeOut(500);
                $(".hs_deparment").removeClass('now');
                // $(".hs_deparment").addClass('complete')
            })
        // 验证
    // 姓名
    	var userName=$(".addName");
    	var regUser= /^[\u4e00-\u9fa5]{2,4}$/;
    	var tipUser="姓名输入不正确";
    	var tipUserKong="姓名不能为空";
    	var flagUser=false;
    	// 姓名验证
        userName.blur(function(){
           if(userName.val().trim("")==""){
               tip(tipUserKong);
               return false;
           }
           validate(userName,regUser,tipUser,flagUser);
       })
       // 手机号
    var phone=$(".addPhone");
    var regPhone=/^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$/;
    var tipPhone="请输入正确的手机号码";
    var tipPhoneKong="手机号不能为空";
    var flagPhone=false;
    // 手机验证
    phone.blur(function(){      
        if(phone.val().trim("")===""){
            tip(tipPhoneKong);
            return false;
        }
        validate(phone,regPhone,tipPhone,flagPhone);
    })
    // 身份证号
    var ID=$(".addID");
    var regID=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    var tipID="请输入正确的身份证号";
    var tipIDKong="身份证号不能为空";
    var flagID=false;
     // 身份证验证
    ID.blur(function(){
        if(ID.val().trim("")==""){
            tip(tipIDKong);
            return false;
        }
        validate(ID,regID,tipID,flagID);
    })
        var select=$("select");
        var confirmBtn=confirm.find(".sure")
        confirmBtn.on("click",function(){
        	var userNameVal=$("#userName").val()
        	var phoneVal=$("#phone").val();
        	var IDcardVal=$("#IDcard").val();
//        	验证
        	 if(userName.val().trim("")==""){
                 tip(tipUserKong);
                 return false;
             }
             if(phone.val().trim("")==""){
                 tip(tipPhoneKong);
                 return false;
             }
             if(ID.val().trim("")==""){
                 tip(tipIDKong);
                 return false;
             }
             if(flagUser==false){
                 if(!regUser.test(userName.val().trim(""))){
                     tip(tipUser);
                     return false;
                 }
             flagUser=true;
             }
             if(flagPhone==false){
                 if(!regPhone.test(phone.val().trim(""))){
                     tip(tipPhone);
                     return false;
                 }
             flagPhone=true;
             }
             if(flagID==false){
                 if(!regID.test(ID.val().trim(""))){
                     tip(tipID);
                     return false;
                 }
                 flagID=true;
             }
             if(flagID==true&&flagUser==true&&flagPhone==true){
             // 进行提交
            	//添加用户信息
             	$.ajax({
                  	type:"POST",
                  	url:"/qazitem/rest/app/pdGh/add",
              		data:{"userName":userNameVal,"phone":phoneVal,"IDcard":IDcardVal},
              		dataType:"json",
              		async:false,
              		success : function(data){
              			var addName=data.data.linkmanname;
              			var id=data.data.linkmanid;
              			var option='<option selected value="1" id='+id+'>'+addName+'</option>';
                         select.append(option);
                         //获取option
                         var opsNew=$("option");
                         selected(select[0],opsNew);
                         
              			$("#IDcard").val(data.data.identifynumber)
              			$("#phone").val(data.data.cellphonenumber)
              			$("#userName").val(data.data.linkmanname)
              			$(".hs_deparment").removeClass('now');
              		},
              		error: function (request){
              			alert("添加失败");
              			return false;
              		}
             
             })
             }
        	
        	
            confirm.fadeOut(500);
        })
        //变动下拉框，改变信息
        var ops=$("option");
        selected(select[0],ops);
        function selected(item,option){
        	item.onchange=function(){
                   var index=item.selectedIndex;//索引值
                   var id=option[index].id;//获得的id值
                   var status=option[index].value;
                   disabled($(".hs_deparment_del_add input"));
                   $(".hs_deparment").removeClass('now');
                   //通过id去查询信息
                   $.ajax({
                    	type:"GET",
                    	url:"/qazitem/rest/app/pdGh/selectById",
                		data:{"status":status,"id":id},
                		dataType:"json",
                		async:false,
                		success : function(data){
                			if(data.resultCode=="1"){
                               $("#IDcard").val(data.data.identifynumber);
                    			$("#phone").val(data.data.cellphonenumber);
                    			$("#userName").val(data.data.linkmanname);
                			}else{
                               $("#IDcard").val(data.data.identifynumber);
                    			$("#phone").val(data.data.cellphonenumber);
                    			$("#userName").val(data.data.realname);
                		}},
                		error: function (request){
                			console.log(request);
                		}
                    })
                    $(".hs_deparment_del_add_confirm").fadeOut(500);
               }
        }
        
     
        $(".addB").on("click", function () {
        	var productId=$("#pdd").text();
        	var userName=$("#userName").val();
        	var IDcard=$("#IDcard").val();
        	if(userName=="" || IDcard==""){
        		tip("请到用户中心完善姓名和身份证信息!");
        	}else{
        	$.ajax({
             	type:"GET",
             	url:"/qazitem/rest/app/pdGh/queding",
         		data:{"productId":productId,"userName":userName,"IDcard":IDcard},
         		dataType:"json",
         		async:false,
         		success : function(data){
         			alert(data.data);
         			if(data.resultCode=="0"){
         			window.location.href="/qazitem/rest/app/pdGhOrder/query";
         			}
         		},
         		error: function (request){
         			console.log(request);
         		}
             })
        	}
        })
        
    
    }
 // 将添加的Input框变为不可点
    function disabled(inps){
        $.each(inps,function(i,v){
                    $(v).attr("disabled",true)
                });
    }
    function quiteAdd(){
        var ops=$("option");
        var indexNow=0;
        for(var i=0;i<ops.length;i++){
            if(ops[i].hasAttribute("selected")){
                indexNow=i;
            }
           ops[i].removeAttribute("selected");
        }        
        var id=ops[indexNow].id;
        var dd=document.getElementById(id);
        dd.setAttribute("selected","selected");
        $.ajax({
                    	type:"GET",
                    	url:"/qazitem/rest/app/pdGh/selectById",
                		data:{"status":0,"id":id},
                		dataType:"json",
                		async:false,
                		success : function(data){
                			if(data.resultCode=="1"){
                               $("#IDcard").val(data.data.identifynumber);
                    			$("#phone").val(data.data.cellphonenumber);
                    			$("#userName").val(data.data.linkmanname);
                			}else{
                               $("#IDcard").val(data.data.identifynumber);
                    			$("#phone").val(data.data.cellphonenumber);
                    			$("#userName").val(data.data.realname);
                		}},
                		error: function (request){
                			console.log(request);
                		}
                    })
                    $(".hs_deparment_del_add_confirm").fadeOut(500);
        disabled($(".hs_deparment_del_add input"));
    }

    
     // 验证方法
        function validate(input,reg,tipHtml,flag){
          if(!reg.test(input.val().trim(""))){
              tip(tipHtml);
              flag=false;
              return false;
          }
          flag=true;
      }
        // 提示方法
        var tipName=$(".hs_medLab_tip");
          function tip(tipHtml){
            tipName.html(tipHtml).fadeIn(500).delay(1500).fadeOut(500);
        }
    //日期

    function date(liWeeks,lis){
        var currentDate=new Date();
        //    获取年
        var year=currentDate.getFullYear();
//    获取月份
        var month=currentDate.getMonth()+1;
        //  获取日期
        var day=currentDate.getDate();
//    获取星期
        var week=currentDate.getDay();

        //   未来日期
        var futureDay=day+29;
//    日期记录
        var j=1;
//    判断年
        if(year%4==0&&year%100!=0||year%400==0){
//        闰年
            if(month ==1){
                for(var i=0;i<lis.length;i++){
                    if(day+i<=31){
                        lis[i].innerHTML=month+"-"+(day+i);
                    }else if(day+i>=32){
                        lis[i].innerHTML=(month+1)+"-"+(j++);
                    }
                }
            }else if(month==2){
                for(var i=0;i<lis.length;i++){
                    if(day+i<=29){
                        lis[i].innerHTML=month+"-"+(day+i);
                    }else if(day+i>=30){
                        lis[i].innerHTML=(month+1)+"-"+(j++);
                    }
                }
            }
        }else{
//        平年
            if(month ==1){
                for(var i=0;i<lis.length;i++){
                    if(day+i<=31){
                        lis[i].innerHTML='1'+"-"+(day+i);
                    }else if(day+i>=32){
                        lis[i].innerHTML='2'+"-"+(j++);
                    }else if(day+i==59){
                        lis[i].innerHTML='3'+"-"+(1);
                    }
                }
            }else if(month==2){
                for(var i=0;i<lis.length;i++){
                    if(day+i<=28){
                        lis[i].innerHTML=month+"-"+(day+i);
                    }else if(day+i>=29){
                        lis[i].innerHTML=(month+1)+"-"+(j++);
                    }
                }
            }
        }
//    平年


        if(month==3||month==5||month==7||month==8||month==10){
            for(var i=0;i<lis.length;i++){
                if(day+i<=31){
                    lis[i].innerHTML=month+"-"+(day+i);
                }else if(day+i>=32){
                    lis[i].innerHTML=(month+1)+"-"+(j++);
                }
            }
        }else if(month==12){
            for(var i=0;i<lis.length;i++){
                if(day+i<=31){
                    lis[i].innerHTML="12"+"-"+(day+i);
                }else if(day+i>=32){
                    lis[i].innerHTML="1"+"-"+(j++);
                }
            }

        }else if(month==4||month==6||month==9||month==11){
            for(var i=0;i<lis.length;i++){
                if(day+i<=30){
                    lis[i].innerHTML=month+"-"+(day+i);
                }else if(day+i>=31){
                    lis[i].innerHTML=(month+1)+"-"+(j++);
                }
            }
        }
//计算周几

        for(var k=0;k<liWeeks.length;k++){
            if((week+k)%7==0){
                liWeeks[k].innerHTML="星期日"
            }else if((week+k)%7==1){
                liWeeks[k].innerHTML="星期一"
            }else if((week+k)%7==2){
                liWeeks[k].innerHTML="星期二"
            }else if((week+k)%7==3){
                liWeeks[k].innerHTML="星期三"
            }else if((week+k)%7==4){
                liWeeks[k].innerHTML="星期四"
            }else if((week+k)%7==5){
                liWeeks[k].innerHTML="星期五"
            }else if((week+k)%7==6){
                liWeeks[k].innerHTML="星期六"
            }
        }
    }
// 轮播图
function animate(obj,target){
    clearInterval(obj.timer);
    obj.timer=setInterval(function(){
        var leader=obj.offsetLeft;
        var step=30;
        step=leader<target?step:-step;
        if(Math.abs(target-leader)>=Math.abs(step)){
            leader=leader+step;
            obj.css("left",leader)
        }else{
            obj.css("left",target)
            clearInterval(obj.timer);
        }

    },15);
}

})
