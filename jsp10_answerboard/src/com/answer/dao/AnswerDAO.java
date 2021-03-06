package com.answer.dao;

import java.util.List;

import com.answer.dto.AnswerDTO;

public interface AnswerDAO {
	String SELECT_LIST_SQL = " SELECT * FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSEQ ";
	String SELECT_ONE_SQL = " SELECT * FROM ANSWERBOARD WHERE BOARDNO = ? ";
	String INSERT_SQL = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, ?,?,?, SYSDATE) ";
	String INSERT_SUB_SQL = 
			" INSERT INTO ANSWERBOARD " + 
			" VALUES( " + 
			"	BOARDNOSEQ.NEXTVAL, " + 
			"	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?), " + 
			"	(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) + 1, " + 
			"	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO = ?) + 1, " + 
			"	?, " + 
			"	?, " + 
			"	?, " + 
			"	SYSDATE " + 
			" ) ";
	String UPDATE_FOR_SUB_SQL = 
			" UPDATE ANSWERBOARD " + 
			" SET GROUPSEQ = GROUPSEQ + 1 " + 
			" WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?) " + 
			" AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) ";
	
	String UPDATE_SQL = " UPDATE ANSWERBOARD SET TITLE = ?, CONTENT = ? WHERE BOARDNO = ? ";
	String DELETE_SQL = " DELETE FROM ANSWERBOARD WHERE BOARDNO = ? ";
	String CAN_BE_DELETE_SQL = " SELECT TITLETAB FROM ANSWERBOARD WHERE GROUPNO = ? AND GROUPSEQ = ? + 1 ";
	String UPDATE_FOR_DELETE_SQL = 
			" UPDATE ANSWERBOARD " + 
			" SET GROUPSEQ = GROUPSEQ - 1 " + 
			" WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?) " + 
			" AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) ";
			
	public List<AnswerDTO> selectList();

	public AnswerDTO selectOne(int BOARDNO);

	public int insert(AnswerDTO answerdto);
	
	public int insertSub(AnswerDTO answerdto, int BOARDNO);

	public int updateForSub(int BOARDNO);
	
	public int update(AnswerDTO answerdto);

	public int canBeDelete(int GROUPNO, int GROUPSEQ);
	
	public int delete(int BOARDNO);
	
	public int updateForDelete(int BOARDNO);

	public boolean multiDelete(String[] seqList);
}
