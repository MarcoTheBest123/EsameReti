package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ClientHandler implements Runnable{
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out;

    Thread th;
    private static int secondi = 0;

    LocalDateTime time;

    int numero = 12;


    ClientHandler (Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run () {
        SeeMessage();
    }

    private void SeeMessage() {
        th = new Thread(
                ()->{
                    while(true) {
                        secondi++;
                        if (secondi == 60) {
                            out.println("CP " + time + "POLL CL" + numero);
                            secondi = 0;
                        }
                        try{
                            Thread.sleep(5000);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    });
    }


}