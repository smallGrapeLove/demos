package com.xuhuan.design.patterns.abstractFactoryPattern.impl;

import com.xuhuan.design.patterns.abstractFactoryPattern.Color;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class Red implements Color {
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
