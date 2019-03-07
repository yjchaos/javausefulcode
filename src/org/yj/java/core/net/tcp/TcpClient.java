package org.yj.java.core.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/12 17:56
 */
public class TcpClient {
    public static void main(String[] args) {
        System.out.println("tcp 客户端启动。。。");
        try {
            Socket client = new Socket("localhost", 9000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream daos = new DataOutputStream(client.getOutputStream());
            DataInputStream dis = new DataInputStream(client.getInputStream());
            boolean isRunning = true;
            while (isRunning) {
                String msg = reader.readLine();
                daos.writeUTF(msg);
                daos.flush();
                String res = dis.readUTF();
                System.out.println(res);
            }
            daos.close();
            dis.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
