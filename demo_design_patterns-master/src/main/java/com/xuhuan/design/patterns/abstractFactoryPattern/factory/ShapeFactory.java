package com.xuhuan.design.patterns.abstractFactoryPattern.factory;

import com.xuhuan.design.patterns.abstractFactoryPattern.Color;
import com.xuhuan.design.patterns.abstractFactoryPattern.Shape;
import com.xuhuan.design.patterns.abstractFactoryPattern.impl.Circle;
import com.xuhuan.design.patterns.abstractFactoryPattern.impl.Rectangle;
import com.xuhuan.design.patterns.abstractFactoryPattern.impl.Square;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class ShapeFactory extends AbstractFactory {
    public Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
