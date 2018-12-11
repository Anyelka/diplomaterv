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
            <li class="active"><a href="admin_events.html">Events</a></li>
            <li><a href="admin_users.html">Users</a></li>
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
            <button id="generateResultsButton" type="button" class="btn btn-danger">Generate random results for all events!</button>
        </div>

    </div>
</div>
<script src="../../resources/js/generate-results.js" type="text/javascript"></script>
</body>
</html>
