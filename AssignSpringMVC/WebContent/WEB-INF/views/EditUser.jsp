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
<form:form action="/AssignSpringMVC/editUser.html" modelAttribute="user">
		<div>User ID</div>
		<form:input path="userId" />
		<form:errors path="userId" />
		<div>User Name</div>
		<form:input path="username" />
		<form:errors path="username" />
		<div>Password</div>
		<form:input path="password" />
		<form:errors path="password" />
		<div>User Name</div>
		<form:input path="fullname" />
		<form:errors path="fullname" />
		<button>Add</button>
	</form:form>
</body>
</html>