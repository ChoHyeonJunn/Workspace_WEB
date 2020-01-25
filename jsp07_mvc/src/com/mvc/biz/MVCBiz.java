package com.mvc.biz;

import java.util.List;

import com.mvc.dto.MVCDto;

public interface MVCBiz {

	public List<MVCDto> selectList();

	public MVCDto selectOne(int SEQ);

	public int insert(MVCDto mvcdto);

	public int update(MVCDto mvcdto);

	public int delete(int SEQ);

	public boolean multiDelete(String[] seqList);
}
