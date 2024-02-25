package com.snspj.domain;

public class BoardDTO extends BaseDTO{
	private int bbsId;
	private String bbsCn;
	private int atchFileNo;
	private int bbsSptCnt;
	private String bbsPlc;
	
	
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public String getBbsCn() {
		return bbsCn;
	}
	public void setBbsCn(String bbsCn) {
		this.bbsCn = bbsCn;
	}
	public int getAtchFileNo() {
		return atchFileNo;
	}
	public void setAtchFileNo(int atchFileNo) {
		this.atchFileNo = atchFileNo;
	}
	public int getBbsSptCnt() {
		return bbsSptCnt;
	}
	public void setBbsSptCnt(int bbsSptCnt) {
		this.bbsSptCnt = bbsSptCnt;
	}
	public String getBbsPlc() {
		return bbsPlc;
	}
	public void setBbsPlc(String bbsPlc) {
		this.bbsPlc = bbsPlc;
	}	
}
