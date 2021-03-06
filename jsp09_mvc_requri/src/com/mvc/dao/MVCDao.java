package com.mvc.dao;

import java.util.List;

import com.mvc.dto.MVCDto;

public interface MVCDao {
	String SELECT_LIST_SQL = " SELECT * FROM MVCBOARD ORDER BY SEQ DESC ";
	String SELECT_ONE_SQL = " SELECT * FROM MVCBOARD WHERE SEQ = ? ";
	String INSERT_SQL = " INSERT INTO MVCBOARD VALUES(MVCBOARDSEQ.NEXTVAL, ?,?,?, SYSDATE) ";
	String UPDATE_SQL = " UPDATE MVCBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
	String DELETE_SQL = " DELETE FROM MVCBOARD WHERE SEQ = ? ";
	
	public List<MVCDto> selectList();

	public MVCDto selectOne(int SEQ);

	public int insert(MVCDto mvcdto);

	public int update(MVCDto mvcdto);

	public int delete(int SEQ);

	public boolean multiDelete(String[] seqList);
}
