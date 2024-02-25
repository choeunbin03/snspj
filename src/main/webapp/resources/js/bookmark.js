function fn_addBookmark(bmkParam, cnt){
	var params = bmkParam[cnt];
	
	$.ajax({
		type : "POST",
		url : "/bookmark/bmkPlc",
		data : JSON.stringify(params),
		contentType : "application/json; charset=UTF-8",
		success : function(data){
				location.reload();
		},
		error : function(request, status, error){
			alert("실패");
			console.log("code: " + request.status);
			console.log("message: " + request.responseText);
			console.log("error: " + error);
		}
	});
}