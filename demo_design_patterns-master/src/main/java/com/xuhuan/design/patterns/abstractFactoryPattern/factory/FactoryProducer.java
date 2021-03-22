package com.xuhuan.design.patterns.abstractFactoryPattern.factory;

/**
 * @author huan.xu
 * @Date 2020-09-29
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }

}
