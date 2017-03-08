$(function () {
    var del = $(".del");
    var tip=$(".hs_familyMeb_tip");
    $.each(del,function(index,item){
        var _this=$(this);
        $(this).on("click",function(){
            $("body").css("background:rgba(0,233,0,0.3)","z-index:10000","position:relative")
            $(".confirm").on("click",function(){
             var id=_this.parent().find("input").attr("id");
                $('#myModal').modal('hide')
                _this.parent().parent().remove();
              
		$.ajax({
    				type: "GET",
    	             url:"/qazitem/rest/app/appLinkman/delete",
    	             data: {"linkmanid":id},
    	             dataType: "json",
    	             success: function(data){
    	            	location.href="/qazitem/rest/app/appLinkman/select";
    	             }
    	             
    			});
            })
            $(".quit").on("click",function(){
		tip.fadeOut(500);
            })
        })
    })


})
