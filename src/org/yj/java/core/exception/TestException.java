package org.yj.java.core.exception;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/3/7 14:42
 */
public class TestException {
    public static void main(String[] args) {
        System.out.println("java 异常测试：");
        TestException testException = new TestException();
        testException.testArithmeticException();
    }

    public void testArithmeticException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------");
            System.out.println(e.toString());
            System.out.println("-------------------------------------------------------");
            System.out.println(e.getLocalizedMessage());
            System.out.println("-------------------------------------------------------");
            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement element : elements) {
                System.out.println(element);
            }
        }
    }
}
