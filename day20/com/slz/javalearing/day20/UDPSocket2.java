package com.slz.javalearing.day20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class UDPSocket2 {
    public static void main(String[] args) throws IOException {
        // 创建Socket
        DatagramSocket datagramSocket = new DatagramSocket(2222);
        // 消息转为byte数组
        String msg = "你好";
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        // 创建数据包
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("localhost"), 3333);
        // 调用send方法发送消息
        datagramSocket.send(datagramPacket);
    }
}
