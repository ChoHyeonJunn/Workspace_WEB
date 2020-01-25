package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.common.JDBCTemplate;
import com.mvc.dto.MVCDto;

public class MVCDaoImpl extends JDBCTemplate implements MVCDao {

	public List<MVCDto> selectList() {
		List<MVCDto> list = new ArrayList<MVCDto>();

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQL);

			while (rs.next()) {
				MVCDto mvcdto = new MVCDto();

				mvcdto.setSEQ(rs.getInt("SEQ"));
				mvcdto.setWRITER(rs.getString("WRITER"));
				mvcdto.setTITLE(rs.getString("TITLE"));
				mvcdto.setCONTENT(rs.getString("CONTENT"));
				mvcdto.setREGDATE(rs.getDate("REGDATE"));

				list.add(mvcdto);
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

	public MVCDto selectOne(int SEQ) {
		MVCDto mvcboard = new MVCDto();

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(SELECT_ONE_SQL);
			pstmt.setInt(1, SEQ);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mvcboard.setSEQ(rs.getInt("SEQ"));
				mvcboard.setWRITER(rs.getString("WRITER"));
				mvcboard.setTITLE(rs.getString("TITLE"));
				mvcboard.setCONTENT(rs.getString("CONTENT"));
				mvcboard.setREGDATE(rs.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return mvcboard;
	}

	public int insert(MVCDto mvcdto) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(INSERT_SQL);
			pstmt.setString(1, mvcdto.getWRITER());
			pstmt.setString(2, mvcdto.getTITLE());
			pstmt.setString(3, mvcdto.getCONTENT());

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

	public int update(MVCDto mvcdto) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(UPDATE_SQL);
			pstmt.setString(1, mvcdto.getTITLE());
			pstmt.setString(2, mvcdto.getCONTENT());
			pstmt.setInt(3, mvcdto.getSEQ());

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

		try {
			pstmt = con.prepareStatement(DELETE_SQL);
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

	public boolean multiDelete(String[] seqList) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;

		int res = 0;
		int[] cnt = null;

		try {
			pstmt = con.prepareStatement(DELETE_SQL);
			for (int i = 0; i < seqList.length; i++) {
				pstmt.setString(1, seqList[i]);
				pstmt.addBatch(); // 메모리에 적재 후, executeBatch() 메소드가 호출될 때 한번에 실행!
				System.out.println("삭제할 번호 : " + seqList[i]);
			}
			System.out.println("3. query 준비 : " + DELETE_SQL);

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
				System.out.println("delete all fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (res == seqList.length) ? true : false;
	}
}
