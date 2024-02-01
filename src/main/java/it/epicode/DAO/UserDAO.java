package it.epicode.DAO;

import it.epicode.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {

    private static EntityManager em;


    public UserDAO(EntityManager em) {
        this.em = em;
    }


    public void save(User user) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(user);
            transaction.commit();
//            System.out.println(user + "salvato correttamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(User user) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(em.contains(user) ? user : em.merge(user));
            transaction.commit();
            System.out.println(user + " deleted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
