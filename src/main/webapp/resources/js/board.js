function fn_goBackPg(){
	var referrer = document.referrer;	
	window.location.href = referrer;
};

function fn_updateBbsSpt(bbsId){
	
	$.ajax({
		type : "POST",
		url : "/board/updateBbsSpt",
		data : {bbsId: bbsId},
		success : function(data){
			location.reload();
		},
		error : function(data){
			alert("실패");
			console.log(data);
		}
	});
};