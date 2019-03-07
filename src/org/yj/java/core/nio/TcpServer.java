package org.yj.java.core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/2/16 11:37
 */
public class TcpServer {
    public static void main(String[] args) {
        System.out.println("server...");
        try {
            // 选择器
            Selector selector = Selector.open();
            // 通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost", 9000));
            serverSocketChannel.configureBlocking(false);
            // 注册通道到选择器
            int interestSet = SelectionKey.OP_ACCEPT;
            serverSocketChannel.register(selector, interestSet);

            ByteBuffer readBuff = ByteBuffer.allocate(1024);
            while (true) {
                int readyNum = selector.select();
                if (readyNum == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    if (sk.isConnectable()) {
                        System.out.println("channel" + sk.channel() + " connectable");
                    }
                    if (sk.isAcceptable()) {
                        try {
                            ServerSocketChannel ssc = (ServerSocketChannel) sk.channel();
                            SocketChannel sc = ssc.accept();
                            sc.configureBlocking(false);
                            sc.register(sk.selector(), SelectionKey.OP_READ);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("channel" + sk.channel() + " acceptable");
                    }
                    if (sk.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) sk.channel();
                        readBuff.clear();
                        socketChannel.read(readBuff);
                        readBuff.flip();
                        System.out.println("received : " + new String(readBuff.array()));
                        System.out.println("channel" + sk.channel() + " readable");
                    }
                    if (sk.isWritable()) {
                        System.out.println("channel" + sk.channel() + " writable");
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
