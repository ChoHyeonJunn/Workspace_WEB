package com.mvc.dto;

import java.util.Date;

public class MVCDto {
	private int SEQ;
	private String WRITER;
	private String TITLE;
	private String CONTENT;
	private Date REGDATE;

	public MVCDto() {
		super();
	}

	public MVCDto(int sEQ, String wRITER, String tITLE, String cONTENT, Date rEGDATE) {
		super();
		SEQ = sEQ;
		WRITER = wRITER;
		TITLE = tITLE;
		CONTENT = cONTENT;
		REGDATE = rEGDATE;
	}

	public int getSEQ() {
		return SEQ;
	}

	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}

	public String getWRITER() {
		return WRITER;
	}

	public void setWRITER(String wRITER) {
		WRITER = wRITER;
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

	public Date getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}

	@Override
	public String toString() {
		return "MVCdto [SEQ=" + SEQ + ", WRITER=" + WRITER + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT + ", REGDATE="
				+ REGDATE + "]";
	}

}
