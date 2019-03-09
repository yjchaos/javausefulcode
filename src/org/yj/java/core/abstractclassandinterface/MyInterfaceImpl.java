package org.yj.java.core.abstractclassandinterface;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yaojun
 * @date 2019/3/8 14:41
 */
public class MyInterfaceImpl implements MyInterface, MyInterface1 {
    @Override
    public void method1() {
        System.out.println("MyInterfaceImpl method1");
    }

    @Override
    public void method2() {
        System.out.println("MyInterfaceImpl method2");
    }

    @Override
    public void defaultMethod() {
        System.out.println("MyInterfaceImpl defaultMethod");
    }

    public static void main(String[] args) {
        try {
            Set<String> result = new HashSet<String>();
            for (Method m : MyFunctionalInterface.class.getMethods()) {
                result.add(m.getName());
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.method1();
        myInterface.method2();
        MyInterface.staticMethod();
        MyInterface1.staticMethod();
        myInterface.defaultMethod();
    }
}
