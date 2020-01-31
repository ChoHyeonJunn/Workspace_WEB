package com.cal.dto;

import java.util.Date;

public class CALBOARD {
	private int SEQ;
	private String ID;
	private String TITLE;
	private String CONTENT;
	private String MDATE;
	private Date REGDATE;

	public CALBOARD() {
		super();
	}

	public CALBOARD(int sEQ, String iD, String tITLE, String cONTENT, String mDATE, Date rEGDATE) {
		super();
		SEQ = sEQ;
		ID = iD;
		TITLE = tITLE;
		CONTENT = cONTENT;
		MDATE = mDATE;
		REGDATE = rEGDATE;
	}

	public int getSEQ() {
		return SEQ;
	}

	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public String getMDATE() {
		return MDATE;
	}

	public void setMDATE(String mDATE) {
		MDATE = mDATE;
	}

	public Date getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}

	@Override
	public String toString() {
		return "CALBOARD [SEQ=" + SEQ + ", ID=" + ID + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT + ", MDATE=" + MDATE
				+ ", REGDATE=" + REGDATE + "]";
	}

}
