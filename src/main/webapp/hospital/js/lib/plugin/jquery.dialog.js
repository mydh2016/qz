/*
* dialog jquery插件
* dialog的内容为选择器选中的元素
* @param {Object} options dialog的配置对象参数
*
* */
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
        $.fn.extend({
            "dialog":function(options){
                var $con = $('#container'),
                    $dialog,
                    btnStr = '',
                    btnHandlers = {},
                    $this = this;
                var defaults={
                    title: 'dialog',
                    width: 'auto',
                    height: 'auto',
                    top: '',
                    left: '',
                    isModal: '',
                    closeCallback: function(){},
                    draggable: false,
                    buttons: {
                        ok: {
                            label: 'ok',
                            className: 'btn-primary',
                            handler: function () {

                            }
                        },
                        cancel: {
                            label: 'cancel',
                            className: 'btn-default',
                            handler: function () {

                            }
                        }
                    }
                };

                function close() {
                    $con.length ? $con.removeClass('blur') : $('body').removeClass('blur');
                    options.closeCallback();
                    $dialog.toggleClass('in out');
                    setTimeout(function(){ $dialog.remove(); },1000);
                }
                // options对象的属性
                // width，height为dialog的宽高参数;
                // title为标题
                // buttons为dialog的按钮对象，拥有3个属性，label为按钮的显示文字，className为按钮的样式名称，handler为按钮点击后出发的事件
                // draggable 是否拖动默认否 如果想使用拖动务必在引入jquery.dialog.js之前引入 jquery.drag.js
                // top,left 为dialog的初始位置坐标只有在draggable为真的时候才有作用
                options = $.extend(defaults, options);

                $dialog = $('<div class="modal">'
                            +'<div class="middle">'
                                +'<div class="modal-dialog" style="width: ' + options.width + (options.width == 'auto' ? '' : 'px') + ';">'
                                    +'<div class="modal-dialog-header">'
                                        +'<button type="button" class="close">×</button>'
                                        +'<h4>'+options.title+'</h4>'
                                    +'</div>'
                                    + '<div class="modal-dialog-body" style="height:' + options.height + (options.height == 'auto' ? '' : 'px;overflow:auto;') + ';"></div>'
                                    +'<div class="modal-dialog-footer">'
                                    +'</div>'
                                +'</div>'
                        +'</div>'
                    +'</div>');

                $this.length || ($this = $('<span>' + $this.selector + '</span>'));
                $dialog.find('.modal-dialog-body').append($this);
                $.each(options.buttons, function(key, btn){
                    btnStr += '<button type="button" class="btn '+btn.className+'" handler="'+key+'">'+btn.label+'</button>';
                    btnHandlers[key] = btn.handler;
                });

                $dialog.find('.modal-dialog-footer').append(btnStr);

                $con.length ? $dialog.insertAfter($con.addClass('blur')) : $dialog.appendTo($('body').addClass('blur'));

                $dialog.on('click', '.modal-dialog-footer button', function(){
                    btnHandlers[$(this).attr("handler")](close, $dialog);
                });
                $dialog.on('click', '.close', close);

                $dialog.addClass('in');
                if(options.draggable){
                    var $window = $(window),
                        $dia = $dialog.find('.modal-dialog');

                    $dia.drag({
                        target: '.modal-dialog-header'
                    })
                    .css({
                        position: 'absolute',
                        top: options.top || ($window.height() - $dia.height()) / 2,
                        left: options.left || ($window.width() - $dia.width()) / 2
                    });

                }

                return $dialog;

            }
        });

    }
));