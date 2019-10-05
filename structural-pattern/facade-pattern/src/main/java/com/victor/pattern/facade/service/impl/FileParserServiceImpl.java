package com.victor.pattern.facade.service.impl;

import com.victor.pattern.facade.service.FileParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 文件解析接口实现类
 * @Author victor su
 * @Date 2019/10/5 22:19
 **/
public class FileParserServiceImpl implements FileParserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileSaveServiceImpl.class);
    @Override
    public String parserFile(String filePath) {
        LOGGER.info(filePath);
        return "file:" + filePath;
    }
}
