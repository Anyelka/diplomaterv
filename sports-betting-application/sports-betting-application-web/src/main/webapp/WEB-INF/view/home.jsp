<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <jsp:include page="../assets/include.jsp"/>
    <jsp:include page="../assets/navbar.jsp"/>
</head>
<body>

<div class="panel panel-default">
    <div class="panel-heading">Account details</div>
    <div class="panel-body">
        <form:form modelAttribute="accountDetailsRequest" action="saveAccountDetails.html">
            <form:input path="username" type="hidden" name="playerUsername"/>
            <form:input path="version" type="hidden" name="playerVersion"/>

            <div class="input-group">
                <span class="input-group-addon">Name</span>
                <form:input path="name" id="playerName" type="text" class="form-control" name="playerName"/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Date of birth</span>
                <form:input path="dateOfBirth" id="playerDateOfBirth" type="text" class="form-control"
                            name="playerDateOfBirth"/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Account number</span>
                <form:input path="accountNumber" id="playerAccountNumber" type="text" class="form-control"
                            name="playerAccountNumber"/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Balance</span>
                <form:input path="balance" id="playerBalance" type="text" class="form-control" name="playerBalance"
                            disabled="true"/>
            </div>
            <div class="input-group">
                <span class="input-group-addon">Currency</span>
                <form:input path="currency" id="playerCurrency" type="text" class="form-control" name="playerCurrency"
                            disabled="true"/>
            </div>
            <%-- 				<input type="hidden" name="playerId" value="${player.userId}"> --%>
        </form:form>
        <div id="saveAccountDetailsResponseDiv">
            <p id="saveAccountDetailsResponseText"></p>
        </div>
        <button id="saveAccountDetailsButton" type="button" class="btn btn-default">Save</button>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">Wagers</div>
    <div class="panel-body">
        <c:choose>
            <c:when test="${listWagersView.wagers.size() == 0}">
                You have no wagers!
            </c:when>
            <c:otherwise>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Event title</th>
                            <th>Event type</th>
                            <th>Bet type</th>
                            <th>Outcome value</th>
                            <th>Outcome odd</th>
                            <th>Stake</th>
                            <th>Winner</th>
                            <th>Processed</th>
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
                                    <c:if test="${!wager.isProcessed}">
                                        <form:form modelAttribute="removeWagerRequest" action="removeWager.html">
                                            <form:input path="id" type="hidden" name="id" value="${wager.id}"/>
                                            <button type="submit" class="btn btn-inline">Remove</button>
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