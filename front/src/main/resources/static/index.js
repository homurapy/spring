angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/store/api/v1';

    $scope.saveProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath + '/product', $scope.NewProduct)
            .then(function (resp){
                $scope.NewProduct = null
                $scope.fillTable();
            })

    };
    $scope.saveProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath + '/product', $scope.NewProduct)
            .then(function (resp){
                $scope.NewProduct = null
                $scope.fillTable();
            })

    };

    $scope.fillTable = function () {
        $http({
            url: contextPath + '/product',
            method: 'GET',
            params: {
                'title': $scope.filter ? $scope.filter.title : null,
                'price': $scope.filter ? $scope.filter.price : null
            }
        }).then(function (response) {
            $scope.Products = response.data;
        });
    };

    $scope.fillTable();
});