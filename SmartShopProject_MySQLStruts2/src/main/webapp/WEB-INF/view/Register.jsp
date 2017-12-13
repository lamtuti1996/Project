<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<spring:form action="register" modelAttribute="rUser" method="POST">
		<div class="form-group">

			<div>
				<fmt:message key="label.username" />
			</div>
			<spring:input path="email" class="form-control"
				placeholder="User Name" />
				<spring:errors path="email" />
		</div>
		<div class="form-group">
			<div>
				<fmt:message key="label.password" />
			</div>
			<spring:input path="password" class="form-control"
				placeholder="Password" />
				<spring:errors path="password" />
		</div>
		<br>
		<input type="submit" value="<fmt:message key="button.login"/>"
			class="btn btn-success btn-sm">
	</spring:form>
</body>
</html>