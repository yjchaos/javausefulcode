package org.yj.java.core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/16 11:44
 */
public class TcpClient {
    public static void main(String[] args) {
        System.out.println("client...");
        // 通道
        try {
            SocketChannel socketChannel = SocketChannel.open();
            // socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 9000));
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("hello nio".getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
