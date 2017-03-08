/**
 * jQuery tab
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
    $.fn.extend({
        "tab":function(callback){
            var $tabcon = this.find('.tabcon');
            $tabcon.eq(0).show().siblings('.tabcon').hide();
            this.find('.tabbtn').children().on('click', function(){
                var $this = $(this),
                    ind = $this.index();
                $this.addClass('act').siblings().removeClass('act');
                $tabcon.hide().eq(ind).show();
                callback && callback.call(this, $tabcon.eq(ind));
            });

            return this;
        }
    });

}));
