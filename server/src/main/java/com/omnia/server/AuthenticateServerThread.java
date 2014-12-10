//package com.omnia.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

public class AuthenticateServerThread extends Thread
{
    private SSLSocket sslSocket = null;

    public AuthenticateServerThread(SSLSocket sslSocket)
    {
        super("AuthenticateServerThread");
        this.sslSocket = sslSocket;
    }

    public void run()
    {
        try (PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream())))
        {
            String inputLine, outputLine;
            outputLine = "connected";
            System.err.println(in.readLine());
            out.println(outputLine);
            sslSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
