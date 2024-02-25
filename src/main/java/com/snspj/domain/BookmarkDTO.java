package com.snspj.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkDTO extends BaseDTO{
	private String mbrId; //회원 아이디
	private int bmkType; //북마크 타입 (0:게시글 북마크, 1:장소 북마크)
	private String bmkCn; //게시물: 게시물번호, 장소: 장소 정보 JsonString(place_name, address_name, road_address_name, x, y, phone)
	private String ctgryNm; // 카테고리 내용 : (게시물은 항상 null, 장소는 사용자 설정)
}
