package org.example;

import org.example.dao.ClientDAO;
import org.example.entity.Client;
import org.example.jpa.EntityManagerSingleton;
import org.example.util.State;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void createClient()
    {
        Client client=new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE);

        ClientDAO.create(client);

        assertTrue( true );
    }

    @Test
    public void findById(){
        Client client=new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE);
        ClientDAO.create(client);

        Client deuxiemeClient= ClientDAO.findById(client.getId());
        assertEquals("Sacha", deuxiemeClient.getFirstName());
    }

    @Test
    public void findAll() {
        ClientDAO.deleteAll();
        ClientDAO.create(new Client( "Pikachu", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE));
        ClientDAO.create(new Client( "Ondine", "Eau", "o@mail.com",
                "000","pokemon",
                "1 rue d'Azuria", "25", "Azuria", "Kanto", State.ACTIVE));
        ClientDAO.create(new Client( "Giovanni", "etchum", "g@mail.com",
                "000","pokemon",
                "jadielle 2", "25", "Jadielle", "Kanto", State.INACTIVE));

        List<Client> clients = ClientDAO.findAll();
        assertEquals(3, clients.size());
    }

    @Test
    public void deleteClient(){
        Client raichu=new Client( "Raichu", "Eau", "o@mail.com",
                "000","pokemon",
                "1 rue d'Azuria", "25", "Azuria", "Kanto", State.ACTIVE);
        ClientDAO.create(raichu);

        List<Client> clients = ClientDAO.findAll();
        int sizeClients=clients.size();

        ClientDAO.delete(raichu);

        clients = ClientDAO.findAll();
        assertEquals(sizeClients-1, clients.size());
    }

    public static void deleteClientById(Long id) {
        ClientDAO.deleteAll();
        Client raichu=new Client( "Raichu", "Eau", "o@mail.com",
                "000","pokemon",
                "1 rue d'Azuria", "25", "Azuria", "Kanto", State.ACTIVE);
        ClientDAO.create(raichu);
        long idRaichu=raichu.getId();


        ClientDAO.deleteClientById(raichu.getId());

        assertNull(ClientDAO.findById(idRaichu));
    }
    @Test
    public void updateClient(){
        ClientDAO.deleteAll();
        Client raichu=new Client( "Raichu", "Eau", "o@mail.com",
                "000","pokemon",
                "1 rue d'Azuria", "25", "Azuria", "Kanto", State.ACTIVE);
        ClientDAO.create(raichu);

        /*****************/

        Client newRaichu = new Client();
        newRaichu.setFirstName("Rai");

        ClientDAO.update(raichu.getId(), newRaichu);

        /*****************/

        Client updatedRaichu = ClientDAO.findById(raichu.getId());
        assertEquals("Rai", updatedRaichu.getFirstName());
        ClientDAO.delete(raichu);
    }

    @Test
    public void selectWhere(){
        ClientDAO.deleteAll();
        Client raichu=new Client( "Raichu", "Eau", "o@mail.com",
                "000","pokemon",
                "1 rue d'Azuria", "25", "Azuria", "Kanto", State.ACTIVE);
        ClientDAO.create(raichu);
        Client raichu2=new Client( "Raichu", "Electrik", "o@mail.com",
                "000","pokemon",
                "1 rue d'Azuria", "25", "Azuria", "Kanto", State.ACTIVE);
        ClientDAO.create(raichu2);

        /*****************/

        List<Client> raichus= ClientDAO.findByFirstName("Raichu");

        /*****************/

        assertEquals(2, raichus.size());
        ClientDAO.deleteAll();
    }

}
