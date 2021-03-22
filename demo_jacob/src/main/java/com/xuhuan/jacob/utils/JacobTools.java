package com.xuhuan.jacob.utils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.log4j.Logger;

/**
 * 使用jacob把word的内容生成到txt或者html中
 *
 * @author huan.xu
 * @Time 2019-06-26 14:18
 */
public class JacobTools {

    private static Logger logger = Logger.getLogger(JacobTools.class);

    public static void extractDoc(String inputFIle, String outputFile) {
        ComThread.Release();
        ComThread.InitMTA(true);
        boolean flag = false;

        // 打开Word应用程序
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        try {
            // 设置word不可见
            app.setProperty("Visible", new Variant(false));

            // 打开word文件
            Dispatch doc1 = app.getProperty("Documents").toDispatch();

            Dispatch doc2 = Dispatch.invoke(
                    doc1,
                    "Open",
                    Dispatch.Method,
                    new Object[]{inputFIle, new Variant(false),
                            new Variant(true)}, new int[1]).toDispatch();

            Dispatch selection = app.getProperty("Selection").toDispatch();
            Dispatch.call(selection, "HomeKey", new Variant(6));
            Dispatch find = Dispatch.call(selection, "Find").toDispatch();
            Dispatch.put(find, "Text", "Lin1");
            Dispatch.call(find, "Execute");
//            Dispatch.call(selection,"MoveRight",new Variant(1),new Variant(1));
            Dispatch.put(selection, "Text", "test text");


            // 作为txt格式保存到临时文件
            Dispatch.invoke(doc2, "SaveAs", Dispatch.Method, new Object[]{
                    outputFile, new Variant(7)}, new int[1]);

            // 关闭word
            Variant f = new Variant(false);
            Dispatch.call(doc2, "Close", f);
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            app.invoke("Quit", new Variant[]{});
        }

        if (flag == true) {
            logger.info("Transformed Successfully");
        } else {
            logger.info("Transform Failed");
        }
        ComThread.Release();
    }

    public static void main(String[] args) {
        extractDoc("D:\\git_repositorys\\demo_repository\\demo_word_jacob\\data\\demo1.doc", "D:\\git_repositorys\\demo_repository\\demo_word_jacob\\data\\demo1.txt");
        extractDoc("D:\\git_repositorys\\demo_repository\\demo_word_jacob\\data\\demo1.doc", "D:\\git_repositorys\\demo_repository\\demo_word_jacob\\data\\demo1.html");
    }
}
