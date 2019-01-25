package org.yj.java.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件字节流
 * 
 * 1、创建源 2、选择流 3、操作 4、释放资源
 * 
 * @author yaojun
 * @version 1.0
 * @date 2019/1/24 15:37
 */
public class FileXXXStream {
    public static void main(String[] args) {
        System.out.println("文件字节流测试：");
        FileXXXStream stream = new FileXXXStream();
        stream.readFile3("src/org/yj/java/core/io/directory4Test/中文.txt");
    }

    /**
     * 单字节读取测试
     * 
     * @param srcPath
     */
    public void readFile1(String srcPath) {
        // 1.创建源
        File file = openFile(srcPath);
        if (file != null) {

            if (file.isFile()) {
                // 2.选择流
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    // 3.操作
                    // 单字节读取，返回当前字节内容
                    int data1 = fis.read();
                    int data2 = fis.read();
                    int data3 = fis.read();
                    int data4 = fis.read();
                    System.out.println((char) data1);
                    System.out.println((char) data2);
                    System.out.println((char) data3);
                    System.out.println((char) data4);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 4.释放资源
                    // 晚打开的先释放
                    if (null != fis) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("not a file");
            }
        }
    }

    /**
     * 标准读取，将一个文件数的数据全部读出
     *
     * @param srcPath
     */
    public void readFile2(String srcPath) {
        // 1.创建源
        File file = openFile(srcPath);
        if (file != null) {
            if (file.isFile()) {
                // 2.选择流
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    // 3.操作
                    // 有了数组字节流其实我们就不用自己去创建byte数组了
                    int temp;
                    byte[] bytes = new byte[1024];
                    int i = 0;
                    while ((temp = fis.read()) != -1) {
                        if (i > bytes.length - 1) {
                            // bytes的容量翻倍
                            byte[] bytesTemp = bytes;
                            bytes = new byte[bytes.length << 1];
                            System.arraycopy(bytesTemp, 0, bytes, 0, bytesTemp.length);
                        }
                        bytes[i] = (byte) temp;
                        i++;
                    }
                    String s = new String(bytes, 0, i);
                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 4.释放资源
                    // 晚打开的先释放
                    if (null != fis) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("not a file");
            }
        }
    }

    /**
     * 分段读取
     * 
     * @param srcPath
     */
    public void readFile3(String srcPath) {
        // 1.创建源
        File file = openFile(srcPath);
        if (file != null) {
            if (file.isFile()) {
                // 2.选择流
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    // 3.操作
                    // 有了数组字节流其实我们就不用自己去创建byte数组了，这里并没有让bytes扩容，如果文件过大会出错

                    // 用来存放从文件中读出的完整字节数组
                    byte[] bytes = new byte[1024];
                    // 用来存放一次读出的字节数组
                    byte[] bytesBuffer = new byte[128];
                    // 一次读出的长度
                    int len;
                    // 当前数组可插入位置的索引
                    int bytesPoint = 0;
                    while ((len = fis.read(bytesBuffer)) != -1) {
                        System.arraycopy(bytesBuffer, 0, bytes, bytesPoint, len);
                        bytesPoint += len;
                    }
                    String s = new String(bytes, 0, bytesPoint);
                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 4.释放资源
                    // 晚打开的先释放
                    if (null != fis) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("not a file");
            }
        }
    }

    private File openFile(String srcPath) {
        File file = new File(srcPath);
        try {
            if (!file.exists()) {
                boolean flag = file.createNewFile();
                if (!flag) {
                    System.out.println("create file fail");
                    return null;
                } else {
                    System.out.println("create file success");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
