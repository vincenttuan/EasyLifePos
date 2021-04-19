package com.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class WebServer {
    public static void main(String[] args) throws Exception {

        String requestMessageLine;
        String fileName;
        System.out.println("Web Server Starting on Port 80");
        ServerSocket s = new ServerSocket(80);


        System.out.println("Waiting for Connecting...");
        while(true) {
            Socket serverSocket = s.accept();
            System.out.println("Connection, sending data.");
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(serverSocket.getOutputStream());
            
            requestMessageLine = in.readLine();
            StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);

            if(tokenizedLine.nextToken().equals("GET")) {
                fileName = tokenizedLine.nextToken();
                if(fileName.startsWith("/")==true)
                    fileName = fileName.substring(1);

                if(fileName.endsWith(".jpg")) {
                    File file = new File(fileName);
                    int numOfBytes = (int) file.length();

                    FileInputStream inFile = new FileInputStream("/Users/vincenttuan/NetBeansProjects/JavaSocket/src/main/java/com/lab/T28.jpg");
                    byte[] fileInBytes = new byte[numOfBytes];
                    inFile.read(fileInBytes);

                    outToClient.writeBytes("HTTP/1.0 200 OK\r\n");
                    outToClient.writeBytes("Content-Type: image/jpeg\r\n");
                    outToClient.writeBytes("Content-Length: "+numOfBytes+"\r\n");
                    outToClient.writeBytes("\r\n");
                    outToClient.write(fileInBytes, 0, numOfBytes);
                    inFile.close();
                    System.out.println("Sending image data completely.");
                }
                else {
                    outToClient.writeBytes("HTTP/1.0 200 OK\r\n");
                    outToClient.writeBytes("Content-Type: text/html\r\n");
                    outToClient.writeBytes("\r\n");
                    outToClient.writeBytes("<H1>Welcome to the Java WebServer</H1>\r\n");
                    System.out.println("Sending txt data completely.");
                }
            serverSocket.close();
            outToClient.flush();
        }
        else
            System.out.println("Bad Request Message");
        }
    }
}
