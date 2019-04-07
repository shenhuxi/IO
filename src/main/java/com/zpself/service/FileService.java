package com.zpself.service;

import com.zpself.util.IOBase;
import com.zpself.util.IOFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by zengpeng on 2019/4/3
 */
@Service
public class FileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void upload() {
        logger.info("调用了FileService：upload（）方法");
    }

    public void download() throws Exception{
        //IOUtil.redaDirectory("D:/英雄时刻");
        IOFile.redaAndWriteDirectory(new File("D:/英雄时刻"),new File("C:/copy"));
        logger.info("调用了FileService：download（）方法");
    }

    public String testIo() throws IOException{
        //return IOBase.countFileString("使用buffredRead");
        return IOFile.countFileStringByBuffred("使用文件编码的改变");
    }
}
