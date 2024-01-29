package it.epicode.DAO;

import it.epicode.Card;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CardDAO {
    private static EntityManager em;


    public CardDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Card card) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(card);
            transaction.commit();
            System.out.println(card + "salvato correttamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}