package com.victor.pattern.facade.service;

/**
 * @Description
 * 文件存储服务接口
 * @Author victor su
 * @Date 2019/10/5 22:12
 **/
public interface FileSaveService {

    /**
     * 加密后文件存储
     * @param filePath
     * @param encodeContent
     * @return
     */
    String saveFile (String filePath, String encodeContent);
}
