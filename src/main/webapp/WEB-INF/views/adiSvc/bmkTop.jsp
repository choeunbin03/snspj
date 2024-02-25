<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		#totalContainer {display:flex; height:100%;}
		#bmkTopList {width:350px; display:block; border-right:1px solid #E2E2E2; height:100%; overflow:auto;}
		#mapContent {width:100%; height:95%;}
		
	</style>
	
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">
		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/search.js" type="text/javascript" defer="defer"></script>
	<script src="${path}/resources/js/bookmark.js" type="text/javascript" defer="defer"></script>
	
	
	
</head>
<body>
	<div id="totalContainer">
		<%@ include file="../module/side.jsp" %>
		
		<div id="bmkTopList">			
			
			<h3>저장 TOP</h3>
			<br>
			<table>
				<tbody>
					<c:forEach items="${bmkTopList}" var="bmkTopList" varStatus="status">
						<tr>
							<td>
							<a href="#" onclick="panTo(${bmkTopList.x}, ${bmkTopList.y})">
								<span id="bmkItem"></span>
								<div>${bmkTopList.place_name}</div>
								<div>${bmkTopList.road_address_name}</div>
								<div>${bmkTopList.address_name}</div>
								<div>${bmkTopList.phone}</div>
								<button type="button" onclick='fn_addBookmark(${jsonResult}, ${status.index})'>북마크</button>
							</a>
							</td>								
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div><!-- //bmkCtgry -->
		
		
		<div id="mapContent">
			<div id="map" style="width:100%;height:100%;"></div>
		</div>	<!-- mapContent -->
			
	</div><!-- totalContainer -->
	
	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d8b839059cce4c79377c08d03ea18c5f"></script>
<script>
	var markers = [];
	var bmkTopJsonString = ${bmkTopJsonString};
	var x = [];
	var y = [];
	var bmkItem = document.getElementById("bmkItem");
	
 	for(var i = 0; i<bmkTopJsonString.length; i++){
		x[i] = bmkTopJsonString[i].x;
		y[i] = bmkTopJsonString[i].y;
	}
 
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 4
	};
	
	var map = new kakao.maps.Map(container, options);
	
	var infowindow = new kakao.maps.InfoWindow({zindex:1});
	
//현재 위치
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        
	        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	            
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, message);
	}
	
	function displayMarker(locPosition, message) {

	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({  
	        map: map, 
	        position: locPosition
	    }); 
	    
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;

	    // 인포윈도우를 생성합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content : iwContent,
	        removable : iwRemoveable
	    });
	    
	    // 인포윈도우를 마커위에 표시합니다 
	    infowindow.open(map, marker);
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);      
	}    
	
		
	
//마커	

$( document ).ready(function displayPlaces(){
	

		for ( var i=0; i<bmkTopJsonString.length; i++ ) {
			
			fragment = document.createDocumentFragment(); 
		    bounds = new kakao.maps.LatLngBounds(); 
	
	        // 마커를 생성하고 지도에 표시합니다
	        var placePosition = new kakao.maps.LatLng(y[i], x[i]);
			var marker = addMarker(placePosition, i); 
			
	        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
	        // LatLngBounds 객체에 좌표를 추가합니다
	        bounds.extend(placePosition);
	
	        // 마커와 검색결과 항목에 mouseover 했을때
	        // 해당 장소에 인포윈도우에 장소명을 표시합니다
	        // mouseout 했을 때는 인포윈도우를 닫습니다
	        (function(marker, title) {
	            kakao.maps.event.addListener(marker, 'mouseover', function() {
	                displayInfowindow(marker, title);
	            });
	
	            kakao.maps.event.addListener(marker, 'mouseout', function() {
	                infowindow.close();
	            });
	
	            bmkItem.onmouseover =  function () {
	                displayInfowindow(marker, title);
	            };
	
	            bmkItem.onmouseout =  function () {
	                infowindow.close();
	            };
	        })(marker, bmkTopJsonString[i].place_name);
	
	        fragment.appendChild(bmkItem);
	    }
		map.setBounds(bounds);
    
	});
	
	function addMarker(position, idx, title) {
	    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
	        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
	        imgOptions =  {
	            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
	            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
	            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
	        },
	        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
	            marker = new kakao.maps.Marker({
	            position: position, // 마커의 위치
	            image: markerImage 
	        });

	    marker.setMap(map); // 지도 위에 마커를 표출합니다
	    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

	    return marker;
	}
	
	function displayInfowindow(marker, title) {
	    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

	    infowindow.setContent(content);
	    infowindow.open(map, marker);
	}
	
	//지도 이동하기(부드럽게 이동)
	function panTo(x, y) {
	    // 이동할 위도 경도 위치를 생성합니다 
	    var moveLatLon = new kakao.maps.LatLng(y, x);
	    
	    // 지도 중심을 부드럽게 이동시킵니다
	    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
	    map.panTo(moveLatLon);            
	}
</script>


</body>
</html>