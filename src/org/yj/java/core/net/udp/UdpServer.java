package org.yj.java.core.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/12 10:41
 */
public class UdpServer {
    public static void main(String[] args) {
        System.out.println("udp 服务器启动。。。");
        try {
            DatagramSocket datagramSocket = new DatagramSocket(9000);
            byte[] container = new byte[1024 * 60];
            DatagramPacket datagramPacket = new DatagramPacket(container, container.length);
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            String msg = new String(data, 0, data.length);
            System.out.println(msg);
            System.out.println("接收完成。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
