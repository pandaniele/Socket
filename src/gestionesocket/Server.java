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
       //  DataOutputStream out;
         BufferedWriter bf;
         BufferedReader in;
            
                 BufferedReader tastiera;
                 String stringaRicevuta;
                 
                  ServerSocket serverSocket;
                    Socket socket;
                    
  public Server(int porta){
             try {
                 
                 serverSocket = new ServerSocket(porta);
                  System.out.println("1) SERVER IN ASCOLTO AVVIATO CORRETTAMEMTE \n");
             } 
                  catch (BindException ex) {
              System.out.println(" SERVER: ERRORE, LA PORTA E' GIA' OCCUPATA \n");
        }catch (IOException ex) {
               System.out.println("SERVER: ERRORE INIZIALE DEL SERVER \n");
             }
           
  }
                
public void attendi(){
             try {
                 tastiera=new BufferedReader(new InputStreamReader(System.in));
                 socket=serverSocket.accept();
                  System.out.println("3) SERVER: NUOVO CANALE DI COMUNICAZIONE CON IL CLIENT \n");
              //stream di scrittura del socket
             bf=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                   in= new BufferedReader( new InputStreamReader(socket.getInputStream()));
             } catch (IOException ex) {
                    System.out.println(" SERVER: ERRORE DI ACCETTAZIONE \n");
             }
}
    
          
        public void scrivi(){
              try {
                 System.out.println(" SERVER: COSA VUOI MANDARE AL CLIENT?  \n");
               // String messaggioBenevnuto="MI DAI DATA E ORA?";
               String hh=tastiera.readLine();
               if("0".equals(hh)){
                   
                   SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        String timeStamp = date.format(new Date());
                   
         bf.write(timeStamp+"\r\n");
              System.out.println("8) INVIO DATA E ORA \n");
              
               }
               else{
                   bf.write(hh+"\r\n");
                //messaggio di saluto
                System.out.println("4) INVIO MESSAGGIO:"+ tastiera.readLine()+"\n");
               }
                
                bf.flush();
            }
              catch (IOException ex) {
               System.out.println(" SERVER: ERORE DI SCRITTURA  \n");
            }
        }
        
        public void leggi(){
            try {
                stringaRicevuta=in.readLine();
                 System.out.println("7) SERVER: IL MESSAGGIO DEL CLIENT E' : " +stringaRicevuta+"\n");
            } catch (IOException ex) {
               System.out.println(" SERVER: ERRORE DI RICEVIMENTO"+ "\n");
            } 
        }
 
 
        public void chiudiConnessione(){
             try {
                 socket.close();
                    System.out.println("11)CONNESSIONE CON IL CLIENT TERMINATA \n");
             } catch (IOException ex) {
                 System.out.println(" SERVER: IMPOSSIBILE CHIUDERE LA CONNESSIONE CON IL CLIENT"+ "\n");
             }
        }
        
        public void chiudiServer(){
             try {
                 serverSocket.close();
             } catch (IOException ex) {
                  System.out.println(" SERVER: IMPOSSIBILE SPEGNERE IL SERVER"+ "\n");
             }
        }
                 
                
    }
    
