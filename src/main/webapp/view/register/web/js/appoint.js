$(function(){
    // 导航栏点击加active
    var navLis=$(".hsRegistion_navBar li");
    $.each(navLis,function(index,item){
        item.onclick=function(){
            if(index==navLis.length-1){
                $(".chooseOthers").removeClass('active');
            }else{
                $(this).siblings('li').removeClass("active");
                $(this).addClass('active');
            }
            
        }
    })
    // 接百度地图
    var map=new BMap.Map("allmap");//创建Map实例
    map.centerAndZoom(new BMap.Point(116.404,39.915),11);//初始化地图，设置中心点坐标和地图级别
    map.setCurrentCity("北京");//设置地图显示的城市
    map.enableScrollWheelZoom(true);//开启滚轮缩放

})