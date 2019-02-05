package org.yj.java.core.io;

import java.io.*;

/**
 * 字节数组流测试，文件流是处理硬盘中的文件，字节数组流处理的是内存中的字节数组
 * @author yaojun
 * @version 1.0
 * @date 2019/2/3 19:22
 **/
public class ByteArrayXXXStream {
    public static void main(String[] args) {
        System.out.println("字节数组流测试：");
        ByteArrayXXXStream byteArrayXXXStream = new ByteArrayXXXStream();
//        byteArrayXXXStream.readByteArray();
        byteArrayXXXStream.writeByteArray();
//        byte[] src = byteArrayXXXStream.fileToByteArray("src/org/yj/java/core/io/directory4Test/picture.jpg");
//        byteArrayXXXStream.byteArrayToFile(src,"src/org/yj/java/core/io/directory4Test/picture-copy.jpg");
    }

    public void readByteArray() {
        System.out.println();
        System.out.println("readByteArray test:");
        // 1.创建源
        byte[] src = "read byte array test".getBytes();

        // 2.选择源
        InputStream is = null;

        try {
            is = new ByteArrayInputStream(src);
            // 3.操作（分段读取）
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.释放资源
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeByteArray() {
        System.out.println();
        System.out.println("writeByteArray test:");
        // 1.创建源
        byte[] dest = null;

        // 2.选择源
        ByteArrayOutputStream os = null;

        try {
            os = new ByteArrayOutputStream();
            // 3.操作(写出)
            String msg = "test writeByteArray\r\n";
            byte[] datas = msg.getBytes();
            os.write(datas, 0, datas.length);
            dest = os.toByteArray();
            System.out.println(new String(dest, 0, dest.length));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.释放资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public byte[] fileToByteArray(String srcPath) {
        System.out.println();
        System.out.println("test fileToByteArray:");
        File srcFile = new File(srcPath);
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(srcFile);
            baos = new ByteArrayOutputStream();
            byte[] flush = new byte[1024];
            int len;
            while ((len = is.read(flush)) != -1) {
                baos.write(flush, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
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
        return null;
    }

    public void byteArrayToFile(byte[] src, String filePath) {
        File file = new File(filePath);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(file);
            byte[] flush = new byte[1024];
            int len;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
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
