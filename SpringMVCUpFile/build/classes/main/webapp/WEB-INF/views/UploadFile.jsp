<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.form-group{
margin: 10px;
}
</style>

</head>
<body>
<h2>NỘP ĐƠN XIN VIỆC</h2>
${message}
<form action="upload" method="post" enctype="multipart/form-data">
<div class="form-group">
<div>Họ và tên ứng viên</div>
<input type="text" name="fullname">
</div>
<div class="form-group">
<div>Hình ảnh</div>
<input type="file" name="photo">
</div>
<div class="form-group">
<div>Hồ sơ xin việc</div>
<input type="file" name="cv">
</div>
<div class="form-group">
<button>Nộp</button>
</div>
</form>

</body>
</html>