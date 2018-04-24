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
    			  <li id="user"><a href="details.html">User details</a></li>
    			  </li>
    			  <li id="my-foods"><a href="my-foods.html">My foods</a></li>
    			  <li id="my-ingredients" class ="active"><a href="#">My ingredients</a></li>
    			  <li id="foods"><a href="foods.html">All foods</a></li>
    			  </li>
			    </ul>
    			<ul class="nav navbar-nav navbar-right">
    			  <li><a href="logout">Logout</a></li>
      		    </ul>
			  </div>
			</nav>
		</header>
		<main>
			<section id="ingredients" class="container">
				<h4>Wagers</h4>
				<table id="foods-table" class="table-style">
					<tr class="th-style">
						<th></th><th>#</th><th>Ingredient name</th><th>Quantity</th><th>Unit</th><th>Price</th><th>Currency</th>
					</tr>
					<c:forEach var="ingredient" items="${ingredients}" varStatus="loopCounter">
					<tr class="td-style">
						<td><a id="remove-button" class="btn btn-default btn-xs" alt="Remove" href='deleteIngredient?id=<c:out value="${ingredient.id}"/>'>Remove</a>
						</td><th>${loopCounter.count}</th><td>${ingredient.name}</td><td>${ingredient.quantity}</td><td>${ingredient.unit}</td><td>${ingredient.price}</td><th>${ingredient.currency}</th>
					</tr>
					</c:forEach>
				</table>
			</section>
		</main>
	</body>
</html>