/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 201619060051
 */
public class Proxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String argv[]) throws Exception { 
        String clientSentence; 
        String capitalizedSentence;

        ServerSocket severSocket = new ServerSocket(12345);
        InetAddress myAddress = severSocket.getInetAddress();

        System.out.println("Address: " + myAddress.getHostAddress());

        while(true) {
            //fica esperando requisicao
            Socket client = severSocket.accept();
            
            //Criar a thread para tratar essa requisicao e passar como parametro do contrutor o Socket da conexao (client)
            new RequestHandlerThread(client).start();
        }
    }
}
