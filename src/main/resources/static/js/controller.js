app.controller('getRecipeController', function($scope,$http) {
    $scope.headingTitle = "Recipes List";
    $http.get('/recipes', { cache: false}).then(
            function(responseData){
            	$scope.y = responseData.data;            	
            });
});

app.controller('addRecipeController', function($scope,$http,$filter,$location,$window) {	
	$scope.headingTitle = "Add recipe";
	$scope.createDateTime = $filter('date')(new Date(), 'dd‐MM‐yyyy HH:mm');
    $scope.addRecipe = function(data1,data2,data3,data4,data5){  
		var recipeJson = {createDateTime:new Date(),dishType:data2,noOfPeople:data3,ingredient:data4,instructions:data5}; 
    $http.post('/recipes', JSON.stringify(recipeJson)).then(function (response) {
    	if(response.status == 200){
    		alert("Recipe added successfully !!");
    		window.location= "#/recipes";
    		
    	}else if(response.status == 500){	
    		alert("Technical error occurred !!");
    	}
    	
    });
    }
});

app.controller('updateRecipeController', function($scope,$http,$location,$window) {	
	$scope.headingTitle = "Update recipe";
	$http.get('/recipes', { cache: false}).then(
            function(responseData){
            	$scope.y = responseData.data;
            });
	
    $scope.updateRecipe = function(data1,data2,data3,data4,data5,data6){
		var recipeJson = {createDateTime:new Date(),dishType:data2,noOfPeople:data3,ingredient:data4,instructions:data5,id:data6};
		
    $http.put("/recipes/", JSON.stringify(recipeJson)).then(function (response) {
    	if(response.status == 200){
    		alert("Recipe updated successfully !!");
    		window.location= "#/recipes";
    	}else if(response.status == 500){	
    		alert("Technical error occurred !!");
    	}
    	
    });
    }
});

app.controller('deleteRecipeController', function($scope,$http,$location,$window) {	
	$scope.headingTitle = "Delete recipe";
	$http.get('/recipes', { cache: false}).then(
            function(responseData){
            	$scope.y = responseData.data;
            });
    $scope.deleteRecipe = function(id){
    	
    	var url = "/recipes/"+id;
    $http.delete(url).then(function (response) {
    	if(response.status == 200){
    		alert("Recipe deleted successfully !!");
    		window.location= "#/recipes";
    	}else if(response.status == 500){	
    		alert("Technical error occurred !!");
    	}
    });
    }
});
