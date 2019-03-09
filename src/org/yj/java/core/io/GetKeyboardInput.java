package org.yj.java.core.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 从键盘中获取输入的两种方式
 * 
 * @author yaojun
 * @date 2019/3/8 10:54
 */
public class GetKeyboardInput {
    public static void main(String[] args) {
        System.out.println("测试从键盘获取输入：");
        GetKeyboardInput getKeyboardInput = new GetKeyboardInput();
        // getKeyboradInput.method1();
        getKeyboardInput.method2();
    }

    /**
     * Scanner方式获取键盘输入
     */
    public void method1() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (!s.equals("exit")) {
            System.out.println(s);
            s = scanner.nextLine();
        }
    }

    /**
     * 把System.in转成一个字符输入流，从输入流中去读取内容
     */
    public void method2() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();
            while (!s.equals("exit")) {
                System.out.println(s);
                s = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
