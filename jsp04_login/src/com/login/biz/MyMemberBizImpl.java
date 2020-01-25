package com.login.biz;

import java.util.List;

import com.login.dto.MYMEMBER;

public class MyMemberBizImpl implements MyMemberBiz {

	
	@Override
	public List<MYMEMBER> selectList() {
		return dao.selectList();
	}

	@Override
	public List<MYMEMBER> selectEnabled() {
		return dao.selectEnabled();
	}

	@Override
	public int updateRole(int MYNO, String MYROLE) {
		return dao.updateRole(MYNO, MYROLE);
	}

	@Override
	public MYMEMBER login(String MYID, String MYPW) {
		return dao.login(MYID, MYPW);
	}

	@Override
	public int insertUser(MYMEMBER mymember) {
		return dao.insertUser(mymember);
	}

	@Override
	public MYMEMBER idChk(String MYID) {
		MYMEMBER mymember = dao.idChk(MYID);
		System.out.println(mymember);
		return dao.idChk(MYID);
	}

	@Override
	public MYMEMBER selectUser(int MYNO) {
		return dao.selectUser(MYNO);
	}

	@Override
	public int updateUser(MYMEMBER mymember) {
		return dao.updateUser(mymember);
	}

	@Override
	public int deleteUser(int MYNO) {
		return dao.deleteUser(MYNO);
	}

}
