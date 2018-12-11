<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>SportsBet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../assets/bootstrap/bootstrap-3.3.7.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../assets/bootstrap/bootstrap-3.3.7.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../assets/style.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">SportsBetting</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="admin_events.html">Events</a></li>
            <li class="active"><a href="admin_users.html">Users</a></li>
            <li class="dropdown"><a class="dropdown-toggle"
                                    data-toggle="dropdown" href="#">Language <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">English</a></li>
                    <li><a href="#">Hungarian</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="index.html">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="panel panel-default">
    <div class="panel-heading">Users</div>
    <div class="panel-body">

        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Full name</th>
                    <th>Account number</th>
                    <th>Date of birth</th>
                    <th>Balance</th>
                    <th>Currency</th>
                    <th id="edit"></th>
                    <th id="remove"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userListView.users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.email}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.fullName}</td>
                        <td>${user.accountNumber}</td>
                        <td>${user.dateOfBirth}</td>
                        <td>${user.balance}</td>
                        <td>${user.currency}</td>
                        <td>
                            <button id="editUserButton" class="btn btn-primary" type="button">Edit</button>
                        </td>
                        <td>
                            <button id="deleteUserButton" class="btn btn-primary" type="button">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    <script src="../../resources/js/users.js" type="text/javascript"></script>
</body>
</html>
