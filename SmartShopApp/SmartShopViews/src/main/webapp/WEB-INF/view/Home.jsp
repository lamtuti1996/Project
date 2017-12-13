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
<script src="../js/app.js"></script>
<link href="../static/image" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<!--top-bar  -->
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="pull-left">
						<div class="lang">
							<!-- Single button -->
							<div class="btn-group">
								<button type="button"
									class="btn btn-default dropdown-toggle no-border"
									data-toggle="dropdown">
									English <span class="caret"></span>
								</button>
								<ul class="dropdown-menu no-border" role="menu">
									<li><a href="#">Vietnamese</a></li>
									<li class="divider"></li>
									<li><a href="#">English</a></li>
								</ul>
							</div>
						</div>
					</div>

					<div class="pull-right">
						<ul class="list-unstyled top-link">
							<!--không có các chấm danh much ở li  -->


							<c:choose>
								<c:when test="${pageContext.request.remoteUser}">
									<li><a href="<c:url value='setRegister' />">Register</a></li>
								</c:when>
								<c:otherwise>
									<li>${pageContext.request.remoteUser}</li>
									<li><a href="<c:url value='/listOrder' />">My Order</a></li>
									<li><a href="<c:url value='/logout' />">Logout</a></li>

								</c:otherwise>
							</c:choose>


							<li><a href="<c:url value='admin' />">Test</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- enad top-bar  -->

	<!--Menu  -->
	<div class="main-header">
		<div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
					<div class="btn-group">
						<button type="button" class="btn btn-default">Home</button>


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

						<button type="button" class="btn btn-default">
							<a href="<c:url value='listNews' />"> News </a>
						</button>
						<button type="button" class="btn btn-default">Introduction</button>
						<button type="button" class="btn btn-default">Liên hệ</button>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!--End Menu  -->

	<!-- Thanh Search -->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="pull-right"></div>
				<div class="pull-left"></div>
			</div>
		</div>
	</div>
	<!--End Thanh Search -->

	<section class="slider">
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="images/slider_1" alt="slider 1">
				<div class="carousel-caption">slider 1 example</div>
			</div>
			<div class="item">
				<img src="images/slider_2" alt="slider 2">
				<div class="carousel-caption">slider 2 example</div>
			</div>
			<div class="item">
				<img src="images/slider_3" alt="slider 3">
				<div class="carousel-caption">slider 3 example</div>
			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left"></span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
	</section>
	<!-- end slider  -->



	<div class="col-sm-9">
		<div class="container main-content form">
			<table class="table table-striped">
				<tr>
					<td>Image</td>
					<td>Product Name</td>
					<td>Price</td>
					<td>Description</td>
					<td>Detail</td>
				</tr>
				<c:forEach items="${listProduct}" var="list">
					<tr>
						<td>${list.imageURL}</td>
						<td><a
							href="<c:url value='getProductByID?id=${list.productID}' />">${list.productName}</a></td>
						<td>${list.price}</td>
						<td>${list.description}</td>
						<td>${list.status}</td>

					</tr>
				</c:forEach>
			</table>

		</div>
		<div class="col-sm-3"></div>


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