<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>SportsBet</title>
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
            <a class="navbar-brand" href="#">SportsBetting</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="home.html">Home</a></li>
            <li class="active"><a href="events.html">Events</a></li>
            <li><a href="export.html">Export data</a></li>
            <li class="dropdown"><a class="dropdown-toggle"
                                    data-toggle="dropdown" href="#">Language <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">English</a></li>
                    <li><a href="#">Hungarian</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="index.html">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="panel panel-default">
    <div class="panel-heading">Events</div>
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
                                                                <input type="hidden" id="betDescription"
                                                                       value="${betModel.description}">

                                                                <button type="button"
                                                                        class="btn btn-primary openModalButton"
                                                                        data-toggle="modal"
                                                                        data-target="#saveWagerModal">
                                                                        ${outcomeModel.value}<br>${outcomeModel.odd}
                                                                </button>
                                                            </div>

                                                            <form:form modelAttribute="saveWagerRequest">
                                                                <form:input path="playerUsername"
                                                                            id="playerUsername"
                                                                            type="hidden"/>
                                                                <form:input path="outcomeId"
                                                                            id="outcomeId"
                                                                            type="hidden"
                                                                            value="${outcomeModel.id}"/>
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
                <p>Stake:</p>
                <input type="text" id="wagerStake" class="form-control"/>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" id="confirmWager" class="btn btn-primary">Save</button>
            </div>

        </div>
    </div>
</div>

<script src="../../resources/js/save-wager.js" type="text/javascript"></script>
</body>
</html>