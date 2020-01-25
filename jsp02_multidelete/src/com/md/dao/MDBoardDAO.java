package com.md.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.md.common.JDBCTemplate;
import com.md.vo.MDBOARD;

public class MDBoardDAO extends JDBCTemplate {
	public List<MDBOARD> selectList() {
		List<MDBOARD> list = new ArrayList<MDBOARD>();

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MDBOARD ORDER BY SEQ DESC ";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MDBOARD mdboard = new MDBOARD();

				mdboard.setSEQ(rs.getInt("SEQ"));
				mdboard.setWRITER(rs.getString("WRITER"));
				mdboard.setTITLE(rs.getString("TITLE"));
				mdboard.setCONTENT(rs.getString("CONTENT"));
				mdboard.setREGDATE(rs.getDate("REGDATE"));

				list.add(mdboard);
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

	public MDBOARD selectOne(int SEQ) {
		MDBOARD mdboard = new MDBOARD();

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MDBOARD WHERE SEQ = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, SEQ);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mdboard.setSEQ(rs.getInt("SEQ"));
				mdboard.setWRITER(rs.getString("WRITER"));
				mdboard.setTITLE(rs.getString("TITLE"));
				mdboard.setCONTENT(rs.getString("CONTENT"));
				mdboard.setREGDATE(rs.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return mdboard;
	}

	public int insert(MDBOARD mdboard) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " INSERT INTO MDBOARD VALUES(MDBOARDSEQ.NEXTVAL, ?,?,?, SYSDATE) ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdboard.getWRITER());
			pstmt.setString(2, mdboard.getTITLE());
			pstmt.setString(3, mdboard.getCONTENT());

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

	public int update(MDBOARD mdboard) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " UPDATE MDBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdboard.getTITLE());
			pstmt.setString(2, mdboard.getCONTENT());
			pstmt.setInt(3, mdboard.getSEQ());

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("update fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return res;
	}

	public int delete(int SEQ) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " DELETE FROM MDBOARD WHERE SEQ = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, SEQ);

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

	public int multiDelete(String[] seqList) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		String sql = " DELETE FROM MDBOARD WHERE SEQ = ? ";

		int[] cnt = null;

		try {
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < seqList.length; i++) {
				pstmt.setString(1, seqList[i]);
				pstmt.addBatch(); // 메모리에 적재 후, executeBatch() 메소드가 호출될 때 한번에 실행!
				System.out.println("삭제할 번호 : " + seqList[i]);
			}
			System.out.println("3. query 준비 : " + sql);

			cnt = pstmt.executeBatch(); // 메모리에 있던 query를 한번에 실행!, int[]로 리턴!

			// [-2,-2, -3, ...]
			for (int i = 0; i < cnt.length; i++) {
				// -2 : 성공
				// -3 : 실패
				if (cnt[i] == -2) {
					res++;
				}
			}

			if (res == seqList.length) {
				commit(con);
			} else {
				res = 0;
				System.out.println("delete all fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
}
