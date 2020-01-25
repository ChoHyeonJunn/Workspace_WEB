package com.mvc.biz;

import java.util.List;

import com.mvc.dao.MVCDao;
import com.mvc.dao.MVCDaoImpl;
import com.mvc.dto.MVCDto;

public class MVCBizImpl implements MVCBiz {

	private MVCDao dao = new MVCDaoImpl();

	@Override
	public List<MVCDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MVCDto selectOne(int SEQ) {
		return dao.selectOne(SEQ);
	}

	@Override
	public int insert(MVCDto mvcdto) {
		return dao.insert(mvcdto);
	}

	@Override
	public int update(MVCDto mvcdto) {
		return dao.update(mvcdto);
	}

	@Override
	public int delete(int SEQ) {
		return dao.delete(SEQ);
	}

	@Override
	public boolean multiDelete(String[] seqList) {
		return dao.multiDelete(seqList);
	}

}
