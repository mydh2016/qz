$(function(){
    var startX = 0, moveX = 0 , distanceX = 0 , isMove = false;
    $('.hs_layout_carousel').on('touchstart',function(e){
        startX = e.originalEvent.touches[0].clientX;
    }).on('touchmove',function(e){
        moveX = e.originalEvent.touches[0].clientX;
        distanceX = moveX - startX;
        isMove = true;
    }).on('touchend',function(e){
        console.log(distanceX);
        if(isMove && Math.abs(distanceX) > 50){
            if(distanceX > 0){
                $('.carousel').carousel('prev');
            }else{
                $('.carousel').carousel('next');
            }
        }
    });
})
