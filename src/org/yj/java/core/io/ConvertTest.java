package org.yj.java.core.io;

import java.io.*;
import java.net.URL;

/**
 * 转换流：InputStreamReader，OutputStreamWriter
 *
 * @author yaojun
 * @version 1.0
 * @date 2019/2/4 12:50
 **/
public class ConvertTest {
    public static void main(String[] args) {
        System.out.println("转换流测试：");
        ConvertTest convertTest = new ConvertTest();
//        convertTest.test1();
        convertTest.test2();
    }

    public void test1() {
        System.out.println();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String msg = "";
            while (!msg.equals("exit")) {
                msg = reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        System.out.println();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/org/yj/java/core/io/directory4Test/writeTest.txt")))
        ) {
            String msg ;
            while((msg=reader.readLine())!=null) {
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
