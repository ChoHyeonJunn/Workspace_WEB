package com.bike.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.biz.BikeBizImpl;
import com.bike.dao.BikeDaoImpl;
import com.bike.dto.BIKE;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/BikeServlet")
public class BikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BikeBizImpl biz = new BikeBizImpl();

	public BikeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		doPost(request, response);
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + msg + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String command = request.getParameter("command");

		if (command.equals("first")) {

			response.sendRedirect("bike01.jsp");

		} else if (command.equals("firstdb")) {

			String[] bikes = request.getParameterValues("bike");
			List<BIKE> list = new ArrayList<BIKE>();

			for (int i = 0; i < bikes.length; i++) {
				String[] bikeRow = bikes[i].split("/");
				BIKE bike = new BIKE();

				bike.setADDR_GU(bikeRow[0]);
				bike.setCONTENT_ID(Integer.parseInt(bikeRow[1]));
				bike.setCONTENT_NM(bikeRow[2]);
				bike.setNEW_ADDR(bikeRow[3]);
				bike.setCRADLE_COUNT(Integer.parseInt(bikeRow[4]));
				bike.setLONGITUDE(Double.parseDouble(bikeRow[5]));
				bike.setLATITUDE(Double.parseDouble(bikeRow[6]));

				list.add(bike);
			}

			int res = biz.multiInsert(list);

			if (res > 0) {
				System.out.println("저장 성공!");
				response.getWriter().append(res + "");

			} else if (res == -1) {

				System.out.println("테이블 비우기 실패 ㅜ");
				response.getWriter().append(res + "");

			} else {
				System.out.println("db 저장 실패 ㅜㅜ");
				response.getWriter().append(res + "");
			}

		} else if (command.equals("second")) {

			response.sendRedirect("bike02.jsp");

		} else if (command.equals("second_db")) {

			String txt = request.getParameter("obj");

			// System.out.println(txt);

			JsonElement element = JsonParser.parseString(txt);
			// JsonElement : 추상클래스 - Json 의 요소를 나타내는 클래스, (JsonObject, JsonArray 등 이 될수있다.)
			// 파서, 파싱 : 문장의 구조를 알아내는 작업.
			// JsonParser : json 을 jsonElement 에 파싱해 주는 객체이다. 
			// jsonString 을 jsonElement에 파싱해준다.
			
			// System.out.println(element.getAsJsonObject().get("DESCRIPTION"));

			List<BIKE> bikes = new ArrayList<>();
			for (int i = 0; i < element.getAsJsonObject().get("DATA").getAsJsonArray().size(); i++) {
				JsonObject tmp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();

				// System.out.println(tmp.get("addr_gu").getAsString());
				JsonElement addr_gu_je = tmp.get("addr_gu");
				JsonElement content_id_je = tmp.get("content_id");
				JsonElement content_nm_je = tmp.get("content_nm");
				JsonElement new_addr_je = tmp.get("new_addr");
				JsonElement cradle_count_je = tmp.get("cradle_count");
				JsonElement longitude_je = tmp.get("longitude");
				JsonElement latitude_je = tmp.get("latitude");

				String addr_gu = addr_gu_je.getAsString();
				int content_id = content_id_je.getAsInt();
				String content_nm = content_nm_je.getAsString();
				String new_addr = new_addr_je.getAsString();
				int cradle_count = cradle_count_je.getAsInt();
				double longitude = longitude_je.getAsDouble();
				double latitude = latitude_je.getAsDouble();

				BIKE dto = new BIKE(addr_gu, content_id, content_nm, new_addr, cradle_count, longitude, latitude);
				bikes.add(dto);
			}
			BikeDaoImpl dao = new BikeDaoImpl();
			dao.deleteAll();
			int res = dao.multiInsert(bikes);

			if(res == 1163) {
				System.out.println("insert 성공!");
			}  else {
				System.out.println("insert 실패");
			}
			response.getWriter().append(res+"");

		}
	}

}
