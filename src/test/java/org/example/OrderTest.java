package org.example;

import org.example.dao.ClientDAO;
import org.example.dao.OrderDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.State;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class OrderTest {
    @Test
    public void createOrder()
    {
        ClientDAO.create(new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE));

        Client sacha= ClientDAO.findByFirstName("Sacha").get(0);
        Order order=new Order( sacha, "Formation", "Lancer",
                2,10,State.ACTIVE);

        OrderDAO.create(order);

        assertTrue( true );
    }

    @Test
    public void findById(){
        OrderDAO.deleteAll();

        ClientDAO.create(new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE));

        Client sacha= ClientDAO.findByFirstName("Sacha").get(0);
        Order order=new Order( sacha, "Formation", "Lancer",
                2,10,State.ACTIVE);
        OrderDAO.create(order);

        Order deuxiemeOrder= OrderDAO.findById(order.getId());
        assertEquals("Sacha", deuxiemeOrder.getClient().getFirstName());
    }

    @Test
    public void findAll() {
        OrderDAO.deleteAll();
        ClientDAO.deleteAll();

        ClientDAO.create(new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE));
        ClientDAO.create(new Client( "Ondine", "Eau", "o@mail.com",
                "000","pokemon",
                "1 rue d'Azuria", "25", "Azuria", "Kanto", State.ACTIVE));
        ClientDAO.create(new Client( "Giovanni", "etchum", "g@mail.com",
                "000","pokemon",
                "jadielle 2", "25", "Jadielle", "Kanto", State.INACTIVE));


        Client sacha= ClientDAO.findByFirstName("Sacha").get(0);
        Client ondine= ClientDAO.findByFirstName("Ondine").get(0);
        Client giovanni= ClientDAO.findByFirstName("Giovanni").get(0);

        OrderDAO.create(new Order( sacha, "Formation", "Lancer",
                2,10,State.ACTIVE));
        OrderDAO.create(new Order( sacha, "Coaching", "Dressage",
                2,10,State.ACTIVE));
        OrderDAO.create(new Order( ondine, "Coaching", "PokemonEau",
                2,10,State.ACTIVE));
        OrderDAO.create(new Order( giovanni, "Formation", "Genetique",
                30,100,State.ACTIVE));

        List<Order> orders = OrderDAO.findAll();
        assertEquals(4, orders.size());

        OrderDAO.deleteAll();
        ClientDAO.deleteAll();
    }

    @Test
    public void deleteOrder(){
        OrderDAO.deleteAll();
        ClientDAO.deleteAll();

        ClientDAO.create(new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE));
        Client sacha= ClientDAO.findByFirstName("Sacha").get(0);
        Order order2=new Order( sacha, "Coaching", "Dressage",
                2,10,State.ACTIVE);

        OrderDAO.create(order2);

        List<Order> orders = OrderDAO.findAll();
        int sizeOrders=orders.size();

        OrderDAO.delete(order2);

        orders = OrderDAO.findAll();
        assertEquals(0,orders.size());
    }

    public static void deleteOrderById(Long id) {
        OrderDAO.deleteAll();

        ClientDAO.deleteAll();

        ClientDAO.create(new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE));
        Client sacha= ClientDAO.findByFirstName("Sacha").get(0);
        Order order2=new Order( sacha, "Coaching", "Dressage",
                2,10,State.ACTIVE);

        OrderDAO.create(order2);

        long idOrder=order2.getId();


        OrderDAO.deleteOrderById(idOrder);

        assertNull(OrderDAO.findById(idOrder));
    }

    @Test
    public void updateOrder(){
        OrderDAO.deleteAll();

        ClientDAO.deleteAll();

        ClientDAO.create(new Client( "Sacha", "Ketchum", "a@mail.com",
                "000","pokemon",
                "1 rue de bourg palette", "25", "Bourg palette", "Kanto", State.ACTIVE));
        Client sacha= ClientDAO.findByFirstName("Sacha").get(0);
        Order order2=new Order( sacha, "Coaching", "Dressage",
                2,10,State.ACTIVE);


        /*****************/

        Order newOrder = new Order();
        newOrder.setDesignation("Formation");

        order2.setNotNullData(newOrder);
        //OrderDAO.update(order2.getId(), newOrder);

        /*****************/
        assertEquals("Formation", order2.getDesignation());
        OrderDAO.deleteAll();
    }

}
