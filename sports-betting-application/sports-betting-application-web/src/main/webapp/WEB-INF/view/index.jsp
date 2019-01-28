<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="index.header.major" var="headerMajor"></spring:message>
<spring:message code="index.header.minor" var="headerMinor"></spring:message>
<spring:message code="index.title.login.label" var="titleLogin"></spring:message>
<spring:message code="index.title.or" var="titleOr"></spring:message>
<spring:message code="index.title.register.label" var="titleRegister"></spring:message>
<spring:message code="index.title.toStart" var="titleToStart"></spring:message>
<spring:message code="index.loginbox.login.button" var="loginboxLogin"></spring:message>
<spring:message code="index.loginbox.password.placeholder" var="loginboxPassword"></spring:message>
<spring:message code="index.loginbox.username.placeholder" var="loginboxUsername"></spring:message>

<html>
<head>
    <jsp:include page="../assets/include.jsp"/>
</head>
<body>
<div class="jumbotron text-center">
    <h1>${headerMajor}</h1>
    <p>${headerMinor}</p>
</div>

<div class="container">
    <div class="row login-header">
        <h2>
            <em>${titleLogin}</em> ${titleOr} <em><a href="register.html">${titleRegister}</a></em> ${titleToStart}
        </h2>
        <div></div>
    </div>

    <div class="row">
        <div class="panel panel-default login-panel">
            <div class="panel-heading">${loginboxLogin}</div>
            <div class="panel-body">
                <form:form modelAttribute="loginRequest" class="form-horizontal"
                           action="login">
                    <form:errors element="div"/>
                    <div class="form-group col-xs-12">
                        <form:input path="username" class="form-control"
                                    placeholder="${loginboxPassword}"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="password" class="form-control"
                                    placeholder="${loginboxUsername}"/>
                    </div>
                    <button type="submit" class="btn btn-default">Login</button>
                </form:form>
            </div>


        </div>

    </div>
</div>

</body>
</html>
