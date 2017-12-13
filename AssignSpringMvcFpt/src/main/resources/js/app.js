/*
function Edit(){
	var par = $(this).parent().parent(); //tr

	var tdMark = par.children("td:nth-child(2)");
	var tdNameMajor = par.children("td:nth-child(3)");


	tdMark.html("<input type='text' id='txtName' value='"+tdMark.html()+"'/>");
	tdNameMajor.html("<input type='text' id='txtPhone' value='"+tdNameMajor.html()+"'/>");
	

	$(".btnSave").bind("click", Save);
	$(".btnEdit").bind("click", Edit);
	$(".btnDelete").bind("click", Delete);
};


$(document).ready(function(){
	
	$().click(function(){
		
		alter('chay vao update'),
		
		
		var par = $(this).parent().parent(); //tr

		var tdMark = par.children("td:nth-child(2)");
		var tdNameMajor = par.children("td:nth-child(3)");


		tdMark.html("<input type='text' id='txtName' value='"+tdMark.html()+"'/>");
		tdNameMajor.html("<input type='text' id='txtPhone' value='"+tdNameMajor.html()+"'/>");
		
		
	});
			

 */

$(document).ready(function() {
	updateFunction();
	deleteFunction();
	addFunction();
});

function addFunction() {
	$('#add_click').click(function() {
		/*
		 * Window: đối tượng ở mức cao nhất, có các thuộc tính thực hiện áp dụng
		 * trên toàn cửa sổ 
		 * Location: đối tượng lưu thông tin về URL hiện hành
		 * 
		 * Document: đối tượng mô tả toàn bộ cấu trúc HTML của tài liệu, có thể
		 * sử dụng đối tượng này để truy cập các thành phần trong trang.
		 * 
		 */
		window.location.href = "/setAddStudent";

	});
}

function deleteFunction() {
	$('#delete_click').click(function() {

		var array = [];
		var checkbox = $('input[name="active"]:checked');

		for (var i = 0; i < checkbox.length; i++) {
			array.push($(checkbox[i]).val());
		}

		var jsonArray = JSON.stringify(array)

		$.ajax({

			url : '/deleteStudent',
			type : 'POST',
			dataType : 'json',
			contentType : "application/json; charset=utf-8",
			data : jsonArray,
			success : function(data) {
				if (data == true) {
					location.reload();
					alert("successfully");
				} else {
					alert("faile");
				}
			}

		});

	});

}

function updateFunction() {
	// function là callback function là hàm gọi lại thực hiện dạng bất đồng bộ
	var array = [];
	var check = false;

	$('#update_click')
			.click(
					function() {

						// :checked đối tượng này có đc check hay không
						/*
						 * var values =
						 * $('input[name="active"]:checked').map(function()
						 * {//Qua mỗi phần tử được chọn, thông qua một function
						 * tạo ra một jquery object có chứa các giá trị trả lại.
						 * return this.id; }).get(); //alert(values);
						 */

						var checkbox = $('input[name="active"]:checked');

						for (var i = 0; i < checkbox.length; i++) {
							array.push($(checkbox[i]).val());
						}

						var arraySize = array.length;

						if (arraySize == 1) {
							var id;
							for (var i = 0; i < array.length; i++) {
								id = array[i];
							}

							window.location.href = "/setUpdate/" + id + "";

						} else {
							check = true;
							for (var i = 0; i < array.length; i++) {

								mark = 'mark' + array[i];
								major = 'major' + array[i];

								markInput = 'input' + mark;
								majorInput = 'input' + major;
								var eMark = '#' + mark;
								var eMajor = '#' + major;

								$(eMark)
										.each(
												// Thực hiện một hành động cho
												// mỗi phần tử, mỗi lần thực
												// hiện một phần tử, để làm được
												// điều này ta cần sử dụng
												// phương thức $(this).
												function() {
													var html = $(this).html();
													var input = $("<input type='text'  name='markName' id='"
															+ markInput
															+ "' />");
													input.val(html);
													$(this).html(input);
												});

								$(eMajor)
										.each(
												function() {
													var html = $(this).html();
													var input = $("<input type='text'  name='majorName' id='"
															+ majorInput
															+ "'  />");
													input.val(html);
													$(this).html(input);
												});
							}

						}

					});

	function updateFunction() {
		var pluginArray = new Array();
		console.log(array.length);
		for (var i = 0; i < array.length; i++) {

			var id = array[i];

			var markID = '#inputmark' + array[i];
			var markValue = $(markID).val();

			var majorID = '#inputmajor' + array[i];
			var majorValue = $(majorID).val();

			var jsonArg = new Object();
			jsonArg.id = id;
			jsonArg.nameMajor = majorValue;
			jsonArg.mark = markValue;

			pluginArray.push(jsonArg);

		}
		var jsonArray = JSON.stringify(pluginArray)
		console.log(jsonArray);
		return jsonArray;

	}

	if (check = true) {

		var oKey_code = {
			KEYCODE_ENTER : 13,
			KEYCODE_ESC : 27,
			KEYCODE_DELETE : 46
		};

		$(document).keyup(function(e) {

			switch (e.keyCode) {
			case oKey_code.KEYCODE_ENTER:
				$.ajax({

					url : '/editStudent',
					type : 'POST',
					dataType : 'json',
					contentType : "application/json; charset=utf-8",
					data : updateFunction(),
					success : function(data) {
						if (data == true) {
							location.reload();
							alert("successfully");
						} else {
							alert("faile");
						}
					}

				});

				break;

			default:
				return;
			}
		});
	}

};
