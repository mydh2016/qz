define([ 'jquery', 'avalon', 'common', 'datalist', 'event', 'simditor', 'dialog', 'bootstrapDateZn', 'growl', 'btnState'], function($, avalon, common, DataList, mEvent, simditor){

	return function (){
		var $con = $('#content').children('div'),
			$alSearch = $('#al-search'),
			$btnExport = $('#btnExport'),
			$btnImport = $('#btnImport'),
			$allSelect = $('#allSelect'),
			$currentAllSelect = $('#currentAllSelect'),
			$currentInvert = $('#currentInvert'),
			$tbody = $('#checks-form');

		var recyclebin = new DataList({
			id: 'recyclebin',
			dataUrl: appName + '/rest/recycle/selectForList'
		});

		var $table = $(recyclebin.tDom);

		$alSearch.on('submit', function (e){
			e.preventDefault();
			$.post(appName + '/rest/recycle/selectForList', $alSearch.serialize(), function(data){
				recyclebin.dataParseToVm(data);
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

		$table.on('click', '#btnDelete', function (){
			$.post(appName + '/rest/recycle/delete', $("#selectForm").serialize(), function(data){
				recyclebin.reload();
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
			});
		});
		$table.on('click', '#update', function (){
			$.post(appName + '/rest/recycle/update', $("#selectForm").serialize(), function(data){
				recyclebin.reload();
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
			});
		});

		$btnExport.on('click', function(){

		});

		$btnImport.on('click', function(){

		});

		$allSelect.on('click', function(){

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