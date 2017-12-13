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
<!-- Bootstrap -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	href="@{/webjars/bootstrap/3.3.7/css/bootstrap.min.css}"
	rel="stylesheet" />
<!-- Custom style -->
<!-- <link href="../static/css/style.css" href="@{/css/style.css}"
	rel="stylesheet" /> -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"
	src="@{/webjars/jquery/1.12.4/jquery.min.js}"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	src="@{/webjars/bootstrap/3.3.7/js/bootstrap.min.js}"></script>
</head>
<body>
	

	<div class="container">
		<div class="col-sm-3"></div>
		<div class="col-sm-4">
			<spring:form action="checkLogin" modelAttribute="user" method="POST">
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
			<label>${message}</label>
		</div>
		<div class="col-sm-3"></div>
	</div>
</body>
</html>