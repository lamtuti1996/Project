<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<%-- <script src="../js/app.js"></script> --%>
<script type="text/javascript">
	//Get XMLHTTP Object
	function getXMLHTTPObject() {
		var xmlhttpObject = null;
		try {
			// For Old Microsoft Browsers
			xmlhttpObject = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				// For Microsoft IE 6.0+
				xmlhttpObject = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e1) {
				// No Browser accepts the XMLHTTP Object then false
				xmlhttpObject = false;
			}
		}

		if (!xmlhttpObject && typeof XMLHttpRequest != 'undefined') {
			//For Mozilla, Opera Browsers
			xmlhttpObject = new XMLHttpRequest();
		}
		// Mandatory Statement returning the ajax object created
		return xmlhttpObject;
	}

	// Change the value of the outputText field
	function setAjaxOutput() {
		
		document.getElementById('notification').innerHTML = xmlhttpObject.responseText;
	}

	function handleServerResponse() {
		if (xmlhttpObject.readyState == 4) {
			if (xmlhttpObject.status == 200) {
				setAjaxOutput();
			} else {
				alert("Error during AJAX call. Please try again");
			}
		}
	}

	// Implement business logic
	function doAjaxCall() {
		xmlhttpObject = getXMLHTTPObject();
		if (xmlhttpObject != null) {
			var URL = "myAjaxAction.action?quanity="
					+ document.getElementById('quanity').value + "&productID="+
			document.getElementById('productID').value;
		
			xmlhttpObject.open("POST", URL, true);
			xmlhttpObject.onreadystatechange = handleServerResponse;
			xmlhttpObject.send(null);
		}
	}
</script>
</head>
<body>

	<div>Image</div>
	<div>Product Name</div>
	<div>Price</div>
	<div>Description</div>
	<div>Status</div>

	<div>
		<s:property value="%{product.imageURL}" />
	</div>
	<div>
		<s:property value="%{product.productName}" />
	</div>
	<div>
		<s:property value="%{product.price}" />
	</div>
	<div>
		<s:property value="%{product.description}" />
	</div>
	<div>
		<s:property value="%{product.status}" />
	</div>

	<s:form action="addCart" method="get">

		<s:textfield key="quanity" id="quanity" name="quanity"
			onblur="doAjaxCall();" />
		<s:hidden id="productID" name="productID" value="%{product.productID}" />
		<s:submit key="submit" />
	</s:form>
	<%-- <s:textfield id="notification" /> --%>
	<div id="notification" style="color: red; font-weight: bold"></div>
</body>
</html>