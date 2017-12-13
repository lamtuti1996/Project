<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<!-- <script src="../js/app.js"></script> -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table id="tblData" class="table table-striped">
			<tr>
				<th>Check</th>
				<th>Id</th>
				<th>Mark</th>
				<th>Name Major</th>
			</tr>
			<c:forEach items="${listStudent}" var="list">
				<tr>
					<td><input type="checkbox" class="check" name="active"
						id="${list.id}" value="${list.id}" /></td>
					<td id="student${list.id}">${list.id}</td>
					<td id="mark${list.id}">${list.mark}</td>
					<td id="major${list.id} ">${list.nameMajor}</td>
				</tr>
			</c:forEach>
		</table>
			<div class="btn-group btn-group-justified">
			<div class="btn-group">
				<!-- <button type="button" class="btn btn-default">Add</button> -->
				<input type="button" id="add_click" class="btn btn-default" value="<fmt:message key="button.add"/>">
			</div>
			<div class="btn-group">
				<!-- <button type="button" id="update_click" class="btn btn-default">Update</button> -->
				<input type="button" id="update_click" class="btn btn-default" value="<fmt:message key="button.update"/>">
			</div>
			<div class="btn-group">
				<!-- <button type="button" class="btn btn-default" id="delete_click">Delete</button> -->
				<input type="button" id="delete_click" class="btn btn-default" value="<fmt:message key="button.delete"/>">
			</div>
		</div>
		<tag:paginate max="15" offset="${offset}" count="${count}" uri="list"
			next="&raquo;" previous="&laquo;" />
	</div>
</body>
</html>