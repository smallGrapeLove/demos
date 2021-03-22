package com.xuhuan.excel.jxls2.utils;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;

/**
 * jxls2工具类
 *
 * @author huan.xu
 * @Time 2019-08-20 11:01
 */
public class Jxls2Util {

    public static void makeExcelJxls2(String sourceFilePath, String targetFilePath, Context context) throws Exception {
        InputStream is = new FileInputStream(new File(sourceFilePath));
        //设置参数变量
        OutputStream os = new FileOutputStream(new File(targetFilePath));
        //载入模板、处理导出
        JxlsHelper.getInstance().processTemplate(is, os, context);
        //释放资源
        os.flush();
        os.close();
        is.close();
    }
}
