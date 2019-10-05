package com.victor.pattern.facade;

import com.victor.pattern.facade.api.FileManageFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 外观模式客户端
 * @Author victor su
 * @Date 2019/10/5 22:06
 **/
public class FacadePatternApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadePatternApplication.class);

    public static void main(String[] args) {

        FileManageFacade fileManageFacade = new FileManageFacade();
        String source = "文件源地址";
        String dest = "文件目标地址";
        String result = fileManageFacade.fileManage(source, dest);
        LOGGER.info("源文件: {}, 目标文件: {}, 文件处理结果: {}", source, dest, result );
    }
}
