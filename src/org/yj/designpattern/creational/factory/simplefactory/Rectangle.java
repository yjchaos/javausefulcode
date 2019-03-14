package org.yj.designpattern.creational.factory.simplefactory;

/**
 * 简单工厂模式中具体产品(Concrete Product)的角色
 * 
 * @author yaojun
 * @date 2019/3/13 17:02
 */
public class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("rectangle construct");
    }

    @Override
    public void draw() {
        System.out.println("rectangle draw");
    }
}
