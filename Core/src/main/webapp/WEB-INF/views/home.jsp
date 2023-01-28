<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/addMovie?customerId=0">Add a new movie</a><br><br>
	<a href="${pageContext.request.contextPath}/searchForm?customerId=0">Browse Movie</a><br><br>
	
	<c:forEach var="eachCustomer" items="${customers}">
		<a href="${pageContext.request.contextPath}/customerHistory?customerId=${eachCustomer.id}">Log in as ${eachCustomer.firstName}</a><br><br>
	</c:forEach>
     
</body>
</html>