angular.module('theCrud').controller('Controller', function ($scope, $http) {
	
	$scope.contacts = [];

	$http.get('rest/contacts').success(function (data) {
		$scope.contacts = data;
	}).error(function (error) {
		console.log(error);
	});

	$scope.login = function () {
		$http.post('rest/user/login', { 
			username: $scope.email,
			password: $scope.password
		}).then(function (response) {
			console.log(response);
			console.log($scope.email);
		}, function (response) {
			console.log(response);
			console.log('Erro');
		});
	}

	$scope.deleteContact = function (contact) {
		$http.get('rest/contacts/delete/' + contact.id)
		.success(function (data) {
			var contactIndex = $scope.contacts.indexOf(contact);
			$scope.contacts.splice(contactIndex, 1);
			console.log($scope.contacts);
			console.log('Contato (' + contact.id + ') da posição ' + contactIndex + ' deletado!');
		})
		.error(function (data) {

		});
	}

});