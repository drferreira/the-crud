angular.module('theCrud').controller('NewContactCtrl', ['$scope', '$http', '$window', function ($scope, $http, $window) {
	
	$scope.save = function () {

		$http.post('rest/contacts/add', { 

			name: $scope.name,
			phone: $scope.phone

		}).then(function (response) {

			$window.location.href = 'contacts.html'

		}, function (response) {

			console.log(response);
			console.log('Erro');

		});
	}

	$scope.cancel = function () {
		$window.location.href = 'contacts.html'
	}

}]);