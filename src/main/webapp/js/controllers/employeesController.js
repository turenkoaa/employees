var employeesApp = angular.module("purchaseApp", ["ngTable"]);
employeesApp.controller("employeesController", function ($scope, $http, NgTableParams) {

    $http.get("/employees").then(function (data) {
        $scope.tableParams = new NgTableParams({}, { dataset: data.data});
    });

    $http.get("/companies").then(function (response) {
        $scope.companies = response.data;
        console.log($scope.companies);
    });

    $http.get("/posts").then(function (response) {
        $scope.posts = response.data;
        console.log($scope.posts);
    });

    $scope.submit_form = function()
    {
        console.log(JSON.stringify($scope.form))
        $http({
            url: "/save_employees",
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            data: $scope.form
        }).success(function(data, status, headers, config) {
            $scope.tableParams.reload();
            $( "#emptable" ).load( "your-current-page.html #empTable" );
        }).error(function(data, status, headers, config) {
            console.log(status);
            alert(data.message);

        });

        $scope.status = status;
        $scope.form = "";
    }

});