package org.yj.java.core.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/12 17:48
 */
public class TcpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("tcp 服务器启动。。。");
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立连接。。。");
            new Thread(() -> {
                DataOutputStream daos = null;
                DataInputStream dis = null;
                try {
                    daos = new DataOutputStream(client.getOutputStream());
                    dis = new DataInputStream(client.getInputStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Boolean isRunning = true;
                while (isRunning) {
                    try {
                        String msg = dis.readUTF();
                        System.out.println(msg);
                        daos.writeUTF("login success");
                        daos.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("client quit");
                        isRunning = false;
                    }
                }
            }).start();
        }
    }
}
