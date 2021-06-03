package com.xuhuan.io;

import com.xuhuan.io.demos.IODemo;
import com.xuhuan.io.exception.CustomerException;
import com.xuhuan.io.exception.ExcepitonDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoIoApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(DemoIoApplicationTests.class);

    @Test
    public void testIO() {
//        IODemo.copyFileChar("F:\\io-dir\\test.txt","F:\\io-dir\\copyFileChar.txt");
//        IODemo.copyFileCharArray("F:\\io-dir\\test.txt","F:\\io-dir\\copyFileCharArray.txt");
//        IODemo.copyFileBufferedChar("F:\\io-dir\\test.txt","F:\\io-dir\\copyFileBufferedChar.txt");
//        IODemo.copyFileBufferedCharArray("F:\\io-dir\\test.txt","F:\\io-dir\\copyFileBufferedCharArray.txt");
//        IODemo.copyFileBufferedCharLine("F:\\io-dir\\test.txt","F:\\io-dir\\copyFileBufferedCharLine.txt");
//
//        IODemo.copyFileByte("F:\\io-dir\\jdk.exe","F:\\io-dir\\copyFileByte.exe");
//        IODemo.copyFileByteArray("F:\\io-dir\\jdk.exe","F:\\io-dir\\copyFileByteArray.exe");
//        IODemo.copyFileByteBuffered("F:\\io-dir\\jdk.exe","F:\\io-dir\\copyFileByteBuffered.exe");
//        IODemo.copyFileByteArrayBuffered("F:\\io-dir\\jdk.exe","F:\\io-dir\\copyFileByteArrayBuffered.exe");

        IODemo.copyDirFile("E:\\1.非标项目组管理", "F:\\io-dir\\test");
//        IODemo.copyDirFile("F:\\4.github_repository\\common_util","F:\\io-dir\\2-1");


    }

    @Test
    public void testException() {
        try {
            ExcepitonDemo.createException(0);
        } catch (CustomerException e) {
            String code = e.getCode();
            if ("0".equals(code)) {
                logger.info("错误码[{}],错误信息[{}]", code, e.getMessage());
            } else if ("1".equals(code)) {
                logger.info("错误码[{}],错误信息[{}]", code, e.getMessage());
            } else if ("2".equals(code)) {
                logger.info("错误码[{}],错误信息[{}]", code, e.getMessage());
            }
        }

    }

}
