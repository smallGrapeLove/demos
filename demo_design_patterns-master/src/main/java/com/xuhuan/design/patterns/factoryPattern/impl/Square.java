package com.xuhuan.design.patterns.factoryPattern.impl;


import com.xuhuan.design.patterns.factoryPattern.Shape;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class Square implements Shape {
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
