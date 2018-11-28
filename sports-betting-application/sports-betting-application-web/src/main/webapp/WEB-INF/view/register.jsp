<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>SportsBet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="assets\bootstrap\bootstrap.css">
    <link rel="stylesheet" href="assets\style.css">
    <script src="assets\bootstrap\bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <%--Datepicker--%>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
    <%--Datepicker--%>
</head>
<body>

<div class="container">

    <div class="row">
        <div class="panel panel-default login-panel">
            <div class="panel-heading">Create an account!</div>
            <div class="panel-body">
                <form:form modelAttribute="registrationRequest" class="form-horizontal"
                           action="sendRegistrationRequest">
                    <form:errors element="div"/>
                    <div class="form-group col-xs-12">
                        <form:input path="email" class="form-control"
                                    placeholder="E-mail" />
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="username" class="form-control"
                                    placeholder="Username" />
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="password" class="form-control"
                                    placeholder="Password" />
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="fullName" class="form-control"
                                    placeholder="Full Name" />
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="accountNumber" class="form-control"
                                    placeholder="Account Number" />
                    </div>
                    <div class="form-group col-xs-12">
                        <label>Currency</label>
                        <form:select path="currency" class="form-control">
                            <form:option value="HUF"/>
                            <form:option value="EUR"/>
                            <form:option value="GBP"/>
                        </form:select>
                    </div>
                    <div class="form-group col-xs-12">
                        <form:input path="dateOfBirth" class="form-control"
                                    placeholder="Date Of Birth" id="datepicker"/>
                    </div>
                    <button type="submit" class="btn btn-default">Register</button>
                </form:form>
            </div>


        </div>

    </div>
</div>

</body>
</html>