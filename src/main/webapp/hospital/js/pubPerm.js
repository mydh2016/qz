define( ['jquery', 'avalon', 'cell'], function($, avalon, cell) {
	var pubUserObject;
	
	function pubUser() {
		$.ajax({
		    type: 'POST',
			url: appName + '/rest/user/getSessionUser',
			success: function(data){
				pubUserObject = data;
			} ,
			async: false, // 同步请求
			dataType: 'json'
		
		});
		
		return pubUserObject;
	}
	
	return  pubUser();
});
