<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*[id$=errors]{
	color:red;
	font-style: italic;
}
</style>

</head>
<body>
${message} 
	<form:form action="validate2" modelAttribute="student">
		<div>Họ Tên</div>
		<form:input path="name" /><form:errors path="name"/> 
		<div>Điểm</div>
		<form:input path="mark" /> <form:errors path="mark"/> 
		<div>Chuyên ngành</div>
		<form:radiobutton path="major" value="APP" label="Ứng dụng phần mềm" />
		<form:radiobutton path="major" value="WEB" label="Thiết kế trang web" /><form:errors path="major"/> 
		<div>
			<button>Validate 1</button>
		</div>

	</form:form>


</body>
</html>