define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState', 'bootstrapValidatorZn'], function($, avalon, common, DataList, mEvent, simditor){
    var departmentAddVm = avalon.define({
        $id: 'departmentAdd',
        departmentType: {},
        littleTypeSelect: '',
        bigType: {},
        littleType: {},
        isSpecial: 2
    });

    return function (){
        var $departmentAddForm = $('#departmentAdd');

        avalon.scan($departmentAddForm[0]);

        // 表单验证参数
        $departmentAddForm.bootstrapValidator({
            feedbackIcons: {
                valid: 'fa fa-check',
                invalid: 'fa fa-remove',
                validating: 'fa fa-refresh'
            },
            fields : {
                dptId: {
                    validators : {
                        notEmpty : {}
                    }
                },
                departmentName: {
                    validators : {
                        notEmpty : {}
                    }
                }
            }
        });

        $departmentAddForm.on('submit', function(e){
            e.preventDefault();

            $departmentAddForm.data('bootstrapValidator').validate();
            if($departmentAddForm.data('bootstrapValidator').isValid()) {
                $.post(appName + '/rest/department/insert', $departmentAddForm.serialize() + '&dptName=' + $('#dptId').find("option:selected").text(), function (data){
                    if(data.resultCode==0){
                        window.location.href="#/department";
                        /*$.notify(
                         {message: "保存成功"},
                         {
                         type: 'success',
                         delay: 6000,
                         animate: {
                         enter: 'animated bounceIn',
                         exit: 'animated bounceOut'
                         }
                         }
                         );*/
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
        $.post(appName + '/rest/departmentType/selectForList', function (data){
            departmentAddVm.departmentType = data.data.dataList;
        });
    }
    
});
