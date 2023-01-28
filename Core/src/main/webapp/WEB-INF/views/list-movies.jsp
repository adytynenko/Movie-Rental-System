<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Movies List</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color: coral;}
</style>
</head>
<body>
<form:hidden path="customerId"/>
<h2>Movies List</h2>
<table>
<tr>
	<th>Title</th>
	<th>Year</th>
	<th style="text-align: center">Length, min</th>
	<th style="text-align: center">Genre</th>
	<th style="text-align: center">Release Date</th>
	<th>Rating</th>
	<th style="text-align: center">Description</th>
	<th style="text-align: center">Total copies</th>
	<th style="text-align: center">Available copies</th>
</tr>
<c:forEach var = "eachMovie" items = "${movies}">
<tr>
	<td>${eachMovie.title}</td>
	<td>${eachMovie.year}</td>
	<td style="text-align: center">${eachMovie.length}</td>
	<td>${eachMovie.genre}</td>
	<td style="text-align: center" width=100>${eachMovie.releaseDate}</td>
	<td style="text-align: center">${eachMovie.rating}</td>
	<td>${eachMovie.description}</td>
	<td style="text-align: center">${eachMovie.totalCopies}</td>
	<td style="text-align: center">${eachMovie.availableCopies}</td>
	<c:choose>
		<c:when test="${customerId != 0}">
		<c:choose>
			<c:when test="${eachMovie.availableCopies<=0 }">
				<td>no available copies</td>
			</c:when>
			<c:when test="${eachMovie.availableCopies>0 }">
				<td><form action="checkoutMovie" method="post">
				<input type="hidden" name="movieId" value="${eachMovie.id}" />
				<input type="hidden" name="customerId" value="${customerId}" />
				<input type="submit" value="Checkout Movie">
				</form></td>
			</c:when>
		</c:choose>
		</c:when>
	</c:choose>
</tr>
</c:forEach>
</table>
<br><br>
<h3><a href = ${pageContext.request.contextPath}/home>Back to Main</a></h3>
</body>
</html>