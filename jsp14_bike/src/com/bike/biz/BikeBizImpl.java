package com.bike.biz;

import java.util.List;

import com.bike.dao.BikeDaoImpl;
import com.bike.dto.BIKE;

public class BikeBizImpl {
	BikeDaoImpl dao = new BikeDaoImpl();

	public int multiInsert(List<BIKE> list) {
		int res = dao.selectCount(); // 이미 테이블에 데이터가 있는지 확인

		if (res > 0) { // 이미 데이터가 존재할 때
			int delRes = dao.deleteAll(); // 테이블을 비워준다
			if (delRes == res) { // 이미 존재하던 테이블의 row 갯수와 지운 row 갯수가 같다면
				return dao.multiInsert(list);
			} else { // 모두 다 지우지 못했다면
				return -1;
			}
		} else { // 비어있는 테이블이라면
			return dao.multiInsert(list);
		}
	}
}