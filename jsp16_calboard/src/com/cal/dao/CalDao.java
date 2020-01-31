package com.cal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cal.common.JDBCTemplate;
import com.cal.dto.CALBOARD;

public class CalDao extends JDBCTemplate {

	// 해당 연월일의 일정 갯수
	public int getCalCount(String id, String yyyyMMdd) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int res = 0;

		String sql = " SELECT COUNT(*) FROM CALBOARD WHERE ID = ? AND SUBSTR(MDATE, 1, 8) = ? ";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, yyyyMMdd);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				res = rs.getInt("COUNT(*)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return res;
	}

	// 달력에 일정 요약 표시
	public List<CALBOARD> getCalViewList(String id, String yyyyMM) {
		List<CALBOARD> list = new ArrayList<CALBOARD>();

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT * " + " FROM( "
				+ "    SELECT (ROW_NUMBER() OVER(PARTITION BY SUBSTR(MDATE, 1, 8) ORDER BY MDATE)) RN, "
				+ "    SEQ, ID, TITLE, CONTENT, MDATE, REGDATE " + "    FROM CALBOARD "
				+ "    WHERE ID = ? AND SUBSTR(MDATE, 1, 6) = ? " + " ) " + " WHERE RN BETWEEN 1 AND 3 ";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, yyyyMM);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CALBOARD calboard = new CALBOARD();

				calboard.setSEQ(rs.getInt("SEQ"));
				calboard.setID(rs.getString("ID"));
				calboard.setTITLE(rs.getString("TITLE"));
				calboard.setCONTENT(rs.getString("CONTENT"));
				calboard.setMDATE(rs.getString("MDATE"));
				calboard.setREGDATE(rs.getDate("REGDATE"));

				list.add(calboard);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return list;
	}

	// 해당 연월일의 일정 리스트
	public List<CALBOARD> selectCalList(String id, String yyyyMMdd) {
		List<CALBOARD> list = new ArrayList<CALBOARD>();

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT * FROM CALBOARD WHERE ID = ? AND SUBSTR(MDATE, 1, 8) = ? ";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, yyyyMMdd);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CALBOARD calboard = new CALBOARD();

				calboard.setSEQ(rs.getInt("SEQ"));
				calboard.setID(rs.getString("SEQ"));
				calboard.setTITLE(rs.getString("TITLE"));
				calboard.setCONTENT(rs.getString("CONTENT"));
				calboard.setMDATE(rs.getString("MDATE"));
				calboard.setREGDATE(rs.getDate("REGDATE"));

				list.add(calboard);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return list;
	}

	// 일정 등록
	public int insertCalBoard(CALBOARD calboard) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " INSERT INTO CALBOARD VALUES(CALBOARDSEQ.NEXTVAL, ?,?,?,?,SYSDATE) ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, calboard.getID());
			pstmt.setString(2, calboard.getTITLE());
			pstmt.setString(3, calboard.getCONTENT());
			pstmt.setString(4, calboard.getMDATE());

			res = pstmt.executeUpdate();

			if (res > 0)
				commit(con);
			else
				System.out.println("insert calboard failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		return res;
	}
}
