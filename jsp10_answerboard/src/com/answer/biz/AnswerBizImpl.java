package com.answer.biz;

import java.util.List;

import com.answer.dao.AnswerDAO;
import com.answer.dao.AnswerDAOImpl;
import com.answer.dto.AnswerDTO;

public class AnswerBizImpl implements AnswerBiz {

	private AnswerDAO dao = new AnswerDAOImpl();

	@Override
	public List<AnswerDTO> selectList() {
		return dao.selectList();
	}

	@Override
	public AnswerDTO selectOne(int BOARDNO) {
		return dao.selectOne(BOARDNO);
	}

	@Override
	public int insert(AnswerDTO answerdto) {
		return dao.insert(answerdto);
	}

	@Override
	public int insertSub(AnswerDTO answerdto, int BOARDNO) {
		int res = dao.updateForSub(BOARDNO);
		int result = 0;
		if (res > 0) {
			result = dao.insertSub(answerdto, BOARDNO);	
		} else {
			System.out.println("Biz updateForSub 실패!");
		}
		return result;
	}

	@Override
	public int update(AnswerDTO answerdto) {
		return dao.update(answerdto);
	}

	@Override
	public int delete(int BOARDNO, int TITLETAB, int GROUPNO, int GROUPSEQ) {
		int canbe = dao.canBeDelete(GROUPNO, GROUPSEQ);
		if (canbe > TITLETAB) {
			return -1;	// -1 : 답글이 존재해서 삭제 불가
		} else {
			int res = dao.delete(BOARDNO);
			if(res > 0) {
				dao.updateForDelete(BOARDNO);	
			}
			return res;
		}
	}

	@Override
	public boolean multiDelete(String[] seqList) {
		return dao.multiDelete(seqList);
	}

}
