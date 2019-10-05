package com.victor.pattern.facade.api;

import com.victor.pattern.facade.service.FileEncryptService;
import com.victor.pattern.facade.service.FileParserService;
import com.victor.pattern.facade.service.FileSaveService;
import com.victor.pattern.facade.service.impl.FileEncryptServiceImpl;
import com.victor.pattern.facade.service.impl.FileParserServiceImpl;
import com.victor.pattern.facade.service.impl.FileSaveServiceImpl;

/**
 * @Description
 * 文件处理外观模式
 * @Author victor su
 * @Date 2019/10/5 22:20
 **/
public class FileManageFacade {

    private FileParserService fileParserService;

    private FileEncryptService fileEncryptService;

    private FileSaveService fileSaveService;

    public FileManageFacade () {
        fileParserService = new FileParserServiceImpl();
        fileEncryptService = new FileEncryptServiceImpl();
        fileSaveService = new FileSaveServiceImpl();
    }

    /**
     * 文件处理方法
     * 外观方法，屏蔽客户端和各个子系统间直接耦合
     * @param fileSourcePath
     * @param fileDesPath
     * @return
     */
    public String fileManage (String fileSourcePath, String fileDesPath) {

        String parserResult = fileParserService.parserFile(fileSourcePath);

        String encodeContent = fileEncryptService.encryptFile(parserResult);

        String saveResult = fileSaveService.saveFile(fileDesPath, encodeContent);

        return saveResult;
    }

}
