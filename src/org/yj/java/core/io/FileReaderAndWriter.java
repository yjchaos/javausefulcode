package org.yj.java.core.io;

import java.io.*;

/**
 * 文件字符流测试
 *
 * @author yaojun
 * @version 1.0
 * @date 2019/1/27 12:05
 **/
public class FileReaderAndWriter {
    public static void main(String[] args) {
        System.out.println("文件字符流测试：");
        FileReaderAndWriter fileReaderAndWriter = new FileReaderAndWriter();
//        fileReaderAndWriter.readFile("src/org/yj/java/core/io/directory4Test/中文.txt");
        fileReaderAndWriter.writeFile("src/org/yj/java/core/io/directory4Test/writeTest.txt");
    }

    public void readFile(String srcPath) {
        System.out.println();
        System.out.println("readFile test:");
        File srcFile = new File(srcPath);
        if (srcFile.exists()) {
            Reader reader = null;
            try {
                reader = new FileReader(srcFile);
                char[] chars = new char[1024];
                int len;
                while ((len = reader.read(chars)) != -1) {
                    String s = new String(chars, 0, len);
                    System.out.println(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (null != reader) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            System.out.println("file not exist");
        }
    }

    public void writeFile(String destPath) {
        System.out.println();
        System.out.println("writeFile test:");
        File destFile = new File(destPath);
        if (destFile.exists()) {
            Writer writer = null;
            try {
                writer = new FileWriter(destFile);
                writer.append("file writer test\r\n").append("file writer test");
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (null != writer) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            System.out.println("file not exist");
        }
    }
}
