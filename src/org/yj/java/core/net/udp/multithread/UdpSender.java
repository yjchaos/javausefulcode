package org.yj.java.core.net.udp.multithread;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/12 14:50
 */
public class UdpSender implements Runnable {

    /**
     * 发送到指定端口
     */
    private Integer toPort;

    /**
     * 接收方ip
     */
    private String toIp;

    /**
     * 名字
     */
    private String name;

    DatagramSocket datagramSocket;

    BufferedReader reader;

    ByteArrayOutputStream baos;

    DataOutputStream dos;

    Boolean inited = true;

    public UdpSender(Integer toPort, String toIp, String name) {
        this.toPort = toPort;
        this.toIp = toIp;
        this.name = name;
        try {
            datagramSocket = new DatagramSocket();
            reader = new BufferedReader(new InputStreamReader(System.in));
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
        } catch (Exception e) {
            inited = false;
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (inited) {
            System.out.println("udp 发送端启动成功。。。");
        } else {
            System.out.println("udp 发送端启动失败。。。");
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(toIp);
            while (true) {
                String msg = reader.readLine();
                System.out.println(msg);
                dos.writeUTF(name);
                dos.writeUTF(msg);
                dos.flush();
                DatagramPacket datagramPacket = new DatagramPacket(baos.toByteArray(), baos.toByteArray().length, inetAddress, toPort);
                datagramSocket.send(datagramPacket);
                baos.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
