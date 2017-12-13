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
<div class="container">
<div class="col-sm-9">
<c:forEach var="list" items="${listProduct}" begin="0" end="2">

<div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="${list.imageURL}" alt="${list.productName}">
      <div class="caption">
        <h3><a href="<c:url value='getProductByID?id=${list.productID}' />">${list.productName}</a></h3>
        <p>${list.description}</p>
       
      </div>
    </div>
  </div>
</div>

 </c:forEach>
</div>
<div class="col-sm-3"></div>
</div>
</body>
</html>