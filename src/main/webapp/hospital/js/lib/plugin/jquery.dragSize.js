(function(mod){
    if(typeof define==="function"&&define.amd)
    {
        define(['jquery'],mod);

    }
    else{
        mod(jQuery);
    }
}(


function($){
    $.fn.extend({
        "dragSize":function(settings){
            var defaults={
                minHeight: 10,
                minWidth: 10,
                limit: false,     // 限制在父元素内
                before: function(){},
                doing: function(){},
                callback: function(){}
            };
            settings = $.extend(defaults, settings);
            var $border=$('<div class="Dleft"><div class="jcrop-hline fr"></div></div><div class="Dright"><div class="jcrop-hline fl"></div></div><div class="Dtop"><div class="jcrop-vline" style="margin-top: 4px;"></div></div><div class="Dbtm"><div class="jcrop-vline"></div></div><div class="Dlt"></div><div class="Drt"></div><div class="Dlb"></div><div class="Drb"></div>');
            var $This, $parent, cha_h, cha_w;
            function Dleft(e){
                var w = $parent.width(),
                    l = $parent.position().left;
                var live = e.pageX - $This.offset().left;
				if(settings.limit && e.pageX - $parent.parent().offset().left < -live){
					$parent.css({width: w + l, left: 0});
				}else if(e.pageX < $parent.offset().left + $parent.width() - settings.minWidth - cha_w && e.pageX > 0)
                {
                    l = l + live;
                    w = w - live;
                    $parent.css({width: w, left: l})
                }
            }
            function Dright(e){
                var w = $parent.width(),
                    parentWidth = $parent.parent().width();
                var live = e.pageX - $This.offset().left - cha_w;
                if(settings.limit && e.pageX - $parent.parent().offset().left > parentWidth){
                    $parent.css({width: parentWidth - $parent.position().left});
                }else if(e.pageX - $parent.offset().left - cha_w > settings.minWidth && e.pageX < $(window).width())
                {
                    w = w + live;
                    $parent.css({width: w});
                }
            }
            function Dtop(e){
                var h = $parent.height(),
                    t = $parent.position().top;
                var live = e.pageY - $This.offset().top - cha_h;
                if(settings.limit && e.pageY - $parent.parent().offset().top < -live){
                    $parent.css({height: h + t, top: 0});
                }else if(e.pageY < $parent.offset().top + $parent.height() - settings.minHeight - cha_h && e.pageY > 0) {
                    h = h - live;
                    t = t + live;
                    $parent.css({height: h, top: t})
                }
            }
            function Dbtm(e){
                var h = $parent.height();
                var live = e.pageY - $This.offset().top - cha_h;
                var parentHeight = $parent.parent().height();
                if(settings.limit && e.pageY - $parent.parent().offset().top > parentHeight){
                    $parent.css({height: parentHeight - $parent.position().top});
                }else if(e.pageY - $parent.offset().top - cha_h > settings.minHeight && e.pageY < $(window).height())
                {
                    h = h+live;
                    $parent.css({"height": h})
                }
            }
            
            $border.appendTo(this).on("mousedown", function(e){
                if(e.which == 1){
                    e.stopPropagation();
                    var work, work2;
                    $This = $(this);
                    $parent = $This.parent();
                    switch ($This[0].className)
                    {
                        case "Dleft":
                          work = Dleft;
                          break;
                        case "Dright":
                          work = Dright;
                          break;
                        case "Dtop":
                         work = Dtop;
                          break;
                        case "Dbtm":
                          work = Dbtm;
                          break;
                        case "Dlt":
                          work = Dleft; work2 = Dtop;
                          break;
                        case "Drt":
                          work = Dright; work2 = Dtop;
                          break;
                        case "Dlb":
                          work = Dleft; work2 = Dbtm;
                          break;
                        case "Drb":
                          work = Dright; work2 = Dbtm;
                          break;
                    }
                    (settings.before && typeof(settings.before) === 'function') && settings.before($This, $parent);
                    cha_h = Math.ceil($This.height()/2);
                    cha_w = Math.ceil($This.width()/2);
                    $(window).on("mousemove", function(e){
                        work && work(e);
                        work2 && work2(e);
                        e.preventDefault();
                        (settings.doing && typeof(settings.doing) === 'function') && settings.doing($This, $parent);
                    });
                    
                    $(window).on("mouseup", function(){
                        $(window).unbind("mousemove").unbind("mouseup");
                        (settings.callback && typeof(settings.callback) === 'function') && settings.callback($This, $parent);
                    });
                        
                }
            });
            
         }
    });
}



));

