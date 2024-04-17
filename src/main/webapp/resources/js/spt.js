function fn_updateBbsSpt(bbsId, sptYn, index){
	var funcType = null;
	//url을 다르게 해줘야 함. controller를 따로 빼기?spt를?
	if(sptYn == 'N'){//좋아요 add
		funcType = "add";
		$.ajax({
			type : "POST",
			url : "/board/updateBbsSpt",
			data : {bbsId: bbsId, funcType: funcType},
			success : function(data){
				//location.reload();
				//console.log("하트 add");
				$(".feed-heart-wrapper"+index).load(location.href + " .feed-heart-wrapper"+index);	//부분 업데데이트
			},
			error : function(data){
				alert("실패");
				console.log(data);
			}
		});
//		$(".feed-heart-btn"+index).html('<i class="xi-heart xi-2x"></i>');

	}else{//좋아요 remove
		funcType = "remove";
		$.ajax({
			type : "POST",
			url : "/board/updateBbsSpt",
			data : {bbsId: bbsId, funcType: funcType},
			success : function(data){
				//location.reload();
				console.log("하트 remove");
				$(".feed-heart-wrapper"+index).load(location.href + " .feed-heart-wrapper"+index);
			},
			error : function(data){
				alert("실패");
				console.log(data);
			}
		});
//		$(".feed-heart-btn"+index).html('<i class="xi-heart-o xi-2x"></i>');//그냥 부분적으로 화면을 변경하는 코드.근본적인 업데이트는 안됨

	}
	
};