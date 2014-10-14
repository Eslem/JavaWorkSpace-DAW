var app = angular.module("app", []);

function PruebaController($scope) {
    $scope.mensaje = "hola mundo";

    $scope.direccion = {
        nombreVia: "vía",
        pisoPuerta: "1º 15",
        cp: "0000"
    };

    $scope.changeVia = function() {
        $scope.direccion.nombreVia = "Otra via"
    };

    $scope.show = function() {
        $scope.todo = $scope.direccion.nombreVia+" "+$scope.direccion.pisoPuerta+" C.P:"+$scope.direccion.cp;
    };
}