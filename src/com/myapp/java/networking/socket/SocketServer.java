package com.myapp.java.networking.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
    static ServerSocket serverSocket;
    static Socket socket;


    static void receivingThread() {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        socket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws Exception {
        try {
            serverSocket = new ServerSocket(6660);
            while (true) {
                socket = serverSocket.accept();
                try(DataInputStream dis = new DataInputStream(socket.getInputStream())){
                    String message = dis.readUTF();
                    System.out.println(message);
                    if(message.equalsIgnoreCase("exit")) break;
                }catch (Exception e){
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
