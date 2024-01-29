package it.epicode.DAO;

import it.epicode.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class UserDAO {

    private static EntityManager em;


    public UserDAO(EntityManager em){
        this.em = em;
    }


    public void save (User user){
        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(user);
            transaction.commit();
            System.out.println( user + "salvato correttamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
