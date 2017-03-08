define([ 'jquery', 'avalon', 'common', 'datalist', 'dialog', 'bootstrapDateZn', 'growl'], function($, avalon, common, DataList){
    var tempViewVm = avalon.define({
        $id: 'tempView',
        data: {},
        modelStatus: {
            1: '启用',
            2: '停用'
        }
    });

    return function (){

        $.post(appName + '/rest/model/selectByPrimaryKey', {id: window.location.href.split('=')[1]}, function(data){
            if(data.resultCode == 0){
                tempViewVm.data = data.data;
            }else {
                $.notify(
                    {message: data.data},
                    {
                        type: 'danger',
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