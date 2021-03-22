package com.xuhuan.xml.packaging;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * 拼装xml demo
 *
 * @author 徐欢
 */
public class PackagingXml {

    public static void main(String[] args) {
        Document document = createDocument();
//        createXmlFile(document, "src/main/resources/foo.xml");
        createXmlFile(document, "D:\\git_repositorys\\demos_repository\\demo_xml_dom4j\\src\\main\\resources\\foo.xml");
        String xmlString = createXmlString(document);
        System.out.println(xmlString);
    }

    /**
     * 创建xml文件格式化
     *
     * @return
     */
    public static OutputFormat createOutputFormat() {
        // 设置XML文档格式
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        // 设置XML编码方式,即是用指定的编码方式保存XML文档到字符串(String),这里也可以指定为GBK或是ISO8859-1  
        outputFormat.setEncoding("UTF-8");
        //是否生产xml头
        //outputFormat.setSuppressDeclaration(true);
        //设置是否缩进
        outputFormat.setIndent(true);
        //以四个空格方式实现缩进
        outputFormat.setIndent("    ");
        //设置是否换行
        outputFormat.setNewlines(true);
        return outputFormat;
    }

    /**
     * 创建xml文件
     *
     * @param document
     * @param path
     */
    public static void createXmlFile(Document document, String path) {
        XMLWriter writer=null;
        try {
            writer = new XMLWriter(new FileOutputStream(new File(path)), createOutputFormat());
            writer.write(document);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 创建xml字符串
     *
     * @param document
     * @return
     */
    public static String createXmlString(Document document) {
        StringWriter stringWriter = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(stringWriter, createOutputFormat());
        try {
            xmlWriter.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    /**
     * 创建document
     *
     * @return
     */
    public static Document createDocument() {
        Document document = DocumentHelper.createDocument();

        Element root = document.addElement("result");
        root.addElement("code").addText("1");
        Element data = root.addElement("data");

        Element person1 = data.addElement("Person");
        person1.addElement("name").setText("张三");
        person1.addElement("id").setText("1");
        person1.addElement("url").setText("http://192.168.191.1:9999/TestWeb/c7fe21616d2a5e2bd1e84bd453a5b30f.jpg");
        Element courses1 = person1.addElement("courses");
        Element course1 = courses1.addElement("course");
        course1.addElement("courseName").setText("语文");
        course1.addElement("courseMarks").setText("90");
        course1.addElement("courseId").setText("1");
        Element course2 = courses1.addElement("course");
        course2.addElement("courseName").setText("数学");
        course2.addElement("courseMarks").setText("80");
        course2.addElement("courseId").setText("2");
        Element course3 = courses1.addElement("course");
        course3.addElement("courseName").setText("英语");
        course3.addElement("courseMarks").setText("70");
        course3.addElement("courseId").setText("3");

        Element person2 = data.addElement("Person")
                .addAttribute("name", "李四")
                .addAttribute("id", "2")
                .addAttribute("url", "http://192.168.191.1:9999/TestWeb/4052858c526002a712ef574ccae1948f.jpg");
        person2.addElement("course")
                .addAttribute("courseName", "语文")
                .addAttribute("courseMarks", "91")
                .addAttribute("courseId", "1");
        person2.addElement("course")
                .addAttribute("courseName", "数学")
                .addAttribute("courseMarks", "82")
                .addAttribute("courseId", "1");
        person2.addElement("course")
                .addAttribute("courseName", "英语")
                .addAttribute("courseMarks", "73")
                .addAttribute("courseId", "1");

        return document;
    }

}
