package org.yj.designpattern.creational.factory.factorymethod;

/**
 * 工厂方法模式中具体工厂(Concrete Factory)角色
 *
 * @author yaojun
 * @date 2019/3/14 11:12
 */
public class DivFacotory implements OperationFactory {
    @Override
    public Operation createOperation() {
        return new Div();
    }
}
