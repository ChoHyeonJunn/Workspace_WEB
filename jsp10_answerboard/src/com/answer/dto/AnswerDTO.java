package com.answer.dto;

import java.util.Date;

public class AnswerDTO {
	private int BOARDNO;
	private int GROUPNO;
	private int GROUPSEQ;
	private int TITLETAB;

	private String TITLE;
	private String CONTENT;
	private String WRITER;
	private Date REGDATE;

	public AnswerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerDTO(int bOARDNO, int gROUPNO, int gROUPSEQ, int tITLETAB, String tITLE, String cONTENT, String wRITER,
			Date rEGDATE) {
		super();
		BOARDNO = bOARDNO;
		GROUPNO = gROUPNO;
		GROUPSEQ = gROUPSEQ;
		TITLETAB = tITLETAB;
		TITLE = tITLE;
		CONTENT = cONTENT;
		WRITER = wRITER;
		REGDATE = rEGDATE;
	}

	public int getBOARDNO() {
		return BOARDNO;
	}

	public void setBOARDNO(int bOARDNO) {
		BOARDNO = bOARDNO;
	}

	public int getGROUPNO() {
		return GROUPNO;
	}

	public void setGROUPNO(int gROUPNO) {
		GROUPNO = gROUPNO;
	}

	public int getGROUPSEQ() {
		return GROUPSEQ;
	}

	public void setGROUPSEQ(int gROUPSEQ) {
		GROUPSEQ = gROUPSEQ;
	}

	public int getTITLETAB() {
		return TITLETAB;
	}

	public void setTITLETAB(int tITLETAB) {
		TITLETAB = tITLETAB;
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

	public String getWRITER() {
		return WRITER;
	}

	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}

	public Date getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}

	@Override
	public String toString() {
		return "answerDTO [BOARDNO=" + BOARDNO + ", GROUPNO=" + GROUPNO + ", GROUPSEQ=" + GROUPSEQ + ", TITLETAB="
				+ TITLETAB + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT + ", WRITER=" + WRITER + ", REGDATE=" + REGDATE
				+ "]";
	}

}
