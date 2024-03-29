package it.epicode.DAO;

import it.epicode.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.UUID;

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Card card) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(em.contains(card) ? card : em.merge(card));
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void updateCardSub(UUID cardID, Subscriptions newSub) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Card card = em.find(Card.class, cardID);
        em.persist(newSub);
        card.setTravelDocument(newSub);
        transaction.commit();
    }

    public void renewCardIfExpired(UUID cardID) {
        LocalDate currentDate = LocalDate.now();
        Card card = em.find(Card.class, cardID);
        if (card.getDateOfExpiration().isBefore(currentDate)) {
            LocalDate newExpirationDate = currentDate.plusYears(1);
            card.setDateOfExpiration(newExpirationDate);
            save(card);
            System.out.println("Tessera rinnovata con successo. Nuova data di scadenza: " + newExpirationDate);
        } else {
            System.out.println("La tessera non é ancora scaduta.");
        }
    }
}