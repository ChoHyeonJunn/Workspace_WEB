package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.answer.common.JDBCTemplate;
import com.answer.dto.AnswerDTO;

public class AnswerDAOImpl extends JDBCTemplate implements AnswerDAO {

	public List<AnswerDTO> selectList() {
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQL);

			while (rs.next()) {
				AnswerDTO answerdto = new AnswerDTO();

				answerdto.setBOARDNO(rs.getInt("BOARDNO"));
				answerdto.setGROUPNO(rs.getInt("GROUPNO"));
				answerdto.setGROUPSEQ(rs.getInt("GROUPSEQ"));
				answerdto.setTITLETAB(rs.getInt("TITLETAB"));

				answerdto.setTITLE(rs.getString("TITLE"));
				answerdto.setCONTENT(rs.getString("CONTENT"));
				answerdto.setWRITER(rs.getString("WRITER"));
				answerdto.setREGDATE(rs.getDate("REGDATE"));

				list.add(answerdto);
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

	public AnswerDTO selectOne(int BOARDNO) {
		AnswerDTO answerdto = new AnswerDTO();

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(SELECT_ONE_SQL);
			pstmt.setInt(1, BOARDNO);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				answerdto.setBOARDNO(rs.getInt("BOARDNO"));
				answerdto.setGROUPNO(rs.getInt("GROUPNO"));
				answerdto.setGROUPSEQ(rs.getInt("GROUPSEQ"));
				answerdto.setTITLETAB(rs.getInt("TITLETAB"));

				answerdto.setTITLE(rs.getString("TITLE"));
				answerdto.setCONTENT(rs.getString("CONTENT"));
				answerdto.setWRITER(rs.getString("WRITER"));
				answerdto.setREGDATE(rs.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return answerdto;
	}

	public int insert(AnswerDTO answerdto) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(INSERT_SQL);
			pstmt.setString(1, answerdto.getTITLE());
			pstmt.setString(2, answerdto.getCONTENT());
			pstmt.setString(3, answerdto.getWRITER());

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

	@Override
	public int insertSub(AnswerDTO answerdto, int BOARDNO) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(INSERT_SUB_SQL);
			pstmt.setInt(1, BOARDNO);
			pstmt.setInt(2, BOARDNO);
			pstmt.setInt(3, BOARDNO);
			pstmt.setString(4, answerdto.getTITLE());
			pstmt.setString(5, answerdto.getCONTENT());
			pstmt.setString(6, answerdto.getWRITER());

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("insertSub fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		return res;
	}

	@Override
	public int updateForSub(int BOARDNO) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(UPDATE_FOR_SUB_SQL);
			pstmt.setInt(1, BOARDNO);
			pstmt.setInt(2, BOARDNO);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("updateForSub fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return res;
	}

	public int update(AnswerDTO answerdto) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(UPDATE_SQL);
			pstmt.setString(1, answerdto.getTITLE());
			pstmt.setString(2, answerdto.getCONTENT());
			pstmt.setInt(3, answerdto.getBOARDNO());

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
	
	@Override
	public int canBeDelete(int GROUPNO, int GROUPSEQ) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(CAN_BE_DELETE_SQL);
			pstmt.setInt(1, GROUPNO);
			pstmt.setInt(2, GROUPSEQ);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				res = rs.getInt("TITLETAB");
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
	
	public int delete(int BOARDNO) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(DELETE_SQL);
			pstmt.setInt(1, BOARDNO);

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

	@Override
	public int updateForDelete(int BOARDNO) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(UPDATE_FOR_DELETE_SQL);
			pstmt.setInt(1, BOARDNO);
			pstmt.setInt(2, BOARDNO);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("updateForDelete fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
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
