
/**
 * 
 */
app.controller('appointHsCtrl', ['$scope', '$resource','$location',function($scope,$resource,$location) {
	$scope.hsList=null;
	var hl = null;
	$scope.hsListShow = function (){
		var postResource = $resource('/qazitem/rest/web/hospital/getHospitals', {}, {query:{method:'GET',isArray:false}});  
		postResource.query({},function(res){
			$scope.hsList = res.data;
			hl = res.data;
		}, function (res) { 
			console.log("error");  
		});
	};
	$scope.hsListShow();
}]);

/**
 * 
 */
app.controller('appointCtrl', ['$rootScope','$scope', '$resource','$location','$stateParams','$q','$state',function($rootScope,$scope,$resource,$location,$stateParams,$q,$state) {
//	var c_user = $rootScope.s_webUser;
//	console.log("c_user:"+c_user);
//	if(c_user.s_username==null ||  c_user.s_username=='undefined'){
//		console.log("dd");
//		$state.go("login");
//	}
	
	$scope.hospitalId = $stateParams.hospitalId;
	var deferred = $q.defer();
	$scope.hsDetailShow = function (){
		var postResource = $resource('/qazitem/rest/web/hospital/getHospital', {get:{method:'GET',isArray:false}});  
		postResource.get({id:$scope.hospitalId},function(res){
			console.log(res.data); 
			$scope.hs = res.data;
			deferred.resolve(res.data);
		}, function (res) { 
			console.log("error");  
		});
	};
	
	$scope.hsDetailShow();
	$scope.getqdefer = function(){
		return deferred;
	};
	/**
	deferred.promise.then(function(data) {  // 调用承诺API获取数据 .resolve  
        var departmentResource = $resource('/qazitem/rest/web/test/qdepartment', {get:{method:'GET',isArray:false}});  
        departmentResource.get({hcode:$scope.hs.hcode},function(res){
			console.log(res.data);
			$scope.depart = res.data;
			$scope.departmentTypeList = $scope.depart.deptType_dept;
			//$state.go("appoint.dept", {hospitalId: $scope.hospitalId});
			//$state.go("appoint.dept");
			alert("ghfduyejkd");
			//$scope.jieshaoClass = "active";
		}, function (res) { 
			console.log("error");  
		});
    }, function(data) {  // 处理错误 .reject  
    	console.log("error");  
    });**/
	
	$scope.keshiState = function (val){
		if(val==1){
			$scope.keshiClass="active";
		}else{
			$scope.keshiClass="";
		}
	};
	$scope.jieshaoState = function (val){
		if(val==1){
			$scope.jieshaoClass="active";
		}else{
			$scope.jieshaoClass="";
		}
	};
	$scope.yishengState = function (val){
		if(val==1){
			$scope.yishengClass="active";
		}else{
			$scope.yishengClass="";
		}
	};

}]);

/**
 * 
 */
app.controller('appointDeptCtrl', ['$scope', '$resource','$location','$stateParams','$q',function($scope,$resource,$location,$stateParams,$q) {
	$scope.keshiState(1);
	$scope.jieshaoState(2);
	$scope.yishengState(2);
	
	var qdefer = $scope.getqdefer();
	qdefer.promise.then(function(data) {  // 调用承诺API获取数据 .resolve  
        var departmentResource = $resource('/qazitem/rest/web/department/qdepartment', {get:{method:'GET',isArray:false}});  
        departmentResource.get({hcode:$scope.hs.hcode},function(res){
			console.log(res.data);
			$scope.depart = res.data;
			$scope.departmentTypeList = $scope.depart.deptType_dept;
		}, function (res) { 
			console.log("error");  
		});
    }, function(data) {// 处理错误 .reject  
    	console.log("error");  
    });

}]);

/**
 * 
 */
app.controller('appointHospitalCtrl', ['$scope', '$resource','$location','$stateParams',function($scope,$resource,$location,$stateParams) {
	$scope.keshiState(2);
	$scope.jieshaoState(1);
	$scope.yishengState(2);
	
}]);

/**
 * 
 */
app.controller('appointDoctorCtrl', ['$scope', '$resource','$location','$stateParams','$q',function($scope,$resource,$location,$stateParams,$q) {
	$scope.keshiState(2);
	$scope.jieshaoState(2);
	$scope.yishengState(1);
	
	var qdefer = $scope.getqdefer();
	qdefer.promise.then(function(data) {  // 调用承诺API获取数据 .resolve  
        var doctorResource = $resource('/qazitem/rest/web/doctor/queryAllDocter', {get:{method:'GET',isArray:false}});  
        doctorResource.get({hcode:$scope.hs.hcode},function(res){
			console.log(res.data);
			
		}, function (res) { 
			console.log("error");  
		});
    }, function(data) {// 处理错误 .reject  
    	console.log("error");  
    });

}]);

/**
 * 
 */
app.controller('appointDepartmentCtrl', ['$scope', '$resource','$location','$stateParams','$q','$sce',function($scope,$resource,$location,$stateParams,$q,$sce) {
	$scope.keshiState(1);
	$scope.jieshaoState(2);
	$scope.yishengState(2);
	$scope.db=false;
	var qdefer = $scope.getqdefer();
	qdefer.promise.then(function(data) {  // 调用承诺API获取数据 .resolve  
		console.log("hid:"+$scope.hs.hospitalId);
		console.log("did:"+$stateParams.departmentId);
		var pmlist = null;
		var amlist = null;
		var deferred = $q.defer();
		$scope.getpd = function(){
			var pdResource = $resource('/qazitem/rest/web/pdgh/query', {get:{method:'GET',isArray:false}});  
			pdResource.get({hospitalId:$scope.hs.hospitalId,departmentId:$stateParams.departmentId},function(res){
				console.log(res.data);
				deferred.resolve(res.data);
				console.log("amlist:"+res.data.amlist);
				console.log("pmlist:"+res.data.pmlist);
				$scope.amlist = res.data.amlist;
				$scope.pmlist = res.data.pmlist;
				amlist = $scope.amlist;
				pmlist = $scope.pmlist;
			}, function (res) { 
				console.log("error");  
			});
		};
		$scope.getpd();
		
		deferred.promise.then(function(data) {
			/***********/
			// 给日期添加点击效果
		    var keyRight = $(".hsDepartment_table_rowYou");
		    var keyLeft = $(".hsDepartment_table_rowZuo");
		    var parentNodeWidth = $(".hsDepartment_table_date").width();
		    var childNode = $(".hsDepartment_table ul");
		    var childLis = $(".hsDepartment_table ul li");
		    var pic = 0;
		    keyRight.on("click", function() {
		        pic++;
		        var target = -pic * parentNodeWidth;
		        if (pic == Math.floor(childLis.length/21)-1) {
		            animate(childNode, -5 * parentNodeWidth);
		        } else if (pic > Math.floor(childLis.length/21)-1) {
		            pic = Math.floor(childLis.length / 21);
		            return false;
		        }
		        animate(childNode, target);
		    })
		    keyLeft.on("click", function() {
		            if (pic <= 0) {
		                pic = 0;
		                animate(childNode, 0);
		            } else {
		                pic--;
		                var target = -pic * parentNodeWidth;
		                animate(childNode, target);
		            }
		        })
		        // 添加日期
		    var liWeeks = $(".week");
		    var liDates = $(".date");
		    date(liWeeks, liDates);
		    // 日期
		    function date(liWeeks, lis) {
		        var currentDate = new Date();
		        //    获取年
		        var year = currentDate.getFullYear();
		        //    获取月份
		        var month = currentDate.getMonth() + 1;
		        //  获取日期
		        var day = currentDate.getDate();
		        //    获取星期
		        var week = currentDate.getDay();

		        //   未来日期
		        var futureDay = day + 29;
		        //    日期记录
		        var j = 1;
		        //    判断年
		        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
		            //        闰年
		            if (month == 1) {
		                for (var i = 0; i < lis.length; i++) {
		                    if (day + i <= 31) {
		                        lis[i].innerHTML = year + "-" + month + "-" + (day + i);
		                    } else if (day + i >= 32) {
		                        lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
		                    }
		                }
		            } else if (month == 2) {
		                for (var i = 0; i < lis.length; i++) {
		                    if (day + i <= 29) {
		                        lis[i].innerHTML = year + "-" + month + "-" + (day + i);
		                    } else if (day + i >= 30) {
		                        lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
		                    }
		                }
		            }
		        } else {
		            //        平年
		            if (month == 1) {
		                for (var i = 0; i < lis.length; i++) {
		                    if (day + i <= 31) {
		                        lis[i].innerHTML = year + "-" + '1' + "-" + (day + i);
		                    } else if (day + i >= 32) {
		                        lis[i].innerHTML = year + "-" + '2' + "-" + (j++);
		                    } else if (day + i == 59) {
		                        lis[i].innerHTML = year + "-" + '3' + "-" + (1);
		                    }
		                }
		            } else if (month == 2) {
		                for (var i = 0; i < lis.length; i++) {
		                    if (day + i <= 28) {
		                        lis[i].innerHTML = year + "-" + month + "-" + (day + i);
		                    } else if (day + i >= 29) {
		                        lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
		                    }
		                }
		            }
		        }
		        //    平年
		        if (month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
		            for (var i = 0; i < lis.length; i++) {
		                if (day + i <= 31) {
		                    lis[i].innerHTML = year + "-" + month + "-" + (day + i);
		                } else if (day + i >= 32) {
		                    lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
		                }
		            }
		        } else if (month == 12) {
		            for (var i = 0; i < lis.length; i++) {
		                if (day + i <= 31) {
		                    lis[i].innerHTML = year + "-" + "12" + "-" + (day + i);
		                } else if (day + i >= 32) {
		                    lis[i].innerHTML = (year + 1) + "-" + "1" + "-" + (j++);
		                }
		            }

		        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
		            for (var i = 0; i < lis.length; i++) {
		                if (day + i <= 30) {
		                    lis[i].innerHTML = year + "-" + month + "-" + (day + i);
		                } else if (day + i >= 31) {
		                    lis[i].innerHTML = year + "-" + (month + 1) + "-" + (j++);
		                }
		            }
		        }
		        //计算周几

		        for (var k = 0; k < liWeeks.length; k++) {
		            if ((week + k) % 7 == 0) {
		                liWeeks[k].innerHTML = "星期日"
		            } else if ((week + k) % 7 == 1) {
		                liWeeks[k].innerHTML = "星期一"
		            } else if ((week + k) % 7 == 2) {
		                liWeeks[k].innerHTML = "星期二"
		            } else if ((week + k) % 7 == 3) {
		                liWeeks[k].innerHTML = "星期三"
		            } else if ((week + k) % 7 == 4) {
		                liWeeks[k].innerHTML = "星期四"
		            } else if ((week + k) % 7 == 5) {
		                liWeeks[k].innerHTML = "星期五"
		            } else if ((week + k) % 7 == 6) {
		                liWeeks[k].innerHTML = "星期六"
		            }
		        }
		    }
		    // 轮播图
		    function animate(obj, target) {
		        clearInterval(obj.timer);
		        obj.timer = setInterval(function() {
		            var leader = obj.offsetLeft;
		            var step = 30;
		            step = leader < target ? step : -step;
		            if (Math.abs(target - leader) >= Math.abs(step)) {
		                leader = leader + step;

		                obj.css("left", leader);
		            } else {
		                obj.css("left", target);
		                clearInterval(obj.timer);
		            }
		        }, 18);
		    }
			/***********/
		    /*****日期格式化******/
		    function dformat(now,mask)
		    {
		        var d = now;
		        var zeroize = function (value, length)
		        {
		            if (!length) length = 2;
		            value = String(value);
		            for (var i = 0, zeros = ''; i < (length - value.length); i++)
		            {
		                zeros += '0';
		            }
		            return zeros + value;
		        };
		     
		        return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
		        {
		            switch ($0)
		            {
		                case 'd': return d.getDate();
		                case 'dd': return zeroize(d.getDate());
		                case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
		                case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
		                case 'M': return d.getMonth() + 1;
		                case 'MM': return zeroize(d.getMonth() + 1);
		                case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
		                case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
		                case 'yy': return String(d.getFullYear()).substr(2);
		                case 'yyyy': return d.getFullYear();
		                case 'h': return d.getHours() % 12 || 12;
		                case 'hh': return zeroize(d.getHours() % 12 || 12);
		                case 'H': return d.getHours();
		                case 'HH': return zeroize(d.getHours());
		                case 'm': return d.getMinutes();
		                case 'mm': return zeroize(d.getMinutes());
		                case 's': return d.getSeconds();
		                case 'ss': return zeroize(d.getSeconds());
		                case 'l': return zeroize(d.getMilliseconds(), 3);
		                case 'L': var m = d.getMilliseconds();
		                    if (m > 99) m = Math.round(m / 10);
		                    return zeroize(m);
		                case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
		                case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
		                case 'Z': return d.toUTCString().match(/[A-Z]+$/);
		                // Return quoted strings with the surrounding quotes removed
		                default: return $0.substr(1, $0.length - 2);
		            }
		        });
		    };
		    
		    /*************/
			//$scope.tthl = '<td class="hsDepartment_table_appTime">早上</td><td></td><td></td><td></td><td></td><td class="overplus"><a href="#">剩余33</a></td><td></td><td></td><td rowspan="3" class="hsDepartment_table_rowspan"></td>'; 
			//$scope.myText = $sce.trustAsHtml('<td class="hsDepartment_table_appTime">早上</td><td></td><td></td><td></td><td></td><td class="overplus"><a href="#">剩余33</a></td><td></td><td></td><td rowspan="3" class="hsDepartment_table_rowspan"></td>');
			//设置

			var usengpms = $("li[name='usengpm']")
			usengpms.each(function(i){
				var lidateval = liDates[i].innerHTML;
				var usengpmElm = this;
				$.each(pmlist, function(){
					var pddate = dformat(new Date(this.consDate),"yyyy-M-d");
					if(pddate == lidateval){
						//TODO
						if(this.orderNumber>0){//有数量
							usengpmElm.className += " "+"overplus";
							usengpmElm.innerHTML="<a href='javascript:void(0)' onclick=\"getpdlist("+this.consDate+","+this.timeSolt+")\">剩余"+this.orderNumber+"</a>";
							//usengpmElm.innerHTML="<a  onclick=getpdlist("+this.hospitalId+","+this.departId+","+this.consDate+")>剩余"+this.orderNumber+"</a>";
							//usengpmElm.innerHTML="<button  ng-click='getpdlist()'>剩余"+this.orderNumber+"</button>";
						}else{//约满
							usengpmElm.className += " "+"full";
							usengpmElm.innerHTML="约满";
						}
					}
				});
			});
			
			
			var usengams = $("li[name='usengam']")
			usengams.each(function(i){
				var lidateval = liDates[i].innerHTML;
				var usengamElm = this;
				$.each(amlist, function(){
					var pddate = dformat(new Date(this.consDate),"yyyy-M-d");
					if(pddate == lidateval){
						//TODO
						if(this.orderNumber>0){//有数量
							usengamElm.className += " "+"overplus";
							usengamElm.innerHTML="<a href='javascript:void(0)' onclick=\"getpdlist("+this.consDate+","+this.timeSolt+")\">剩余"+this.orderNumber+"</a>";
							//usengpmElm.innerHTML="<a  onclick=getpdlist("+this.hospitalId+","+this.departId+","+this.consDate+")>剩余"+this.orderNumber+"</a>";
							//usengpmElm.innerHTML="<button  ng-click='getpdlist()'>剩余"+this.orderNumber+"</button>";
						}else{//约满
							usengamElm.className += " "+"full";
							usengamElm.innerHTML="约满";
						}
					}
				});
			});
			//获取号源
			getpdlist = function(selectDate,timeSolt){
				selectDate = dformat(new Date(selectDate),"yyyy-MM-dd");
				console.log(selectDate);
				console.log(timeSolt);
				var pdltResource = $resource('/qazitem/rest/web/pdgh/queryPDList', {get:{method:'GET',isArray:false}});  
				pdltResource.get({hospitalId:$scope.hs.hospitalId,departmentId:$stateParams.departmentId,date:selectDate,timeSolt:timeSolt},function(res){
					console.log(res.data);
					$scope.pdlt = res.data;
					$scope.db = true;
				}, function (res) { 
					console.log("error");  
				});
				$scope.db=true;
			};
			
			
		}, function(data) {// 处理错误 .reject  
	    	console.log("error");  
	    });
		
		
    }, function(data) {// 处理错误 .reject  
    	console.log("error");  
    });
	
	
	

}]);


/**
 * 
 */
app.controller('registerCtrl', ['$rootScope','$scope', '$resource','$state',function($rootScope,$scope,$resource,$state) {
	$scope.webUser={};
	//判断确认密码是否与密码相同
	$scope.affirmPwd = function () {
        if($scope.webUser.userpassword===undefined || $scope.webUser.userpassword2===undefined) return false;
        if($scope.webUser.userpassword===$scope.webUser.userpassword2){
            return true;
        }else{
            return false;
        }
    };
	
	//判断手机号
    $scope.IsPhone = function () {
        return /^1[3|4|5|8][0-9]\d{4,8}$/.test($scope.phone);
    };
    
    //确认按钮是否启动
    $scope.forminvalid = function () {
        if($scope.affirmPwd() &&
            $scope.IsPhone())
        {
            return false;
        }else
        {
            return true;
        }
    };
	
    $scope.signup = function(){
    	$rootScope.s_webUser={};
    	console.log($scope.webUser);
    	
    	var sigupResource = $resource('/qazitem/rest/web/user/reg', $scope.webUser, {save:{method:'POST'}});
    	sigupResource.save({},$scope.webUser, function (res) {
    		$rootScope.s_webUser.s_username=res.data.username;
    		$state.go("index");
        }, function (data) {
        	alert("signup faliure");
        });
//    	var sigupResource = $resource('/qazitem/rest/web/user/reg',$scope.webUser, {save:{method:'POST'}});
//    	sigupResource.save({},{webUser:$scope.webUser}, function (res) {
//    		$rootScope.s_webUser.s_username=res.data.username;
//    		$state.go("index");
//        }, function (data) {
//        	alert("signup faliure");
//        });
    	
    };
	
}]);

/**
 * 
 */
app.controller('loginCtrl', ['$rootScope','$scope', '$resource','$location','$state',function($rootScope,$scope,$resource,$location,$state) {
	$rootScope.s_webUser={};
	$scope.login = function(){
		var sigupResource = $resource('/qazitem/rest/web/user/login', {get:{method:'GET',isArray:false}});
		sigupResource.get({username:$scope.webUser.username,userpassword:$scope.webUser.userpassword}, function (res) {
			if(res.resultCode==0){
				$rootScope.s_webUser.s_username=res.data.username;
				
				console.log($rootScope.s_webUser);
				$state.go("index");
			}else{
				alert(res.data);
			}
		}, function (data) {
			alert("login faliure");
		});
	}
}]);

/**
 * 
 */
app.controller('healthInquiryCtrl', ['$scope', '$resource','$location',function($scope,$resource,$location) {
	$scope.getmdpeList = function(){
		var postResource = $resource('/qazitem/rest/web/medpedia/getMedpediaList', {}, {query:{method:'GET',isArray:false}});  
		postResource.query({},function(res){
			$scope.medList = res.data;
			console.log(res.data);
		}, function (res) { 
			console.log("error");  
		});
	}
	$scope.getmdpeList();
}]);

/**
 * 
 */
app.controller('noticeListCtrl', ['$scope', '$resource','$location',function($scope,$resource,$location) {
	$scope.getnoticeList = function(){
		var noticeListResource = $resource('/qazitem/rest/web/notice/queryAll', {}, {query:{method:'GET',isArray:false}});  
		noticeListResource.query({},function(res){
			$scope.noticeList = res.data;
			console.log(res.data);
		}, function (res) { 
			console.log("error");  
		});
	}
	$scope.getnoticeList();
}]);

/**
 * 
 */
app.controller('personalCtrl', ['$scope', '$resource','$location',function($scope,$resource,$location) {
	
}]);

app.controller('healthInquiryDelCtrl', ['$scope', '$resource','$location','$stateParams',function($scope,$resource,$location,$stateParams) {
	$scope.getDetail = function(){
		var mDetailResource = $resource('/qazitem/rest/web/medpedia/getMedpediaInfo', {get:{method:'GET',isArray:false}});  
		mDetailResource.get({id:$stateParams.contentId},function(res){
			console.log(res.data);
			$scope.detail = res.data;
		}, function (res) { 
			console.log("error");  
		});
	};
	$scope.getDetail();
}]);

app.controller('noticeCtrl', ['$scope', '$resource','$location','$stateParams',function($scope,$resource,$location,$stateParams) {
	$scope.getnotice = function(){
		var noticeResource = $resource('/qazitem/rest/web/notice/selectBynotice', {get:{method:'GET',isArray:false}});  
		noticeResource.get({publicNoticeId:$stateParams.noticeId},function(res){
			console.log(res.data);
			$scope.notice = res.data;
		}, function (res) { 
			console.log("error");  
		});
	};
	$scope.getnotice();
}]);


