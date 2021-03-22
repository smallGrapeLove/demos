package com.xuhuan.design.patterns.abstractFactoryPattern.factory;

import com.xuhuan.design.patterns.abstractFactoryPattern.Color;
import com.xuhuan.design.patterns.abstractFactoryPattern.Shape;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shapeType);
}
