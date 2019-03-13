package org.yj.designmode.creational.factory.simplefactory;

/**
 * 简单工厂模式中具体产品(Concrete Product)的角色
 * 
 * @author yaojun
 * @date 2019/3/13 17:03
 */
public class Square implements Shape {
    public Square() {
        System.out.println("square construct");
    }

    @Override
    public void draw() {
        System.out.println("square draw");
    }
}
