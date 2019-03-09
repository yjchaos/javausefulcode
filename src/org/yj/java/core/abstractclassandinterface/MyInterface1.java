package org.yj.java.core.abstractclassandinterface;

/**
 * @author yaojun
 * @date 2019/3/8 15:41
 */
public interface MyInterface1 {
    void method1();

    static void staticMethod() {
        System.out.println("MyInterface1 staticMethod");
    }

    default void defaultMethod() {
        System.out.println("MyInterface1 defaultMethod");
    }
}
