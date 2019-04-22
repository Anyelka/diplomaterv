<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="page.title" var="pageTitle"/>
<spring:message code="navbar.title" var="navbarTitle"/>
<spring:message code="navbar.users" var="navbarUsers"/>
<spring:message code="navbar.events" var="navbarEvents"/>
<spring:message code="navbar.language.title" var="navbarLanguage"/>
<spring:message code="navbar.language.english" var="navbarLanguageEng"/>
<spring:message code="navbar.language.hungarian" var="navbarLanguageHun"/>
<spring:message code="navbar.logout" var="navbarLogout"/>
<spring:message code="admin.users.title" var="title"/>
<spring:message code="admin.users.id" var="userId"/>
<spring:message code="admin.users.email" var="email"/>
<spring:message code="admin.users.username" var="username"/>
<spring:message code="admin.users.password" var="password"/>
<spring:message code="admin.users.fullName" var="fullName"/>
<spring:message code="admin.users.accountNumber" var="accountNumber"/>
<spring:message code="admin.users.dateOfBirth" var="dateOfBirth"/>
<spring:message code="admin.users.balance" var="balance"/>
<spring:message code="admin.users.currency" var="currency"/>
<spring:message code="admin.users.edit.button" var="editButton"/>
<spring:message code="admin.users.saveEdit.button" var="saveEditButton"/>
<spring:message code="admin.users.delete.button" var="deleteButton"/>
<spring:message code="admin.users.confirm.delete.button" var="confirmDeleteButton"/>


<html>
<head>
    <title>${pageTitle}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../assets/bootstrap/bootstrap-3.3.7.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../assets/bootstrap/bootstrap-3.3.7.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="../assets/style.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">${navbarTitle}</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="events">${navbarEvents}</a></li>
            <li class="active"><a href="users">${navbarUsers}</a></li>
            <li class="dropdown"><a class="dropdown-toggle"
                                    data-toggle="dropdown" href="#">${navbarLanguage}<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">${navbarLanguageEng}</a></li>
                    <li><a href="#">${navbarLanguageHun}</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<c:url value="/logout"/>">${navbarLogout}</a></li>
        </ul>
    </div>
</nav>
<div class="panel panel-default">

    <div class="panel-heading">${title}</div>
    <div class="panel-body">

        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>${userId}</th>
                    <th>${email}</th>
                    <th>${username}</th>
                    <th>${fullName}</th>
                    <th>${accountNumber}</th>
                    <th>${dateOfBirth}</th>
                    <th>${balance}</th>
                    <th>${currency}</th>
                    <th id="edit"></th>
                    <th id="quitEdit"></th>
                    <th id="remove"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userListView.users}">
                    <tr>
                        <td><p id="${user.id}userId">${user.id}</p>
                        <td><p id="userEmail${user.id}">${user.email}</p>
                            <input type="text" id="inputUserEmail${user.id}" value="${user.email}"
                                   class="form-control hide"/></td>
                        <td><p id="userName${user.id}">${user.username}</p>
                            <input type="text" id="inputUserName${user.id}" value="${user.username}"
                                   class="form-control hide"/></td>
                        <td><p id="userFullName${user.id}">${user.fullName}</p>
                            <input type="text" id="inputUserFullName${user.id}" value="${user.fullName}"
                                   class="form-control hide"/></td>
                        <td><p id="userAccountNumber${user.id}">${user.accountNumber}</p>
                            <input type="text" id="inputUserAccountNumber${user.id}" value="${user.accountNumber}"
                                   class="form-control hide"/></td>
                        <td><p id="userDateOfBirth${user.id}">${user.dateOfBirth}</p>
                            <input type="text" id="inputUserDateOfBirth${user.id}" value="${user.dateOfBirth}"
                                   class="form-control hide"/></td>
                        <td><p id="userBalance${user.id}">${user.balance}</p>
                            <input type="text" id="inputUserBalance${user.id}" value="${user.balance}"
                                   class="form-control hide"/></td>
                        <td><p id="userCurrency${user.id}">${user.currency}</p>
                            <input type="text" id="inputUserCurrency${user.id}" value="${user.currency}"
                                   class="form-control hide"/></td>
                        <td>
                            <button id="editUserButton${user.id}" class="btn btn-primary"
                                    type="button">${editButton}</button>
                            <button id="saveEditUserButton${user.id}" class="btn btn-primary hide"
                                    type="button">${saveEditButton}</button>
                        </td>
                        <td>
                            <button id="quitEditUserButton${user.id}" class="btn btn-primary hide"
                                    type="button">&times;</button>
                        </td>
                        <td>
                            <input type="hidden" id="deleteUserUsername${user.id}" value="${user.username}"/>
                            <button id="deleteUserButton${user.id}" class="btn btn-primary"
                                    type="button" data-toggle="modal"
                                    data-target="#deleteUserModal">${deleteButton}</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    <!-- Delete user modal-->
    <div id="deleteUserModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <div class="modal-content">
                <div id="deleteUserModalHeader" class="modal-header">
                    <button id="closeDeleteUserModalButton" type="button" class="close" data-dismiss="modal">&times;
                    </button>
                    <h4 id="deleteUserModalText" class="modal-title"></h4>
                </div>
                <div id="deleteUserModalBody" class="modal-body">
                    <button id="confirmDeleteUserButton" type="button" class="btn btn-primary">
                        ${confirmDeleteButton}</button>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="../../resources/js/users.js" type="text/javascript"></script>
</body>
</html>
