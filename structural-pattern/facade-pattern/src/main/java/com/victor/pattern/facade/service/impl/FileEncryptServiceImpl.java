package com.victor.pattern.facade.service.impl;

import com.victor.pattern.facade.service.FileEncryptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 文件加密接口实现类
 * @Author victor su
 * @Date 2019/10/5 22:19
 **/
public class FileEncryptServiceImpl implements FileEncryptService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileSaveServiceImpl.class);

    @Override
    public String encryptFile(String content) {
        LOGGER.info(content);
        return "encode:" + content;
    }
}
