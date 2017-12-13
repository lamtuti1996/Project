<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>

	<s:if test="%{#parameters.error != null}">
		<div style="color: red">Invalid User</div>
	</s:if>
	<s:form name="loginForm" action="j_spring_security_check" method="post">
		<s:textfield name="username" label="Username" />
		<s:password name="password" label="Password" />
		<s:submit value="Login" />
	</s:form>
</body>
</html>