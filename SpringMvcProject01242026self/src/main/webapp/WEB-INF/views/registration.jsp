<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User Registration</h1>
	<form action="save" method="POST">
		<p>
			First Name:<input type="text" name="fname" id="fname"
				placeholder="Enter First Name" required="true">
		</p>
		<p>
			Last Name:<input type="text" name="lname" id="lname"
				placeholder="Enter Last Name" required="true">
		</p>
		<p>
			Country: <select name="country" id="country" required="true">
				<option value="">Select Country</option>
				<option value="IND">India</option>
				<option value="USA">United States</option>
				<option value="UK">United Kingdom</option>
			</select>
		</p>
		<p>
			Gender: <input type="radio" name="gender" id="gender" value="Male" />Male
			<input type="radio" name="gender" id="gender" value="Female" />Female
		</p>
		<p>
			Languages: <input type="checkbox" name="lang" id="c" value="C" />C
			<input type="checkbox" name="lang1" id="c#" value="C#">C#
			<input type="checkbox" name="lang2" id="java" value="Java">Java
		</p>
		<p>
			Email Id:<input type="email" name="emailid" id="emailid"
				required="true" />
		</p>
		<p>
			Password:<input type="password" name="password" id="password"
				required="true" />
		</p>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>