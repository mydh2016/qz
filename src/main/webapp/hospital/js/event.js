define(["jquery", "touch"], function($) {
    var mEvent={};
    mEvent.isTouch = ("createTouch" in document);

    if(mEvent.isTouch){
        mEvent.pointclick = "tap";
        mEvent.pointdown = "touchstart";
        mEvent.pointup = "touchend";
        mEvent.dbclick = "tap2";
    }else{
        mEvent.pointclick = "click";
        mEvent.pointdown = "mousedown";
        mEvent.pointup = "mouseup";
        mEvent.dbclick = "dblclick";
    }

    return mEvent;
});

