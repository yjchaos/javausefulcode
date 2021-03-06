package org.yj.java.core.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author yaojun
 * @version 1.0
 * @date 2018/12/31 11:49
 **/
public class FileTest {
    public static void main(String[] args) {
        System.out.println("File类测试");
        FileTest fileTest = new FileTest();
//        fileTest.fileTest();
//        fileTest.directoryTest();
        // fileTest.printFileTree();
        fileTest.printFileLength();
    }

    /**
     * 文件测试
     */
    public void fileTest() {
        System.out.println(System.getProperty("user.dir"));
        // 新建File实例时，可以传递绝对路径，譬如："g:/test.txt"或者"g:\\test.txt"
        // 也可以传递相对路径。不以"\\"或"/"开头时，相对于user.dir目录，也就是当前工程的根目录；以"\\"或"/"开头时，相对于盘符。
        // 例如"src/org/yj"则绝对路径是"E:\work\core\javausefulcode\src\org\yj";"/src/org/yj"则绝对路径是"E:\src\org\yj"
        // 路径必须存在，否则会抛异常
        File file = new File("src/org/yj/java/core/../core/io/directory4Test/a.txt");
        System.out.println("文件是否存在：" + file.exists());
        if (file.exists()) {
            System.out.println("删除文件");
            file.delete();
        }
        try {
            System.out.println("创建文件");
            file.createNewFile();
            System.out.println("再次判断文件是否存在：" + file.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("是否是目录：" + file.isDirectory());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("文件最后修改时间：" + new Date(file.lastModified()));
        System.out.println("文件大小：" + file.length());
        System.out.println("文件名：" + file.getName());
        System.out.println("文件的相对路径：" + file.getPath());
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        try {
            System.out.println("文件的规范路径：" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 目录测试
     */
    public void directoryTest() {
        System.out.println();
        System.out.println("目录测试");
        File file = new File("src/org/yj/java/core/io/directory4Test");
        if (file.exists()) {
            file.delete();
        }
        //mkdir方法如果路径中间有一个目录不存在，则创建目录失败
        //mkdirs方法会创建整个目录树
        boolean flag = file.mkdir();
        if (flag) {
            System.out.println("mkdir创建目录成功.");
        }else{
            System.out.println("mkdir创建目录失败.");
        }
        flag = file.mkdirs();
        if (flag) {
            System.out.println("mkdirs创建目录成功.");
        }else{
            System.out.println("mkdirs创建目录失败.");
        }
        System.out.println("是否是目录：" + file.isDirectory());
    }

    /**
     * 打印目录树
     */
    public void printFileTree() {
        System.out.println();
        System.out.println("打印目录树：");
        File root = new File("src/org/yj");
        printFile(root, 0);
    }

    /**
     * 打印目录或文件大小
     */
    public void printFileLength() {
        System.out.println();
        System.out.println("打印目录或文件大小：");
        File root = new File("src/org/yj");
        System.out.println(root.getAbsolutePath() + "的大小为：" + calculateFileLength(root));
    }

    private void printFile(File file, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                printFile(f, level + 1);
            }
        }
    }

    private long calculateFileLength(File root) {
        long length = 0;
        if (root.exists()) {
            if (root.isFile()) {
                length = root.length();
                return length;
            } else {
                File[] fileList = root.listFiles();
                if (fileList != null) {
                    for (File file : fileList) {
                        length += calculateFileLength(file);
                    }
                }
            }
        }
        return length;
    }
}
