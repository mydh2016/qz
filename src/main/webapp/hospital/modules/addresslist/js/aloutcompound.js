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
			$selectForm = $('#selectForm');

		var alOutCompound = new DataList({
			id: 'alOutCompound',
			dataUrl: appName + '/rest/address/selectForList?status=2',
			sex: {
				1: '男',
				2: '女'
			}
		});
		var categoryList = avalon.define({   
            $id: "select",   
            departments: {} ,
            duties:{},
            title:{},
            unit:{}
            
        })  
        $.ajax({
				url: appName + '/rest/department/selectList' ,
				type: 'POST',
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				success: function (data) {
					categoryList.departments=data.data
				},
				error: function (data) {
					
				}
			});
		 /*$.ajax({
				url: appName + '/rest/address/selectDuties' ,
				type: 'POST',
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				success: function (data) {
					categoryList.duties=data.data
				},
				error: function (data) {
					
				}
			});
			 $.ajax({
					url: appName + '/rest/address/selectTitle' ,
					type: 'POST',
					async: false,
					cache: false,
					contentType: false,
					processData: false,
					success: function (data) {
						categoryList.title=data.data
					},
					error: function (data) {
						
					}
				});
		 $.ajax({
				url: appName + '/rest/address/selectUnit' ,
				type: 'POST',
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				success: function (data) {
					categoryList.unit=data.data
				},
				error: function (data) {
					
				}
			});*/
		var $table = $(alOutCompound.tDom);

		$alSearch.on('submit', function (e){
			e.preventDefault();
			$.post(appName + '/rest/address/selectForList?status=2', $alSearch.serialize(), function(data){
				alOutCompound.dataParseToVm(data);
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

		$table.on('click', '.al-delete', function (){
			$.post(appName + '/rest/address/deleteByPrimaryKey', {id: $(this).closest('tr').attr('data-id')}, function(data){
				alOutCompound.reload();
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
			$selectForm.submit();
		});

		$btnImport.on('click', function(){
			var formData = new FormData($( "#uploadForm" )[0]);
			$.ajax({
				url: appName + '/rest/address/upload' ,
				type: 'POST',
				data: formData,
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				success: function (data) {
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
					alOutCompound.reload();
				},
				error: function (data) {
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
		});

		$allSelect.on('click', function(){
			var $input = $selectForm.find("input[name='allSelect']");
			if($input.val()=='0') {
				$input.val('1');
				$tbody.find('._check').prop('checked', true);
			} else {
				$input.val('0');
				$tbody.find('._check').prop('checked', false);
			}
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