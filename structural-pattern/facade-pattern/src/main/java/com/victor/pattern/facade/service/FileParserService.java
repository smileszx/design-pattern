package com.victor.pattern.facade.service;

/**
 * @Description
 * 文件解析服务接口
 * @Author victor su
 * @Date 2019/10/5 22:11
 **/
public interface FileParserService {

    /**
     * 解析文件内容
     * @param filePath
     * @return
     */
    String parserFile(String filePath);
}
