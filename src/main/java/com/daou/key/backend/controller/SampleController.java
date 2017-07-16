package com.daou.key.backend.controller;


import com.daou.key.backend.model.vo.UserVo;
import com.daou.key.backend.service.SampleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class SampleController {

    private Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        return "hello test";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserList() {

        List<UserVo> userList = sampleService.getUserList();

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(userList);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(UserVo userVo) {

        return Integer.toString(sampleService.insertUser(userVo));
    }
}
