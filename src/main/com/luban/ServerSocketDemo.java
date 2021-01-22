package com.luban;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[10];
            int n = inputStream.read(bytes);
            System.out.println(new String(bytes,0,n));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
