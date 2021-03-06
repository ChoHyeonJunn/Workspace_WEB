package com.bike.dto;

public class BIKE {
	private String ADDR_GU;
	private int CONTENT_ID;
	private String CONTENT_NM;
	private String NEW_ADDR;

	private int CRADLE_COUNT;
	private double LONGITUDE;
	private double LATITUDE;

	public BIKE() {
		super();
	}

	public BIKE(String aDDR_GU, int cONTENT_ID, String cONTENT_NM, String nEW_ADDR, int cRADLE_COUNT, double lONGITUDE,
			double lATITUDE) {
		super();
		ADDR_GU = aDDR_GU;
		CONTENT_ID = cONTENT_ID;
		CONTENT_NM = cONTENT_NM;
		NEW_ADDR = nEW_ADDR;
		CRADLE_COUNT = cRADLE_COUNT;
		LONGITUDE = lONGITUDE;
		LATITUDE = lATITUDE;
	}

	public String getADDR_GU() {
		return ADDR_GU;
	}

	public void setADDR_GU(String aDDR_GU) {
		ADDR_GU = aDDR_GU;
	}

	public int getCONTENT_ID() {
		return CONTENT_ID;
	}

	public void setCONTENT_ID(int cONTENT_ID) {
		CONTENT_ID = cONTENT_ID;
	}

	public String getCONTENT_NM() {
		return CONTENT_NM;
	}

	public void setCONTENT_NM(String cONTENT_NM) {
		CONTENT_NM = cONTENT_NM;
	}

	public String getNEW_ADDR() {
		return NEW_ADDR;
	}

	public void setNEW_ADDR(String nEW_ADDR) {
		NEW_ADDR = nEW_ADDR;
	}

	public int getCRADLE_COUNT() {
		return CRADLE_COUNT;
	}

	public void setCRADLE_COUNT(int cRADLE_COUNT) {
		CRADLE_COUNT = cRADLE_COUNT;
	}

	public double getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(double lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	public double getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(double lATITUDE) {
		LATITUDE = lATITUDE;
	}

	@Override
	public String toString() {
		return "BIKE [ADDR_GU=" + ADDR_GU + ", CONTENT_ID=" + CONTENT_ID + ", CONTENT_NM=" + CONTENT_NM + ", NEW_ADDR="
				+ NEW_ADDR + ", CRADLE_COUNT=" + CRADLE_COUNT + ", LONGITUDE=" + LONGITUDE + ", LATITUDE=" + LATITUDE
				+ "]";
	}

}
