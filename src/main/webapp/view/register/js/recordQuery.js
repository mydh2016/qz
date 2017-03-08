$(function(){
    // 点击导航栏按钮，显示当前页
    var navlis=$(".hs_record_nav li");
    var pagelis=$(".hs_record_inquiry li");
    $.each(navlis,function(index,item){
        $(item).on("click",function(){
            $(this).addClass("active");
            $(this).siblings().removeClass('active');
            var index=$(this).index();
            // 显示当前页
            $(pagelis[index]).css("display","block");
            $( pagelis[index]).siblings().css("display","none")
        })
    })
    // 点击删除，弹出弹出框
    $(".hs_resRecord_info_btn button").each(function(index,item){
        var _this=$(this);
        _this.on("click",function(){
            // 确认删除，删除此条数据
            $(".confirm").on("click",function(){
                _this.parent().parent().remove();
                $('#myModal').modal('hide')
            })
        })  
    })
    $("body").on("click",function(){
         $('#myModal').modal('hide');
    })
    /*console.log($(".imgCl"))*/
    $(".imgCl").each(function(index,item){
    	var _this=$(this)
    	item.onclick=function(){
    		 var id=_this.attr("id");
    		 $.ajax({
              	type:"GET",
              	url:"/qazitem/rest/app/pdGhOrder/queryById",
          		data:{"id":id},
          		dataType:"json",
          		async:false,
          		success : function(data){
          			var list=data.data;
          			//alert("sss")
         			var hm="http://qr.topscan.com/api.php?text=就诊人:"+list.realName +"%0A医生:"+list.doctorName +"%0A科室:"+list.hospitalName +"-"+list.departName +"%0A时间:"+list.time+""+list.timeSolt +"";
             		$("#imgT").attr("src",hm);
          		},
          		error: function (request){
          			console.log(request);
          		}
              });
    	}
   
    })
    
})