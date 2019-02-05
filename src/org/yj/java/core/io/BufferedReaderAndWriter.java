package org.yj.java.core.io;

import java.io.*;

/**
 * 缓冲字符流测试
 * 
 * @author yaojun
 * @version 1.0
 * @date 2019/2/4 12:29
 **/
public class BufferedReaderAndWriter {
    public static void main(String[] args) {
        System.out.println("BufferedReaderAndWriter test:");
        BufferedReaderAndWriter bufferedReaderAndWriter = new BufferedReaderAndWriter();
        bufferedReaderAndWriter
            .readWithBufferedReader("src/org/yj/java/core/io/directory4Test/english.txt");
        bufferedReaderAndWriter
            .writeWithBufferedWriter("src/org/yj/java/core/io/directory4Test/writeTest.txt");

    }

    public void readWithBufferedReader(String srcPath) {
        System.out.println();
        System.out.println("字符缓冲流读入测试：");
        File file = new File(srcPath);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeWithBufferedWriter(String destPath) {
        System.out.println();
        System.out.println("字符缓冲流写入测试：");
        File file = new File(destPath);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.append("writeWithBufferedWriter test...");
            bw.newLine();
            bw.append("writeWithBufferedWriter test...");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
