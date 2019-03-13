package org.yj.designmode.creational.factory.simplefactory;

/**
 * 简单工厂模式中具体产品(Concrete Product)的角色
 *
 * @author yaojun
 * @date 2019/3/13 16:59
 */
public class Circle implements Shape {

    public Circle() {
        System.out.println("circle construct");
    }

    @Override
    public void draw() {
        System.out.println("circle draw");
    }
}
