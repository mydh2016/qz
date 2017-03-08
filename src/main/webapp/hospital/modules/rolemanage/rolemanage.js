define([ 'jquery', 'avalon', 'common', 'datalist', 'dialog', 'bootstrapDateZn', 'growl', 'tab', 'bootstrapValidatorZn'], function($, avalon, common, DataList){

    var roleDataVm = avalon.define({
        $id: 'roleData',
        data: {},
        roleList: [],
        roleMenuList: [],
        treeSelect: function (){
            var $this = $(this),
                $parents = $this.closest('.tree-item').parents('.tree-item').children('label').find("input[name='permissionIds']"),
                $children = $this.closest('.tree-item').find('.tree-item').find("input[name='permissionIds']");

            if($this.is(':checked')) {
                $parents.prop('checked', true);
                $children.prop('checked', true);
            } else {
                $children.prop('checked', false);
                if($this.closest('.tree-item').siblings('.tree-item').find(':checked').length == 0) {
                    $this.closest('.tree-item').parent('.tree-item').children('label').find("input[name='permissionIds']").prop('checked', false);
                }
            }

        }
    });

    return function (){
        var $con = $('#content').children('div'),
            $searchForm = $('#role-search');

        $('#tab').tab();

        var roleList = new DataList({
            id: 'rolelist',
            dataUrl: appName + '/rest/role/getRoles'
//            dataUrl: '/10.json'
        });
        var $table = $(roleList.tDom);

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
            $.post(appName + '/rest/role/getRoles', $searchForm.serialize(), function(data){
                roleList.dataParseToVm(data);
            }, 'json');
        });

        $table.on('click', '.role-edit', function(){
            var roleId = $(this).closest('tr').attr('data-roleId');
            var $dialogContent;

            roleDataVm.roleList = [];
            roleDataVm.roleMenuList = [];

            $.ajax({
                type: "POST",
                async: false,
                url: "modules/rolemanage/editrole.html",
                success: function(data){
                    $dialogContent = $(data).dialog({
                        title: '权限编辑',
                        height: '460',
                        width:'550',
                        buttons: {
                            ok: {
                                label: '修改',
                                className: 'btn-primary',
                                handler: function (close) {
                                    var $form = $('#edit-role-form');
                                   // $.post(appName + '/rest/role/saveRoleMenuPerm', $form.eq(1).serialize(), function(){});

                                    $form.data('bootstrapValidator').validate();
                                    if($form.data('bootstrapValidator').isValid()) {
                                        $.post(appName + '/rest/role/saveRoleInfo', $form.serialize(), function(data){
                                            var message="编辑失败";
                                            if(data.resultCode==0){
                                                message="编辑成功";
                                                roleList.reload();
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

                    var $form = $('#edit-role-form');

                    // 表单验证参数
                    $form.bootstrapValidator({
                        feedbackIcons: {
                            valid: 'fa fa-check',
                            invalid: 'fa fa-remove',
                            validating: 'fa fa-refresh'
                        },
                        fields : {
                            roleName: {
                                validators : {
                                    notEmpty : {}
                                }
                            }
                        }
                    });

                    $dialogContent.find('#tab').tab();
                    avalon.scan($dialogContent[0]);
                }
            });

            // 获取要编辑权限的所属用户的列表数据
            $.ajax({
                type: "POST",
                async: false,
                url: "/qazitem/rest/role/getAllUserList",
                data: {roleId: roleId,type:1},
                dataType: "json",
                success: function(data){
                    roleDataVm.roleList = data;
                }
            });

            // 获取权限菜单列表
            $.ajax({
                type: "POST",
                async: false,
                url: "/qazitem/rest/role/getResourcesJson",
                //url: '/11.json',
                data: {roleId: roleId,type:1},
                dataType: "json",
                success: function(data){
                    roleDataVm.roleMenuList = data;
                }
            });

            // 请求要编辑的权限数据
            $.ajax({
                type: "POST",
                async: false,
                url: "/qazitem/rest/role/getRoleById",
                data: {roleId: roleId},
                dataType: "json",
                success: function(data){
                    roleDataVm.data = data;
                }
            });

        })
            .on('click', '.role-delete', function(){
                var roleId = $(this).closest('tr').attr('data-roleId');
                $.post(appName + '/rest/role/deleteRole', {roleId: roleId}, function(data){
                	//增加判断 data里面需要返回是否删除成功的标识
                	
                	roleList.reload();
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

        /*var $btnBatchDel = $('#batch-del-user'),*/
        var $addRole = $('#add-role');

        $addRole.on('click', function(){
            var roleid = $(this).closest('tr').attr('data-roleid');

            roleDataVm.roleList = [];
            roleDataVm.roleMenuList = [];

            $.post('modules/rolemanage/addrole.html', function(data){
                var $dialog = $(data);

                // 获取所有所属用户数据
                $.ajax({
                    type: "POST",
                    async: false,
                    url: "/qazitem/rest/role/getAllUserList",
                    //url: '/8.json',
                    data: {type: 0},
                    dataType: "json",
                    success: function(data){
                        roleDataVm.roleList = data;
                    }
                });

                // 获取权限菜单列表
                $.ajax({
                    type: "POST",
                    async: false,
                    url: "/qazitem/rest/role/getResourcesJson",
//                    url: '/11.json',
                    data: {type:0},
                    dataType: "json",
                    success: function(data){
                        roleDataVm.roleMenuList = data;
                    }
                });

                $dialog.dialog({
                    title: '添加角色',
                    height: '460',
                    width:'550',
                    buttons: {
                        ok: {
                            label: '确认',
                            className: 'btn-primary',
                            handler: function (close) {
                                $form.data('bootstrapValidator').validate();
                                if($form.data('bootstrapValidator').isValid()) {
                                    $.post(appName + '/rest/role/saveRoleInfo', $form.serialize(), function(data){
                                        roleList.reload();
                                        $.notify(
                                            {message: '成功添加一个角色'},
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

                var $form = $('#add-role-form');

                // 表单验证参数
                $form.bootstrapValidator({
                    feedbackIcons: {
                        valid: 'fa fa-check',
                        invalid: 'fa fa-remove',
                        validating: 'fa fa-refresh'
                    },
                    fields : {
                        roleName: {
                            validators : {
                                notEmpty : {}
                            }
                        }
                    }
                });

                avalon.scan($dialog[0]);
                $dialog.tab();

            });
        });



    }

});