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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

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
            
            String firstLine = msg.readLine();
            String secondLine = msg.readLine();
            Package pack = new Package(firstLine.split(" ")[0], firstLine.split(" ")[1] , firstLine.split(" ")[2], secondLine.split(" ")[1]);
            
            //Criar msg de requisicao para o servidor
            pack.setRest(firstLine);
            pack.setRest(pack.getRest() +"\n"+ secondLine+ "\n");    
            //criar conexao com o servidor
            URL url;
            url = new URL(pack.getUrl());
            
            HttpURLConnection http1 = (HttpURLConnection) url.openConnection();
            
            http1.setRequestMethod("GET");

            String parametro = msg.readLine();
            http1.setRequestProperty(parametro.split(": ")[0], parametro.split(": ")[0]);
            parametro = msg.readLine();
            http1.setRequestProperty(parametro.split(": ")[0], parametro.split(": ")[0]);
            BufferedReader in = new BufferedReader(new InputStreamReader( http1.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            
            //Encaminhar o conteudo para o cliente
            DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());

            outToServer.writeBytes(response.toString());
            
            client.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(RequestHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
        }
        
    }
    
}