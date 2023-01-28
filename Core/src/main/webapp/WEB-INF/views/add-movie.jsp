<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.error {
	color:red
}
</style>
</head>
<body>
	<b>Please enter the movie info:</b>	
	
	<form:form action = "processMovie" modelAttribute = "movie" method = "post">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title"/>
				<form:errors path = "title" cssClass = "error" />
				</td>
			</tr>
			
			<tr>
				<td>Description:</td>
				<td><form:textarea type="text" style="height: calc(2.5em + 2.75rem + 2px)" path="description"/>
				<form:errors path = "description" cssClass = "error" />
				</td>
			</tr>
			<tr>
				<td>Length, min:</td>
				<td><form:input path="length"/>
				<form:errors path = "length" cssClass = "error" />
				</td>
			</tr>
			<tr>
				<td>Year made:</td>
				<td><form:input path="year"/>
				<form:errors path = "year" cssClass = "error" />
				</td>
			</tr>
			<tr>
				<td>Release date:</td>
				<td><form:input path="releaseDate"/>
				<form:errors path = "releaseDate" cssClass = "error" />
				</td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><form:select path = "rating">
				<form:options items = "${ratingList}" />
				</form:select></td>
			</tr>
			<tr>
				<td>Total number of copies:</td>
				<td><form:input path="totalCopies"/>
				<form:errors path = "totalCopies" cssClass = "error" />
				</td>
			</tr>
			<tr>
				<td>Genre:</td>
				<td><form:checkboxes path = "genre" items = "${genreList}" />
				<form:errors path = "genre" cssClass = "error" />
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="hidden" name="customerId" value="${customerId}" />
				<input type = "submit" value = "Save Movie"/></td>
			</tr>	
		</table>
		<a href = ${pageContext.request.contextPath}/home>Back to Main</a>
	</form:form>
</body>
</html>