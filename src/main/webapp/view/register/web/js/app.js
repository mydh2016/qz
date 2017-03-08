'use strict';

var app = angular.module('app', [
'ngResource',
'ui.router',
'oc.lazyLoad'
]);


app.config(function ($stateProvider , $urlRouterProvider) {
	$urlRouterProvider.otherwise('/');
	$stateProvider
    .state('index', {//网站主页
        url:'/',
        templateUrl: 'main.html',
        //controller: 'myCtrl',
    	resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load([
                    ]);
            }]
        }
    })
    .state('appointHs', {//挂号医院列表页面
        url:'/appointHs',
        templateUrl: 'appointHs.html',
        controller: 'appointHsCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/appointHs.css'
                    ]);
            }]
        }
    })
    .state('appoint', {//挂号医院列表页面
        url:'/appoint/:hospitalId',
        templateUrl: 'appoint.html',
        controller: 'appointCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/appoint.css','css/hospital.css',
                             'css/doctorList.css','css/doctorDetail.css'
                    ]);
            }]
        }
    })
//    .state('hospital', {
//        url:'/hospital/:hospitalId',
//        templateUrl: 'hospital.html',
//        controller: 'hospitalCtrl',
//        resolve: {
//            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
//                return $ocLazyLoad.load(['ctrljs/hospitalCtrl.js','css/appoint.css',
//                       'css/hospital.css'
//                    ]);
//            }]
//        }
//    })
    .state('appoint.dept', {
        url:'/appointDept',
        templateUrl: 'appointDept.html',
        controller: 'appointDeptCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/appoint.css'
                    ]);
            }]
        }
    })
    .state('appoint.hospital', {
        url:'/appointHospital',
        templateUrl: 'appointHospital.html',
        controller: 'appointHospitalCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/hospital.css'
                    ]);
            }]
        }
    })
    .state('appoint.doctor', {
        url:'/appointDoctor',
        templateUrl: 'appointDoctor.html',
        controller: 'appointDoctorCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load([
                    ]);
            }]
        }
    })
    .state('appoint.department', {
        url:'/appointDepartment/:departmentId',
        templateUrl: 'department.html',
        controller: 'appointDepartmentCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/department.css'
                    ]);
            }]
        }
    })
    .state('register', {
        url:'/register',
        templateUrl: 'register.html',
        controller: 'registerCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/register.css'
                    ]);
            }]
        }
    })
    .state('login', {
        url:'/login',
        templateUrl: 'login.html',
        controller: 'loginCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/register.css'
                    ]);
            }]
        }
    })
    .state('healthInquiry', {
        url:'/healthInquiry',
        templateUrl: 'healthInquiry.html',
        controller: 'healthInquiryCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/healthInquiry.css'
                    ]);
            }]
        }
    })
    .state('noticeList', {
        url:'/noticeList',
        templateUrl: 'noticeList.html',
        controller: 'noticeListCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/noticeList.css'
                    ]);
            }]
        }
    })
    .state('personal', {
    	url:'/personal',
    	templateUrl: 'personal.html',
    	controller: 'personalCtrl',
    	resolve: {
    		loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
    			return $ocLazyLoad.load([
    			                         ]);
    		}]
    	}
    })
    .state('healthInquiryDel', {
        url:'/healthInquiryDel/:contentId',
        templateUrl: 'healthInquiryDel.html',
        controller: 'healthInquiryDelCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/healthInquiryDel.css'
                    ]);
            }]
        }
    })
    .state('notice', {
        url:'/notice/:noticeId',
        templateUrl: 'notice.html',
        controller: 'noticeCtrl',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
                return $ocLazyLoad.load(['css/notice.css'
                    ]);
            }]
        }
    })
    .state('appointInfo', {
    	url:'/appointInfo',
    	templateUrl: 'appointInfo.html',
    	controller: 'appointInfoCtrl',
    	resolve: {
    		loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {  
    			return $ocLazyLoad.load(['css/appointInfo.css'
    			                         ]);
    		}]
    	}
    })
});

app.run(['$rootScope','$resource',function($rootScope,$resource){  
    //$rootScope.s_webUser={};
    //alert("dddsss");
//    $rootScope.ifshow = false;
//    //alert($rootScope.s_webUser.s_username);
//    if($rootScope.s_webUser.s_username=='undefined'){
//    	$rootScope.ifshow = true;
//    	alert("578");
//    }
}]);


app.constant('AUTH_EVENTS', {
	  loginSuccess: 'auth-login-success',
	  loginFailed: 'auth-login-failed',
	  logoutSuccess: 'auth-logout-success',
	  sessionTimeout: 'auth-session-timeout',
	  notAuthenticated: 'auth-not-authenticated',
	  notAuthorized: 'auth-not-authorized'
});
