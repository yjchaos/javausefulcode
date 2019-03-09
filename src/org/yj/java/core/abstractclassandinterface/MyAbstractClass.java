package org.yj.java.core.abstractclassandinterface;

/**
 * @author yaojun
 * @date 2019/3/8 11:23
 */
public abstract class MyAbstractClass {
    private String s1;
    protected String s2;
    public String s3;
    private static String s4;
    private static final String s5 = "default";
    private final String s6 = "default";

    public static void staticMethod() {
        System.out.println("abstract staticMethod");
    }
}
