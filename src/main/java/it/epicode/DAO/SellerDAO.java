package it.epicode.DAO;

import it.epicode.Sellers;
import it.epicode.Vehicles;
import it.epicode.enums.SellerType;
import it.epicode.enums.VehicleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class SellerDAO {
    private static EntityManager em;


    public SellerDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Sellers sellers) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(sellers);
            transaction.commit();
            System.out.println(sellers + "salvato correttamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filterByService(SellerType sellerType) {
        List<Sellers> automaticSellers = em.createQuery("SELECT s FROM Sellers s WHERE s.sellerType = :sellerType", Sellers.class)
                .setParameter("sellerType", SellerType.AUTOMATIC)
                .getResultList();
        List<Sellers> automaticSellersInService = automaticSellers.stream()
                .filter(Sellers::isInService)
                .collect(Collectors.toList());
        if (automaticSellersInService.isEmpty()) {
            System.out.println("Nessun Distributore Automatico in servizio trovato");
        } else {
            System.out.printf("Distributori Automatici in servizio trovati: %s", automaticSellersInService);
        }
    }
}
