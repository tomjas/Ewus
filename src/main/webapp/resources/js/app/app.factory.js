angular.module('eWUS').factory('personFactory',
		[ '$resource', function($resource) {

			var baseUrl = "/eWUS/people";
			var factory = {};

			factory.people = function() {
				return $resource(baseUrl + "/:id", {id:'@id'});
			};
			
			factory.personDetails = function() {
				return $resource(baseUrl + "/:id/details", {id:'@id'});
			};

			return factory;
		} ]);