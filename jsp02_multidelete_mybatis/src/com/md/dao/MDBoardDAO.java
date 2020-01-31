package com.md.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.md.vo.MDBOARD;

public class MDBoardDAO extends SqlMapConfig {
	private String namespace = "muldel.";
	
	public List<MDBOARD> selectList() {

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();

		List<MDBOARD> list = session.selectList("com.md.mapper.selectList");
		session.close();
		return list;
	}

	public List<MDBOARD> selectListList(){
		List<MDBOARD> list = null;
		SqlSession session = null;
		session = getSqlSessionFactory().openSession();
		list = session.selectList("");
		
		return list;
	}
	public MDBOARD selectOne(int SEQ) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();

		MDBOARD mdboard = session.selectOne("com.md.mapper.selectOne", SEQ);
		session.close();
		return mdboard;
	}

	public int insert(MDBOARD mdboard) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();

		int res = session.insert("com.md.mapper.insert", mdboard);
		if (res > 0) {
			session.commit();
		}
		session.close();
		return res;
	}

	public int update(MDBOARD mdboard) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();

		int res = session.update("com.md.mapper.update", mdboard);
		if (res > 0) {
			session.commit();
		}
		session.close();
		return res;
	}

	public int delete(int SEQ) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();

		int res = session.delete("com.md.mapper.delete", SEQ);
		if (res > 0) {
			session.commit();
		}
		session.close();
		return res;
	}

	public int multiDelete(String[] seqList) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();

		int res = session.delete("com.md.mapper.multidelete", seqList);
		if (res > 0) {
			session.commit();
		}
		session.close();
		return res;
	}
}
