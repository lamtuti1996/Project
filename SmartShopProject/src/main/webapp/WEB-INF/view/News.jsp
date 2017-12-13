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
<!-- <script src="../js/app.js"></script> -->
<title>Insert title here</title>
</head>
<body>


	<div>
		<ul>
			<li><a href="<c:url value='createdNews' />">Create News</a></li>
		</ul>
	</div>


	<div class="container main-content form">
		<table class="table table-striped">
			<tr>
				<td>Title</td>
				<td>Content</td>
				<td>Date Created</td>
				<td>Edit News</td>

			</tr>
			<c:forEach items="${listNews}" var="list">
				<tr>
					<td>${list.title}</td>
					<td>${list.content}</td>
					<td>${list.createDate}</td>
					<td><a href="<c:url value='editNews?newsID=${list.newsID}' />">Click</a></td>

				</tr>
			</c:forEach>
		</table>
		<div>
			<ul class='pagination pagination-centered'>


				<c:choose>
					<c:when test="${page.firstPage}">
						<li class="disabled"><span>Fist</span></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="<c:url value='${page.url}?page=0&size=${page.size}' />">First</a></li>
					</c:otherwise>
				</c:choose>


				<c:choose>
					<c:when test="${page.hasPreviousPage}">
						<li><a
							href="<c:url value='${page.url}?page=${page.number-2}&size=${page.size}' />">«</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><span>«</span></li>
					</c:otherwise>
				</c:choose>

				<c:forEach var="item" items="${page.items}">
					<c:choose>
						<c:when test="${item.current}">
							<li class="active"><c:choose>
									<c:when test="${item.current}">
										<span>${item.number}</span>
									</c:when>
									<c:otherwise>
										<a
											href="<c:url value='${page.url}?page=${item.number-1}&size=${page.size}' />">
											<span>${item.number}</span>
										</a>
									</c:otherwise>
								</c:choose></li>
						</c:when>
						<c:otherwise>
							<li><c:choose>
									<c:when test="${item.current}">
										<span>${item.number}</span>
									</c:when>
									<c:otherwise>
										<a
											href="<c:url value='${page.url}?page=${item.number-1}&size=${page.size}' />">
											<span>${item.number}</span>
										</a>
									</c:otherwise>
								</c:choose></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${page.hasNextPage}">
						<li><a
							href="<c:url value='${page.url}?page=${page.number}&size=${page.size}' />">»</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><span>»</span></li>

					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${page.lastPage}">
						<li class="disabled"><span>Last </span></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="<c:url value='${page.url}?page=${page.totalPages - 1}&size=${page.size}' />">Last</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>

</body>
</html>