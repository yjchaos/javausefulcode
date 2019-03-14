package org.yj.designpattern.creational.factory.abstractfactory;

/**
 * 抽象工厂模式测试类
 * 
 * @author yaojun
 * @date 2019/3/14 16:38
 */
public class Test {
    public static void main(String[] args) {
        PcFactory factory = new DellFactory();
        Mouse mouse = factory.createMouse();
        Keyboard keyboard = factory.createKeyboard();
        mouse.sayHi();
        keyboard.sayHi();

        factory = new HpFactory();
        mouse = factory.createMouse();
        keyboard = factory.createKeyboard();
        mouse.sayHi();
        keyboard.sayHi();
    }
}
