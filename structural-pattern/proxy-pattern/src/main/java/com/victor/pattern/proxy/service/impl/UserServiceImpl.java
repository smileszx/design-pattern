package com.victor.pattern.proxy.service.impl;

import com.victor.pattern.proxy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @Description
 * 用户服务接口实现类
 * @Author victor su
 * @Date 2019/10/5 9:41
 **/
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Override
    public String findUserName(Integer userId) {
        String userName = "user:" + userId + ":" + UUID.randomUUID();
        LOGGER.info("用户名:" + userName);
        return userName;
    }
}
