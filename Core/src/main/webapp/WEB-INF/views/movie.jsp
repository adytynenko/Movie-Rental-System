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
<h2>Movie</h2>
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
<tr>

<td>${movie.title}</td>
<td style="text-align: center">${movie.year}</td>
<td style="text-align: center">${movie.length}</td>
<td>${movie.genre}</td>
<td style="text-align: center" width=100>${movie.releaseDate}</td>
<td style="text-align: center">${movie.rating}</td>
<td>${movie.description}</td>
<td style="text-align: center">${movie.totalCopies}</td>
<td style="text-align: center">${movie.availableCopies}</td>

</tr>		
</table><br><br>

<a href = ${pageContext.request.contextPath}/home>Back to Main</a>

</body>
</html>