<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://paginationtag.miin.com" prefix="pagination-tag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h1>Information User</h1>

	<div>
		<html:link href="myOrder.do">My Order</html:link>
	</div>
	<div>
		<html:link href="CreateUser.jsp">Create User</html:link>
	</div>
	<div>
		<html:link href="test2.do">Test</html:link>
	</div>
 <table border="1">
		<tr>
			<th>Product ID</th>
			<th>Description</th>
			<th>Image URL</th>
			<th>Product Price</th>
			<th>Product Name</th>
			<th>Quality</th>
			<th>Status</th>
		</tr>

		<logic:iterate name="showProductForm.listProduct"
			id="row" >
			<tr>
				<td><bean:define id="id" type="java.lang.Integer" name="row"
						property="productID" /></td>
				<td><%=id%></td>
				<td><bean:write name="id" /></td>

				<td><bean:write name="row" property="description" /></td>
				<td><bean:write name="row" property="imageURL" /></td>
				<td><bean:write name="row" property="productPrice" /></td>
				<td><bean:write name="row" property="productName" /></td>
				<td><bean:write name="row" property="quality" /></td>
				<td><bean:write name="row" property="status" /></td>
			</tr>
		</logic:iterate>
	</table> 
	
	
	<display:table id="data"
		
		name="showProductForm.listProduct"
		requestURI="/showProduct.do" pagesize="3">
		<display:column property="productID" title="Product ID"
			sortable="true" />
		<display:column property="description" title="Description"
			sortable="true" />
		<display:column property="imageURL" title="Image URL" sortable="true" />
		<display:column property="productPrice" title="Product Price"
			sortable="true" />
		<display:column property="productName" title="Product Name"
			sortable="true" />
		<display:column property="quality" title="Quality" sortable="true" />
		<display:column property="status" title="Status" sortable="true" />
	</display:table>

	
	<c:set var="start" value="${paginationForm.start}" />
	<c:set var="range" value="${paginationForm.range}" />
	<c:set var="results" value="${paginationForm.results}" />

	<jsp:useBean id="start" class="java.lang.String" />
	<jsp:useBean id="range" class="java.lang.String" />
	<jsp:useBean id="results" class="java.lang.String" />
	<pagination-tag:pager start="<%=start%>" range="<%=range%>"
		results="<%=results%>" styleClass="paginationClass" />
</body>
</html>

<%-- name="sessionScope.showProductForm.listProduct" --%>