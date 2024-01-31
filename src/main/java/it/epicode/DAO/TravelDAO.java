package it.epicode.DAO;

import it.epicode.Card;
import it.epicode.Subscriptions;
import it.epicode.TravelDocument;
import it.epicode.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.UUID;

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

    public void checkValidityByCardId(UUID cardId) {
        LocalDate today = LocalDate.now();
        Subscriptions sub = em.find(Subscriptions.class, cardId);
        LocalDate expDate = sub.getDateOfExpiration();
        if (today.isAfter(expDate)) {
            System.out.printf("L'abbonamento associato alla card %s é scaduto", cardId);
        } else {
            System.out.printf("L'abbonamento associato alla card %s é attivo, con scadenza %s", cardId, expDate);
        }
    }

    public void findSubByUserId(UUID userId) {
        User user = em.find(User.class, userId);
        Card card = em.createQuery("SELECT c FROM Card c WHERE c.user = :userId", Card.class).setParameter("userId", user).getResultList().stream().findFirst().orElse(null);
        if (card != null) {
            System.out.println("Sub trovata: " + card.getTravelDocument());
        } else {
            System.out.printf("L'utente %s non ha abbonamenti", userId);
        }
    }
}
