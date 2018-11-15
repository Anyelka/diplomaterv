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
				<li><a href="home.html">Home</a></li>
				<li><a href="events.html">Events</a></li>
				<li class="active"><a href="export.html">Export data</a></li>
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
	
	<div class="alert alert-primary">
	<form class="alert alert-primary" action="exportData.html" method="POST">
	
		<strong>Export data for the given player: ${playerName}</strong> 
		<br>Choose the time range from which you would like to get the wagers:<br>
		<input name="playerName" value="${playerName}" type="hidden"/>
		<label >Start date</label>
		<input name="dateFrom" value="${dateFrom}"  type="text" class="form-control"/>
		<label >End date</label>
		<input name="dateTo" value="${dateTo}" type="text" class="form-control"/>
		<button type="submit" class="btn btn-inline">Export Data</button>
	</form>

	</div>
	
</body>
</html>