package com.login.dao;

import java.util.List;

import com.login.dto.MYMEMBER;

public interface MyMemberDao {
	////////////// 관리자 기능 ///////////

	String SELECT_ALL_SQL = " SELECT * FROM MYMEMBER ";
	String SELECT_ENABLED_SQL = " SELECT * FROM MYMEMBER WHERE MYENABLED = 'Y' ";
	String UPDATE_ROLE_SQL = " UPDATE MYMEMBER SET MYROLE = ? WHERE MYNO = ? ";

	// 1. 회원 전체 정보 (탈퇴회원 포함)
	public List<MYMEMBER> selectList();

	// 2. 회원 전체 정보 (가입된 회원들만) : myenabled = y
	public List<MYMEMBER> selectEnabled();

	// 3. 회원 등급 조정
	public int updateRole(int MYNO, String MYROLE);

	////////////// 사용자 기능 //////////////

	String INSERT_SQL = " INSERT INTO MYMEMBER VALUES(MYMEMBERSEQ.NEXTVAL,?,?,?,?,?,?,'Y','USER') ";
	String LOGIN_SQL = " SELECT * FROM MYMEMBER WHERE MYID = ? AND MYPW = ? AND MYENABLED = ? ";
	String SELECT_USER_SQL = " SELECT * FROM MYMEMBER WHERE MYNO = ? ";
	String ID_CHK_SQL = " SELECT * FROM MYMEMBER WHERE MYID = ? ";
	String UPDATE_USER_SQL = " UPDATE MYMEMBER SET MYID=?,MYPW=?,MYNAME=?,MYADDR=?,MYPHONE=?,MYEMAIL=? WHERE MYNO = ? ";
	String DELETE_USER_SQL = " UPDATE MYMEMBER SET MYENABLED='N' WHERE MYNO = ? ";


	// 1. 로그인
	public MYMEMBER login(String MYID, String MYPW);

	// 2. 회원가입
	public int insertUser(MYMEMBER mymember);

	// 2-1. 중복체크
	public MYMEMBER idChk(String MYID);

	// 3. 내 정보 조회
	public MYMEMBER selectUser(int MYNO);

	// 4. 내 정보 수정
	public int updateUser(MYMEMBER mymember);

	// 5. 회원탈퇴 : update myenabled = 'n'
	public int deleteUser(int MYNO);
}
