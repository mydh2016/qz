define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState', 'bootstrapValidatorZn'], function($, avalon, common, DataList, mEvent, simditor){
    var tempTypeAddVm = avalon.define({
        $id: 'tempTypeAdd',
        bigTypeSelect: '',
        littleTypeSelect: '',
        bigType: {},
        littleType: {}
    });

    return function (){
        var $tempAddForm = $('#tempAddForm');
        $tempAddForm.on('submit', function(e){
            e.preventDefault();
            $.post(appName + '/rest/model/insert', $tempAddForm.serialize(), function (data){
                if(data.resultCode==0){
                    window.location.href="#/tempmanage";
//        		$.notify(
//                        {message: "保存成功"},
//                        {
//                            type: 'success',
//                            delay: 6000,
//                            animate: {
//                                enter: 'animated bounceIn',
//                                exit: 'animated bounceOut'
//                            }
//                        }
//                    );
                }else{
                    $.notify(
                        {message: data.data},
                        {
                            type: 'success',
                            delay: 6000,
                            animate: {
                                enter: 'animated bounceIn',
                                exit: 'animated bounceOut'
                            }
                        }
                    );
                }

            });
//            $tempAddForm.data('bootstrapValidator').validate();
//            if($tempAddForm.data('bootstrapValidator').isValid()) {
//                
//            }


        });


//        // 表单验证参数
//        $tempAddForm.bootstrapValidator({
//            feedbackIcons: {
//                valid: 'fa fa-check',
//                invalid: 'fa fa-remove',
//                validating: 'fa fa-refresh'
//            },
//            fields : {
//                modelName: {
//                    validators : {
//                        notEmpty : {}
//                    }
//                },
//                parentType: {
//                    validators : {
//                        notEmpty : {}
//                    }
//                },
//                childrenType: {
//                    validators : {
//                        notEmpty : {}
//                    }
//                }
//            }
//        });

        $.post(appName + '/rest/model/selectParentType', function (data){
            tempTypeAddVm.bigType = data.data;
        });
        tempTypeAddVm.$watch("bigTypeSelect" ,function(a, b) {
            $.post(appName + '/rest/model/selectChildrenType', {modelParentType: a}, function (data){
                tempTypeAddVm.littleType = data.data;
            });
        });
        $("#tp").on("click",function(){
        	var value=$("#modelContent").val();
        	var newContent=value+"#telphone#";
        	$("#modelContent").val(newContent);
        })
        $("#na").on("click",function(){
        	var value=$("#modelContent").val();
        	var newContent=value+"#name#";
        	$("#modelContent").val(newContent);
        })
        $("#ad").on("click",function (){
        	var value=$("#modelContent").val();
        	var newContent=value+"#disease#";
        	$("#modelContent").val(newContent);
        })
        $("#modelContent").on("keyup",function(){
        	var value=$("#modelContent").val();
        	value=value.replace(/#telphone#/g, "13233233323");
        	value=value.replace(/#name#/g, "张三");
        	value=value.replace(/#disease#/g, "咳嗽");
        	$("#yulan").val(value);
        })

        /*var editor, mobileToolbar, toolbar;
        toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'];
        mobileToolbar = ["bold", "underline", "strikethrough", "color", "ul", "ol"];
        if (mEvent.isTouch && $(window).width() < 624) {
            toolbar = mobileToolbar;
        }
        editor = new simditor({
            textarea: $('#newsEditor'),
            placeholder: '这里输入文字...',
            toolbar: toolbar,
            pasteImage: true,
            defaultImage: 'assets/images/image.png',
            upload: {
                url: '',
                params: null,
                fileKey: 'upload_file',
                connectionCount: 3,
                leaveConfirm: '正在上传，确定要离开当前页面?'
            }
        });
*/
    }
    
});
