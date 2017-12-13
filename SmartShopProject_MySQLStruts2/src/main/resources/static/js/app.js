$(document).ready(function() {
	checkQuanityProduct();
	
});

function checkQuanityProduct() {
	$('#buttonBuy').click(function() {
		var quanity = $(quanityField).val();
		var id = $(productID).val();
		var param = "productID=" + id + "&" + "quanity=" + quanity;
		$.ajax({

			url : '/checkQuanity',
			type : 'GET',
			data : param,
			success : function(data) {
				if (data == true) {
				  
					$("#buy_Form").submit();
				} else {

					$("#notification").text("Not enough quantity");
					alert("faile");
				}
			}

		});

	});

}

