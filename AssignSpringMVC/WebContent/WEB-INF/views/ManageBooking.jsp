<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Code</td>
			<td>Plane ID</td>
			<td>Booking Date</td>
			<td>Booking Time</td>
			<td>Full Name</td>
			<td>Fare</td>
			<td>Departure Date</td>
			<td>Departure Time</td>
			<td>From City</td>
			<td>To City</td>
			<td>DUration</td>
		</tr>
		<c:forEach items="${listBooking}" var="booking">
			<tr>
				<td>${booking.reservationCode}</td>
				<td>${booking.planeID}</td>
				<td>${booking.bookingDate}</td>
				<td>${booking.bookingTime}</td>
				<td>${booking.fullName}</td>
				<td>${booking.fare}</td>
				<td>${booking.departureDate}</td>
				<td>${booking.departureTime}</td>
				<td>${booking.fromCity}</td>
				<td>${booking.toCity}</td>
				<td>${booking.duration}</td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>