<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkouts List</title>
</head>
<body>
<form:hidden path="customerId"/>
<h2>Checkout List for ${customerName}</h2>
	<table> 
		<tr>
			<th> Checkout ID </th>
			<th width=200> Movie Title </th>
			<th> Checkout Date </th>
			<th> Returned Date </th>
		</tr>
		
		<c:forEach var="eachCheckout" items="${checkouts}">

		<tr>
			<td style="text-align: center">${eachCheckout.id}</td>
			<td style="text-align: center" width=200><a href="${pageContext.request.contextPath}/movie?movieId=${eachCheckout.movie.id}">${eachCheckout.movie.title}</a></td>
			<td width=155>${eachCheckout.checkoutDate}</td>
			<td width=155>${eachCheckout.returnedDate}</td>
			<c:choose>
			<c:when test="${eachCheckout.returnedDate == null}">
				<td><form action = "returnMovie"  modelAttribute = "checkout" method = "post">
					<input type="hidden" name="checkoutId" value="${eachCheckout.id}" />
					<input type="hidden" name="customerId" value="${customerId}" />
					<input type="submit" value="Return Movie" />
				</form></td>
			</c:when>
			</c:choose>
		</tr>

		</c:forEach>
		</table><br><br>
		
		<div>
			<form action = "searchForm" method = "get">
			<input type="hidden" name="customerId" value="${customerId}" />
			<input type = "submit" value="Browse Movie" />
			</form>
		</div><br>

		<a href = ${pageContext.request.contextPath}/home>Back to Main</a>
			
</body>
</html>