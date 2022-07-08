package org.example;

import org.example.dao.ClientDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.State;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        /*Client raichu=new Client( "Raichu", "Eau", "o@mail.com",
                "000","pokemon",
                "1 rue d'Azuria", "25", "Azuria", "Kanto", State.ACTIVE);
        System.out.println( "Hello World!" );
        Client newRaichu = new Client();
        newRaichu.setFirstName("Rai");
        System.out.println(raichu);
        ClientDAO.create(raichu);
        ClientDAO.update(raichu.getId(), newRaichu);
        System.out.println(raichu);*/

        /*Client sacha=new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE);
        Order order2=new Order( sacha, "Coaching", "Dressage",
                2,10,State.ACTIVE);


        *//*****************//*

        Order newOrder = new Order();
        newOrder.setDesignation("Formation");

        order2.setNotNullData(newOrder);
        System.out.println(order2);*/

    }
}
