package it.epicode;

import it.epicode.DAO.CardDAO;
import it.epicode.DAO.SellerDAO;
import it.epicode.DAO.TravelDAO;
import it.epicode.DAO.UserDAO;
import it.epicode.enums.SellerType;
import it.epicode.enums.SubType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{

    public  static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transport Agency");


    public static void main( String[] args ){

        EntityManager em = emf.createEntityManager();
        UserDAO userDAO = new UserDAO(em);
        CardDAO cardDAO = new CardDAO(em);
        TravelDAO travelDAO = new TravelDAO(em);
        SellerDAO sellerDAO = new SellerDAO(em);

        User user = new User("gianni","cabiddu",1234);
        userDAO.save(user);

        Sellers seller = new Sellers(SellerType.AUTHORIZED);
        sellerDAO.save(seller);

        Subscriptions subscription = new Subscriptions(seller,LocalDate.now(),150.00, SubType.WEEKLY);
        travelDAO.save(subscription);

        Card card = new Card(user, LocalDate.now(),subscription);
        cardDAO.save(card);

    }
}
