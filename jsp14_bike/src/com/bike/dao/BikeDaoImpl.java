package com.bike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bike.common.JDBCTemplate;
import com.bike.dto.BIKE;

public class BikeDaoImpl extends JDBCTemplate {

	public int selectCount() {

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		String SELECT_COUNT_SQL = " SELECT COUNT(*) FROM BIKE ";
		int res = 0;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_COUNT_SQL);

			while (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}

		return res;
	}

	public int multiInsert(List<BIKE> list) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;

		int res = 0;
		int[] cnt = null;
		String INSERT_SQL = " INSERT INTO BIKE VALUES(?,?,?,?,?,?,?) ";
		try {
			pstmt = con.prepareStatement(INSERT_SQL);

			for (int i = 0; i < list.size(); i++) {
				pstmt.setString(1, list.get(i).getADDR_GU());
				pstmt.setInt(2, list.get(i).getCONTENT_ID());
				pstmt.setString(3, list.get(i).getCONTENT_NM());
				pstmt.setString(4, list.get(i).getNEW_ADDR());
				pstmt.setInt(5, list.get(i).getCRADLE_COUNT());
				pstmt.setDouble(6, list.get(i).getLONGITUDE());
				pstmt.setDouble(7, list.get(i).getLATITUDE());

				pstmt.addBatch(); // 메모리에 적재 후, executeBatch() 메소드가 호출될 때 한번에 실행!
				// System.out.println("insert into bike : " + list.get(i));
			}
			System.out.println("3. query 준비 : " + INSERT_SQL);

			cnt = pstmt.executeBatch(); // 메모리에 있던 query를 한번에 실행!, int[]로 리턴!

			// [-2, -2, -3, ...]
			for (int i = 0; i < cnt.length; i++) {
				// -2 : 성공
				// -3 : 실패
				if (cnt[i] == -2) {
					res++;
				}
			}

			if (res == list.size()) {
				commit(con);
			} else {
				System.out.println("delete all fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//return (res == list.size()) ? true : false;
		return res;
	}

	public int deleteAll() {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		String DELETE_ALL_SQL = " DELETE FROM BIKE ";
		int res = 0;

		try {
			pstmt = con.prepareStatement(DELETE_ALL_SQL);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("deleteAll fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return res;
	}
}
