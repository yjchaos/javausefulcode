package org.yj.java.core.io;

import java.io.*;

/**
 * 字节缓冲流测试
 *
 * @author yaojun
 * @version 1.0
 * @date 2019/2/4 11:39
 **/
public class BufferedXXXStream {
    public static void main(String[] args) {
        System.out.println("字节缓冲流测试：");
        BufferedXXXStream bufferedXXXStream = new BufferedXXXStream();
//        bufferedXXXStream.readByBufferedInputStream("src/org/yj/java/core/io/directory4Test/english.txt");
        bufferedXXXStream.writeByBufferedOutputStream("src/org/yj/java/core/io/directory4Test/writeTest.txt");

    }

    public void readByBufferedInputStream(String srcPath) {
        System.out.println();
        System.out.println("readByBufferedInputStream test:");
        File file = new File(srcPath);
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            byte[] flush = new byte[1024];
            int len;
            while ((len = is.read(flush)) != -1) {
                String tmp = new String(flush, 0, len);
                System.out.println(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeByBufferedOutputStream(String destPath) {
        System.out.println();
        System.out.println("writeByBufferedOutputStream test:");
        File file = new File(destPath);
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            String msg = "writeByBufferedOutputStream test";
            byte[] data = msg.getBytes();
            os.write(data);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
