<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Image</th>
			<th>Name Product</th>
			<th>Quanity</th>
			<th>Price</th>
			<th>Total</th>
			<th>Increase</th>
			<th>Decrease</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${cartInfo.cartLines}" var="cartLineInfo">
			<tr>

				<td>${cartLineInfo.productInfo.imageURL}</td>
				<td>${cartLineInfo.productInfo.productName}</td>
				<td>${cartLineInfo.quantity}</td>
				<td>${cartLineInfo.productInfo.price}</td>
				<td>${cartLineInfo.totalPrice}</td>
				<td><a
					href="<c:url value='increaseQuanity?id=${cartLineInfo.productInfo.productID}' />">
						+ </a></td>
				<td><a
					href="<c:url value='decreaseQuanity?id=${cartLineInfo.productInfo.productID}' />">
						- </a></td>
				<td><a
					href="<c:url value='removeProduct?id=${cartLineInfo.productInfo.productID}' />">
						X </a></td>
			</tr>
		</c:forEach>
		<tr>
			<td>${totalQuantity}</td>
			<td>${totalAmount}</td>
		</tr>

	</table>
	<form action="setCustomerInfo" method="get">
	<input type="submit" value="Save">
	</form>
		<form action="setHome" method="get">
	<input type="submit" value="Buy More">
	</form>
</body>
</html>