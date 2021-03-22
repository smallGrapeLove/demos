package com.xuhuan.design.patterns.proxyPattern.impl;

import com.xuhuan.design.patterns.proxyPattern.Image;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
