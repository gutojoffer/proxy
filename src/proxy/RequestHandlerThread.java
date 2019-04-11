/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.io.BufferedReader;
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
            BufferedReader inFromClient  = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //Olhar o conteudo
            while(true){
                String clientSentence = inFromClient.readLine();
                if (clientSentence == null)
                        break;		
                System.out.println(clientSentence);
            }
            //Criar msg de requisicao para o servidor
            
            //criar conexao com o servidor
            
            //Receber o conteudo
            
            //Encaminhar o conteudo para o cliente
        } catch (IOException ex) {
            Logger.getLogger(RequestHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
