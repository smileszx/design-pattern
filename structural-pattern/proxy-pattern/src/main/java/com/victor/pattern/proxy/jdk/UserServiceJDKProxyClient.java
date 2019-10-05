package com.victor.pattern.proxy.jdk;

import com.victor.pattern.proxy.service.UserService;
import com.victor.pattern.proxy.service.impl.UserServiceImpl;

/**
 * @Description
 * JDK 动态代理客户端
 * @Author victor su
 * @Date 2019/10/4 23:18
 **/
public class UserServiceJDKProxyClient {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        UserServiceJDKProxy proxy = new UserServiceJDKProxy();
        proxy.setObject(userService);

        UserService proxyUserService = (UserService) proxy.createProxyedObj();

        proxyUserService.findUserName(1);

    }
}
