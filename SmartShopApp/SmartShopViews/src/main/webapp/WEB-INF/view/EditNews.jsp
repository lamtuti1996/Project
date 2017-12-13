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
			<spring:form action="" modelAttribute="n" method="POST">
				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						Products<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<c:forEach var="row" items="${categoryProduct}">
							<li><a
								href="<c:url value='searchCategoryProduct?categoryID=${row.categoryID}' />">
									<c:out value="${row.categoryName}" />
							</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="form-group">
					<div>Title</div>
					<spring:input path="title" class="form-control" value="" />
				</div>
				<div class="form-group">
					<div>Content</div>
					<spring:input path="content" class="form-control" value="" />
				</div>


				<br>
				<input type="submit" value="Edit" class="btn btn-success btn-sm">

			</spring:form>

		</div>
		<div class="col-sm-3"></div>
	</div>
</body>
</html>