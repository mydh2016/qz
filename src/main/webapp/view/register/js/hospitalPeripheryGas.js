$(function(){
    var map = new BMap.Map("l-map");            // 创建Map实例
var pointer=new BMap.Point(116.288692, 40.050293);
    map.centerAndZoom(pointer, 11);
// 百度地图API功能  缩放按钮
var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_ZOOM}); //右上角，仅包含平移和缩放按钮

//添加控件和比例尺
  function add_control(){
    map.addControl(top_right_navigation);
}
add_control();
var local = new BMap.LocalSearch(new BMap.Point(116.40387397, 39.91488908), {
renderOptions: {map: map, panel: "r-result"}
});
local.searchNearby("加油站",pointer,1000);
    var body=$("body")[0];
    var startY=0;
    var moveY=0;
    var endY=0;
    var footer=$(".hs_periphery_nav");
    body.addEventListener("touchstart",function(e){
        startY=e.touches[0].clientY;
    })
    body.addEventListener("touchmove",function(e){
        moveY=e.touches[0].clientY;
        if(startY-moveY>0){
            footer.fadeOut(500);
        }else{
            footer.fadeIn(500);
        }
    })
    body.addEventListener("touchend",function(e){
        endY=e.changedTouches[0].clientY;
        if(endY<startY){
            footer.fadeIn(500);
        }else{
            footer.fadeOut(500);
        }
    })

})

