<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>SportsBet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="assets\bootstrap\bootstrap.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="assets\bootstrap\bootstrap.js"></script>
    <link rel="stylesheet" href="assets\style.css">
</head>
<body>

<div class="container">

    <div class="row">
        <div class="panel panel-default login-panel">
            <div class="panel-heading">Login</div>
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
                    <button type="submit" class="btn btn-default">Register</button>
                </form:form>
            </div>


        </div>

    </div>
</div>

</body>
</html>