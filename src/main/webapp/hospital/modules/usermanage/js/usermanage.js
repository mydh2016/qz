define([ 'jquery', 'avalon', 'common', 'datalist', 'dialog', 'bootstrapDateZn', 'growl', 'bootstrapValidatorZn'], function($, avalon, common, DataList){

    var userDataVm = avalon.define({
        $id: 'userManageData',
        data: {},
        roleList: [],
        departmentName: []
    });

    return function (){
        var $con = $('#content').children('div'),
            $searchForm = $('#user-search');

        var userList = new DataList({
            id: 'userlist',
            dataUrl: appName + '/rest/user/getUsers',
            departmentName: []
        });

        $.post(appName + '/rest/department/selectList', function(data) {
            userList.vm.departmentName = data.data;
            userDataVm.departmentName = data.data;
        }, 'json');

        var $table = $(userList.tDom);

        $('#dateStart').datetimepicker({
            format: 'yyyy-mm-dd',
            container: $con,
            todayHighlight: true,
            language: 'zh-CN',
            autoclose: true,
            minView: 2,
            maxView: 2
        });
        $('#dateEnd').datetimepicker({
            format: 'yyyy-mm-dd',
            container: $con,
            todayHighlight: true,
            language: 'zh-CN',
            autoclose: true,
            minView: 2,
            maxView: 2
        });

        $searchForm.on('submit', function (e){
            e.preventDefault();
            var t = new Date().getTime();
            $.post(appName + '/rest/user/getUsers', $searchForm.serialize()+"&t="+t, function(data){
                userList.dataParseToVm(data);
            }, 'json');
        });

        
        $table.on('click', '.user-edit', function(){
            var userId = $(this).closest('tr').attr('data-userid');
            var $dialogContent;

            userDataVm.roleList = [];

            $.ajax({
                type: "POST",
                async: false,
                url: "modules/usermanage/edituser.html",
                success: function(data){
                    $dialogContent = $(data).dialog({
                        title: '用户编辑',
                        height: '460',
                        width:'550',
                        buttons: {
                            ok: {
                                label: '修改',
                                className: 'btn-primary',
                                handler: function (close) {
                                    $editUserForm.data('bootstrapValidator').validate();
                                    if($editUserForm.data('bootstrapValidator').isValid()) {
                                        var o = new Date();
                                        $.post(appName + '/rest/user/saveOrUpdateUser', $editUserForm.serialize()+"&o="+o, function(data){
                                            var message="编辑失败";
                                            if(data.resultCode==0){
                                                message="编辑成功";
                                                userList.reload();
                                                $.notify(
                                                    {message: message},
                                                    {
                                                        type: 'success',
                                                        delay: 6000,
                                                        animate: {
                                                            enter: 'animated bounceIn',
                                                            exit: 'animated bounceOut'
                                                        }
                                                    }
                                                );
                                                close();
                                            }else{
                                                message=data.data;
                                                $.notify(
                                                    {message: message},
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

                                }
                            },
                            cancel: {
                                label: '取消',
                                className: 'btn-default',
                                handler: function (close) {
                                    close();
                                }
                            }
                        }
                    });

                    var $editUserForm = $('#edit-user-form');
                    // 表单验证参数
                    $editUserForm.bootstrapValidator({
                        feedbackIcons: {
                            valid: 'fa fa-check',
                            invalid: 'fa fa-remove',
                            validating: 'fa fa-refresh'
                        },
                        fields : {
                            userName: {
                                validators : {
                                    notEmpty : {}
                                }
                            },
                            mobilePhone: {
                                validators : {
                                    notEmpty : {},
                                    regexp: {
                                        regexp: /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i,
                                        message: '请输入正确的手机号'
                                    }
                                }
                            },
                            departmentId: {
                                validators : {
                                    notEmpty : {}
                                }
                            }
                        }
                    });

                }
            });

            // 获取要编辑用户的角色列表数据
            $.ajax({
                type: "POST",
                async: false,
                url: "/qazitem/rest/user/getAllRoleList",
                data: {userId: userId},
                dataType: "json",
                success: function(data){
                    userDataVm.roleList = data;
                }
            });

            // 请求要编辑的用户数据
            $.ajax({
                type: "POST",
                async: false,
                url: "/qazitem/rest/user/getUserById",
                data: {userid: userId},
                dataType: "json",
                success: function(data){
                    userDataVm.data = data;
                    avalon.scan($dialogContent[0]);
                }
            });
            
            //

        })
            .on('click', '.user-delete', function(){
                var userId = $(this).closest('tr').attr('data-userid');
                var isDeleted = $(this).closest('tr').attr('data-status');
                $.post(appName + '/rest/user/deleteUser', {userId: userId,isDeleted:isDeleted}, function(data){
                	userList.reload();
                    $.notify(
                            {message: '成功'},
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
            });

        var $addUser = $('#add-user');

        $addUser.on('click', function(){
            var userId = 0;
            var o= new Date();
            userDataVm.roleList = [];
            $.post('modules/usermanage/adduser.html', function(data){
                var $dialog = $(data);
                $.post("/qazitem/rest/user/getAllRoleList", {userId: userId,o: o}, function(data){
                    $dialog.dialog({
                        title: '添加新用户',
                        height: '460',
                        width:'550',
                        buttons: {
                            ok: {
                                label: '确认',
                                className: 'btn-primary',
                                handler: function (close) {
                                    $addUserForm.data('bootstrapValidator').validate();
                                    if($addUserForm.data('bootstrapValidator').isValid()) {
                                        $.post(appName + '/rest/user/saveOrUpdateUser?0=new Date()', $addUserForm.serialize(), function(data){
                                            var message="添加失败";
                                            if(data.resultCode==0){
                                                message="添加成功";
                                                userList.reload();
                                                $.notify(
                                                    {message: message},
                                                    {
                                                        type: 'success',
                                                        delay: 6000,
                                                        animate: {
                                                            enter: 'animated bounceIn',
                                                            exit: 'animated bounceOut'
                                                        }
                                                    }
                                                );
                                                close();
                                            }else{
                                                message=data.data;
                                                $.notify(
                                                    {message: message},
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

                                }
                            },
                            cancel : {
                                label: '取消',
                                className: 'btn-default',
                                handler: function (close) {
                                    close();
                                }
                            }
                        }
                    });

                    var $addUserForm = $('#add-user-form');
                    // 表单验证参数
                    $addUserForm.bootstrapValidator({
                        feedbackIcons: {
                            valid: 'fa fa-check',
                            invalid: 'fa fa-remove',
                            validating: 'fa fa-refresh'
                        },
                        fields : {
                            userName: {
                                validators : {
                                    notEmpty : {}
                                }
                            },
                            password: {
                                validators : {
                                    notEmpty : {}
                                }
                            },
                            mobilePhone: {
                                validators : {
                                    notEmpty : {},
                                    regexp: {
                                        regexp: /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i,
                                        message: '请输入正确的手机号'
                                    }
                                }
                            },
                            departmentId: {
                                validators : {
                                    notEmpty : {}
                                }
                            }
                        }
                    });

                    userDataVm.roleList = data;
                    avalon.scan($dialog[0]);
                }, 'json');
            });
        });
        
        var $checksForm  = $('#checks-form');
        $('#autidor').on('click', function() {
        	$('<form id="auditor-form"><input type="hidden" name="userid" value="' + $checksForm.find(':checked').val() +'"><label class="radio-inline"><input type="radio" name="status" value="0">通过</label><label class="radio-inline"><input type="radio"name="status"value="1">不通过</label><div class="form-group mt15"><label for="agreeAppr">审批意见</label><textarea id="remark" name="remark" class="form-control"rows="3" placeholder="审批意见"></textarea></div></form>').dialog({
                title: '审核',
                buttons: {
                    ok: {
                        label: '确定',
                        className: 'btn-primary',
                        handler: function (close) {
                            var $auditorForm = $('#auditor-form');
                            
                            $.post(appName + '/rest/user/auditor', $auditorForm.serialize(), function(data){
                            	if(data == 2) {
                            		$.notify(
                                        {message: '您没有审核权限'},
                                        {
                                            type: 'success',
                                            delay: 6000,
                                            animate: {
                                                enter: 'animated bounceIn',
                                                exit: 'animated bounceOut'
                                            }
                                        }
                                    );
                            	} else {
                            		userList.reload();
                                    $.notify(
                                        {message: '编辑成功'},
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

                                close();
                            });
                        }
                    },
                    cancel: {
                        label: '取消',
                        className: 'btn-default',
                        handler: function (close) {
                            close();
                        }
                    }
                }
            });
        });



    }

});