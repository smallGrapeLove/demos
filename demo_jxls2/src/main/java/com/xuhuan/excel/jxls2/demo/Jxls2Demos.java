package com.xuhuan.excel.jxls2.demo;

import com.xuhuan.excel.jxls2.utils.Jxls2Util;
import org.junit.Test;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author huan.xu
 * @Time 2019-08-19 19:20
 */
public class Jxls2Demos {

    private String sourceFilePath = "D:\\git_repositorys\\demo_repository\\demo_jxls2\\src\\main\\resources\\source.xls";
    private String targetFilePath = "D:\\git_repositorys\\demo_repository\\demo_jxls2\\src\\main\\resources\\target.xls";
    private Context context = new Context();


    @Test
    public void test1() throws Exception {
        InputStream is = this.getClass().getResourceAsStream("/source.xls");
        Context context = new Context();
        //设置参数变量
        context.putVar("name", "chendd");
        OutputStream os = new FileOutputStream(new File("D:\\git_repositorys\\demo_repository\\demo_jxls2\\src\\main\\resources\\target.xls"));
        //载入模板、处理导出
        JxlsHelper.getInstance().processTemplate(is, os, context);
        //释放资源
        os.flush();
        os.close();
        is.close();
    }

    @Test
    public void test2() throws Exception {
        context.putVar("name", "xuhuan");

        Jxls2Util.makeExcelJxls2(sourceFilePath, targetFilePath, context);
    }

    @Test
    public void testCreateExcelByTemplate() throws Exception {
        context.putVar("dataList", makeExcelData());
        Jxls2Util.makeExcelJxls2(sourceFilePath, targetFilePath, context);
    }

    /**
     * 组装excel数据，简单
     *
     * @return
     */
    private List<Map> makeExcelData() {
        List<Map> excelDataList = new ArrayList<>();

        Map map1 = new HashMap();
        map1.put("subject", "语文");
        map1.put("student", "张1");
        map1.put("grade", "81");
        excelDataList.add(map1);

        Map map2 = new HashMap();
        map2.put("subject", "数学");
        map2.put("student", "张2");
        map2.put("grade", "82");
        excelDataList.add(map2);

        Map map3 = new HashMap();
        map3.put("subject", "英语");
        map3.put("student", "张3");
        map3.put("grade", "83");
        excelDataList.add(map3);

        Map map4 = new HashMap();
        map4.put("subject", "物理");
        map4.put("student", "张4");
        map4.put("grade", "84");
        excelDataList.add(map4);

        Map map5 = new HashMap();
        map5.put("subject", "化学");
        map5.put("student", "张5");
        map5.put("grade", "85");
        excelDataList.add(map5);

        return excelDataList;

    }

}
