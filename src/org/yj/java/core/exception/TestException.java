package org.yj.java.core.exception;

import java.io.*;

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

    /**
     * 非检查异常
     */
    public void testArithmeticException() {
        int i = 0;
        try {
            i = 1 / 0;
        } catch (ArithmeticException e) {
            throw e;
        } finally {
            System.out.println("testArithmeticException finally");
        }
    }

    /**
     * 检查异常
     * 
     * @throws FileNotFoundException
     */
    public void testIOException() throws FileNotFoundException {
        File file = new File("src/org/yj/java/core/io/directory4Test/english.txt");
        Reader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
