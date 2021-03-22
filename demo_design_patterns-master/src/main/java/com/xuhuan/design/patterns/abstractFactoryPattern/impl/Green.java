package com.xuhuan.design.patterns.abstractFactoryPattern.impl;

import com.xuhuan.design.patterns.abstractFactoryPattern.Color;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class Green implements Color {
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
