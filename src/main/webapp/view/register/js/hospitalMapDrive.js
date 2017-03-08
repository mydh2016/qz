$(function(){
    //创建Map实例
    var map=new BMap.Map("l-map");
    map.centerAndZoom(new BMap.Point(116.404,39.915),11);/*初始化，地图中心和地图级别*/
    map.setCurrentCity("北京");
    // 百度地图API功能  缩放按钮
    var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_ZOOM}); //右上角，仅包含平移和缩放按钮

    //添加控件和比例尺
    function add_control(){
        map.addControl(top_right_navigation);
    }
    add_control();
    //使用jps定位
    //获取我的位置
    var geolocation=new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r){
        if(this.getStatus()==BMAP_STATUS_SUCCESS){
            var mk=new BMap.Marker(r.point);
            map.addOverlay(mk);
            map.panTo(r.point);
            var myP1=new BMap.Point(r.point.lng, r.point.lat);
            var myP2=new BMap.Point(116.404,39.915);
            var driving = new BMap.DrivingRoute(map, {renderOptions: {map: map, panel: "r-result", autoViewport: true}});
            driving.search(myP1,myP2);
        }else{
            alert("failed"+this.getStatus());
        }

    },{enableHighAccuracy:true});

})
