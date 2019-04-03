package com.zpself.service;

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

    public void download() {
        logger.info("调用了FileService：download（）方法");
    }
}
