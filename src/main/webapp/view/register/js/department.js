$(function(){
     //左侧盒子滑动
    var parentBoxLeft=$(".hs_deparment_item_med");
    var childBoxLeft=$(".hs_deparment_item_med ul");
    var itemMedsLeft = $(".hs_deparment_item_med ul li")
    var flagLeft=true;
    swipe(parentBoxLeft,childBoxLeft,flagLeft,itemMedsLeft);
    //右侧盒子滑动
    var parentBoxRight=$(".hs_deparment_item_det");
    var childBoxRight=$(".hs_deparment_item_det ul");
    var flagRight=false;
    swipe(parentBoxRight,childBoxRight,flagRight);
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
   						html+="<li><a id='"+list[i].departmentId+"' href='departmentX?departmentId="+list[i].departmentId+" &hcode="+list[i].hospitalSn+"'>"+list[i].departmentName+"</a></li>"
   					}
   					$("#ul").html(html);
   				 var MedsLeft = $(".hs_deparment_item_med ul li");
   				},
   				error:function(){
   					
   				}
   				
   			})
				
  	        }
  	        })
  	        
  	 
  	 }
})
