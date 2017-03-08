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

		var alpatient = new DataList({
			id: 'alpatient',
			dataUrl: appName + '/rest/patientAddress/selectForList',
			sex: {
				1: '男',
				2: '女'
			}
		});

		var $table = $(alpatient.tDom);
		
		var categoryList = avalon.define({   
            $id: "category",   
            data: []  
        })  
        $.ajax({
				url: appName + '/rest/patientAddress/selectCategory' ,
				type: 'POST',
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				success: function (data) {
					categoryList.data=data.data
				},
				error: function (data) {
					
				}
			});

		$alSearch.on('submit', function (e){
			e.preventDefault();
			$.post(appName + '/rest/patientAddress/selectForList', $alSearch.serialize(), function(data){
				alpatient.dataParseToVm(data);
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
			$.post(appName + '/rest/patientAddress/delete', {id: $(this).closest('tr').attr('data-id')}, function(data){
				alpatient.reload();
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
				url: appName + '/rest/patientAddress/upload' ,
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
					alpatient.reload();
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