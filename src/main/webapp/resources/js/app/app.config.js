angular.module('eWUS').config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/register', {
		templateUrl : "resources/pages/register.html",
	}).when('/login', {
		templateUrl : "resources/pages/login.html"
	}).when('/people', {
		templateUrl : "resources/pages/people.html",
		controller : "PersonListController"
	}).when('/people/:id', {
		templateUrl : "resources/pages/person.html",
		controller : "PersonViewController"
	}).when('/people/:id/details', {
		templateUrl : "resources/pages/details.html",
		controller : "PersonDetailsViewController"
	});
} ]);