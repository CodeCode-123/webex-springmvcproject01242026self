<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/style.css" />
</head>
<body> -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="generator" content="Hugo 0.84.0">
<title>Login</title>
<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">



<!-- Bootstrap core CSS -->
<link href="${contextPath}/resources/admincss/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link href="${contextPath}/resources/style.css" rel="stylesheet">
</head>
<body>
	<h1>Login</h1>
	<form action="authentication" method="POST">
		<table cellpadding="10" border="1" cellspacing="0">

			<tr>
				<th>User Name</th>
				<td><input type="text" id="uname" name="uname"
					placeholder="Enter User Name" required="true" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" id="upass" name="upass"
					placeholder="Enter Password" required="true" /></td>
			</tr>
			<tr>
			    <td colspan="2">
			        <div class="err">${error}</div>
			    </td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit">Sign in</button>
			</tr>
		</table>
	</form>
	<a href="registration">New user Sign Up</a>
</body>
</html>