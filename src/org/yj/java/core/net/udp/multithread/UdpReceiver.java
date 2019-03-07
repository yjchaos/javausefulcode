package org.yj.java.core.net.udp.multithread;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/12 14:49
 */
public class UdpReceiver implements Runnable {
    /**
     * 监听的端口
     */
    private int port;

    /**
     * 名字
     */
    private String name;

    DatagramSocket datagramSocket;

    private Boolean inited = true;

    public UdpReceiver(int port, String name) {
        this.port = port;
        this.name = name;

        try {
            datagramSocket = new DatagramSocket(port);
        } catch (Exception e) {
            inited = false;
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (inited) {
            System.out.println("udp 接收端启动成功。。。");
        } else {
            System.out.println("udp 接收端启动失败。。。");
        }
        try {
            byte[] container = new byte[1024 * 60];
            DatagramPacket datagramPacket = new DatagramPacket(container, container.length);
            while (true) {
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
                String from = dis.readUTF();
                String msg = dis.readUTF();
                System.out.println(from + ":" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
