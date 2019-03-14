package org.yj.designpattern.creational.factory.simplefactory;

/**
 * @author yaojun
 * @date 2019/3/13 17:06
 */
public class ShapeFactory {
    /**
     * 通过形状类型获取具体形状的对象<br/>
     * 不符合开闭原则，每增加一个形状就要多加一个if-else
     * 
     * @param shapeType 形状类型
     * @return Shape对象
     */
    public static Shape getShapeByType(String shapeType) {
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

    /**
     * 用反射的方式获取具体形状的对象，比上面的方式好一些
     *
     * @param clazz 具体形状类型
     * @return Shape对象
     */
    public static Shape getShapeByClass(Class<? extends Shape> clazz) {
        Shape shape = null;
        try {
            shape = (Shape) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shape;
    }
}
