package com.myapp.java.networking.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class SocketClient {
    static Socket socket;

    SocketClient() throws Exception{
        socket = new Socket("localhost",6660);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        socket.close();
    }



    static void sendMessage(String message) throws Exception{
        socket = new Socket("localhost",6660);
        try (DataOutputStream dis = new DataOutputStream(socket.getOutputStream())){
            dis.writeUTF(message);
            dis.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        socket.close();
    }

    public static void main(String[] args) throws Exception {

        sendMessage("2");
        sendMessage("1");
        sendMessage("exit");
        sendMessage("4");
    }
}
