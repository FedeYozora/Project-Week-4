package it.epicode;

import it.epicode.DAO.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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


//        User user = new User("gianni","cabiddu",1234);
//        userDAO.save(user);


    }
}
