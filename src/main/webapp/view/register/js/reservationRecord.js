$(function(){

    $(".hs_resRecord_info_btn button").each(function(index,item){
        var _this=$(this);
        _this.on("click",function(){
            $(".confirm").on("click",function(){
                _this.parent().parent().remove();
                $('#myModal').modal('hide')
            })
        })

})	
	$(".imgOn").on("click", function (){
		alert(ss)
	})
	function img(th){
    	alert(th.id);
    }
})
