<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
<spring:message code="admin.users.delete.button" var="deleteButton"/>


<html>
<head>
    <jsp:include page="../assets/include.jsp"/>
    <jsp:include page="../assets/navbar.jsp"/>
</head>
<body>
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
                    <th>${password}</th>
                    <th>${fullName}</th>
                    <th>${accountNumber}</th>
                    <th>${dateOfBirth}</th>
                    <th>${balance}</th>
                    <th>${currency}</th>
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
                            <button id="editUserButton" class="btn btn-primary" type="button">${editButton}</button>
                        </td>
                        <td>
                            <button id="deleteUserButton" class="btn btn-primary" type="button">${deleteButton}</button>
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
