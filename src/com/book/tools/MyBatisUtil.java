package com.book.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil{
	private static SqlSessionFactory sqlSessionFactory;
	private MyBatisUtil() {}
	public static SqlSession open() {
		try {
			if(sqlSessionFactory == null) {
				sqlSessionFactory 
					= new SqlSessionFactoryBuilder().build(
						Resources.getResourceAsStream("mybatis-config.xml"));
			}
		} catch (Exception e) {e.printStackTrace();}
		return sqlSessionFactory.openSession(false);
	}
	public static void close(SqlSession sqlSession) {
		if(sqlSession != null)
			sqlSession.close();
	}
}
