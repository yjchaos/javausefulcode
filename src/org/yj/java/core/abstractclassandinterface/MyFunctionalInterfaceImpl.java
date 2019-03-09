package org.yj.java.core.abstractclassandinterface;

/**
 * @author yaojun
 * @date 2019/3/9 15:08
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    public static void main(String[] args) {
        System.out.println("函数式接口测试：");
        // anonymous Inner Class，匿名内部类实现
        MyFunctionalInterfaceImpl.testFunctionalInterface(new MyFunctionalInterface() {
            @Override
            public void functionalInterfaceTest() {
                System.out.println("anonymous Inner Class functionalInterfaceTest");
            }
        });
        // lambda表达式
        MyFunctionalInterfaceImpl.testFunctionalInterface(() -> System.out.println("lambda functionalInterfaceTest"));
    }

    public static void testFunctionalInterface(MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.functionalInterfaceTest();
    }

    @Override
    public void functionalInterfaceTest() {
        System.out.println("MyFunctionalInterfaceImpl functionalInterfaceTest");
    }
}
