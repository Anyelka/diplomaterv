<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="navbar.title" var="title"></spring:message>
<spring:message code="navbar.home" var="home"></spring:message>
<spring:message code="navbar.events" var="events"></spring:message>
<spring:message code="navbar.language.title" var="language"></spring:message>
<spring:message code="navbar.language.english" var="languageEng"></spring:message>
<spring:message code="navbar.language.hungarian" var="languageHun"></spring:message>
<spring:message code="navbar.logout" var="logout"></spring:message>

<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">${title}</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="player/home">${home}</a></li>
            <li><a href="player/events">${events}</a></li>
            <li class="dropdown"><a class="dropdown-toggle"
                                    data-toggle="dropdown" href="#">${language}<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">${languageEng}</a></li>
                    <li><a href="#">${languageHun}</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/index">${logout}</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
