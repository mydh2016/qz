$(function(){
      var parent=$("body");
        // 获取子盒子
      var child=$(".hs_health_main ul");
        // 获取topBar的高度
      var topBarHeight=$(".topBar").height();
        // 获取父盒子的高度
      var parentHeight=parent.height();
        // 获取子盒子的高度
      var  childHeight = child.height();
        // 子盒子和父盒子的高度差       
      var  distance=childHeight-parentHeight-topBarHeight;
        console.log(distance)
   
      /*var moban='<%for(var l=0;l<result.length; l++) {%>'+
    	  '<li><a href="healthInquiryDel.html">'+
                        '<h4>'+'<%= result[l].publish_content_name %>'+'</h4>'+
                        '<p class="hs_health_main_time">'+'<%= result[l].publish_date %>'+'</p>'+
                        '<i class="icon iconfont icon-icon"></i>'+
                    '</a></li>'+
                    '<%}%>'
      var jiazai=template.compile(moban);*/
     // 判断触底
    function sole(){
      // 重新获取父盒子高度
       parentHeight=parent.height();
       // 重新获取子盒子高度
       childHeight = child.height();
       // 重新获取高度差
       distance=childHeight-parentHeight;
       // 进行判断
      if(childHeight>parentHeight-topBarHeight){   
          if(Math.ceil(-child.offset().top)==distance){
            // 进行加载
            return true;
          }else{
            return false;
          }      
      }
    }
    // 当进行滑动时
      $("body").on("touchmove",function(){
        if(sole()){
        	var li=child.children("li").length;
        	 var publish_module_sn="gs_sqfw";
             	$.ajax({
     				type:"POST",
     				url:"/qazitem/rest/app/medpedia/getMedpediaPage",
     				data:{"publish_module_sn":publish_module_sn,"startNum":li},
     				dataType:"json",
     				async:false,
     				success:function(json){
     					var result=json.data;
     					var html="";
     					var hl="";
     					if(result.length==0){
     						$("#ll").remove();
     						hl="<li id='ll' class='last'>没有更多的数据了....</li>";
     	    			    child.append(hl);
     					}else{
    					for(var i=0;i<result.length;i++){
     					html +="<li><a href='/qazitem/rest/app/medpedia/getMedpediaInfo?id="+result[i].publish_content_id+"&publish_module_sn=gs_yybk'><h4>"+result[i].publish_content_name +"</h4><p class='hs_health_main_time'>"+result[i].publishDate+"</p><i class='icon iconfont icon-icon'></i></a></li>";
    					}
    					child.append(html);
    					}
     				},
     				error:function(request){
     					console.log(request)
     				}
     				
     			})
                
        }
    }) 
   
})