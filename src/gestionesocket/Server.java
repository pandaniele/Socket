/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionesocket;

/**
 *
 * @author pandl
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    
    public static void main(String[] args){
                

        try {
          
             DataOutputStream out;
             BufferedWriter bf;
             BufferedReader in;
            
             //server in ascolto sulla porta 2000
            ServerSocket serverSocket = new ServerSocket(2000);
            System.out.println("1) SERVER AVVIATO CORRETTAMEMTE \n");
             //
             //accetta la richeista di connesisone del client
       Socket socket=serverSocket.accept();
         System.out.println("3) CONNESSIONE AVVENUTA \n");
         
 
                 
             //stream di scrittura del socket
             out= new DataOutputStream( socket.getOutputStream());
             
             bf=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             
            String messaggioBenevnuto="ciao";
         out.writeBytes(messaggioBenevnuto+"\r\n");
              System.out.println("4) INVIO MESSAGGIO DI BENVENUTO \n");
            out.flush();
            
             //stream di scrittura del socket
            in= new BufferedReader( new InputStreamReader(socket.getInputStream()));
                
            String stringaRicevuta;
            stringaRicevuta=in.readLine();
                      System.out.println("7) LA RICHIESTA DEL CLIENT E': " +stringaRicevuta+"\n");
                           
                      SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        String timeStamp = date.format(new Date());
                   
         out.writeBytes(timeStamp+"\r\n");
              System.out.println("8) INVIO DATA E ORA \n");
            out.flush();
              
        
         socket.close();
           System.out.println("11)CONNESSIONE TERMINATA \n");
           
                   
         //connessione unicast
         serverSocket.close();
    }
                catch (BindException ex) {
              System.out.println("ERRORE) LA PORTA E' GIA' OCCUPATA \n");
        }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
