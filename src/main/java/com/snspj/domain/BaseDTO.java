package com.snspj.domain;

import java.util.Date;

public class BaseDTO {
	
	private String rgtrId;//등록자 아이디
	private Date   rgtrDt;//등록 일시
	private String mdfrId;//수정자 아이디
	private Date   mdfrDt;//수정일시
	
	public String getRgtrId() {
		return rgtrId;
	}
	public void setRgtrId(String rgtrId) {
		this.rgtrId = rgtrId;
	}
	public Date getRgtrDt() {
		return rgtrDt;
	}
	public void setRgtrDt(Date rgtrDt) {
		this.rgtrDt = rgtrDt;
	}
	public String getMdfrId() {
		return mdfrId;
	}
	public void setMdfrId(String mdfrId) {
		this.mdfrId = mdfrId;
	}
	public Date getMdfrDt() {
		return mdfrDt;
	}
	public void setMdfrDt(Date mdfrDt) {
		this.mdfrDt = mdfrDt;
	}
	
	

}
