package $15_network.$03_udp.demo01;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // conn();
        nonConn();
    }

    private static void conn() throws IOException{
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"), 6666); // 连接指定服务器和端口
        // 发送:
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length);
        ds.send(packet);
        // 接收:
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        ds.receive(packet);
        String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
        System.out.println(resp);
        ds.disconnect();
        // 关闭:
        ds.close();
    }
    private static void nonConn() throws IOException{
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        // 发送到localhost:6666:
        byte[] data1 = "Hello wa".getBytes();
        var packet1 = new DatagramPacket(data1, data1.length, InetAddress.getByName("localhost"), 6666);
        ds.send(packet1);
        // 发送到localhost:8888:
        byte[] data2 = "Hi".getBytes();
        var packet2 = new DatagramPacket(data2, data2.length, InetAddress.getByName("localhost"), 8888);
        ds.send(packet2);
        // 关闭:
        ds.close();
    }
}
