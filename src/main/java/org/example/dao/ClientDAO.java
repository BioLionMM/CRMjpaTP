package org.example.dao;

import org.example.entity.Client;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.*;
import java.util.List;

public class ClientDAO {
    public static void create(Client nouveauClient) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(nouveauClient);
        tx.commit();
    }


    public static Client findById(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client client = entityManager.find(Client.class, id);

        return client;
    }


    public static List<Client> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Client c");
        return findAllQuery.getResultList();
    }

    public static void delete(Client clientASupprimer) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(clientASupprimer);
        tx.commit();
    }

    public static void deleteClientById(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Query deleteQuery = entityManager.createQuery("delete from Client c where c.id= :id");
        deleteQuery.setParameter("id", id);
        deleteQuery.executeUpdate();

        tx.commit();
    }

    public static void deleteAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Query deleteQuery = entityManager.createQuery("delete from Client");
        deleteQuery.executeUpdate();

        tx.commit();
    }


    public static void update(Long id, Client newClientData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client clientToUpdate = entityManager.find(Client.class, id);
        clientToUpdate.setNotNullData(newClientData);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(clientToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public static List<Client> findByFirstName(String firstName) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query queryToFindCustomerByFirstName = entityManager.createQuery("select c from Client c where c.firstName = :firstName");
        queryToFindCustomerByFirstName.setParameter("firstName", firstName);
        return queryToFindCustomerByFirstName.getResultList();
    }
}
