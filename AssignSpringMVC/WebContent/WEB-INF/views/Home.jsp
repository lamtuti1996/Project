<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/AssignSpringMVC/searchFligh.html"  modelAttribute="flightsearchDTO">
		<div>From City</div>
		<form:select path="fromCity" items="${city}" itemLabel="cityName"
			itemValue="cityName" />

		<div>To City</div>
		<form:select path="toCity" items="${city}" itemLabel="cityName"
			itemValue="cityName" />
		<div>Departure</div>
		<input type="text" name="departureDate">
		<button>Search</button>
	</form:form>
</body>
</html>