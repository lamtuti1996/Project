<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:form action="/saveCart" method="POST" modelAttribute="customer">
		<table border="1">
			<tr>
				<td>Email:</td>
				<td>${pageContext.request.remoteUser}</td>
			</tr>

			<tr>
				<td>Name :</td>
				<td><spring:input type="text" name="name" path="name" /></td>
			</tr>

			<tr>
				<td>Mobile :</td>

				<td><spring:input type="text" name="mobile" path="mobile" /></td>

			</tr>

			<tr>
				<td>Address :</td>

				<td><spring:input type="text" name="address" path="address" /></td>

			</tr>
		</table>
		<button>Save</button>
	</spring:form>
</body>
</html>