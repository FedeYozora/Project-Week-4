package it.epicode.DAO;

import it.epicode.Sellers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class SellerDAO {
    private static EntityManager em;


    public SellerDAO(EntityManager em){
        this.em = em;
    }


    public void save (Sellers sellers){
        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(sellers);
            transaction.commit();
            System.out.println( sellers + "salvato correttamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
}}
