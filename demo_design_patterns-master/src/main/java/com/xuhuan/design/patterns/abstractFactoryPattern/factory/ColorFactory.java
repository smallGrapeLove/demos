package com.xuhuan.design.patterns.abstractFactoryPattern.factory;

import com.xuhuan.design.patterns.abstractFactoryPattern.Color;
import com.xuhuan.design.patterns.abstractFactoryPattern.Shape;
import com.xuhuan.design.patterns.abstractFactoryPattern.impl.Blue;
import com.xuhuan.design.patterns.abstractFactoryPattern.impl.Green;
import com.xuhuan.design.patterns.abstractFactoryPattern.impl.Red;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class ColorFactory extends AbstractFactory {
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    public Shape getShape(String shape) {
        return null;
    }
}
