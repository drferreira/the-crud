angular.module('theCrud').controller('Controller', function ($scope, $http) {
	
	$scope.contacts = [];

	$http.get('rest/contacts')
	.success(function (data) {
		$scope.contacts = data;
	})
	.error(function (error) {
		console.log(error);
	});

});