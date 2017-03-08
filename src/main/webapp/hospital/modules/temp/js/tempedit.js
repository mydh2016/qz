define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState', 'bootstrapValidatorZn'], function($, avalon, common, DataList, mEvent, simditor){
    var tempEditVm = avalon.define({
        $id: 'tempEdit',
        data: {}
    });

    var tempTypeEditVm = avalon.define({
        $id: 'tempTypeEdit',
        bigTypeSelect: '',
        littleTypeSelect: '',
        bigType: {},
        littleType: {}
    });

    return function (){

        var $tempEdit = $('#tempEdit'),
            $tempEditForm = $('#tempEditForm'),
            tempId = window.location.href.split('=')[1];

        tempEditVm.data = {};

        // 表单验证参数
//        $tempEditForm.bootstrapValidator({
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

        $.post(appName + '/rest/model/selectByPrimaryKey?id=' + tempId, function(data){
            tempEditVm.data = data.data;

            tempTypeEditVm.$watch("bigTypeSelect" ,function(a, b) {
                $.post(appName + '/rest/model/selectChildrenType', {modelParentType: a}, function (data){
                    tempTypeEditVm.littleType = data.data;
                });
            });
            $.post(appName + '/rest/model/selectParentType', function (data){
                tempTypeEditVm.bigType = data.data;
                tempTypeEditVm.bigTypeSelect = tempEditVm.data.modelParentType;
            });


        });


        avalon.scan($tempEdit[0]);

        $tempEditForm.on('submit', function(e){
            e.preventDefault();
            $.post(appName + '/rest/model/updateByPrimaryKey', $tempEditForm.serialize(), function(data){

                $.notify(
                    {message: '保存成功'},
                    {
                        type: 'success',
                        delay: 6000,
                        animate: {
                            enter: 'animated bounceIn',
                            exit: 'animated bounceOut'
                        }
                    }
                );
            });
//            $tempEditForm.data('bootstrapValidator').validate();
//            if($tempEditForm.data('bootstrapValidator').isValid()) {
//            }

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
    }

});