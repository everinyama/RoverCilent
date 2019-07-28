package roverclient;

/**
 *
 * @author Vedzah
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import clients.Client;


public class RoverClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Client client = new Client() {};
        client.establishConnection();
    }
}
