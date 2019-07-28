/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vedzah
 */
public class ClientTest {
    
    public ClientTest() {
    }
    
    public class ClientImpl extends Client {
    }

    /**
     * Test of establishConnection method, of class Client.
     */
    @Test
    public void testEstablishConnection() {
        System.out.println("establishConnection");
        Client instance = new ClientImpl();
        instance.establishConnection();
    }

    
    
}
