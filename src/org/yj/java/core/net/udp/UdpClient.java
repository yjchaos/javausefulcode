package org.yj.java.core.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/12 10:41
 */
public class UdpClient {
    public static void main(String[] args) {
        System.out.println("udp 客户端启动。。。");
        try {
            DatagramSocket datagramSocket = new DatagramSocket(9001);
            String msg = "hello udp";
            byte[] data = msg.getBytes();
            InetAddress inetAddress = InetAddress.getByName("localhost");
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, 9000);
            datagramSocket.send(datagramPacket);
            System.out.println("发送完成。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
