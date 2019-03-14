package org.yj.designpattern.creational.factory.factorymethod;

/**
 * 工厂方法测试类
 * 
 * @author yaojun
 * @date 2019/3/14 11:13
 */
public class Test {
    public static void main(String[] args) {
        OperationFactory addFactory = new AddFactory();
        OperationFactory subFactory = new SubFactory();
        OperationFactory mulFactory = new MulFactory();
        OperationFactory divFactory = new DivFacotory();
        Operation add = addFactory.createOperation();
        Operation sub = subFactory.createOperation();
        Operation mul = mulFactory.createOperation();
        Operation div = divFactory.createOperation();
        System.out.println("2 + 3 = " + add.calculateResult(2, 3));
        System.out.println("3 - 1 = " + sub.calculateResult(3, 1));
        System.out.println("2 * 3 = " + mul.calculateResult(2, 3));
        System.out.println("4 / 2 = " + div.calculateResult(4, 2));
    }
}
