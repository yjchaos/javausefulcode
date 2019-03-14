package org.yj.designpattern.creational.factory.factorymethod;

/**
 * 工厂方法模式中具体产品(Concrete Product)的角色
 *
 * @author yaojun
 * @date 2019/3/14 10:25
 */
public class Add implements Operation {
    @Override
    public double calculateResult(double number1, double number2) {
        return number1 + number2;
    }
}
