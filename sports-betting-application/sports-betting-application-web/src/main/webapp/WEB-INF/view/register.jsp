<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="register.title" var="title"></spring:message>
<spring:message code="register.email.placeholder" var="email"></spring:message>
<spring:message code="register.username.placeholder" var="username"></spring:message>
<spring:message code="register.password.placeholder" var="password"></spring:message>
<spring:message code="register.fullName.placeholder" var="fullName"></spring:message>
<spring:message code="register.accountNumber.placeholder" var="accountNummber"></spring:message>
<spring:message code="register.currency.label" var="currency"></spring:message>
<spring:message code="register.dateOfBirth.placeholder" var="dateOfBirth"></spring:message>
<spring:message code="register.register.button" var="registerButton"></spring:message>
<spring:message code="register.back.button" var="backButton"></spring:message>

<html>
<head>
    <jsp:include page="../assets/include.jsp"/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker({
                changeMonth: true,
                changeYear: true
            });
        });
    </script>
</head>
<body>

<div class="container">

    <div class="row">
        <div class="panel panel-default registration-panel center-block">

            <div class="panel-heading">
                <p>${title}</p>
            </div>

            <div class="panel-body">
                <form:form modelAttribute="registrationRequest" class="form-horizontal"
                           action="sendRegistrationRequest">
                    <div class="form-group col-xs-12">
                        <form:input path="email" id="email" class="form-control"
                                    placeholder="${email}"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="username" id="username" class="form-control"
                                    placeholder="${username}"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="password" id="password" class="form-control"
                                    placeholder="${password}"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="fullName" id="fullName" class="form-control"
                                    placeholder="${fullName}"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="accountNumber" id="accountNumber" class="form-control"
                                    placeholder="${accountNummber}"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <label>${currency}</label>
                        <form:select path="currency" id="currency" class="form-control">
                            <form:option value="HUF"/>
                            <form:option value="EUR"/>
                            <form:option value="GBP"/>
                        </form:select>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="dateOfBirth" type="text" id="datepicker" class="form-control"
                                    placeholder="${dateOfBirth}"/>
                    </div>

                    <button id="registerButton" type="button" class="btn">${registerButton}</button>
                    <button type="button" onclick="window.location.href='index.html'"
                            class="btn btn-secondary pull-right">
                            ${backButton}
                    </button>

                </form:form>

            </div>


        </div>
    </div>
    <script src="../../resources/js/register.js" type="text/javascript"></script>
</div>

</body>
</html>
