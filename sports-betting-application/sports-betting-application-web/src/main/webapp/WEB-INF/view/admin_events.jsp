<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="page.title" var="pageTitle"></spring:message>
<spring:message code="navbar.title" var="navbarTitle"></spring:message>
<spring:message code="navbar.users" var="navbarUsers"></spring:message>
<spring:message code="navbar.events" var="navbarEvents"></spring:message>
<spring:message code="navbar.language.title" var="navbarLanguage"></spring:message>
<spring:message code="navbar.language.english" var="navbarLanguageEng"></spring:message>
<spring:message code="navbar.language.hungarian" var="navbarLanguageHun"></spring:message>
<spring:message code="navbar.logout" var="navbarLogout"></spring:message>
<spring:message code="events.events.title" var="eventsTitle"></spring:message>
<spring:message code="events.modal.stake" var="modalStake"></spring:message>
<spring:message code="events.modal.save.button" var="modalSave"></spring:message>
<spring:message code="events.admin.generateResults" var="generateResults"></spring:message>

<html>
<head>
    <title>${pageTitle}</title>
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
            <a class="navbar-brand" href="#">${navbarTitle}</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="admin_events.html">${navbarEvents}</a></li>
            <li><a href="admin_users.html">${navbarUsers}</a></li>
            <li class="dropdown"><a class="dropdown-toggle"
                                    data-toggle="dropdown" href="#">${navbarLanguage} <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">${navbarLanguageEng}</a></li>
                    <li><a href="#">${navbarLanguageHun}</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="index.html">${navbarLogout}</a></li>
        </ul>
    </div>
</nav>

<div class="panel panel-default">
    <div class="panel-heading">${eventsTitle}</div>
    <div class="panel-body">


        <div id="accordion">

            <c:forEach var="sportEventModel" items="${listEventsModel.events}">

                <c:if test="${!sportEventModel.ended}">
                    <div class="card">
                        <div class="card-header">
                            <a class="card-link" data-toggle="collapse"
                               href="#event${sportEventModel.id}">
                                    ${sportEventModel.title} - ${sportEventModel.startDate}</a>
                        </div>
                        <div id="event${sportEventModel.id}" class="collapse"
                             data-parent="#accordion">
                            <div class="card-body">

                                <c:forEach var="betModel" items="${sportEventModel.bets}">

                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse"
                                               href="#bet${betModel.id}"> ${betModel.description} </a>
                                        </div>
                                        <div id="bet${betModel.id}" class="collapse"
                                             data-parent="#${sportEventModel.id}">
                                            <div class="card-body">
                                                <div class="btn-group btn-group-justified">

                                                    <c:forEach var="outcomeModel" items="${betModel.outcomes}">
                                                        <div id="accordion" class="btn-group">
                                                            <div class="card">
                                                                <div>
                                                                    <p>${outcomeModel.value} ${outcomeModel.odd}</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:forEach>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>

                            </div>
                        </div>
                    </div>
                </c:if>

            </c:forEach>


        </div>

        <div>
            <button id="generateResultsButton" type="button" class="btn btn-danger">${generateResults}</button>
        </div>

    </div>
</div>
<script src="../../resources/js/generate-results.js" type="text/javascript"></script>
</body>
</html>
