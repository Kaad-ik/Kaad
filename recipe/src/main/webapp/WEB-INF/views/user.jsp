<%@ page language="java" contentType="text/html" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>User details</title>

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<link rel="stylesheet" href=<c:url value="/css/style.css" /> >
	</head>
	<body>
		<header class="container-fluid">
			<nav id="navbar" class="navbar navbar-inverse">
			  <div class="container-fluid">
    			<div class="navbar-header">
      				<a class="navbar-brand" href="#">Recipe</a>
			    </div>
    			<ul class="nav navbar-nav">
    			  <li id="user" class="active"><a href="#">User details</a></li>
    			  </li>
    			  <li id="foods"><a href="foods.html">Foods</a></li>
    			  </li>
			    </ul>
    			<ul class="nav navbar-nav navbar-right">
    			  <li><a href="logout">Logout</a></li>
      		    </ul>
			  </div>
			</nav>
		</header>
		<main>
			<section id="account-details" class="container">
				<h4>User details</h4>
				<form:form modelAttribute="user" id="account-details-form" class="form-horizontal form-style" action="updateUser" method="post">
					<div class="col-sm-12" hidden>
						<form:input path="id" id="id" class="form-control" required="required" />
					</div>
					
					<label for="user-name" class="control-label col-sm-2">User name</label>
					<div class="col-sm-10">
						<form:input path="userName" id="user-name" class="form-control" required="required" />
					</div>
					<label for="full-name" class="control-label col-sm-2">Full name</label>
					<div class="col-sm-10">
						<form:input path="fullName" id="full-name" class="form-control" required="required" />
					</div>
					<label for="email" class="control-label col-sm-2">E-mail</label>
					<div class="col-sm-10">
						<form:input path="email" id="email" class="form-control" required="required" />
					</div>
					<label for="role" class="control-label col-sm-2">Role</label>
					<div class="col-sm-10">
						<form:input path="role" id="role" class="form-control" required="required" />
					</div>
					<label for="money" class="control-label col-sm-2">Money</label>
					<div class="col-sm-10">
						<form:input path="money" id="money" class="form-control" required="required" />
					</div>
					<label for="currency" class="control-label col-sm-2">Currency</label>
					<div class="col-sm-10">
						<form:select path="currency" id="currency" class="form-control" items="${currencyModel.availableCurrencies}" required="required" />
					</div>
					<button class="btn btn-default" id="save-button" name="save-button">Save</button>
				</form:form>
				<c:if test="${not empty message}">
          			<div class="alert alert-success">${message}</div>
        		</c:if>
			</section>
		</main>
	</body>
</html>