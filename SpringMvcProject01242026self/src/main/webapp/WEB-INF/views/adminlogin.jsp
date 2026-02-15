<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/style.css" />
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
	<br>
	<a href="registration">New user Sign Up</a>
</body>
</html>