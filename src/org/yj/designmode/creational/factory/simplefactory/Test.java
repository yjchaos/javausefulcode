package org.yj.designmode.creational.factory.simplefactory;

/**
 * 测试类
 * 
 * @author yaojun
 * @date 2019/3/13 17:08
 */
public class Test {
    public static void main(String[] args) {
        testGetShapeByType();
        testGetShapeByClass();
    }

    public static void testGetShapeByType() {
        System.out.println("\ntestGetShapeByType:");
        Shape circle = ShapeFactory.getShapeByType("CIRCLE");
        Shape rectangle = ShapeFactory.getShapeByType("RECTANGLE");
        Shape square = ShapeFactory.getShapeByType("SQUARE");
        circle.draw();
        rectangle.draw();
        square.draw();
    }

    public static void testGetShapeByClass() {
        System.out.println("\ntestGetShapeByClass:");
        Shape circle = ShapeFactory.getShapeByClass(Circle.class);
        Shape rectangle = ShapeFactory.getShapeByClass(Rectangle.class);
        Shape square = ShapeFactory.getShapeByClass(Square.class);
        circle.draw();
        rectangle.draw();
        square.draw();
    }
}
