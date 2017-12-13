<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
		
			<td>username</td>
				<td>password</td>
			<td>full name</td>
		</tr>
		<c:forEach items="${user}" var="user">
			<tr>
			
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.fullname}</td>
			<td><a href="<c:url value='/delete/${user.username}' />">delete</a></td>
			<td><a href="<c:url value='/edit/${user.username}' />">update</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value='/add' />">Add User</a>
</body>
</html>