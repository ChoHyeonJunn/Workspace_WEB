package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.login.common.JDBCTemplate;
import com.login.dto.MYMEMBER;

public class MyMemberDaoImpl extends JDBCTemplate implements MyMemberDao {

	@Override
	public List<MYMEMBER> selectList() {
		List<MYMEMBER> list = new ArrayList<MYMEMBER>();

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_ALL_SQL);

			while (rs.next()) {
				MYMEMBER mymember = new MYMEMBER();

				mymember.setMYNO(rs.getInt("MYNO"));
				mymember.setMYID(rs.getString("MYID"));
				mymember.setMYPW(rs.getString("MYPW"));
				mymember.setMYNAME(rs.getString("MYNAME"));
				mymember.setMYADDR(rs.getString("MYADDR"));
				mymember.setMYPHONE(rs.getString("MYPHONE"));
				mymember.setMYEMAIL(rs.getString("MYEMAIL"));
				mymember.setMYENABLED(rs.getString("MYENABLED"));
				mymember.setMYROLE(rs.getString("MYROLE"));

				list.add(mymember);
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

	@Override
	public List<MYMEMBER> selectEnabled() {
		List<MYMEMBER> list = new ArrayList<MYMEMBER>();

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_ENABLED_SQL);

			while (rs.next()) {
				MYMEMBER mymember = new MYMEMBER();

				mymember.setMYNO(rs.getInt("MYNO"));
				mymember.setMYID(rs.getString("MYID"));
				mymember.setMYPW(rs.getString("MYPW"));
				mymember.setMYNAME(rs.getString("MYNAME"));
				mymember.setMYADDR(rs.getString("MYADDR"));
				mymember.setMYPHONE(rs.getString("MYPHONE"));
				mymember.setMYEMAIL(rs.getString("MYEMAIL"));
				mymember.setMYENABLED(rs.getString("MYENABLED"));
				mymember.setMYROLE(rs.getString("MYROLE"));

				list.add(mymember);
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

	@Override
	public int updateRole(int MYNO, String MYROLE) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(UPDATE_ROLE_SQL);
			pstmt.setString(1, MYROLE);
			pstmt.setInt(2, MYNO);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("role update fail");
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
	public MYMEMBER login(String MYID, String MYPW) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MYMEMBER mymember = null;

		try {
			pstmt = con.prepareStatement(LOGIN_SQL);
			pstmt.setString(1, MYID);
			pstmt.setString(2, MYPW);
			pstmt.setString(3, "Y");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mymember = new MYMEMBER();
				mymember.setMYNO(rs.getInt("MYNO"));
				mymember.setMYID(rs.getString("MYID"));
				mymember.setMYPW(rs.getString("MYPW"));
				mymember.setMYNAME(rs.getString("MYNAME"));
				mymember.setMYADDR(rs.getString("MYADDR"));
				mymember.setMYPHONE(rs.getString("MYPHONE"));
				mymember.setMYEMAIL(rs.getString("MYEMAIL"));
				mymember.setMYENABLED(rs.getString("MYENABLED"));
				mymember.setMYROLE(rs.getString("MYROLE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return mymember;
	}

	@Override
	public int insertUser(MYMEMBER mymember) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(INSERT_SQL);
			pstmt.setString(1, mymember.getMYID());
			pstmt.setString(2, mymember.getMYPW());
			pstmt.setString(3, mymember.getMYNAME());
			pstmt.setString(4, mymember.getMYADDR());
			pstmt.setString(5, mymember.getMYPHONE());
			pstmt.setString(6, mymember.getMYEMAIL());

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
	public MYMEMBER idChk(String MYID) {
		MYMEMBER mymember = null;

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(ID_CHK_SQL);
			pstmt.setString(1, MYID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mymember = new MYMEMBER();

				mymember.setMYNO(rs.getInt("MYNO"));
				mymember.setMYID(rs.getString("MYID"));
				mymember.setMYPW(rs.getString("MYPW"));
				mymember.setMYNAME(rs.getString("MYNAME"));
				mymember.setMYADDR(rs.getString("MYADDR"));
				mymember.setMYPHONE(rs.getString("MYPHONE"));
				mymember.setMYEMAIL(rs.getString("MYEMAIL"));
				mymember.setMYENABLED(rs.getString("MYENABLED"));
				mymember.setMYROLE(rs.getString("MYROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return mymember;
	}

	@Override
	public MYMEMBER selectUser(int MYNO) {
		MYMEMBER mymember = null;

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(SELECT_USER_SQL);
			pstmt.setInt(1, MYNO);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mymember = new MYMEMBER();

				mymember.setMYNO(rs.getInt("MYNO"));
				mymember.setMYID(rs.getString("MYID"));
				mymember.setMYPW(rs.getString("MYPW"));
				mymember.setMYNAME(rs.getString("MYNAME"));
				mymember.setMYADDR(rs.getString("MYADDR"));
				mymember.setMYPHONE(rs.getString("MYPHONE"));
				mymember.setMYEMAIL(rs.getString("MYEMAIL"));
				mymember.setMYENABLED(rs.getString("MYENABLED"));
				mymember.setMYROLE(rs.getString("MYROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return mymember;
	}

	@Override
	public int updateUser(MYMEMBER mymember) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(UPDATE_USER_SQL);
			pstmt.setString(1, mymember.getMYID());
			pstmt.setString(2, mymember.getMYPW());
			pstmt.setString(3, mymember.getMYNAME());
			pstmt.setString(4, mymember.getMYADDR());
			pstmt.setString(5, mymember.getMYPHONE());
			pstmt.setString(6, mymember.getMYEMAIL());
			pstmt.setInt(7, mymember.getMYNO());

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("role update fail");
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
	public int deleteUser(int MYNO) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			pstmt = con.prepareStatement(DELETE_USER_SQL);
			pstmt.setInt(1, MYNO);

			res = pstmt.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				System.out.println("role update fail");
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
