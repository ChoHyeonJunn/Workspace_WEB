package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.vo.MYBOARD;

public class DAO {

	public List<MYBOARD> selectList() {
		String resource = "com/my/db/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		List<MYBOARD> list = session.selectList("com.my.mapper.selectList");
		session.close();

		return list;
	}

	public MYBOARD selectOne(int MYNO) {
		String resource = "com/my/db/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		MYBOARD myboard = session.selectOne("com.my.mapper.selectOne", MYNO);
		session.close();

		return myboard;
	}

	public int insert(MYBOARD myboard) {
		String resource = "com/my/db/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		int res = session.insert("com.my.mapper.insertBoard", myboard);
		if (res > 0) {
			session.commit();
		}
		session.close();
		return res;
	}

	public int update(MYBOARD myboard) {
		String resource = "com/my/db/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession(true);	//true 하면 commit 따로 할 필요 없다

		int res = session.insert("com.my.mapper.updateBoard", myboard);
//		if (res > 0) {
//			session.commit();
//		}
		session.close();
		return res;
	}

	public int delete(int MYNO) {
		String resource = "com/my/db/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		int res = session.insert("com.my.mapper.deleteBoard", MYNO);
		if (res > 0) {
			session.commit();
		}
		session.close();
		return res;
	}
}
