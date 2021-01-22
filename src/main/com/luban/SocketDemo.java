package com.luban;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1",8080); //创建tcp连接
            OutputStream outputStream = socket.getOutputStream();

            int i = 1;
            while (true){
                System.out.println(i++);
                outputStream.write("123".getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
