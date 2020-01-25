package com.login.dto;

public class MYMEMBER {
	private int MYNO;
	private String MYID;
	private String MYPW;
	private String MYNAME;
	private String MYADDR;
	private String MYPHONE;
	private String MYEMAIL;
	private String MYENABLED;
	private String MYROLE;

	public MYMEMBER() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MYMEMBER(int mYNO, String mYID, String mYPW, String mYNAME, String mYADDR, String mYPHONE, String mYEMAIL,
			String mYENABLED, String mYROLE) {
		super();
		MYNO = mYNO;
		MYID = mYID;
		MYPW = mYPW;
		MYNAME = mYNAME;
		MYADDR = mYADDR;
		MYPHONE = mYPHONE;
		MYEMAIL = mYEMAIL;
		MYENABLED = mYENABLED;
		MYROLE = mYROLE;
	}

	public int getMYNO() {
		return MYNO;
	}

	public void setMYNO(int mYNO) {
		MYNO = mYNO;
	}

	public String getMYID() {
		return MYID;
	}

	public void setMYID(String mYID) {
		MYID = mYID;
	}

	public String getMYPW() {
		return MYPW;
	}

	public void setMYPW(String mYPW) {
		MYPW = mYPW;
	}

	public String getMYNAME() {
		return MYNAME;
	}

	public void setMYNAME(String mYNAME) {
		MYNAME = mYNAME;
	}

	public String getMYADDR() {
		return MYADDR;
	}

	public void setMYADDR(String mYADDR) {
		MYADDR = mYADDR;
	}

	public String getMYPHONE() {
		return MYPHONE;
	}

	public void setMYPHONE(String mYPHONE) {
		MYPHONE = mYPHONE;
	}

	public String getMYEMAIL() {
		return MYEMAIL;
	}

	public void setMYEMAIL(String mYEMAIL) {
		MYEMAIL = mYEMAIL;
	}

	public String getMYENABLED() {
		return MYENABLED;
	}

	public void setMYENABLED(String mYENABLED) {
		MYENABLED = mYENABLED;
	}

	public String getMYROLE() {
		return MYROLE;
	}

	public void setMYROLE(String mYROLE) {
		MYROLE = mYROLE;
	}

	@Override
	public String toString() {
		return "MYMEMBER [MYNO=" + MYNO + ", MYID=" + MYID + ", MYPW=" + MYPW + ", MYNAME=" + MYNAME + ", MYADDR="
				+ MYADDR + ", MYPHONE=" + MYPHONE + ", MYEMAIL=" + MYEMAIL + ", MYENABLED=" + MYENABLED + ", MYROLE="
				+ MYROLE + "]";
	}

}
