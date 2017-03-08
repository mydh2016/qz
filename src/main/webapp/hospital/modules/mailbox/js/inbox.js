define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){

	return function (){
		var $con = $('#content').children('div'),
			$alSearch = $('#al-search'),
			$btnExport = $('#btnExport'),
			$btnImport = $('#btnImport'),
			$allSelect = $('#allSelect'),
			$currentAllSelect = $('#currentAllSelect'),
			$currentInvert = $('#currentInvert'),
			$tbody = $('#checks-form'),
			$selectForm = $("#selectForm");

		var inbox = new DataList({
			id: 'inbox',
			dataUrl: appName + '/rest/receive/selectForList',
			smsStatus:{1:"未读",2:"已读"}
		});

		var $table = $(inbox.tDom);

		$alSearch.on('submit', function (e){
			e.preventDefault();
			$.post(appName + '/rest/receive/selectForList', $alSearch.serialize(), function(data){
				inbox.dataParseToVm(data);
			});
		});

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
		$table.on('click', '#read', function (){
			$.post(appName + '/rest/receive/update', $selectForm.serialize(), function(data){
				inbox.reload();
				$.notify(
					{message: '修改成功'},
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
		$table.on('click', '#btnDelete', function (){
			$.post(appName + '/rest/receive/delete', $selectForm.serialize(), function(data){
				inbox.reload();
				$.notify(
					{message: '删除成功'},
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

		$btnExport.on('click', function(){

		});

		$btnImport.on('click', function(){

		});

		$allSelect.on('click', function(){

		});
		
		$('#call').on('click', function (){
			$.post('modules/message/templist.html', function(data){
                var $temp = $(data);
                $temp.dialog({
                    title: '选择模板',
                    buttons: {
                        ok: {
                            label: '确认',
                            className: 'btn-primary',
                            handler: function (close) {
                            	$.post(appName + '/rest/receive/insertSend', $selectForm.serialize() + "&modelId=" + $temp.find('input:checked').val(), function(){
                            		
                            	});
                                    $.notify(
                                        {message: '选择成功'},
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

                var templist = new DataList({
                    id: 'templist',
                    dataUrl: appName + '/rest/model/selectForList?modelStatus=' + 1,
                    modelStatus: {
                        1: '启用',
                        2: '停用'
                    }
                });

                avalon.scan($temp[0]);
            });
		});

		$currentAllSelect.on('click', function(){
			$tbody.find('._check').prop('checked', true);
		});

		$currentInvert.on('click', function(){
			var $checks = $tbody.find('._check');
			$checks.each(function(){
				var $this = $(this);
				if($this.prop('checked')) {
					$this.prop('checked', false);
				} else {
					$this.prop('checked', true);
				}
			});


		});

		avalon.scan($table[0]);

	}
});