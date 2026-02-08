<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Please Confirm</h1>
	<p>Name: ${users.getFirstName()} ${users.getLastName()}</p>
	<p>Country: ${users.getGender()}</p>
	<p>Country: ${users.getCountry()}</p>
	<p>Languages: ${users.getLanguagesToString()}</p>
</body>
</html>