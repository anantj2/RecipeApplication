var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider,$httpProvider){
    $routeProvider
        .when('/recipes',{
            templateUrl: '/views/recipelist.html',
            controller: 'getRecipeController'
        })
        .when('/recipes/add',{
            templateUrl: '/views/addrecipe.html',
            controller: 'addRecipeController'
        })
        .when('/recipes/update',{
            templateUrl: '/views/updaterecipelist.html',
            controller: 'updateRecipeController'
        })
        .when('/recipes/delete',{
            templateUrl: '/views/deleterecipelist.html',
            controller: 'deleteRecipeController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

