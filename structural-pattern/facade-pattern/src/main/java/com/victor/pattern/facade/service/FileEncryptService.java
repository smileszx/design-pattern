package com.victor.pattern.facade.service;

/**
 * @Description
 * 文件加密服务接口
 * @Author victor su
 * @Date 2019/10/5 22:12
 **/
public interface FileEncryptService {

    /**
     * 文件内容加密
     * @param content
     * @return
     */
    String encryptFile(String content);
}
