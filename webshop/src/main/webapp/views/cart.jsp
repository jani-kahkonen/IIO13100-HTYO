<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cart</title>
	</head>
	<body>
		<h1>Cart</h1>
		<c:forEach items="${cart.products}" var="product">
			<c:out value="${product.id}" />
			<c:out value="${product.name}" />
			<c:out value="${product.price}" />
		</c:forEach>
		<br />
		<a href="../">Back</a>
	</body>
</html>