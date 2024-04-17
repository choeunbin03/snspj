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

function fn_bmkBbs(bbsId, bmkYn, index){
	var funcType = null;
	
	if(bmkYn == 'N'){//북마크 add
		funcType = "add";
		$.ajax({
			type : "POST",
			url : "/bookmark/bmkBbs",
			data : {bbsId: bbsId, funcType: funcType},
			success : function(data){
				//location.reload();
				//console.log("하트 add");
				$(".feed-bmk-wrapper"+index).load(location.href + " .feed-bmk-wrapper"+index);	//부분 업데데이트
			},
			error : function(data){
				alert("실패");
				console.log(data);
			}
		});

	}else{//북마크 remove
		funcType = "remove";
		$.ajax({
			type : "POST",
			url : "/bookmark/bmkBbs",
			data : {bbsId: bbsId, funcType: funcType},
			success : function(data){
				//location.reload();
				//console.log("하트 remove");
				$(".feed-bmk-wrapper"+index).load(location.href + " .feed-bmk-wrapper"+index);
			},
			error : function(data){
				alert("실패");
				console.log(data);
			}
		});

	}
}