<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="navbar.title" var="navbarTitle"></spring:message>
<spring:message code="navbar.home" var="navbarHome"></spring:message>
<spring:message code="navbar.events" var="navbarEvents"></spring:message>
<spring:message code="navbar.language.title" var="navbarLanguage"></spring:message>
<spring:message code="navbar.language.english" var="navbarLanguageEng"></spring:message>
<spring:message code="navbar.language.hungarian" var="navbarLanguageHun"></spring:message>
<spring:message code="navbar.logout" var="navbarLogout"></spring:message>

<spring:message code="home.accountDetails.accountDetails.title" var="accountDetailsTitle"/>
<spring:message code="home.accountDetails.name" var="accountDetailsName"/>
<spring:message code="home.accountDetails.dateOfBirth" var="accountDetailsDateOfBirth"/>
<spring:message code="home.accountDetails.accountNumber" var="accountDetailsAccountNumber"/>
<spring:message code="home.accountDetails.balance" var="accountDetailsBalance"/>
<spring:message code="home.accountDetails.currency" var="accountDetailsCurrency"/>
<spring:message code="home.accountDetails.save.button" var="accountDetailsSaveButton"/>
<spring:message code="home.wagers.wagers.title" var="wagersTitle"/>
<spring:message code="home.wagers.noWagers" var="wagersNoWagers"/>
<spring:message code="home.wagers.eventTitle" var="wagersEventTitle"/>
<spring:message code="home.wagers.eventType" var="wagersEventType"/>
<spring:message code="home.wagers.betType" var="wagersBetType"/>
<spring:message code="home.wagers.outcomeValue" var="wagersOutcomevalue"/>
<spring:message code="home.wagers.outcomeOdd" var="wagersOutcomeOdd"/>
<spring:message code="home.wagers.stake" var="wagersStake"/>
<spring:message code="home.wagers.winner" var="wagersWinner"/>
<spring:message code="home.wagers.processed" var="wagersProcessed"/>
<spring:message code="home.wagers.remove.button" var="wagersRemove"/>

<html>
<head>
    <jsp:include page="../assets/include.jsp"/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">${navbarTitle}</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="home">${navbarHome}</a></li>
            <li><a href="events">${navbarEvents}</a></li>
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
    <div class="panel-heading">${accountDetailsTitle}</div>
    <div class="panel-body">
        <form:form modelAttribute="accountDetailsRequest" action="saveAccountDetails.html">
            <form:input path="username" type="hidden" name="playerUsername"/>
            <form:input path="version" type="hidden" name="playerVersion"/>

            <div class="input-group">
                <span class="input-group-addon">${accountDetailsName}</span>
                <form:input path="name" id="playerName" type="text" class="form-control" name="playerName"/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">${accountDetailsDateOfBirth}</span>
                <form:input path="dateOfBirth" id="playerDateOfBirth" type="text" class="form-control"
                            name="playerDateOfBirth"/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">${accountDetailsAccountNumber}</span>
                <form:input path="accountNumber" id="playerAccountNumber" type="text" class="form-control"
                            name="playerAccountNumber"/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">${accountDetailsBalance}</span>
                <form:input path="balance" id="playerBalance" type="text" class="form-control" name="playerBalance"
                            disabled="true"/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">${accountDetailsCurrency}</span>
                <form:input path="currency" id="playerCurrency" type="text" class="form-control" name="playerCurrency"
                            disabled="true"/>
            </div>
            <%-- 				<input type="hidden" name="playerId" value="${player.userId}"> --%>
        </form:form>
        <div id="saveAccountDetailsResponseDiv">
            <p id="saveAccountDetailsResponseText"></p>
        </div>
        <button id="saveAccountDetailsButton" type="button" class="btn btn-default">${accountDetailsSaveButton}</button>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">${wagersTitle}</div>
    <div class="panel-body">
        <c:choose>
            <c:when test="${listWagersView.wagers.size() == 0}">
                ${wagersNoWagers}
            </c:when>
            <c:otherwise>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>${wagersEventTitle}</th>
                            <th>${wagersEventType}</th>
                            <th>${wagersBetType}</th>
                            <th>${wagersOutcomevalue}</th>
                            <th>${wagersOutcomeOdd}</th>
                            <th>${wagersStake}</th>
                            <th>${wagersWinner}</th>
                            <th>${wagersProcessed}</th>
                            <th id="remove"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="wager" items="${listWagersView.wagers}">
                            <tr>
                                <td>${wager.id}</td>
                                <td>${wager.eventTitle}</td>
                                <td>${wager.eventType}</td>
                                <td>${wager.betType}</td>
                                <td>${wager.outcome}</td>
                                <td>${wager.odd}</td>
                                <td>${wager.stake}</td>
                                <td>${wager.isWinner}</td>
                                <td>${wager.isProcessed}</td>
                                <td>
                                    <c:if test="${!(wager.isProcessed=='Yes')}">
                                        <form:form modelAttribute="removeWagerRequest" action="removeWager">
                                            <form:input path="id" type="hidden" name="id" value="${wager.id}"/>
                                            <button type="submit" class="btn btn-inline">${wagersRemove}</button>
                                        </form:form>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<script src="../../resources/js/save-account-details.js" type="text/javascript"></script>
</body>
</html>
