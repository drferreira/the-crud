var app = angular.module('theCrud', ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {

	$locationProvider.html5Mode({ enabled: true });

	$routeProvider.when('/', {
		templateUrl: 'login-form.html',
		controller: 'LoginCtrl'
	}).when('/contacts', {
		templateUrl: '/contacts.html',
		controller: 'ContactsCtrl'
	}).otherwise({ redirectTo: '/' });

});