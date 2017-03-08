/**
 * 水波效果
 */

(function(mod){
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as anonymous module.
        define(['jquery'], mod);
    } else {
        // Browser globals.
        mod(jQuery);
    }
}(
    function($) {

        var ua = navigator.userAgent;
            // Better testing of touch support
            // See https://github.com/ngryman/jquery.finger/blob/v0.1.2/dist/jquery.finger.js#L7
            isChrome = /chrome/i.exec(ua),
            isAndroid = /android/i.exec(ua),
            hasTouch = 'ontouchstart' in window && !(isChrome && !isAndroid);

        /**
         * jQuery.fn.ripple
         * @param {Object} options
         * @param {String} [options.color=#fff] The ripple effect color
         */
        $.fn.ripple = function(options) {
            var $this = this,
                defaults = {
                    duration: null,
                    animateClass: null
                },
                opts = $.extend({}, defaults, options);

            opts.event = (hasTouch && 'touchstart.ripple') || 'click.ripple';

            $this
                // Bind the event to run the effect
                .on(opts.event, function(ev) {

                    var x, y, size, touch_ev,
                        $paper = $(this),
                        $effect = $paper.find('.ripple-effect'),
                        $ink = $('<div class="ripple-effect"></div>')
                            .on('transitionend webkitTransitionEnd oTransitionEnd MSTransitionEnd', function(){
                                $ink.remove();
                            })
                            .appendTo($paper);

                    // get click coordinates
                    // logic = click coordinates relative to page
                    // - position relative to page - half of self height/width to make it controllable from the center
                    touch_ev = hasTouch ? ev.originalEvent.touches[0] : ev;
                    x = touch_ev.pageX - $paper.offset().left;
                    y = touch_ev.pageY - $paper.offset().top;
                    size = Math.max(
                        $paper.outerWidth()-x,
                        $paper.outerHeight()-y,
                        x,
                        y
                    ) * 2;

                    x -= size/2;
                    y -= size/2;

                    // Set up ripple position and place it in the DOM
                    if(opts.animateClass) {
                        $ink.addClass(opts.animateClass);
                    }
                    if(opts.duration) {
                        $ink.css({
                            // Duration
                            '-webkit-transition-duration': opts.duration + 'ms',
                            '-moz-transition-duration': opts.duration + 'ms',
                            '-o-transition-duration': opts.duration + 'ms',
                            'transition-duration': opts.duration + 'ms'
                        });
                    }

                    $ink
                        .addClass('ripple-animate ripple-final')
                        .css({
                            height: size,
                            width: size,
                            top: y + 'px',
                            left: x + 'px'
                        });

                });

            // Chaining
            return $this;
        };

    }
));
