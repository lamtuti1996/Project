<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
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

		<s:iterator value="cartLines" var="list">

			<tr>
				<td><s:property value="%{#list.productInfo.imageURL}" /></td>
				<td><s:property value="%{#list.productInfo.productName}" /></td>
				<td><s:property value="%{#list.quantity}" /></td>
				<td><s:property value="%{#list.productInfo.price}" /></td>
				<td><s:property value="%{#list.totalPrice}" /></td>

				<td><s:url action='increaseQuanity' var="urlTag">
						<s:param name="productID" value="%{#list.productInfo.productID}" />

					</s:url> <s:a href="%{urlTag}">
						+
					</s:a></td>
				<td><s:url action='decreaseQuanity' var="urlTag">
						<s:param name="productID" value="%{#list.productInfo.productID}" />

					</s:url> <s:a href="%{urlTag}">
						-
					</s:a></td>
				<td><s:url action='removeProduct' var="urlTag">
						<s:param name="productID" value="%{#list.productInfo.productID}" />

					</s:url> <s:a href="%{urlTag}">
						X
					</s:a></td>
			</tr>
		</s:iterator>
		<tr>
			<td><s:property value="totalQuantity" /></td>
			<td><s:property value="totalAmount" /></td>
		</tr>



	</table>
	<s:form action="setCustomerInfo" method="get">
		<input type="submit" value="Save">
	</s:form>
	
	<s:form action="setHome" method="get">
		<input type="submit" value="Buy More">
	</s:form>

</body>
</html>