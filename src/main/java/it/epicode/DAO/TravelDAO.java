package it.epicode.DAO;

import it.epicode.TravelDocument;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TravelDAO {
    private static EntityManager em;


    public TravelDAO(EntityManager em) {
        this.em = em;
    }


    public void save(TravelDocument travel) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(travel);
            transaction.commit();
            System.out.println(travel + "salvato correttamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
