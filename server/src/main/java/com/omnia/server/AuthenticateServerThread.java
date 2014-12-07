package com.omnia.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AuthenticateServerThread extends Thread
{
    private Socket socket = null;

    public AuthenticateServerThread(Socket socket)
    {
        super("AuthenticateServerThread");
        this.socket = socket;
    }

    public void run()
    {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            String inputLine, outputLine;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
