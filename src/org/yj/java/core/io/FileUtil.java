package org.yj.java.core.io;

import java.io.*;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/1/26 11:27
 */
public class FileUtil {

    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        long beforTime = System.currentTimeMillis();
        // fileUtil.copyWithStream("src/org/yj/java/core/io/directory4Test/video.mp4", "src/org/yj/java/core/io/directory4Test/video_copy.mp4");
        // fileUtil.copyWithBufferdStream("src/org/yj/java/core/io/directory4Test/video.mp4",
        long afterTime = System.currentTimeMillis();
        System.out.println(afterTime - beforTime);
    }

    public void copyWithStream(String src, String dest) {
        File srcFile = new File(src);
        File destFile = new File(dest);
        if (!srcFile.exists()) {
            return;
        }
        if (!destFile.exists()) {
            try {
                boolean flag = destFile.createNewFile();
                if (flag) {
                    System.out.println("dest file create success");
                } else {
                    System.out.println("dest file create fail");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(destFile);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
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

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void copyWithBufferdStream(String src, String dest) {
        File srcFile = new File(src);
        File destFile = new File(dest);
        if (!srcFile.exists()) {
            return;
        }
        if (!destFile.exists()) {
            try {
                boolean flag = destFile.createNewFile();
                if (flag) {
                    System.out.println("dest file create success");
                } else {
                    System.out.println("dest file create fail");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(srcFile));
            os = new BufferedOutputStream(new FileOutputStream(destFile));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
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

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
