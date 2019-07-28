package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vedzah
 */
public abstract class Client implements SendMessage  {
    
    private static String SERVERHOST = "localhost";
    private static int SERVERPORT = 80;
    
    /**
     *
     * @throws IOException
     */
    @Override
    public void establishConnection() {
         //Initialize the socket connection
        Socket echoSocket = null;
        
        try {
            echoSocket = new Socket(SERVERHOST, SERVERPORT);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PrintWriter out = null;
        try {
            out = new PrintWriter(echoSocket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(echoSocket
                    .getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Initialize the reader
        BufferedReader ioReader =  new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!"exit".equals(input)){
            System.out.println("Use exit to terminate initialization process"
                    + " or wait for reponse from the Rover Server : ");
            System.out.println();
            
            try {
                input = ioReader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.write(String.format("%s\n", input));
            out.flush();

            try {
                System.out.println("Rover response : "
                        + in.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println();
            System.out.println();
        }
    
    }
    
}
