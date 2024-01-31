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
import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;

/**
 * Hello world!
 */
public class App {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transport Agency");


    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        UserDAO userDAO = new UserDAO(em);
        CardDAO cardDAO = new CardDAO(em);
        TravelDAO travelDAO = new TravelDAO(em);
        SellerDAO sellerDAO = new SellerDAO(em);
        Scanner scan = new Scanner(System.in);


        System.out.println("Scegli un personaggio: \n1. Gianni \n2. Daniele \n3. Federico \n");
        int scelta = scan.nextInt();
        User gianni = new User("Gianni", "Cabiddu", 123);
        User daniele = new User("Daniele", "Cagnoni", 1234);
        User federico = new User("Federico", "Bonfiglio", 12345);
        User personaggio;


            if (scelta == 1) {
                personaggio = gianni;
                userDAO.save(gianni);
            } else if (scelta == 2) {
                personaggio = daniele;
                userDAO.save(daniele);
            } else if (scelta == 3) {
                personaggio = federico;
                userDAO.save(federico);
            } else {
                System.out.println("Scelta non valida");
                personaggio = null;
            }
            if (personaggio != null) {
                System.out.println("Hai scelto " + personaggio + ".");
                while (true) {
                System.out.println(" ");
                System.out.println("Vuoi usare un bus o un tram? \n1. Bus \n2. Tram \n");
                int sceltaTrasporto = scan.nextInt();
                switch (sceltaTrasporto) {
                    case 1:
                        System.out.println("        ______________________\n" +
                                "       |,----.,----.,----.,--.\\\n" +
                                "       ||    ||    ||    ||   \\\\\n" +
                                "       |`----'`----'|----||----\\`.\n" +
                                "       [            |   -||- __|(|\n" +
                                "       [  ,--.      |____||.--.  |\n" +
                                "       =-(( `))-----------(( `))==\n" +
                                "   javabus`--'     ");
                        System.out.println(" ");
                        System.out.println("Quale bus vuoi prendere? \n1. Bus \n2. Bus \n3. Bus \n");

                        int sceltaBus = scan.nextInt();
                        switch (sceltaBus) {
                            case 1:
                                System.out.println("Hai scelto il bus 1. La tua tratta è:");
                                System.out.println("Piramide - Stazione Termini");
                                System.out.println("          ______________________\n" +
                                        "       |,----.,----.,----.,--.\\\n" +
                                        "       ||    ||    ||    ||   \\\\\n" +
                                        "       |`----'`----'|----||----\\`.\n" +
                                        "       [            |   -||- __|(|\n" +
                                        "       [  ,--.      |____||.--.  |\n" +
                                        "       =-(( `))-----------(( `))==\n" +
                                        "   javabus`--'     ");
                                break;
                            case 2:
                                System.out.println("Hai scelto il bus 2. La tua tratta è:");
                                System.out.println("Aeroporto Ciampino - stazione Tiburtina");
                                System.out.println("        ______________________\n" +
                                        "       |,----.,----.,----.,--.\\\n" +
                                        "       ||    ||    ||    ||   \\\\\n" +
                                        "       |`----'`----'|----||----\\`.\n" +
                                        "       [            |   -||- __|(|\n" +
                                        "       [  ,--.      |____||.--.  |\n" +
                                        "       =-(( `))-----------(( `))==\n" +
                                        "   javabus`--'     ");

                                break;
                            case 3:
                                System.out.println("Hai scelto il bus 3. La tua tratta è:");
                                System.out.println("Tivoli - Stazione Termini+");
                                System.out.println("         ______________________\n" +
                                        "       |,----.,----.,----.,--.\\\n" +
                                        "       ||    ||    ||    ||   \\\\\n" +
                                        "       |`----'`----'|----||----\\`.\n" +
                                        "       [            |   -||- __|(|\n" +
                                        "       [  ,--.      |____||.--.  |\n" +
                                        "       =-(( `))-----------(( `))==\n" +
                                        "   javabus`--'     ");
                                break;
                            default:
                                System.out.println("Scelta non valida.");
                        }
                        break;
                    case 2:
                        System.out.println("   ,',                                   ,',\n" +
                                "     ', ,'                                 ', ,'\n" +
                                "  ,----'--------------------------.     ,----'--------------------------.\n" +
                                "  /''|```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                " |---'---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                " ,_    ______           ______     |=-=,_    ______           ______  jg |\n" +
                                "  '---'(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'");
                        System.out.println(" ");
                        System.out.println("Quale tram vuoi prendere? \n1. Tram \n2. Tram \n3. Tram \n");

                        int sceltaTram = scan.nextInt();
                        switch (sceltaTram) {
                            case 1:
                                System.out.println("Hai scelto il FakerTaxy La tua tratta è:");
                                System.out.println("Duomo - Stazione Centrale");
                                System.out.println("   ,',                                   ,',\n" +
                                        "     ', ,'                                 ', ,'\n" +
                                        "  ,----'--------------------------.     ,----'--------------------------.\n" +
                                        "  /''|```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                        " |---'---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                        " ,_    ______ FakerTaxi ______     |=-=,_    ______           ______  jg |\n" +
                                        "  '---'(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'");
                                break;
                            case 2:
                                System.out.println("Hai scelto il Tram.Random La tua tratta è:");
                                System.out.println("Viale Bligny - San Siro");
                                System.out.println("   ,',                                   ,',\n" +
                                        "     ', ,'                                 ', ,'\n" +
                                        "  ,----'--------------------------.     ,----'--------------------------.\n" +
                                        "  /''|```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                        " |---'---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                        " ,_    ______Tram.Random______     |=-=,_    ______           ______  jg |\n" +
                                        "  '---'(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'");

                                break;
                            case 3:
                                System.out.println("Hai scelto il SwitchTram La tua tratta è:");
                                System.out.println("Piazza Castello - Ospedale maggiore");
                                System.out.println("   ,',                                   ,',\n" +
                                        "     ', ,'                                 ', ,'\n" +
                                        "  ,----'--------------------------.     ,----'--------------------------.\n" +
                                        "  /''|```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                        " |---'---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                        " ,_    ______SwitchTram ______     |=-=,_    ______           ______  jg |\n" +
                                        "  '---'(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'");

                                break;
                            default:
                                System.out.println("Scelta non valida.");
                        }
                }
                System.out.println("C'è il controllore a bordo? \n1. Sì \n2. No \n");
                    System.out.println("  " +
                            "      _.-\"` `'-.\n" +
                            "       '._ __{}_(\n" +
                            "         |'--.__\\\n" +
                            "        (   ^_\\^\n" +
                            "         |   _ |\n" +
                            "         )\\___/\n" +
                            "     .--'`:._]\n" +
                            "    /  \\      '-.");
                int presenzaControllore = scan.nextInt();
                switch (presenzaControllore) {
                    case 1:
                        System.out.println("Hai il biglietto o l'abbonamento? \n1. Sì \n2. No \n");
                        int presenzaBiglietto = scan.nextInt();
                        switch (presenzaBiglietto) {
                            case 1:
                                System.out.println("  " +
                                        "      _.-\"` `'-.\n" +
                                        "       '._ __{}_(\n" +
                                        "         |'--.__\\\n" +
                                        "        (   ^_\\^\n" +
                                        "         |   o |\n" +
                                        "         )\\___/\n" +
                                        "     .--'`:._]\n" +
                                        "    /  \\      '-." +
                                        "La tua corsa è valida."
                                );
                                System.out.println(" ");
                                break;
                            case 2:
                                System.out.println("  " +
                                        "      _.-\"` `'-.\n" +
                                        "       '._ __{}_(\n" +
                                        "         |'--.__\\\n" +
                                        "        (   ^_\\^\n" +
                                        "         |   0 |\n" +
                                        "         )\\___/\n" +
                                        "     .--'`:._]\n" +
                                        "    /  \\      '-.  " +

                                        "Hai ricevuto una multa di 60 euro."
                                );

                                System.out.println("");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println(" ");
                        System.out.println("Pagherò prima che salga il controllore.");
                        break;
                }
            }
        }
    }
}