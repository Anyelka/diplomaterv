<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="../assets/include.jsp"/>
    <%--Datepicker--%>
    <%--<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">--%>
    <%--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
    <%--<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
    <%--<script>--%>
    <%--$(function () {--%>
    <%--$("#datepicker").datepicker();--%>
    <%--});--%>
    <%--</script>--%>
    <%--Datepicker--%>
</head>
<body>

<div class="container">

    <div class="row">
        <div class="panel panel-default registration-panel center-block">

            <div class="panel-heading">
                <p>Create an account!</p>
            </div>

            <div class="panel-body">
                <form:form modelAttribute="registrationRequest" class="form-horizontal"
                           action="sendRegistrationRequest">
                    <div class="form-group col-xs-12">
                        <form:input path="email" id="email" class="form-control"
                                    placeholder="E-mail"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="username" id="username" class="form-control"
                                    placeholder="Username"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="password" id="password" class="form-control"
                                    placeholder="Password"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="fullName" id="fullName" class="form-control"
                                    placeholder="Full Name"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="accountNumber" id="accountNumber" class="form-control"
                                    placeholder="Account Number"/>
                    </div>
                    <div class="form-group col-xs-12">
                        <label>Currency</label>
                        <form:select path="currency" id="currency" class="form-control">
                            <form:option value="HUF"/>
                            <form:option value="EUR"/>
                            <form:option value="GBP"/>
                        </form:select>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="dateOfBirth" id="dateOfBirth" class="form-control"
                                    placeholder="Date Of Birth"/>
                    </div>

                    <div id="registrationErrorDiv" class="form-group col-xs-12">
                            <p id="registrationErrorText"></p>
                    </div>

                    <button id="registerButton" type="button" class="btn">Register</button>
                    <button type="button" onclick="window.location.href='index.html'"
                            class="btn btn-secondary pull-right">
                        Back to login page
                    </button>

                </form:form>

            </div>


        </div>
    </div>
    <script src="../../resources/js/register.js" type="text/javascript"></script>
</div>

</body>
</html>