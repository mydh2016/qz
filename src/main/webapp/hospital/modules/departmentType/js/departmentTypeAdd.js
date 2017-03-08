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

        // 表单验证参数
        $tempAddForm.bootstrapValidator({
            feedbackIcons: {
                valid: 'fa fa-check',
                invalid: 'fa fa-remove',
                validating: 'fa fa-refresh'
            },
            fields : {
                departmentTypeName: {
                    validators : {
                        notEmpty : {}
                    }
                }
            }
        });

        $tempAddForm.on('submit', function(e){
            e.preventDefault();

            $tempAddForm.data('bootstrapValidator').validate();
            if($tempAddForm.data('bootstrapValidator').isValid()) {
                $.post(appName + '/rest/departmentType/insert', $tempAddForm.serialize(), function (data){
                    if(data.resultCode==0){
                        window.location.href="#/departmentType";
//            		$.notify(
//                            {message: "保存成功"},
//                            {
//                                type: 'success',
//                                delay: 6000,
//                                animate: {
//                                    enter: 'animated bounceIn',
//                                    exit: 'animated bounceOut'
//                                }
//                            }
//                        );
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
            }


        });

    }
    
});
