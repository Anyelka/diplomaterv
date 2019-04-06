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


<html>
<head>
    <title>${pageTitle}</title>
    <jsp:include page="../assets/include.jsp"/>
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

    <div id="responseDiv">
        <p id="responseText"></p>
    </div>


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
                    <th id="remove"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userListView.users}">
                    <tr>
                        <td><p id="${user.id}userId">${user.id}</p>
                        <td><p id="userEmail${user.id}">${user.email}</p>
                            <input type="text" id="inputUserEmail${user.id}" value="${user.email}" class="form-control hide"/></td>
                        <td><p id="userName${user.id}">${user.username}</p>
                            <input type="text" id="inputUserName${user.id}" value="${user.username}" class="form-control hide"/></td>
                        <td><p id="userFullName${user.id}">${user.fullName}</p>
                            <input type="text" id="inputFullName${user.id}" value="${user.fullName}" class="form-control hide"/></td>
                        <td><p id="userAccountNumber${user.id}">${user.accountNumber}</p>
                            <input type="text" id="inputUserAccountNumber${user.id}" value="${user.accountNumber}" class="form-control hide"/></td>
                        <td><p id="userDateOfBirth${user.id}">${user.dateOfBirth}</p>
                            <input type="text" id="inputUserDateOfBirth${user.id}" value="${user.dateOfBirth}" class="form-control hide"/></td>
                        <td><p id="userBalance${user.id}">${user.balance}</p>
                            <input type="text" id="inputUserBalance${user.id}" value="${user.balance}" class="form-control hide"/></td>
                        <td><p id="userCurrency${user.id}">${user.currency}</p>
                            <input type="text" id="inputUserCurrency${user.id}" value="${user.currency}" class="form-control hide"/></td>
                        <td>
                            <button id="editUserButton${user.id}" class="btn btn-primary"
                                    type="button">${editButton}</button>
                            <button id="saveEditUserButton${user.id}" class="btn btn-primary hide"
                                    type="button">${saveEditButton}</button>
                        </td>
                        <td>
                            <button id="deleteUserButton${user.id}" class="btn btn-primary"
                                    type="button">${deleteButton}</button>
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
