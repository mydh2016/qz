define(['jquery', 'event', 'avalon', 'cell', 'dragsize'],function($, mEvent, avalon, cell) {
    var pfx = ['webkit', 'moz', 'MS', 'o', ''];
    var $con = $('#content'),
        animationDuration = $con.css("animationDuration");

    if(animationDuration) {
        animationDuration = parseInt(animationDuration) * 1000;
    } else {
        animationDuration = 1000;
    }

    function tempCutover($target, callback, animate){
        var $div = $target.children('div');
        if($div.length <= 1){
            callback && callback();
            return false;
        }

        var $last = $div.eq($div.length-1),
            $other = $last.siblings();

        //animate = 0;
        ie8Handler(null, function(){
            animate = null;
        });

        if(!animate) {
            $other.remove();
            callback();
            return false;
        }

        if(animate.enter){
            setTimeout(function(){
                $other.remove();
                $last.removeClass(animate.enter);
                callback && callback();
            }, animationDuration);


            if(animate.exit) {
                $other.addClass(animate.exit);
            }


            $last.addClass(animate.enter);

        }else{
            $other.remove();
            callback && callback();
        }

    }

    function getTemp(cellName, options){

        var defaults = {
            html: '',
            js: '',
            css: '',
            target: $con,
            animate: {
                enter: 'animated fadeIn',
                exit: 'animated fadeOut'
            },
            callback: function(){},
            before: function(){}
        },
        settings;

        if( typeof cellName === 'object' ) {
            settings = $.extend(defaults, cellName);
        } else {
            cellName = cell[cellName];
            settings = $.extend(defaults, options, cellName);
        }

        $.get(settings.html + window.version, function(data){
            function cutover (getJsCallback) {
                settings.target.append('<div>' + data + '</div>');
                avalon.scan(settings.target[0]);
                tempCutover(
                    settings.target,
                    function () {
                        settings.callback();
                        getJsCallback && getJsCallback()
                    },
                    settings.animate
                );
            }

            settings.before();

            var jsHandle = function(){
                if(settings.js) {
                    require([settings.js + window.version], function(hanler){
                        cutover(hanler);
                    });
                }else {
                    cutover();
                }
            };
            if(settings.css) {
                require(['css!' + settings.css], jsHandle);
            }else {
                jsHandle();
            }



        });
    }

    function ie8Handler(notIe8callback, isIe8callback) {
        if(window.addEventListener){
            notIe8callback && notIe8callback();
        } else {
            isIe8callback && isIe8callback();
        }
    }

    function removeHTMLTag(str) {
        str = str.replace(/<\/?[^>]*>/g,''); //去除HTML tag
        str = str.replace(/[ | ]*\n/g,'\n'); //去除行尾空白
        str = str.replace(/&nbsp;/ig, ' '); //去掉&nbsp;
        return str;
    }

    /*
    * 图片上传预览函数
    * @parm {obj} oFile 上传表单的dom
    * @parm {obj} oImgPreview 图片预览的图片dom
    * */
    function imgUploadPreview(oFile, oImgPreview) {
        var width = $(oImgPreview).parent().width(),
            height = $(oImgPreview).parent().height();

        if(oFile.files && oFile.files[0])
        {
            //火狐下，直接设img属性
            oImgPreview.style.display = 'block';
            oImgPreview.style.width = width;
            oImgPreview.style.height = height;
            //oImgPreview.src = oFile.files[0].getAsDataURL();

            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            oImgPreview.src = window.URL.createObjectURL(oFile.files[0]);
        }
        else
        {
            //IE下，使用滤镜
            oFile.select();
            var imgSrc = document.selection.createRange().text;
            var imgParent = oImgPreview.parentNode;
            
            //必须设置初始大小
            imgParent.style.width = width;
            imgParent.style.height = height;
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try{
                imgParent.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                imgParent.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            }
            catch(e)
            {
                //alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            oImgPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }


    return {
        tempCutover: tempCutover,               // 内容模板切换
        getTemp: getTemp,                        // 获取一个模板
        removeHTML: removeHTMLTag,              // 移除一个字符串中的html
        ie8Handler: ie8Handler,                 // 判断ie8执行方法
        imgUploadPreview: imgUploadPreview     // 图片上传预览
    };

});

