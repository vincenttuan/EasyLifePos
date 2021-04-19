package com.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

public class WebServer {

    public static void main(String[] args) throws Exception {

        String requestMessageLine;
        String fileName;
        System.out.println("Web Server Starting on Port 80");
        ServerSocket s = new ServerSocket(80);

        System.out.println("Waiting for Connecting...");
        while (true) {
            Socket serverSocket = s.accept();
            System.out.println("Connection, sending data.");
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(serverSocket.getOutputStream());

            requestMessageLine = in.readLine();
            StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);

            if (tokenizedLine.nextToken().equals("GET")) {
                fileName = tokenizedLine.nextToken();
                if (fileName.startsWith("/") == true) {
                    fileName = fileName.substring(1);
                }

                outToClient.writeBytes("HTTP/1.0 200 OK\r\n");
                outToClient.writeBytes("Content-Type: text/html\r\n");
                outToClient.writeBytes("\r\n");
                outToClient.writeBytes("<H1>Welcome to the Java WebServer</H1>\r\n");
                System.out.println("Sending txt data completely. " + new Date());

                serverSocket.close();
                outToClient.flush();
            } else {
                System.out.println("Bad Request Message");
            }
        }
    }
}
