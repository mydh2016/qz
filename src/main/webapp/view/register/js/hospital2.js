$(function(){
    var flag=true;
    $(".hs_hospital_info_open").on("click",function(){
        if(flag){
            $(".hs_hospital_info_text").css("overflow","visible");
            $(".hs_hospital_info_text").css("height","auto") ;
            $(".hs_hospital_info_open").html("收起");
            flag=false;
        }else{
            $(".hs_hospital_info_text").css("overflow","hidden");
            $(".hs_hospital_info_text").css("height","2.1rem") ;
            $(".hs_hospital_info_open").html("展开");
            flag=true;
        }


    })
})