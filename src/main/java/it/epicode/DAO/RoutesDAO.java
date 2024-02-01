package it.epicode.DAO;

import it.epicode.Routes;
import it.epicode.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RoutesDAO {
    private static EntityManager em;

    public RoutesDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Routes route) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(route);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
