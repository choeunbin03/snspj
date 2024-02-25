package com.snspj.domain;

public class FollowDTO extends BaseDTO{
	private int fllwId;	//pk
	private String mbrId;	//팔로우를 신청한 사용자 아이디
	private String flwrId;	//팔로우를 당한 사용자 아이디
	
	public int getFllwId() {
		return fllwId;
	}
	public void setFllwId(int fllwId) {
		this.fllwId = fllwId;
	}
	public String getMbrId() {
		return mbrId;
	}
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getFlwrId() {
		return flwrId;
	}
	public void setFlwrId(String flwrId) {
		this.flwrId = flwrId;
	}
	
}
