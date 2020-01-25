package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.common.JDBCTemplate;
import com.vo.MYBOARD;

public class DAO extends JDBCTemplate {

	public List<MYBOARD> selectList() {
		List<MYBOARD> list = new ArrayList<MYBOARD>();

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MYBOARD ";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MYBOARD myboard = new MYBOARD();

				myboard.setMYNO(rs.getInt("MYNO"));
				myboard.setMYNAME(rs.getString("MYNAME"));
				myboard.setMYTITLE(rs.getString("MYTITLE"));
				myboard.setMYCONTENT(rs.getString("MYCONTENT"));
				myboard.setMYDATE(rs.getDate("MYDATE"));

				list.add(myboard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}

		return list;
	}

	public MYBOARD selectOne(int MYNO) {
		MYBOARD myboard = new MYBOARD();

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MYBOARD WHERE MYNO = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, MYNO);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				myboard.setMYNO(rs.getInt("MYNO"));
				myboard.setMYNAME(rs.getString("MYNAME"));
				myboard.setMYTITLE(rs.getString("MYTITLE"));
				myboard.setMYCONTENT(rs.getString("MYCONTENT"));
				myboard.setMYDATE(rs.getDate("MYDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return myboard;
	}

	public int insert(MYBOARD myboard) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " INSERT INTO MYBOARD VALUES(MYSEQ.NEXTVAL, ?,?,?, SYSDATE) ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, myboard.getMYNAME());
			pstmt.setString(2, myboard.getMYTITLE());
			pstmt.setString(3, myboard.getMYCONTENT());

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("insert fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return res;
	}

	public int update(MYBOARD myboard) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " UPDATE MYBOARD SET MYTITLE=?, MYCONTENT=? WHERE MYNO = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, myboard.getMYTITLE());
			pstmt.setString(2, myboard.getMYCONTENT());
			pstmt.setInt(3, myboard.getMYNO());

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("update fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public int delete(int MYNO) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " DELETE FROM MYBOARD WHERE MYNO = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, MYNO);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("delete fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
}
