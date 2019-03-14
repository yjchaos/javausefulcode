package org.yj.designpattern.creational.factory.abstractfactory;

/**
 * 抽象工厂模式中的抽象工厂(Abstract Factory)
 * 
 * @author yaojun
 * @date 2019/3/14 16:18
 */
public interface PcFactory {
    Mouse createMouse();

    Keyboard createKeyboard();
}
