$(function(){
    //创建Map实例
    var map=new BMap.Map("l-map");
    //var map1=new BMap.Map("allMap");
    var latitude=$("#latitude").val();
    var longitude=$("#longitude").val();
    map.centerAndZoom(new BMap.Point(longitude,latitude),11);/*初始化，地图中心和地图级别*/
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
})


