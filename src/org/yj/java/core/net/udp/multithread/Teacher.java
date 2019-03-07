package org.yj.java.core.net.udp.multithread;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/12 15:03
 */
public class Teacher {
    public static void main(String[] args) {
        new Thread(new UdpReceiver(9000, "张三")).start();
        new Thread(new UdpSender(9001, "localhost", "张三")).start();
    }
}
