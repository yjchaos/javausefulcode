package org.yj.java.core.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入流 RandomAccessFile
 *
 * @author yaojun
 * @version 1.0
 * @date 2019/2/4 15:36
 **/
public class RandomTest {
    public static void main(String[] args) {
        System.out.println("随机读取和写入流测试：");
    }

    public void test() {
        File src = new File("src/org/yj/java/core/io/RandomTest.java");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize =1024;
        //块数: 多少块
        int size =(int) Math.ceil(len*1.0/blockSize);
        System.out.println(size);

        int beginPos;
        int actualSize;

        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {
                actualSize = (int) len;
            }else{
                actualSize = blockSize;
                len -= actualSize;
            }
            System.out.println(i+"-->"+beginPos +"-->"+actualSize);
            split(beginPos,actualSize);
        }
    }

    public void split(int beginPos, int size) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("src/org/yj/java/core/io/RandomTest.java"), "r");
            raf.seek(beginPos);
            byte[] flush = new byte[1024];
            int len;
            while ((len = raf.read(flush)) != -1) {
                if (size > len) {
                    System.out.println(new String(flush, 0, len));
                    size -= len;
                } else {
                    System.out.println(new String(flush, 0, size));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != raf) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
