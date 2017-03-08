define([ 'jquery', 'avalon', 'common', 'datalist', 'dialog', 'bootstrapDateZn', 'growl'], function($, avalon, common, DataList){
    var profileDataVm = avalon.define({
        $id: 'profileData',
        data: {},
        editInfo: 0,
        changePwd: 0,
        submitUserInfo: function (e){
            e.preventDefault();
            $.post(appName + '/rest/user/saveOrUpdateUser', $(this).serialize(), function(data){
            	if(data.resultCode == 0) {
            		$.notify(
                        {message: '用户信息修改成功'},
                        {
                            type: 'success',
                            delay: 6000,
                            animate: {
                                enter: 'animated bounceIn',
                                exit: 'animated bounceOut'
                            }
                        }
                    );
            		
            		profileDataVm.toggleEditInfo();
            	} else {
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
        },
        submitPwd: function (e){
            e.preventDefault();
            $.post(appName + '/rest/user/updatePassword', $(this).serialize(), function(data){
            	if(data.resultCode == 0) {
            		$.notify(
                        {message: '密码修改成功'},
                        {
                            type: 'success',
                            delay: 6000,
                            animate: {
                                enter: 'animated bounceIn',
                                exit: 'animated bounceOut'
                            }
                        }
                    );
            		
            		profileDataVm.toggleChangePwd();
            	} else {
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
        },
        toggleEditInfo: function (){
            profileDataVm.editInfo = profileDataVm.editInfo ? 0 : 1;
        },
        toggleChangePwd: function (){
            profileDataVm.changePwd = profileDataVm.changePwd ? 0 : 1;
        }
    });

    return function (){
        var $profile =  $('#profile');

        avalon.scan($profile[0]);

        $.post(appName + '/rest/user/getSessionUser', function(data){
            profileDataVm.data = data;
        });

    }

});