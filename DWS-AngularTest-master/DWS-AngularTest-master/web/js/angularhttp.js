/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var app = angular.module("app", []);
/*
 app.controller("EntidadBancariaController", ['$scope', '$log', '$http', function($scope, $log, $http) {
 
 $scope.entidadBancaria = {
 idEntidadBancaria: 0,
 nombre: "Nombre",
 codigoEntidad: "0000",
 fechaCreacion: ""
 }
 
 var config = {
 method: "GET",
 url: "get.json.jsp?idEntidadBancaria=1"
 }
 
 var response = $http(config);
 
 response.success(function(data, status, headers, config) {
 $scope.entidadBancaria = data;
 });
 }]);
 */
function remoteResourceProvider() {
    var _baseUrl;
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new RemoteResource($http, _baseUrl);
        }];
}

function deleteEntidadProvider() {
    var _baseUrl;
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new DeleteEntidad($http, _baseUrl);
        }];
}


function updateEntidadProvider() {
    var _baseUrl;
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new UpdateEntidad($http, _baseUrl);
        }];
}

function DeleteEntidad($http, baseUrl) {
    this.get = function (fnOk, fnError) {
        $http({
            method: 'GET',
            url: baseUrl + '/delete.json.jsp?idEntidadBancaria=1'
        }).success(function (data) {
            fnOk(data);
        }).error(function (data, status) {
            fnError(data, status);
        });
    };
}

function UpdateEntidad($http, baseUrl) {
    this.get = function (nombre, codigoEntidad, fnOk, fnError) {
        $http({
            method: 'POST',
            url: baseUrl + '/update.json.jsp?idEntidadBancaria=1&nombre=' + nombre + '&codigoEntidad=' + codigoEntidad
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };
}

function RemoteResource($http, baseUrl) {
    this.get = function (fnOk, fnError) {
        $http({
            method: 'GET',
            url: baseUrl + '/get.json.jsp?idEntidadBancaria=1'
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };
}

app.constant("baseUrl", ".");
app.provider("remoteResource", remoteResourceProvider);
app.provider("deleteEntidad", deleteEntidadProvider);
app.provider("updateEntidad", updateEntidadProvider);

app.config(['baseUrl', 'remoteResourceProvider', 'deleteEntidadProvider', 'updateEntidadProvider', function (baseUrl, remoteResourceProvider, deleteEntidadProvider, updateEntidadProvider) {
        remoteResourceProvider.setBaseUrl(baseUrl);
        deleteEntidadProvider.setBaseUrl(baseUrl);
        updateEntidadProvider.setBaseUrl(baseUrl);
    }]);

app.controller("EntidadBancariaController", ['$scope', 'remoteResource', 'deleteEntidad', 'updateEntidad', function ($scope, remoteResource, deleteEntidad, updateEntidad) {
        $scope.loading = true;

        $scope.entidadBancaria = {
            idEntidadBancaria: 0,
            nombre: "Nombre",
            codigoEntidad: "0000",
            fechaCreacion: ""
        };

        remoteResource.get(function (data) {
            $scope.entidadBancaria = data;
            $scope.loading = false;
        }, function (data, status) {
            alert("Error en peticion, error: " + status);
            $scope.loading = false;
        });

        $scope.delete = function () {
            $scope.loading = true;
            deleteEntidad.get(function (data) {
                alert("Se ha eliminado correctamente");
                $scope.loading = false;
            }, function (data, status) {
                $scope.loading = false;
                alert("Error en peticion, error: " + status);

            });
        };

        $scope.update = function () {
            $scope.loading = true;
            updateEntidad.get($scope.entidadBancaria.nombre, $scope.entidadBancaria.codigoEntidad, function (data) {
                $scope.entidadBancaria = data;
                $scope.loading = false;
                alert("Entidad actualizada correctmente");
            }, function (data, status, error) {
                alert("Error en peticion, error: " + error);
                $scope.loading = false;
            });
        };


    }]);
