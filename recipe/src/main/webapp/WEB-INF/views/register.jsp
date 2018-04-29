<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <title>Recipe application</title>
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href=<c:url value="/css/style.css" /> >
</head>
<body>
    <header id="login-main-header" class="container-fluid">
        <h1>Welcome to our Recipe application!</h1>
        <p>This recipe application is created by Klaudia Balázs, Aletta Csikós, Doma Gulyás and Anna Kelecsényi. Hope you find it useful.</p>
    </header>
    <main>
        <header id="login-header" class="container">
            <h2><span class="blue-text"><a href="/">Login</a></span> or <span class="blue-text"><b>Register</b></span> to start!</h2>
        </header>
        <section id="login" class="container">
            <h3>Login</h3>
            <form id="login-form" class="form-style" action="register" method="POST">
                <label class="sr-only" for="userName">Username ${person.userName}</label>
                <input type="text" name="userName" id="userName" class="form-control" placeholder="User name" required="required">
                <label class="sr-only" for="password">Password ${person.password}</label>
                <input type="password" name="password" id="password" class="form-control" placeholder="Password" required="required">
                <label class="sr-only" for="full-name">Full name ${person.fullName}</label>
                <input type="text" name="fullName" id="full-name" class="form-control" placeholder="Full name" required="required">
                <label class="sr-only" for="email">Email ${person.email}</label>
                <input type="email" name="email" id="email" class="form-control" placeholder="Email" required="required">
                <button class="btn btn-default" id="login-button">Register</button>
            </form>
        </section>
    </main>

</body>
</html>