package org.yj.java.core.abstractclassandinterface;

@FunctionalInterface
public interface MyFunctionalInterface {
    /**
     * 重新声明的Object中的public方法
     *
     * @param object
     * @return
     */
    @Override
    public abstract boolean equals(Object object);

    public static void staticMethod() {
        System.out.println("MyFunctionalInterface staticMethod");
    }

    public default void defaultMethod() {
        System.out.println("MyFunctionalInterface defaultMethod");
    }

    /**
     * 自定义的public abstract方法
     */
    void functionalInterfaceTest();
}
