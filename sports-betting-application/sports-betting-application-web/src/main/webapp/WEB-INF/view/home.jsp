<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>SportsBet</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets\bootstrap\bootstrap.css">
<script src="assets\bootstrap\bootstrap.js"></script>
<link rel="stylesheet" href="assets\style.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SportsBetting</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="home.html">Home</a></li>
				<li><a href="events.html">Events</a></li>
				<li><a href="export.html">Export data</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Language <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">English</a></li>
						<li><a href="#">Hungarian</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.html">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="panel panel-default">
		<div class="panel-heading">Account details</div>
		<div class="panel-body">
			<form:form modelAttribute="accountDetailsRequest" action="saveAccountDetails.html">
				<form:input path="username" type="hidden" name="playerUsername"/>
				<form:input path="version" type="hidden" name="playerVersion"/>
				
				<div class="input-group">
					<span class="input-group-addon">Name</span> 
					<form:input path="name" id="msg" type="text" class="form-control" name="playerName"/>
				</div>
				<div class="input-group">
					<span class="input-group-addon">Date of birth</span> 
					<form:input path="dateOfBirth" id="msg" type="text" class="form-control" name="playerDateOfBirth"/>
				</div>
				<div class="input-group">
					<span class="input-group-addon">Account number</span>
					<form:input path="accountNumber" id="msg" type="text" class="form-control" name="playerAccountNumber"/>
				</div>
				<div class="input-group">
					<span class="input-group-addon">Balance</span> 
					<form:input path="balance" id="msg" type="text" class="form-control" name="playerBalance" disabled="true"/>
				</div>
				<div class="input-group">
					<span class="input-group-addon">Currency</span> 
					<form:input path="currency" id="msg" type="text" class="form-control" name="playerCurrency" disabled="true"/>					
				</div>
<%-- 				<input type="hidden" name="playerId" value="${player.userId}"> --%>
				<button type="submit" class="btn btn-default">Save</button>
			</form:form>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">Wagers</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th id="remove"></th>
							<th>#</th>
							<th>Event title</th>
							<th>Event type</th>
							<th>Bet type</th>
							<th>Outcome value</th>
							<th>Outcome odd</th>
							<th>Wager amount</th>
							<th>Winner</th>
							<th>Processed</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="wager" items="${listWagersModel.wagers}">
							<tr>
								<td>
									<c:if test="${!wager.processed}">
									<form:form modelAttribute="removeWagerRequest" action="removeWager.html">									
										<form:input path="id" type="hidden" name="id" value="${wager.id}"/>
										<button type="submit" class="btn btn-inline">Remove</button>
									</form:form>
									</c:if>
								</td>
								<td>
									${wager.id}
								</td>
								<td>${wager.bet.event.title}</td>
								<td>${wager.bet.event.eventType}</td>
								<td>${wager.bet.betType}</td>
								<td>${wager.outcome.value}</td>
								<td>${wager.outcome.odd.value}</td>
								<td>${wager.stake}</td>
								<td><c:choose></c:choose></td>
								<td><c:choose>
										<c:when test="${!wager.processed}">-</c:when>
										<c:otherwise>Yes</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>
</html>