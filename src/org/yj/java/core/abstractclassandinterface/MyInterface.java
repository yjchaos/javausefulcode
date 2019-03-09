package org.yj.java.core.abstractclassandinterface;

/**
 * @author yaojun
 * @date 2019/3/8 11:23
 */
public interface MyInterface {
    /**
     * 变量默认是public static final的
     */
    String s1 = "default";

    public static final String s2 = "default";

    /**
     * 方法默认是public abstract的
     */
    void method1();

    public abstract void method2();

    /**
     * 默认是public的
     */
    static void staticMethod() {
        System.out.println("MyInterface staticMethod");
    }

    /**
     * 默认是public的
     */
    default void defaultMethod() {
        System.out.println("MyInterface defaultMethod");
    }
}
