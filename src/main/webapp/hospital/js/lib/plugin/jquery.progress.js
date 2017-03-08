/**
 * jQuery进度条插件
 *
 */

(function(mod){
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as anonymous module.
        define(['jquery'], mod);
    } else {
        // Browser globals.
        mod(jQuery);
    }
}(function($){
    var $loader = $('<div class="loading-bar"></div>'),
        $spinner = $('<div class="loading-bar-spinner"><div class="spinner-icon"></div></div>'),
        timeout = false;

    function complete($loader, $spinner){
        timeout = true;
        $loader.width('100%');
        setTimeout(function(){
            $loader.fadeOut(function(){
                $loader.width(0);
            });
        }, 600);
        setTimeout(function(){
            $spinner.removeClass('spinner-animation');
        }, 500);
    }
    function start($loader, $spinner){
        var progress = 0,
            reduceNum = 12;

        timeout = false;
        $spinner.addClass('spinner-animation');
        $loader.show().width(0);

        setTimeout(function(){
            progress += (Math.random() * 2 + (reduceNum *= 0.8));
            if(timeout || progress > 98){
                return;
            }
            $loader.width(progress + "%");
            setTimeout(arguments.callee, 400);
        },400);
    }
    $.fn.progress = function(){
        var $this = this,
            $load = $this.find('.loading-bar'),
            $_spinner = $this.find('.loading-bar');

        $load = $load.length == 0 ? $loader.clone().appendTo($this) : $load;
        $_spinner = $_spinner.length == 0 ? $spinner.clone().appendTo($this) : $_spinner;
        return {
            start: function(){
                start($load, $_spinner);
            },
            complete: function(){
                complete($load, $_spinner);
            }
        };
    };

}));
