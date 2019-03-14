package org.yj.designpattern.creational.factory.abstractfactory;

/**
 * 抽象工厂模式中的具体工厂(Concrete Factory)
 * 
 * @author yaojun
 * @date 2019/3/14 16:36
 */
public class HpFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
