var usersApp = angular.module('usersApp', []);

usersApp.controller('usersController', function($scope){

    $scope.users = [];
    $scope.selectedUser = {"Id":0,"Status":"some status","Priority":"some priority","Assignee":"some Assignee","Summary":"some summary","Description":"some 3ption","IsOpen":true};


    $scope.createUpdateBug = function(){
//        var request = $.ajax(
//            {
//                url: 'createbug',
//                type: 'POST',
//                dataType: 'json',
//                data: JSON.stringify($scope.selectedUser)
//
//            }
//        );
//
//
//        request.done(function(){
//            alert('back');
//        });

    };

});


