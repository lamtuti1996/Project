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
	<s:form action="/saveCart" method="POST">
		<table border="1">

			<tr>

				<%-- <td>${pageContext.request.remoteUser}</td> --%>

			</tr>

			<tr>

				<td><s:textfield name="c.name" value="%{c.name}" label="Name" /></td>
			</tr>

			<tr>


				<td><s:textfield name="c.mobile" value="%{c.mobile}"
						label="Mobile" /></td>

			</tr>

			<tr>


				<td><s:textfield name="c.address" value="%{c.address}"
						label="Address" /></td>

			</tr>
		</table>
		<input type="submit" value="Buy">
	</s:form>
</body>
</html>