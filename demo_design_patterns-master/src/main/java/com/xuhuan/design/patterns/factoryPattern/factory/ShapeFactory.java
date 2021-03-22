package com.xuhuan.design.patterns.factoryPattern.factory;

import com.xuhuan.design.patterns.factoryPattern.Shape;
import com.xuhuan.design.patterns.factoryPattern.impl.Circle;
import com.xuhuan.design.patterns.factoryPattern.impl.Rectangle;
import com.xuhuan.design.patterns.factoryPattern.impl.Square;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class ShapeFactory {

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
