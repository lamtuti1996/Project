<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Order ID</th>
			<th>Product Name</th>
			<th>Quanity</th>
			<th>Image URL</th>
			<th>Product Price</th>
			<th>Total Price</th>

		</tr>

		<logic:iterate name="listOrderDetail" id="row">
			<tr>

				<td><bean:write name="row" property="orderId" /></td>
				<td><bean:write name="row" property="productName" /></td>
				<td><bean:write name="row" property="quanity" /></td>

				<td><bean:write name="row" property="imageURL" /></td>
				<%-- <td><bean:write name="row" property="productPrice" /></td> --%>
				<%-- <td><bean:write name="row" property="totalPrice" /></td> --%>

			</tr>
		</logic:iterate>

	</table>
</body>
</html>