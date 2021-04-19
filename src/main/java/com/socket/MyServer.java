package com.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args) throws Exception {
        // 清除主控台資料
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        int port = 5000;
        ServerSocket server = new ServerSocket(port);
        System.out.println("等待 Client 連入");
        Socket socket = server.accept();
        System.out.println("Client 連入, port=" + socket.getPort());
        
        try (InputStream is = socket.getInputStream();
                InputStreamReader bis = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(bis);) {

            System.out.println(br.readLine());

        } catch (Exception e) {
        }

    }
}
