/**
 * jQuery 按钮提交状态插件
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
        btnState: function() {
            var $this = $(this);
            var btnText = $this.text();

            return {
                on: function(text){
                    $this.text(text).attr('disabled', true);
                },
                off: function(){
                    $this.text(btnText).attr('disabled', false);
                }
            };

        }
    });

}));
