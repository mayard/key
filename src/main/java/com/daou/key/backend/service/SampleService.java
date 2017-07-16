package com.daou.key.backend.service;

import com.daou.key.backend.model.dao.UserDao;
import com.daou.key.backend.model.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    private Logger logger = LoggerFactory.getLogger(SampleService.class);

    @Autowired
    private UserDao userDao;

    public List<UserVo> getUserList() {

        return userDao.selectList("user.getUserList", null);
    }

    public int insertUser(UserVo userVo) {

        return userDao.insert("user.insertUser", userVo);
    }
}
