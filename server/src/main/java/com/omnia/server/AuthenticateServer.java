package com.omnia.server;

import sun.security.ssl.SSLServerSocketFactoryImpl;

import java.io.IOException;
import java.net.ServerSocket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class AuthenticateServer
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1)
        {
            System.err.println("Usage: java AuthenticateServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try (SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactoryImpl.getDefault();
             SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(portNumber))
        {
            while (listening)
            {
                new AuthenticateServerThread(sslServerSocket.accept()).start();
            }
        }
        catch (IOException e)
        {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
