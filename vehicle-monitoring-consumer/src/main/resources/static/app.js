var app = angular.module('app', ['ui.grid', 'ui.grid.pagination']);
app.controller('VehicleStatusCtrl', ['$scope', '$interval', 'VehicleStatusService',
    function($scope, $interval, VehicleStatusService) {
        var paginationOptions = {
            page: 1,
            size: 1000,
            sort: null
        };
        VehicleStatusService.getVehicleStatus(
            paginationOptions.page,
            paginationOptions.size).success(function(data) {
            $scope.gridOptions.data = data.content;
            $scope.gridOptions.totalItems = data.totalElements;
        })
        $scope.gridOptions = {
            paginationPageSizes: [5, 10, 20],
            paginationPageSize: paginationOptions.size,
            enableFiltering: true,
            enableColumnMenus: false,
            enableRowHashing: false,
            useExternalPagination: true,
            columnDefs: [
            {
                name: 'customerEntity.customerName',
                displayName: 'Customer ID'
            },
            {
                name: 'vehicleId',
                displayName: 'Vehicle ID',
                enableFiltering: false
            },
            {
                name: 'registrationNo',
                displayName: 'Registration No',
                enableFiltering: false
            },
            {
                name: 'status',
                displayName: 'status'
            }
            ],
            onRegisterApi: function(gridApi) {
                $scope.gridApi = gridApi;
                gridApi.pagination.on.paginationChanged($scope, function(newPage, pageSize) {
                    paginationOptions.page = newPage;
                    paginationOptions.size = pageSize;
                    VehicleStatusService.getVehicleStatus(newPage, pageSize).success(function(data) {
                        $scope.gridOptions.data = data.content;
                        $scope.gridOptions.totalItems = data.totalElements;
                    });
                });
            }
        };
        var socket = new SockJS('/vehicle-status-websocket');
        var stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            stompClient.subscribe('/topic/vehicle-status', function(vehicleData) {
                VehicleStatusService.getVehicleStatus(paginationOptions.page, paginationOptions.size).success(function(data) {
                    $scope.gridOptions.data = data.content;
                    $scope.gridOptions.totalItems = data.totalElements;
                });
            });
        });
        $interval(function() {
            VehicleStatusService.getVehicleStatus(paginationOptions.page, paginationOptions.size).success(function(data) {
                $scope.gridOptions.data = data.content;
                $scope.gridOptions.totalItems = data.totalElements;
            })
        }, 61000);

    }
]);


app.service('VehicleStatusService', ['$http', function($http) {
    function getVehicleStatus(pageNumber, size) {
        pageNumber = pageNumber > 0 ? pageNumber - 1 : 0;
        return $http({
            method: 'GET',
            url: 'v1.0/vehicles?page=' + pageNumber + '&size=' + size
        });
    }
    return {
        getVehicleStatus: getVehicleStatus
    };
}]);