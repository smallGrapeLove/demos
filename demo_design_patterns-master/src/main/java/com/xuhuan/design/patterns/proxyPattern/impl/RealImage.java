package com.xuhuan.design.patterns.proxyPattern.impl;

import com.xuhuan.design.patterns.proxyPattern.Image;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}
