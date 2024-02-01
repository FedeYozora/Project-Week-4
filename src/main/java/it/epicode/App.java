package it.epicode;

import com.github.javafaker.Faker;
import it.epicode.DAO.*;
import it.epicode.enums.SellerType;
import it.epicode.enums.SubType;
import it.epicode.enums.VehicleType;

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
        VehicleDAO vehicleDAO = new VehicleDAO(em);
        Scanner scan = new Scanner(System.in);


        System.out.println("Scegli un personaggio: \n1. Gianni \n2. Daniele \n3. Federico \n");
        int scelta = scan.nextInt();
        User gianni = new User("Gianni", "Cabiddu");
        User daniele = new User("Daniele", "Cagnoni");
        User federico = new User("Federico", "Bonfiglio");
        User personaggio;

        Vehicles vehicle1 = new Vehicles(VehicleType.BUS, 50);
        Vehicles vehicles2 = new Vehicles(VehicleType.BUS, 60);
        Vehicles vehicles3 = new Vehicles(VehicleType.BUS, 75);
        Vehicles vehicles4 = new Vehicles(VehicleType.TRAM, 130);
        Vehicles vehicles5 = new Vehicles(VehicleType.TRAM, 130);
        Vehicles vehicles6 = new Vehicles(VehicleType.TRAM, 130);


        Routes routes1 = new Routes("Piramide", "stazione Termini", 2, vehicle1);
        Routes routes2 = new Routes("Aeroporto Ciampino", "stazione Tiburtina", 6, vehicles2);
        Routes routes3 = new Routes("Tivoli", "stazione Termini", 5, vehicles3);
        Routes routes4 = new Routes("Stazione Centrale", "Viale Bligny", 2, vehicles4);
        Routes routes5 = new Routes("Duomo", "San Siro", 2, vehicles5);
        Routes routes6 = new Routes("Piazza Castello", "Ospedale Maggiore", 4, vehicles6);


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
        while (true) {
            if (personaggio != null) {
                System.out.println("Hai scelto " + personaggio.getName() + ".");
                System.out.println(" ");
                System.out.println("Quale bus vuoi prendere? \n1." + vehicle1.getVehicleNumber() + "\n2." + vehicles2.getVehicleNumber() + "\n3." + vehicles3.getVehicleNumber() + "\n");

                int sceltaBus = scan.nextInt();
                switch (sceltaBus) {
                    case 1:
                        System.out.println("Hai scelto il " + vehicle1.getVehicleNumber() + " La tua tratta è:");
                        System.out.println("Piramide - Stazione Termini");
                        System.out.println("          ______________________\n" +
                                "       |,----.,----.,----.,--.\\\n" +
                                "       ||    ||    ||    ||   \\\\\n" +
                                "       |`----'`----'|----||----\\`.\n" +
                                "       [     23     |   -||- __|(|\n" +
                                "       [  ,--.      |____||.--.  |\n" +
                                "       =-(( `))-----------(( `))==\n" +
                                "   javabus`--'     ");
                        break;
                    case 2:
                        System.out.println("Hai scelto il " + vehicles2.getVehicleNumber() + " La tua tratta è:");
                        System.out.println("Aeroporto Ciampino - stazione Tiburtina");
                        System.out.println("        ______________________\n" +
                                "       |,----.,----.,----.,--.\\\n" +
                                "       ||    ||    ||    ||   \\\\\n" +
                                "       |`----'`----'|----||----\\`.\n" +
                                "       [    123     |   -||- __|(|\n" +
                                "       [  ,--.      |____||.--.  |\n" +
                                "       =-(( `))-----------(( `))==\n" +
                                "   javabus`--'     ");

                        break;
                    case 3:
                        System.out.println("Hai scelto il  " + vehicles3.getVehicleNumber() + "  La tua tratta è:");
                        System.out.println("Tivoli - Stazione Termini+");
                        System.out.println("         ______________________\n" +
                                "       |,----.,----.,----.,--.\\\n" +
                                "       ||    ||    ||    ||   \\\\\n" +
                                "       |`----'`----'|----||----\\`.\n" +
                                "       [   289      |   -||- __|(|\n" +
                                "       [  ,--.      |____||.--.  |\n" +
                                "       =-(( `))-----------(( `))==\n" +
                                "   javabus`--'     ");
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                }
                        System.out.println(" ");
                        System.out.println("Quale tram vuoi prendere? \n1." + vehicles4.getVehicleNumber() + "\n2." + vehicles5.getVehicleNumber() + "\n3." + vehicles6.getVehicleNumber() + "\n");
                        int sceltaTram = scan.nextInt();
                        switch (sceltaTram) {
                            case 1:
                                System.out.println("Hai scelto il FakerTaxi La tua tratta è:");
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
                System.out.println(" ");
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
                        System.out.println("  " +
                                "      _.-\"` `'-.\n" +
                                "       '._ __{}_(\n" +
                                "         |'--.__\\\n" +
                                "        (   ^_\\^\n" +
                                "         |   * |\n" +
                                "         )\\___/\n" +
                                "     .--'`:._]\n" +
                                "    /  \\      '-." +
                                "Salve ha il biglietto o l'abbonamento? \n1. Biglietto \n2. Abbonamento \n3. No"
                        );

                        System.out.println();
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
                                        "Il tuo biglietto è valido."
                                );
                                break;
                            case 2:
                                System.out.println("  " +
                                        "      _.-\"` `'-.\n" +
                                        "       '._ __{}_(\n" +
                                        "         |'--.__\\\n" +
                                        "        (   ^_\\^\n" +
                                        "         |   o |\n" +
                                        "         )\\___/\n" +
                                        "     .--'`:._]\n" +
                                        "    /  \\      '-." +
                                        "l'abbonamento è attivo."
                                );
                                System.out.println(" ");
                                break;
                            case 3:
                                System.out.println("  " +
                                        "      _.-\"` `'-.\n" +
                                        "       '._ __{}_(\n" +
                                        "         |'--.__\\\n" +
                                        "        (   ^_\\^\n" +
                                        "         |   0 |\n" +
                                        "         )\\___/\n" +
                                        "     .--'`:._]\n" +
                                        "    /  \\      '-.  "
                                );
                                userDAO.attemptEscape(personaggio);
                                System.out.println("   ");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println(" ");
                        System.out.println("Pagherò prima che salga il controllore.  " +
                                " ");
                        break;
                }
            }
        }
    }
