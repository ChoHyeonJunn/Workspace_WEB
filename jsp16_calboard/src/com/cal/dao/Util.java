package com.cal.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cal.dto.CALBOARD;

public class Util {

	public static String getCalView(int date, List<CALBOARD> clist) {
		String d = isTwo(date + "");
		String res = "";
		
		for(CALBOARD dto : clist) {
			if(dto.getMDATE().substring(6, 8).equals(d)) {
				res += "<p>"
						+ ((dto.getTITLE().length() > 6) ? dto.getTITLE().substring(0, 6) + "..." : dto.getTITLE())
						+ "</p>";		
			}
		}
		return res;
	}
	
	// MDATE 날짜포맷
	private String todates;

	public String getTodates() {
		return todates;
	}

	public void setTodates(String mdate) {
		// yyyyMMddhhmm
		// yyyy-MM-dd hh:mm:00
		String m = mdate.substring(0, 4) + "-" + mdate.substring(4, 6) + "-" + mdate.substring(6, 8) + " "
				+ mdate.substring(8, 10) + ":" + mdate.substring(10, 12) + ":00";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		Timestamp tm = Timestamp.valueOf(m);
		todates = sdf.format(tm);	
	}

	// font color 변경
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		int day = (dayOfWeek - 1 + date) % 7;

		if (day == 1)
			color = "red";
		else if (day == 0)
			color = "blue";
		else
			color = "black";

		return color;
	}

	// 한자리수 -> 두자리수
	public static String isTwo(String msg) {
		return (msg.length() < 2) ? "0" + msg : msg;
	}

}
