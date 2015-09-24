angular.module('theCrud').controller('ContactsListCtrl', ['$scope', '$http', '$window', function ($scope, $http, $window) {
	
	$scope.contacts = [];

	$http.get('rest/contacts/list').success(function (data) {

		$scope.contacts = data;

	}).error(function (error) {

		console.log(error);

	});

	$scope.deleteContact = function (contact) {

		$http.get('rest/contacts/delete/' + contact.id).success(function (data) {

			var contactIndex = $scope.contacts.indexOf(contact);
			$scope.contacts.splice(contactIndex, 1);
			console.log($scope.contacts);
			console.log('Contato (' + contact.id + ') da posição ' + contactIndex + ' deletado!');

		}).error(function (data) {

		});
	}

	$scope.logout = function () {

		$http.get('rest/user/logout').success(function (data) {

			$window.location.href = 'login.html'

		}).error(function (data) {

		});
	}

}]);