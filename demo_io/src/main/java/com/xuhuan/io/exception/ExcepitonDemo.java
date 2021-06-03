package com.xuhuan.io.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huan.xu
 * @ClassName ExcepitonDemo
 * @date 2021/4/9 10:36
 * @Description 异常类
 */
public class ExcepitonDemo {
    private static Logger logger = LoggerFactory.getLogger(ExcepitonDemo.class);

    public static void createException(int num) {
        if (num == 0) {
            throw new CustomerException("0", "num=0");
        } else if (num == 1) {
            throw new CustomerException("1", "num=1");
        } else if (num == 2) {
            throw new CustomerException("2", "num=2");
        }
        logger.info("我看你是否会走到我这里来。。。。。");
    }
}
