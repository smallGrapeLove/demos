package com.xuhuan.design.patterns.abstractFactoryPattern.impl;

import com.xuhuan.design.patterns.abstractFactoryPattern.Shape;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class Square implements Shape {
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
