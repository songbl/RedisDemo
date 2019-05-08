package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;

public class ReceiveUtils {
    private DatagramSocket socket;
    private static final int PhonePort = 8090;//手机端口号
    private DatagramPacket packet;
    private volatile boolean stopReceiver;
    String filePath = "/sdcard/AIUI/devices.txt";

    public void receiveMessage() {
        new Thread() {
            public void run() {
                try {
                    socket = new DatagramSocket(PhonePort,InetAddress.getLocalHost());
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                byte[] receBuf = new byte[1024];
                packet = new DatagramPacket(receBuf, receBuf.length);
                while (!stopReceiver) {
                    try {
                        socket.receive(packet);
                        String receive = new String(packet.getData(), 0, packet.getLength(), "utf-8");
                        System.out.println("zziafyc收到的内容为："+receive);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    PrintStream out ;
    BufferedReader input;

    public void initServer() {
        try {
            //创建一个ServerSocket，port是客户端的端口
            ServerSocket serverSocket = new ServerSocket(9000);
            String s1 = serverSocket.getInetAddress().toString();
            System.out.println("-------------------111-" + serverSocket.getInetAddress().getHostAddress());
            while (true) {
                System.out.println("--------00-----");
                //从请求队列中取出链接,如果只接受一次则不用使用while循环
                Socket socket = serverSocket.accept();
                //获取客户端信息
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final String clientContent = input.readLine();
                //接下来可以对信息进行操作，我这里是直接打印了，你可以读取或者做其他操作
                System.out.println(clientContent + "-------------------");


                //初始化输出流，回复客户端
                 out = new PrintStream(socket.getOutputStream());
                //获取键盘输出的内容
                String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
                //将信息发送给客户端
                out.println("open");



            }
        } catch (IOException e) {
            System.out.println("服务器异常:" + e);
        }finally {
            //关闭
            out.close();
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket.close();
        }
    }
}

