package com.victor.pattern.facade.service.impl;

import com.victor.pattern.facade.service.FileSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 保存文件接口实现类
 * @Author victor su
 * @Date 2019/10/5 22:18
 **/
public class FileSaveServiceImpl implements FileSaveService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileSaveServiceImpl.class);
    @Override
    public String saveFile(String filePath, String encodeContent) {
        LOGGER.info(filePath + " : " + encodeContent);
        return "success";
    }
}
