define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){

	return function (){
		var $con = $('#content').children('div'),
			$alSearch = $('#al-search'),
			$btnDelete = $('#btnDelete'),
			$currentAllSelect = $('#currentAllSelect'),
			$currentInvert = $('#currentInvert'),
			$tbody = $('#checks-form'),
			$selectForm = $('#selectForm');

		var outbox = new DataList({
			id: 'outbox',
			dataUrl: appName + '/rest/sendMessage/selectForList',
			modelList: [],
		    state: {0:"发送成功",1:"发送",2:"等待发送",3:"发送失败",4:"发送异常"}
		});

		var $table = $(outbox.tDom);

		$.post(appName + '/rest/sendMessage/selectForList', function(data){
			outbox.modelList = data.data.dataList;
		});

		$alSearch.on('submit', function (e) {
			e.preventDefault();
			$.post(appName + '/rest/sendMessage/selectForList', $alSearch.serialize(), function(data){
				outbox.dataParseToVm(data);
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
			$.post(appName + '/rest/sendMessage/delete', {id: $(this).closest('tr').attr('data-id')}, function(data){
				outbox.reload();
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

		$btnDelete.on('click', function(){
			$.post(appName + '/rest/sendMessage/delete', $selectForm.serialize(), function(data){
				outbox.reload();
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
		avalon.scan($table[0]);

	}
});