<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Form</title>
</head>
<body>
	<form:form action = "searchOutput" modelAttribute = "newSearch">
		<table>
			<tr>
				<td><h3>Search by:</h3></td>
			</tr>
			
			<tr>
				<td><form:radiobuttons path = "searchType" items = "${searchList}" />
			</tr>
			
			<tr>
				<td>Keyword:</td>
				<td><input name = "searchString" value="${searchString}" /></td>
			</tr>
	
			<tr><td />
			<td><input type="hidden" name="customerId" value="${customerId}" />
			<input type = "submit" value = "Search" />
			</td></tr><br>
			
		</table>
		
		<a href = ${pageContext.request.contextPath}/home>Back to Main</a>
	</form:form>
</body>
</html>