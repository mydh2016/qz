/*
* 拖拽插件
* */

 (function(mod){
	if (typeof define === 'function' && define.amd) {
		// AMD. Register as anonymous module.
		define(['jquery', 'touch'], mod);
	} else {
		// Browser globals.
		mod(jQuery);
	}
}(
     
    function($){

        var isTouch = ('createTouch' in document); // 判断是否支持触摸
        var defaults = {
            copy: false,
            before: function(){},
            doing: function(){},
            callback: function(){},
            // 限制到父元素、限制坐标、将元素限制在浏览器之内，只能3选一
            limit: false,  // 是否把当前元素锁定到父节点中
            limitPosition: [], // 限制位置top\left,数组元素依次为左右上下的限制值
            limitBrowser: false,  // 将元素限制在浏览器之内
            axis: '',     // 可以将元素限制在x轴或y轴上（只能单方向拖动），默认不限制
            target: '',   // 目标元素的选择器，只有触发目标元素 才能产生拖动
            delay: 0,    // 拖动延迟时间,单位是毫秒
            distance: 0  // 拖动延迟距离,单位是像素
        };
    
        $.fn.extend({
            'drag': function (set) {
                var limitPosition;
                var limitPositionHandler = [
                    function(e){
                        if(!(limitPosition[0] || limitPosition[0] === 0)){
                            return;
                        }
                        if(e.pageX <= $Parent.offset().left + limitPosition[0] + element_left){
                            targetX = limitPosition[0];
                        }
                    },
                    function(e){
                        if(!(limitPosition[1] || limitPosition[1] === 0)){
                            return;
                        }
                        if(e.pageX >= $Parent.offset().left + limitPosition[1] + element_left){
                            targetX = limitPosition[1];
                        }
                    },
                    function(e){
                        if(!(limitPosition[2] || limitPosition[2] === 0)){
                            return;
                        }
                        if(e.pageY <= $Parent.offset().top + limitPosition[2] + element_top){
                            targetY = limitPosition[2];
                        }
                    },
                    function(e){
                        if(!(limitPosition[3] || limitPosition[3] === 0)){
                            return;
                        }
                        if(e.pageY >= $Parent.offset().top + limitPosition[3] + element_top){
                            targetY = limitPosition[3];
                        }
                    }
                ];

                function cancelDelay(){
                    clearTimeout(timmer);
                }

                function dragStart(drager, e){
                    e = e || window.event;
                    if(isTouch || e.which == 1)
                    {
                        $This = $this = $(drager);
                        timmer = setTimeout(function (){
                            parentOffsetTop = $Parent.offset().top;
                            parentOffsetLeft = $Parent.offset().left;
                            if(settings.copy) {
                                $first = $this;
                                $This = $This.clone();

                                $This.appendTo($Parent).css({
                                    top: $first.offset().top - parentOffsetTop,
                                    left:$first.offset().left - parentOffsetLeft
                                });
                            }

                            settings.before($This, $first, e);

                            pageX = isTouch ? event.touches[0].pageX : e.pageX;
                            pageY = isTouch ? event.touches[0].pageY : e.pageY;

                            element_top = pageY - $this.offset().top;
                            element_left = pageX - $this.offset().left;

                            //  把元素的move上升到window
                            window.addEventListener(moveEvent, dragMove);

                            window.addEventListener(endEvent, dragEnd);

                        }, settings.delay);

                        window.addEventListener(endEvent, cancelDelay);

                    }

                }

                function dragMove(e){
                    e = e || window.event;
                    distance ++;
                    if(distance <= settings.distance) {
                        return;
                    }
                    pageX = isTouch ? event.touches[0].pageX : e.pageX;
                    pageY = isTouch ? event.touches[0].pageY : e.pageY;

                    targetY = pageY-element_top - parentOffsetTop;
                    targetX = pageX-element_left - parentOffsetLeft;

                    if(settings.limitBrowser) {
                        pageY < 0 ? targetY = -element_top - parentOffsetTop:
                            pageY > $(window).height() ? targetY = $(window).height() - element_top - parentOffsetTop:
                                pageX < 0 ? targetX = -element_left - parentOffsetLeft:
                                    pageX > $(window).width() ? targetX = $(window).width() - element_left - parentOffsetLeft : '';
                    }
                    else if(settings.limit){
                        if(pageY-element_top <= parentOffsetTop || $This.height() >= $Parent.height())
                        {
                            targetY = 0;
                        }
                        else if(pageY + $This.innerHeight() - element_top - parentOffsetTop >= $Parent.outerHeight())
                        {
                            targetY = $Parent.innerHeight() - $This.innerHeight();
                        }
                        if(pageX - element_left <= parentOffsetLeft)
                        {
                            targetX = 0;
                        }
                        else if(pageX + $This.innerWidth() - element_left - parentOffsetLeft >= $Parent.outerWidth())
                        {
                            targetX = $Parent.innerWidth() - $This.innerWidth();
                        }
                    }
                    else if(limitPosition.length){
                        for(var k = 0; k < limitPosition.length; k++)
                        {
                            limitPositionHandler[k](e);
                        }
                    }
                    if(settings.axis == 'x'){
                        $This.css({left: targetX + 'px'});
                    }else if(settings.axis == 'y'){
                        $This.css({top: targetY + 'px'});
                    }else{
                        $This.css({
                            top: targetY + 'px',
                            left: targetX+'px'
                        });
                    }

                    e.preventDefault();
                    settings.doing($This, $first, e);

                }

                function dragEnd(e){
                    e = e || window.event;
                    // 拖拽结束时移除move和end事件
                    settings.callback($This, $first, e);
                    window.removeEventListener(moveEvent, dragMove, false);
                    window.removeEventListener(endEvent, dragEnd, false);
                    window.removeEventListener(endEvent, cancelDelay, false);

                    distance = 0;
                }

                var startEvent, moveEvent, endEvent,
                    timmer,
                    distance = 0,
                    $target,
                    $this, $This,
                    $Parent,
                    targetY = 0, targetX = 0, element_top, element_left, $first,
                    settings,
                    pageX,pageY,
                    parentOffsetTop, parentOffsetLeft,
                    $dragers = this;

                settings = $.extend({}, defaults, set);
                limitPosition = settings.limitPosition;
    
                $target = settings.target ? $dragers.find(settings.target) : $dragers;
                $Parent = $dragers.parent();
    
                if(isTouch){
                    startEvent = 'touchstart';
                    moveEvent = 'touchmove';
                    endEvent = 'touchend';
                }
                else{
                    startEvent='mousedown';
                    moveEvent = 'mousemove';
                    endEvent ='mouseup';
                }
                this.find('img').on('mousedown touchstart', function (e) { e.preventDefault(); });
    
                var p_ = this.parent()[0];
                if(!p_.onselectstart){
                    p_.onselectstart = function(){return false;}
                }
    
                $target.each(function(i){
                    var targetThis = this;
                    targetThis.addEventListener(startEvent, function (){ dragStart($dragers.eq(i)); });
                });
                
                return this;
               
               }
        });
    }
     
));

