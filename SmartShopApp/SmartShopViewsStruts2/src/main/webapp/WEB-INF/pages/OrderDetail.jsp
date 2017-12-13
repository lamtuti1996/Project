<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>Insert title here</title>
</head>
<body>
	<div class="container main-content form">
		<table class="table table-striped">
			<tr>
				<td>Order ID</td>
				<td>Image</td>
				<td>Product Name</td>
				<td>Quanity</td>
				<td>Price</td>
				<td>Amount</td>


			</tr>
			<s:iterator value="listOrderDetail" var="list">
				<tr>
					<td><s:property value="#list.orderId" /></td>


					<td><s:property value="#list.imageURL" /></td>
					<td><s:property value="#list.productName" /></td>
					<td><s:property value="#list.quanity" /></td>
					<td><s:property value="#list.productPrice" /></td>
					<td><s:property value="#list.totalPrice" /></td>

				</tr>
			</s:iterator>

		</table>
		<div>
			<ul class='pagination pagination-centered'>
				<s:if test="%{pageOrderCustomize.firstPage}">
					<li class="disabled"><span>Fist</span></li>

				</s:if>
				<s:else>
					<li><s:url action="%{pageOrderCustomize.url}" var="urlTag">
							<s:param name="page" value="0" />
							<s:param name="size" value="%{pageOrderCustomize.size}" />

						</s:url> <s:a href="%{urlTag}">First</s:a></li>

				</s:else>

				<s:if test="%{pageOrderCustomize.hasPreviousPage}">
					<li><s:url action="%{pageOrderCustomize.url}" var="urlTag">
							<s:param name="page" value="%{pageOrderCustomize.number-2}" />

							<s:param name="size" value="%{pageOrderCustomize.size}" />

						</s:url> <s:a href="%{urlTag}">«</s:a></li>
				</s:if>
				<s:else>
					<li class="disabled"><span>«</span></li>
				</s:else>

				<s:iterator value="items" var="item">
					<s:if test="#item.current">
						<li class="active"><s:if test="#item.current">
								<span><s:property value="#item.number" /></span>
							</s:if> <s:else>

								<s:url action="%{pageOrderCustomize.url}" var="urlTag">
									<s:param name="page" value="#item.number-1" />

									<s:param name="size" value="%{pageOrderCustomize.size}" />

								</s:url>
								<s:a href="%{urlTag}">
									<s:property value="#item.number" />
								</s:a>

							</s:else></li>
					</s:if>
					<s:else>
						<li><s:if test="#item.current">
								<span><s:property value="#item.number" /></span>
							</s:if> <s:else>
								<s:url action="%{pageOrderCustomize.url}" var="urlTag">
									<s:param name="page" value="#item.number-1" />

									<s:param name="size" value="%{pageOrderCustomize.size}" />

								</s:url>
								<s:a href="%{urlTag}">
									<s:property value="#item.number" />
								</s:a>

							</s:else></li>
					</s:else>
				</s:iterator>
				<s:if test="%{pageOrderCustomize.hasNextPage}">
					<li><s:url action="%{pageOrderCustomize.url}" var="urlTag">
							<s:param name="page" value="%{pageOrderCustomize.number}" />

							<s:param name="size" value="%{pageOrderCustomize.size}" />


						</s:url> <s:a href="%{urlTag}">»</s:a></li>
				</s:if>
				<s:else>
					<li class="disabled"><span>»</span></li>
				</s:else>
				<s:if test="%{pageOrderCustomize.lastPage}">
					<li class="disabled"><span>Last </span></li>
				</s:if>
				<s:else>
					<li><s:url action="%{pageOrderCustomize.url}" var="urlTag">
							<s:param name="page" value="%{pageOrderCustomize.totalPages-1}" />
							<s:param name="size" value="%{pageOrderCustomize.size}" />
						</s:url> <s:a href="%{urlTag}">Last</s:a></li>
				</s:else>


			</ul>
		</div>
	</div>
</body>
</html>