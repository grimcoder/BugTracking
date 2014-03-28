var usersApp = angular.module('usersApp', []);

usersApp.controller('usersController', function($scope){

    $scope.bugs = [];

    function resetSelectedBug() {
        $scope.selectedBug = {Id:'0', Status: ''};
    }

    resetSelectedBug();

    $scope.createUpdateBug = function(){

        $.ajax(
            {
                url: 'createbug',
                type: 'POST',
                contentType: "application/json",
                dataType: 'json',
                data: JSON.stringify($scope.selectedBug)
            }
        );


        resetSelectedBug();


    };

    $scope.readBugs = function(){
        $.ajax(
            {
                url: 'allbugs',
                type: 'GET',
                success: function(data){
                    $scope.bugs = data;
                    $scope.$apply();
                }

            }
        );
    };

});


