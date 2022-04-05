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


public class Client {
    
    public static void main(String[] args){
        
        try {
          DataOutputStream out;
          BufferedReader in;
            
                         
            Socket client = new Socket(InetAddress.getLocalHost(),2000);
             System.out.println(" 2) RICHIESTA CONNESSIONE DEL CLIENT IN CORSO \n");
        // 
             //stream di scrittura del socket
             out= new DataOutputStream( client.getOutputStream());
             
             //stream di scrittura del socket
            in= new BufferedReader( new InputStreamReader(client.getInputStream()));
            
            String stringaRicevuta;
            stringaRicevuta=in.readLine();
                      System.out.println("5) MESSAGGIO DEL SERVER: " +stringaRicevuta+"\n");
                      
                    String messaggioBenevnuto="MI DAI DATA E ORA?";
         out.writeBytes(messaggioBenevnuto+"\r\n");
              System.out.println("6) INVIO RICHIEsta data e ora \n");
              out.flush();
            
            stringaRicevuta=in.readLine();
                      System.out.println("9) LA DATA RICEVUTA E': " +stringaRicevuta+"\n");
              
              
                client.close();
                System.out.println("10)CONNESSIONE TERMINATA \n");
        }
       
        
    
        catch (UnknownHostException ex) {
              System.out.println("HOST SCONOSCIUTO \n");
            }
           catch (Exception ex) {
          System.out.println("ERRORE DURANTE LA CONNESISONE \n");
            }
    }
    
}
