<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<h1>Login</h1>
		<form method="post" action="LoginController">
			Email:<input type="text" name="email" /><br />
			Password:<input type="text" name="password" /><br />
			<input type="submit" value="login" />
		</form>
		<br />
		<a href="../">Back</a>
	</body>
</html>