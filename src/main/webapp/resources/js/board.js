function fn_goBackPg(){
	var referrer = document.referrer;	
	window.location.href = referrer;
};

function fn_regiBbs(){
	var createForm = document.getElementById("bbsRegifrm");
	var formData = new FormData(createForm );
	var data = {   
//	    "userId"    : $("#userId").val(),
//	    "title"     : $("#title").val(),
//	    "contents"  :  $("#contents").val()
	};

	var fileInput = $("#fileupload");
	
//	formData.append( "fileupload", $("#fileupload")[0].files[0] );
	
	for (var i = 0; i < fileInput.length; i++) {
		if (fileInput[i].files.length > 0) {
			for (var j = 0; j < fileInput[i].files.length; j++) {
				console.log(" fileInput[i].files[j] :::"+ fileInput[i].files[j]);
				
				// formData에 'file'이라는 키값으로 fileInput 값을 append 시킨다.  
				//formData.append('fileupload', $('#fileupload')[i].files[j]);
			}
		}
	}
	
	formData.append('key', new Blob([ JSON.stringify(data) ], {type : "application/json"}));
	
	$.ajax({
		type : "POST",
		url : "/board/regiBbs",
		data : formData,
		processData : false,
		contentType: false,
		success : function(data){
			if(data == "Y"){
				alert("글 등록이 완료되었습니다.");
				location.href = "/board/bbsList";
			}else{
				alert("글 등록이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
}

