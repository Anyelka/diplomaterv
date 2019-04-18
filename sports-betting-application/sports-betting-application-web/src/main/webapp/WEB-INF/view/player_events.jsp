<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="page.title" var="pageTitle"></spring:message>
<spring:message code="navbar.title" var="navbarTitle"></spring:message>
<spring:message code="navbar.home" var="navbarHome"></spring:message>
<spring:message code="navbar.events" var="navbarEvents"></spring:message>
<spring:message code="navbar.language.title" var="navbarLanguage"></spring:message>
<spring:message code="navbar.language.english" var="navbarLanguageEng"></spring:message>
<spring:message code="navbar.language.hungarian" var="navbarLanguageHun"></spring:message>
<spring:message code="navbar.logout" var="navbarLogout"></spring:message>
<spring:message code="events.events.title" var="eventsTitle"></spring:message>
<spring:message code="events.modal.stake" var="modalStake"></spring:message>
<spring:message code="events.modal.save.button" var="modalSave"></spring:message>

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
            <li><a href="home">${navbarHome}</a></li>
            <li class="active"><a href="events">${navbarEvents}</a></li>
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
    <div class="panel-heading">${eventsTitle}</div>
    <div class="panel-body">


        <div id="accordion">

            <c:forEach var="sportEventView" items="${eventListView.events}">

                <c:if test="${!sportEventView.ended}">
                    <div class="card">
                        <div class="card-header">
                            <a class="card-link" data-toggle="collapse"
                               href="#eventTitle${sportEventView.id}">
                                    ${sportEventView.title} - ${sportEventView.startDate}</a>
                        </div>
                        <div id="eventTitle${sportEventView.id}" class="collapse"
                             data-parent="#accordion">
                            <div class="card-body">

                                <c:forEach var="betView" items="${sportEventView.bets}">

                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse"
                                               href="#bet${betView.id}"> ${betView.description} </a>
                                        </div>
                                        <div id="bet${betView.id}" class="collapse"
                                             data-parent="#${sportEventView.id}">
                                            <div class="card-body">
                                                <div class="btn-group btn-group-justified">

                                                    <c:forEach var="outcomeView" items="${betView.outcomes}">
                                                        <div id="accordion" class="btn-group">
                                                            <div class="card">
                                                                <input type="hidden" id="betDescription${outcomeView.id}"
                                                                       value="${betView.description}" />
                                                                <button type="button"
                                                                        id="openModalButton${outcomeView.id}"
                                                                        class="btn btn-primary"
                                                                        data-toggle="modal"
                                                                        data-target="#saveWagerModal">
                                                                        ${outcomeView.value}<br>${outcomeView.odd}
                                                                </button>
                                                            </div>

                                                            <form:form modelAttribute="saveWagerRequest">
                                                                <form:input path="playerUsername"
                                                                            id="playerUsername"
                                                                            type="hidden"/>
                                                                <form:input path="outcomeId"
                                                                            id="outcomeId"
                                                                            type="hidden"
                                                                            value="${outcomeView.id}"/>
                                                            </form:form>
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
    </div>
</div>

<!-- The Modal -->
<div class="modal fade modal-dialog-centered" id="saveWagerModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 id="saveWagerModalHeaderText" class="modal-title"><!--TODO: BET DESCRIPTION --></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <p>${modalStake}:</p>
                <input type="text" id="wagerStake" class="form-control"/>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" id="confirmWager" class="btn btn-primary">${modalSave}</button>
            </div>

        </div>
    </div>
</div>

<script src="../../resources/js/save-wager.js" type="text/javascript"></script>
</body>
</html>
