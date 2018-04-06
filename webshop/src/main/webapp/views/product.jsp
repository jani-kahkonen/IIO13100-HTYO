<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Product</title>
	</head>
	<body>
		<h1>Product</h1>
		<c:out value="${product.id}" />
		<c:out value="${product.name}" />
		<c:out value="${product.price}" />
		
		<h1>Products</h1>
		<c:forEach items="${products}" var="product">
			<c:out value="${product.id}" />
			<c:out value="${product.name}" />
			<c:out value="${product.price}" />
			<c:url var="myURL" value="/CartController">
				<c:param name="action" value="insert" />
			</c:url>
			<a href="/<c:out value="${myURL}"/>">Add to cart</a>
		</c:forEach>
		<br />
		<a href="../">Back</a>
	</body>
</html>