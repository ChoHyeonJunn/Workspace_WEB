package com.answer.biz;

import java.util.List;

import com.answer.dto.AnswerDTO;

public interface AnswerBiz {

	public List<AnswerDTO> selectList();

	public AnswerDTO selectOne(int BOARDNO);

	public int insert(AnswerDTO mvcdto);
	
	public int insertSub(AnswerDTO answerdto, int BOARDNO);

	public int update(AnswerDTO mvcdto);

	public int delete(int BOARDNO, int TITLETAB, int GROUPNO, int GROUPSEQ);

	public boolean multiDelete(String[] seqList);
}
