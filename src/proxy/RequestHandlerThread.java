/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 201619060051
 */
public class RequestHandlerThread extends Thread{
    private Socket client;

    public RequestHandlerThread(Socket client) {
        this.client = client;
    }
    
    
    
    
    @Override
    public void run(){        
        try {
            // abrir a msg
            BufferedReader msg  = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //Olhar o conteudo
            msg.readLine();
            String secondLine = msg.readLine();
            
            String host;
            host = secondLine.split(" ")[1];
            
            //Criar msg de requisicao para o servidor
            Socket serverConection = new Socket(host, 80); 
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(serverConection.getInputStream())); 

            DataOutputStream outToServer = new DataOutputStream(serverConection.getOutputStream());
            
            msg.reset();
            
            while(true){
                String line = msg.readLine();
                if (line == null) break;
                outToServer.writeBytes(line + '\n');
            }
            

            //criar conexao com o servidor
            
            //Receber o conteudo
            while(true){
                String line = inFromServer.readLine();
                if (line == null) break;
                System.out.println(line);
                
            }
            //Encaminhar o conteudo para o cliente
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(RequestHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
        }
        
    }
    
}
