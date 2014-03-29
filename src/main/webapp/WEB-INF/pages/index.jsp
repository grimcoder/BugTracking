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

        showList = function () {
            $('#bugList').show();
            $('#bugForm').hide();
        };

        showEdit = function () {
            $('#bugList').hide();
            $('#bugForm').show();
        };

        $(document).ready(
            function(){

                $('#newBug').on('click', showEdit);

                $('#listLink').on('click', showList);
            }
        );

    </script>
</head>

<body style="margin: 20px" ng-controller="usersController">

<h1>Bug tracker</h1>
<div style="height: 50px; width: 100%; background: orangered;">
</div>

<div>
    <a style="font-size: x-large" href="#" id="newBug"> <span>Bug</span></a>&nbsp; |&nbsp;
    <a style="font-size: x-large" ng-click="readBugs();" id="listLink" href="#"><span>List</span></a>

<span style="display:block; width: 400;" id="bugForm">


    <table>
        <tr></tr>
        <td width="100px">
            <h4>Id</h4>
        </td>
        <td width="250px">
            <input id="bugId" disabled ng-model="selectedBug.Id">
        </td>

        <tr></tr>
        <td>
            <h4>Priority</h4>
        </td>
        <td>
            <select ng-model="selectedBug.Priority">
                <option value="High">High</option>
                <option value="Medium">Medium</option>
                <option value="Low">Low</option>
            </select>
        </td>

        <tr></tr>
        <td>
            <h4>Assignee</h4>
        </td>
        <td>
            <input id="assignee"  ng-model="selectedBug.Assignee">
        </td>

        <tr></tr>

        <td>
            <h4>Summary</h4>
        </td>
        <td>
            <input id="bugSummary"  ng-model="selectedBug.Summary">
        </td>

        <tr></tr>
        <td>
            <h4>Description</h4>
        </td>
        <td>
            <input id="bugDescription"  ng-model="selectedBug.Description">
        </td>


        <tr></tr>

        <td>
            <h4>Status</h4>
        </td>

        <td>
            <select ng-model="selectedBug.Status">
                <option value="Open">Open</option>
                <option value="Close">Closed</option>
            </select>

        </td>


        <tr></tr>

    </table>

    <br>

    <button id="createButton" value="Create/Edit" ng-click="createUpdateBug();"  >Submit</button>

</span>

<span style="display:none; float: left;" id="bugList">
    Show only open bugs <input ng-model="onlyOpen" type="checkbox" id="onlyOpen">
    <ul>
        <li ng-repeat="bug in bugs | filter:searchIfOpen() ">
            <a ng-click="edit(bug);" style="font-size: x-large" href="#"> {{bug.Id}} {{bug.Summary}}</a>
        </li>
    </ul>
</span>

</div>

</body>

</html>