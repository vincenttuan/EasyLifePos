package com.socket;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) throws Exception {
        // 清除主控台資料
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        int port = 5000;
        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("連線成功~");

        try (OutputStream os = socket.getOutputStream();) {
            Scanner sc = new Scanner(System.in);
            System.out.print("請輸入資料: ");
            String data = sc.next();
            os.write(data.getBytes());
            os.flush();

        } catch (Exception e) {
        }

    }
}

