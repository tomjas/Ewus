angular.module('menu',[])
.controller('menuCtrl', function($scope, $http) {
	$http.get('resources/menu.json').success(function(d){
		$scope.menu = d;
		$scope.links = d.links
	})
});