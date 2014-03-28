<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html ng-app="usersApp">
<head>
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <link rel="stylesheet" href="static/css/bootstrap-theme.css">
    <script src="static/js/jquery-2.1.0.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>


    <script src="static/js/angular.min.js"></script>

    <script src="static/js/angularcontroller.js"></script>

    <script>

        $(document).ready(
            function(){


                $('#createButton').on('click', function(){
                    alert('a');
                    $.ajax(
                            {
                                url: 'createbug',
                                type: 'POST',
                                dataType: 'json',
                                data: '{}'

                            }
                    );
                });

            }
        );

    </script>
</head>

<body style="margin: 20px" ng-controller="usersController">

<h1>Bug tracker</h1>
<div style="height: 50px; width: 100%; background: orangered;">
    <div   style="margin: 10px; visibility: hidden;">&nbsp;<br>
	<span style="cursor: pointer; color: #ffffff" id="submitBug">Submit Bug</span> | <span style="cursor: pointer; color: #ffffff" id="bugList">Bugs</span>
    </div>
</div>

<div>

<span style="display:block; width: 400; float: left; " id="bug">
    <h3 ng-model="test">Bug</h3>

    <table>
        <tr></tr>
        <td width="100px">
            <h4>Id</h4>
        </td>
        <td width="250px">
            <input id="bugId" disabled ng-model="selectedUser.Id">
        </td>

        <tr></tr>
        <td>
            <h4>Status</h4>
        </td>
        <td>
            <input id="bugStatus" ng-model="selectedUser.Status">
        </td>

        <tr></tr>
        <td>
            <h4>Priority</h4>
        </td>
        <td>
            <input id="bugPriority"  ng-model="selectedUser.Priority">
        </td>

        <tr></tr>
        <td>
            <h4>Assignee</h4>
        </td>
        <td>
            <input id="assignee"  ng-model="selectedUser.Assignee">
        </td>

        <tr></tr>
        <td>
            <h4>Summary</h4>
        </td>
        <td>
            <input id="bugSummary"  ng-model="selectedUser.Summary">
        </td>

        <tr></tr>
        <td>
            <h4>Description</h4>
        </td>
        <td>
            <input id="bugDescription"  ng-model="selectedUser.Description">
        </td>
        <tr></tr>

    </table>

    <br>

    <button id="createButton" value="Create/Edit" ng-click="createUpdateBug();"  >Submit</button>

</span>

<span style="display:none; float: left;" id="list">
    <h2>List</h2>
    <div id="placeholder"></div>
</span>

</div>

</body>

</html>