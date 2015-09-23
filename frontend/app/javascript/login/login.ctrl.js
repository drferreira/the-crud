angular.module('theCrud').controller('LoginCtrl', ['$scope', '$http', function ($scope, $http) {
	
	$scope.contacts = [];

	$scope.login = function () {
		$http.post('rest/user/login', { 
			username: $scope.username,
			password: $scope.password
		}).then(function (response) {
			console.log(response.data);
		}, function (response) {

		});
	}

}]);