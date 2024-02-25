package com.snspj.domain;

import java.util.Date;

public class MemberDTO {

	private String mbrNm;//회원명
	private String mbrId;//회원 아이디
	private String mbrPwd;//회원 암호
	private String mbrRoadAddr;//회원 집주소(도로명주소)
	private String mbrAddrDetail;//회원 집주소(상세주소)
	private int mbrZipNo;//우편번호
	private String mbrEmlAddr;//회원 이메일주소
	private int mbrTelNo;//회원 전화번호
	private int atchFileNo;//첨부파일 번호(프로필 사진)
	private int mbrFlwrCnt;//팔로워 수
	private int mbrFlwngCnt;//팔로잉 수
	private int mbrBbsCnt;//내 게시물 수
	private String mbrIntrcn;//소개글
	private Date mbrJoinYmd;//회원가입 일자
	public String getMbrNm() {
		return mbrNm;
	}
	public void setMbrNm(String mbrNm) {
		this.mbrNm = mbrNm;
	}
	public String getMbrId() {
		return mbrId;
	}
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getMbrPwd() {
		return mbrPwd;
	}
	public void setMbrPwd(String mbrPwd) {
		this.mbrPwd = mbrPwd;
	}	
	public String getMbrRoadAddr() {
		return mbrRoadAddr;
	}
	public void setMbrRoadAddr(String mbrRoadAddr) {
		this.mbrRoadAddr = mbrRoadAddr;
	}
	public String getMbrAddrDetail() {
		return mbrAddrDetail;
	}
	public void setMbrAddrDetail(String mbrAddrDetail) {
		this.mbrAddrDetail = mbrAddrDetail;
	}
	public int getMbrZipNo() {
		return mbrZipNo;
	}
	public void setMbrZipNo(int mbrZipNo) {
		this.mbrZipNo = mbrZipNo;
	}
	public String getMbrEmlAddr() {
		return mbrEmlAddr;
	}
	public void setMbrEmlAddr(String mbrEmlAddr) {
		this.mbrEmlAddr = mbrEmlAddr;
	}
	public int getMbrTelNo() {
		return mbrTelNo;
	}
	public void setMbrTelNo(int mbrTelNo) {
		this.mbrTelNo = mbrTelNo;
	}
	public int getAtchFileNo() {
		return atchFileNo;
	}
	public void setAtchFileNo(int atchFileNo) {
		this.atchFileNo = atchFileNo;
	}
	public int getMbrFlwrCnt() {
		return mbrFlwrCnt;
	}
	public void setMbrFlwrCnt(int mbrFlwrCnt) {
		this.mbrFlwrCnt = mbrFlwrCnt;
	}
	public int getMbrFlwngCnt() {
		return mbrFlwngCnt;
	}
	public void setMbrFlwngCnt(int mbrFlwngCnt) {
		this.mbrFlwngCnt = mbrFlwngCnt;
	}
	public int getMbrBbsCnt() {
		return mbrBbsCnt;
	}
	public void setMbrBbsCnt(int mbrBbsCnt) {
		this.mbrBbsCnt = mbrBbsCnt;
	}	
	public String getMbrIntrcn() {
		return mbrIntrcn;
	}
	public void setMbrIntrcn(String mbrIntrcn) {
		this.mbrIntrcn = mbrIntrcn;
	}
	public Date getMbrJoinYmd() {
		return mbrJoinYmd;
	}
	public void setMbrJoinYmd(Date mbrJoinYmd) {
		this.mbrJoinYmd = mbrJoinYmd;
	}

	
	
}
