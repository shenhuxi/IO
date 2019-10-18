package com.zpself.IO_netty.service;

/**
 * 实现类
 */
public class HelloServiceImpl implements HelloService {
  public String hello(String msg) {
    return msg != null ? msg + " -----> I am fine." : "I am fine.";
  }
}