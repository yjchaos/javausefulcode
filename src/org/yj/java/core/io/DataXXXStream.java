package org.yj.java.core.io;

import java.io.*;

/**
 * 数据流(处理流)：DataOutputStream,DataInputStream
 *
 * @author yaojun
 * @version 1.0
 * @date 2019/2/4 13:36
 **/
public class DataXXXStream {
    public static void main(String[] args) {
        System.out.println("数据流测试：");
        DataXXXStream dataXXXStream = new DataXXXStream();
        dataXXXStream.test();
    }

    public void test() {
        System.out.println();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF("编码辛酸泪");
            dos.writeInt(18);
            dos.writeBoolean(false);
            dos.writeChar('a');
            dos.flush();
            byte[] data =baos.toByteArray();
            //读取
            DataInputStream dis =new DataInputStream(new ByteArrayInputStream(data));
            //顺序与写出一致
            String msg = dis.readUTF();
            int age = dis.readInt();
            boolean flag = dis.readBoolean();
            char ch = dis.readChar();
            System.out.println(msg);
            System.out.println(age);
            System.out.println(flag);
            System.out.println(ch);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
