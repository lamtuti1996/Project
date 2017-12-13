<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- nó sẽ động điwwù chình kích thước cho phù hợp màn hình -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- Bootstrap -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	href="@{/webjars/bootstrap/3.3.7/css/bootstrap.min.css}"
	rel="stylesheet" />
<!-- Custom style -->
<link href="../static/css/style.css" href="@{/css/style.css}"
	rel="stylesheet" />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"
	src="@{/webjars/jquery/1.12.4/jquery.min.js}"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	src="@{/webjars/bootstrap/3.3.7/js/bootstrap.min.js}"></script>

<title>Insert title here</title>
</head>
<body>



	<div class="col-md-3"></div>
	<!-- col-md-number : md là tùy thược vào độ phân giảu của máy ,màn hình  -->
	<div class="col-md-6">
		<div class="row">
			<form:form action="checkLogin" modelAttribute="Users" method="POST">
				<div class="form-group">
					
                   <div><fmt:message key="label.username"/></div>
					<form:input path="username" class="form-control"
						placeholder="User Name" />
					<form:errors path="username" />
				</div>
				<div class="form-group">
				 <div><fmt:message key="label.passwork"/></div>
					<form:input path="password" class="form-control"
						placeholder="Passwork" />
					<form:errors path="password" />
				</div>
				<br>
				<input type="submit" value="<fmt:message key="button.login"/>" class="btn btn-success btn-sm"> 
               
			</form:form>
			<label>${message}</label>
		</div>
	</div>
	<div class="col-md-2">
		<div class="dropdown">
			<a id="dLabel" role="button" data-toggle="dropdown" data-target="#"
				href="#"> Language <span class="caret"></span>
			</a>


			<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">

				<li><a role="button" data-target="#" href="login?lang=en">
						English </a></li>
				<li><a role="button" data-target="#" href="login?lang=vn">
						Vietnameese </a></li>

			</ul>
		</div>
	</div>
</body>
</html>