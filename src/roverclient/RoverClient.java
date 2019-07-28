package roverclient;

/**
 *
 * @author Vedzah
 */

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
