function fn_srch(){
	var srchFrm = document.getElementById("srchFrm");
	srchFrm.method = "get";
	srchFrm.target = "_self";
	
	var f = $("#srchFrm");
	var keyWd = $("#keyWd").val();
//	var type;	//0: 인물 검색, 1: 주소 기반 검색, 2: 키워드로 장소 검색
	var url = '/kakao/searchByAddr';
	if(keyWd[0] == '@'){
		url='/search/srchPrsn?keyWd="+keyWd';
	}else{
		url='/kakao/searchByAddr?keyWd="+keyWd';
	}
	srchFrm.action = url;
	srchFrm.submit();
	
/*	$.ajax({
		type : "GET",
		url : url,
		data : {query : keyWd},
		success : function(data){
			if(data){
				//맵 띄워주는 함수 삽입^^
			}else{
				alert("정보 잘못됨");
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});*/
	/*
	f.attr("action", "/kakao/searchByAddr?keyWd="+keyWd);
	f.attr("method", "GET");
	f.submit();
	*/
}

function fn_srch_old(){
	var f = $("#srchFrm");
	var keyWd = $("#keyWd").val();
//	var type;	//0: 인물 검색, 1: 주소 기반 검색, 2: 키워드로 장소 검색
	var url = '/kakao/searchByAddr';
	if(keyWd[0] == '@'){
//		type = 0; 
		f.attr("action", "/search/srchPrsn?keyWd="+keyWd);
		f.attr("method", "GET");
		f.submit();
	}else{
		$.ajax({
			type : "GET",
			url : url,
			data : {query : keyWd},
			success : function(data){
				if(data){
					//맵 띄워주는 함수 삽입^^
				}else{
					alert("정보 잘못됨");
				}
			},
			error: function(data){
				alert("실패");
				console.log(data);
			}
		});
		/*
		f.attr("action", "/kakao/searchByAddr?keyWd="+keyWd);
		f.attr("method", "GET");
		f.submit();
		*/
		
	}
}