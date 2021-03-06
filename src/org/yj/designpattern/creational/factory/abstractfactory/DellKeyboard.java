package org.yj.designpattern.creational.factory.abstractfactory;

/**
 * 抽象工厂模式中的具体产品(Concrete Product)
 * 
 * @author yaojun
 * @date 2019/3/14 15:54
 */
public class DellKeyboard implements Keyboard {
    @Override
    public void sayHi() {
        System.out.println("DellKeyboard");
    }
}
