package com.xuhuan.design.patterns.proxyPattern;

import com.xuhuan.design.patterns.proxyPattern.impl.ProxyImage;

/**
 * 代理模式
 * @author huan.xu
 * @Date 2020-09-29
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
