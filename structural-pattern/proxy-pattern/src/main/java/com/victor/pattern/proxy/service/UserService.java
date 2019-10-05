package com.victor.pattern.proxy.service;

/**
 * @Description
 * 用户服务接口
 * @Author victor su
 * @Date 2019/10/5 9:39
 **/
public interface UserService {

    /**
     * 根据userId查询用户名
     * @param userId
     * @return
     */
    String findUserName(Integer userId);
}
