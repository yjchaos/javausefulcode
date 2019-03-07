package org.yj.java.core.net.udp.multithread;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/12 15:04
 */
public class Student {
    public static void main(String[] args) {
        new Thread(new UdpReceiver(9001, "李四")).start();
        new Thread(new UdpSender(9000, "localhost", "李四")).start();
    }
}
