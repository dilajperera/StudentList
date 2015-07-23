angular.module('sms', ['controllers','ngRoute','studentDetail']).
	config(function($routeProvider){
		$routeProvider.when('/profiles',{
			templateUrl:'views/partials/manageStudent.html'
		}).when('/new',{
			templateUrl:'views/partials/addStudent.html'
		}).otherwise('/profiles',{
			templateUrl:'views/partials/manageStudent.html'
		});
	});