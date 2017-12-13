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
			<th>Adress Customer</th>
			<th>Amount</th>
			<th>Mobile Cutomer</th>
			<th>Name Cutomer</th>
			<th>Notes</th>
			<th>Order Date</th>
			<th>Quatity Order</th>
			<th>Status</th>
		</tr>

		<logic:iterate name="listOrder" id="row">
			<tr>



				<td><html:link action="orderDetail.do" paramId="orderID"
						paramName="row" paramProperty="orderID">
						<bean:write name="row" property="orderID" />
					</html:link></td>
				<td><bean:write name="row" property="addressCustomer" /></td>
				<%-- 	<td><bean:write name="row" property="amount" /></td> --%>
				<td><bean:write name="row" property="mobileCustomer" /></td>
				<td><bean:write name="row" property="nameCustomer" /></td>
				<td><bean:write name="row" property="notes" /></td>
				<td><bean:write name="row" property="orderDate" /></td>

				<%-- 	<td><bean:write name="row" property="quatityOrder" /></td> --%>

				<td><bean:write name="row" property="status" /></td>

			</tr>
		</logic:iterate>

	</table>
</body>
</html>