package com.daou.key.backend.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao<T> {

    @Autowired
    @Qualifier("firstSqlSessionTemplate")
    private SqlSession sqlSession;

    public List<T> selectList(String statement, Object param) {
        return sqlSession.selectList(statement, param);
    }

    public int insert(String statement, Object param) {
        return sqlSession.insert(statement, param);
    }
}
