<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${listSearch}" var="m">

		<table>

			<tr>
				<td>
					<h3>${m.fromCity}to${m.toCity}</h3>
				</td>

			</tr>
			<tr>
				<td>
					<h4>${m.departDate}</h4>
				</td>

			</tr>
			<tr>
				<td>Departs</td>
		
				<td>Right Detail</td>
			</tr>
			<tr>
				<td>${m.departTime}</td>
			
				<td>${m.duration}H</td>
				<td><input id="checkA" type="checkbox" name="check"
					value="${m.planeID}"  /> 
					
					<input id="isShow"
					type="hidden" name="isShow" value="${show}"  /> 
					<fmt:setLocale value="en_US" /> 
					<fmt:formatNumber type="currency" value="${m.fare}" /></td>
			</tr>


		</table>
	</c:forEach>
</body>
</html>