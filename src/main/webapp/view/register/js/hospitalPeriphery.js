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
    var latitude=$("#latitude").val();
    var longitude=$("#longitude").val();
    var local = new BMap.LocalSearch(new BMap.Point(longitude, latitude), {
        renderOptions: {map: map, panel: "r-result"}
    });
    local.searchNearby("药店",pointer,1000);
 /*  var lis=document.getElementsByTagName("li");
   for(var i=0;i<lis.length;i++){
       lis[i].onclick=function(){
           if(this.index==0){
               local.searchNearby("药店",pointer,1000);
           }else if(this.index==1){
               local.searchNearby("酒店",pointer,1000);
           }else if(this.index==2){
               local.searchNearby("银行",pointer,1000);
           }else if(this.index==3){
               local.searchNearby("加油站",pointer,1000);
           }
           for(var j=0;j<lis.length;j++){
               lis[j].className ="col-xs-3";
           }
           this.className =" col-xs-3 active"
       }
   }
*/

    //手势事件
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
            footer.fadeOut(500);
        }else{
            footer.fadeIn(500);
        }
    })
})
