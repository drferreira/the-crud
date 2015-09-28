angular.module('theCrud').controller('LoginCtrl', ['$scope', '$http', '$window', function ($scope, $http, $window) {
	
	$scope.tituloForm = 'Faz login mano';

	$scope.login = function () {

		$http.post('session/rest/user/login', { 

			username: $scope.email,
			password: $scope.password

		}).then(function (response) {
		
			$window.location.href = 'session/contacts.html'

		}, function (response) {

			console.log(response);
			console.log('Erro');

		});
	}

}]);