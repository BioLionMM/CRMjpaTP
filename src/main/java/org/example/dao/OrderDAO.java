package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Order;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class OrderDAO {

    public static void create(Order newOrder) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(newOrder);
        tx.commit();
    }


    public static Order findById(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order order = entityManager.find(Order.class, id);

        return order;
    }


    public static List<Order> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select o from Order o");
        return findAllQuery.getResultList();
    }

    public static void delete(Order orderASupprimer) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(orderASupprimer);
        tx.commit();
    }


    public static void deleteOrderById(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Query deleteQuery = entityManager.createQuery("delete from Order o where o.id= :id");
        deleteQuery.setParameter("id", id);
        deleteQuery.executeUpdate();

        tx.commit();
    }

    public static void deleteAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Query deleteQuery = entityManager.createQuery("delete from Order");
        deleteQuery.executeUpdate();

        tx.commit();
    }

    public static void update(Long id, Order newOrderData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order orderToUpdate = entityManager.find(Order.class, id);
        orderToUpdate.setNotNullData(newOrderData);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(orderToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }


}
