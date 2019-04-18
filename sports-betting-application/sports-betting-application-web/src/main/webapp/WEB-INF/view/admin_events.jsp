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
            <li class="active"><a href="events">${navbarEvents}</a></li>
            <li><a href="users">${navbarUsers}</a></li>
            <li class="dropdown"><a class="dropdown-toggle"
                                    data-toggle="dropdown" href="#">${navbarLanguage} <span class="caret"></span></a>
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

                <div class="card">

                    <div class="card-header">
                        <a class="card-link" data-toggle="collapse"
                           href="#eventTitle${sportEventView.id}">
                                ${sportEventView.title} - ${sportEventView.startDate}</a>
                        <input type="hidden" id="sportEventTitle${sportEventView.id}"
                               value="${sportEventView.title}"/>
                        <c:if test="${!sportEventView.ended}">
                            <button id="addFTResult${sportEventView.id}" type="button" class="btn btn-primary pull-right"
                                    data-toggle="modal" data-target="#FTResultModal">Add result
                            </button>
                        </c:if>
                        <c:if test="${sportEventView.ended}">
                            <span class="label label-default pull-right">Full Time Result: ${sportEventView.fullTimeResult}</span>
                        </c:if>
                    </div>

                    <div id="eventTitle${sportEventView.id}" class="collapse"
                         data-parent="#accordion">
                        <div class="card-body">

                            <c:forEach var="betView" items="${sportEventView.bets}">

                                <div class="card">
                                    <div class="card-header">
                                        <a class="card-link"> ${betView.description} </a>
                                        <input type="hidden" id="betTitle${betView.id}"
                                               value="${betView.description}"/>
                                        <c:if test="${!betView.ended}">
                                            <button id="addBetResultButton${betView.id}" type="button"
                                                    class="btn btn-primary pull-right"
                                                    data-toggle="modal" data-target="#betResultModal">Add result of bet
                                            </button>
                                        </c:if>
                                        <c:if test="${betView.ended}">
                                            <span class="label label-default pull-right">Bet Result: ${betView.result}</span>
                                        </c:if>
                                        <c:forEach var="outcomeView" items="${betView.outcomes}">
                                            <input type="hidden"
                                                   id="addBetResultOutcomeDescription${betView.id}${outcomeView.id}"
                                                   value="${outcomeView.fullDescription}"/>
                                            <input type="hidden"
                                                   id="addBetResultOutcomeValue${betView.id}${outcomeView.id}"
                                                   value="${outcomeView.value}"/>
                                            <input type="hidden"
                                                   id="addBetResultOutcomeOdd${betView.id}${outcomeView.id}"
                                                   value="${outcomeView.odd}"/>
                                        </c:forEach>
                                    </div>
                                </div>

                            </c:forEach>

                        </div>
                    </div>
                </div>

            </c:forEach>


        </div>

    </div>

    <!-- Add FullTime Result Modal -->
    <div id="FTResultModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 id="FTResultModalText" class="modal-title"></h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-3">
                            <label id="homeTeamModalLabel"></label>
                        </div>
                        <div class="col-sm-3">
                            <select id="homeScoreSelect" class="form-control">
                                <option>0</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <label id="awayTeamModalLabel"></label>
                        </div>
                        <div class="col-sm-3">
                            <select id="awayScoreSelect" class="form-control">
                                <option>0</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div id="FTResultModalFooter" class="modal-footer">
                    <button id="saveFTResultButton" type="button" class="btn btn-default">Save
                        result!
                    </button>
                </div>
            </div>

        </div>
    </div>

    <!-- Add Bet Result Modal -->
    <div id="betResultModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button id="closeBetResultModalButton" type="button" class="close" data-dismiss="modal">&times;
                    </button>
                    <h4 id="betResultModalText" class="modal-title"></h4>
                </div>
                <div id="betResultModalBody" class="modal-body">
                    <div id="modalOutcomesButtonGroup" class="btn-group btn-group-justified">
                        <%--save bet result buttons for each outcome rendered here dynamically--%>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="../../resources/js/add-results.js" type="text/javascript"></script>
</body>
</html>
