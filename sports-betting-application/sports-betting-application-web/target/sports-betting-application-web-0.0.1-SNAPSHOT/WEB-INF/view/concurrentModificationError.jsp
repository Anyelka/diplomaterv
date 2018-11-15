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
		<div class="panel-heading">Concurrent Modification</div>
		<div class="panel-body">
			<h5>Somebody tried to edit the data at the same time. Please try
				it again.</h5>
			<form:form action="sports.betting.application.web.controller.home.html">
				<button type="submit" class="btn">Back to sports.betting.application.web.controller.home</button>
			</form:form>
		</div>
	</div>

</body>
</html>