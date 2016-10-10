angular.module('eWUS').controller('PersonListController',
		[ '$scope', 'personFactory', function($scope, personFactory) {

			$scope.people = personFactory.people().query();

		} ]).controller('PersonViewController',
		[ '$scope', '$routeParams', 'personFactory', function($scope, $routeParams, personFactory) {

			$scope.person = personFactory.people().get({id:$routeParams.id});

		} ]).controller('PersonEditController',
		[ '$scope', '$routeParams', 'personFactory', function($scope, $routeParams, personFactory) {
			
			personFactory.people().get({id:$routeParams.id}, function(user){
					user.$save();
				});
		
		} ]).controller('PersonAddController',
		[ '$scope', '$routeParams', 'personFactory', function($scope, $routeParams, personFactory) {
			
			//TODO Create add method
			
		} ]).controller('PersonDetailsViewController',
		[ '$scope', '$routeParams', 'personFactory', function($scope, $routeParams, personFactory) {
			
			$scope.person = personFactory.personDetails().get({id:$routeParams.id});
			
		} ]);