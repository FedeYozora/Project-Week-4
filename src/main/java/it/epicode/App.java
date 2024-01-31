package it.epicode;

import it.epicode.DAO.*;
import it.epicode.enums.SellerType;
import it.epicode.enums.SubType;
import it.epicode.enums.VehicleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.UUID;

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

        User user = new User("gianni", "cabiddu", 1234);
        userDAO.save(user);

        Sellers seller = new Sellers(SellerType.AUTOMATIC);
        seller.setInService(true);
        sellerDAO.save(seller);

        Sellers seller2 = new Sellers(SellerType.AUTHORIZED);
        seller2.setInService(true);
        sellerDAO.save(seller2);

        Subscriptions subscription = new Subscriptions(seller, LocalDate.now(), 150.00, SubType.WEEKLY);
        travelDAO.save(subscription);

        Subscriptions subscription2 = new Subscriptions(seller, LocalDate.now(), 150.00, SubType.MONTHLY);
        travelDAO.save(subscription2);

        Tickets tickets = new Tickets(seller, LocalDate.now(), 2.00);
        travelDAO.save(tickets);

        Card card = new Card(user, LocalDate.now(), subscription);
        cardDAO.save(card);

        Vehicles vehicles = new Vehicles(VehicleType.BUS, 30, false);
        vehicles.setTickets(tickets);
        vehicleDAO.save(vehicles);

        sellerDAO.filterByService(SellerType.AUTOMATIC);
//        cardDAO.delete(card);
//        travelDAO.checkValidityByCardId(UUID.fromString("220a7147-2b2d-44da-8a93-60307b1a9d2a"));
//        System.out.println();
//        travelDAO.findSubByUserId(UUID.fromString("e523079c-7656-434f-a8ba-9de5ff74af05"));
//        vehicleDAO.findByVehicleType(VehicleType.BUS);
//        vehicleDAO.findByVehicleType(VehicleType.TRAM);

        System.out.println("Dove vuoi andare?");
        System.out.println("1. Rivenditore autorizzato");
        System.out.println("2. Distributore automatico");

        int scanSelection = scan.nextInt();
        switch (scanSelection) {
            case 1:
                System.out.println("\n" +
                        "                    ------------- \n" +
                        "      ////\\\\\\\\     /              \\\n" +
                        "      |      |    <  Buongiorno!   |\n" +
                        "     @  O  O  @    \\              /\n" +
                        "      |  ~   |      -------------    \n" +
                        "       \\ -- /          | p |\n" +
                        "     ___|  |___        | o |\n" +
                        "    /          \\      /|_s_|\n" +
                        "   /            \\    / /\\ /\n" +
                        "  /  /|      |\\  \\  / /  \n" +
                        " /  / |      | \\  \\/ /\n" +
                        "-------------------------------\n" +
                        "\n" +
                        "1.Vorrei acquistare un biglietto!\n" +
                        "\n" +
                        "2.Vorrei acquistare un abbonamento!\n" +
                        "\n" +
                        "3.Mi è scaduto l'abbonamento, \n" +
                        "vorrei caricarne un altro sulla mia card!");


                int scanSelection2 = scan.nextInt();
                switch (scanSelection2) {
                    case 1:
                        System.out.println("                    ------------- \n" +
                                "      ////\\\\\\\\     /             \n" +
                                "      |      |    <   Certo! Ecco a te il biglietto \n" +
                                "     @  ^  ^  @    \\              \n" +
                                "      |  ~   |      -------------\n" +
                                "       \\ -- /          | p |\n" +
                                "     ___|  |___        | o |\n" +
                                "    /          \\      /|_s_|\n" +
                                "   /            \\    / /\\ /\n" +
                                "  /  /|      |\\  \\  / /  \n" +
                                " /  / |      | \\  \\/ /\n" +
                                "-------------------------------\n" +
                                "\n" +
                                "\n" +
                                " _______________________________________               \n" +
                                "(                                       )\n" +
                                "(  JAVAUTOBUS                           )\n" +
                                "(                                       ) \n" +
                                "(                                       ) \n" +
                                "(          " + tickets.getDateOfEmission() + "                   )\n" +
                                "(                                       )\n" +
                                "(   ID Venditore:                       )\n" +
                                "(  " + seller2.getSellerId() + " )\n" +
                                "(_______________________________________)");
                        // FINE TICKET ONE USE
                        break;

                    case 2:
                        System.out.println("                    -------------\n" +
                                "      ////\\\\\\\\     /             \n" +
                                "      |      |    <   Non potevi andare al distributore automatico..?\n" +
                                "     @  -  -  @    \\              \n" +
                                "      |  ~   |      -------------\n" +
                                "       \\ -- /          | p |\n" +
                                "     ___|  |___        | o |\n" +
                                "    /          \\      /|_s_|\n" +
                                "   /            \\    / /\\ /\n" +
                                "  /  /|      |\\  \\  / /  \n" +
                                " /  / |      | \\  \\/ /\n" +
                                "-------------------------------\n" +
                                "\n" +
                                "\n" +
                                "1. No..\n" +
                                "\n" +
                                "2. C'era troppa fila e non sono bravo con i computer\n" +
                                "\n" +
                                "3. Zitto e fai il tuo lavoro");
                        int scanSelection3 = scan.nextInt();
                        switch (scanSelection3) {
                            case 1:
                            case 2:
                            case 3:
                                System.out.println("\n" +
                                        "                    -------------\n" +
                                        "      ////\\\\\\\\     /             \n" +
                                        "      |      |    <   Va beh.. Hai gia una card? \n" +
                                        "     @  o  o  @    \\              \n" +
                                        "      |  ~   |      -------------\n" +
                                        "       \\ -- /          | p |\n" +
                                        "     ___|  |___        | o |\n" +
                                        "    /          \\      /|_s_|\n" +
                                        "   /            \\    / /\\ /\n" +
                                        "  /  /|      |\\  \\  / /  \n" +
                                        " /  / |      | \\  \\/ /\n" +
                                        "-------------------------------\n" +
                                        "\n" +
                                        "1.Si!\n" +
                                        "\n" +
                                        "2.No..");
                                int scanSelection4 = scan.nextInt();
                                switch (scanSelection4) {
                                    case 1:
                                        System.out.println("                    -------------\n" +
                                                "      ////\\\\\\\\     /             \n" +
                                                "      |      |    <   Ok, dammi il numero della card\n" +
                                                "     @  o  o  @    \\              \n" +
                                                "      |  ~   |      -------------\n" +
                                                "       \\ -- /          | p |\n" +
                                                "     ___|  |___        | o |\n" +
                                                "    /          \\      /|_s_|\n" +
                                                "   /            \\    / /\\ /\n" +
                                                "  /  /|      |\\  \\  / /  \n" +
                                                " /  / |      | \\  \\/ /\n" +
                                                "-------------------------------");
                                        String scanSelection5 = scan.nextLine();
                                        // salvare il valore di questo scan
                                        System.out.println("                   -------------\n" +
                                                "      ////\\\\\\\\     /             \n" +
                                                "      |      |    <   Ok, quale abbonamento vuoi caricare?\n" +
                                                "     @  ^  ^  @    \\              \n" +
                                                "      |  ~   |      -------------\n" +
                                                "       \\ -- /          | p |\n" +
                                                "     ___|  |___        | o |\n" +
                                                "    /          \\      /|_s_|\n" +
                                                "   /            \\    / /\\ /\n" +
                                                "  /  /|      |\\  \\  / /  \n" +
                                                " /  / |      | \\  \\/ /\n" +
                                                "-------------------------------\n" +
                                                "\n" +
                                                "1. Settimanale\n" +
                                                "\n" +
                                                "2. Mensile\n");
                                        int scanSelection6 = scan.nextInt();
                                        switch (scanSelection6) {
                                            case 1:
                                                System.out.println("                    -------------\n" +
                                                        "      ////\\\\\\\\     /             \n" +
                                                        "      |      |    <  Perfetto, ecco a te la card aggiornata\n" +
                                                        "     @  ^  ^  @    \\              \n" +
                                                        "      |  ~   |      -------------\n" +
                                                        "       \\ -- /          | p |\n" +
                                                        "     ___|  |___        | o |\n" +
                                                        "    /          \\      /|_s_|\n" +
                                                        "   /            \\    / /\\ /\n" +
                                                        "  /  /|      |\\  \\  / /  \n" +
                                                        " /  / |      | \\  \\/ /\n" +
                                                        "-------------------------------\n" +
                                                        "\n" +
                                                        " _______________________________________\n" +
                                                        "|                                       |\n" +
                                                        "|   || NOMEMAIUSC      ||COGNOMEMAIUSC  |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "|       || ABBONAMENTO SETTIMANALE      |\n" +
                                                        "|                                       |\n" +
                                                        "|      .DATAEMISSIONE / .DATASCADENZA   |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "(  " + seller2.getSellerId() + " )\n" +
                                                        "|_______________________________________|");
                                                // FINE ABBONAMENTO SETTIMANALE CARD AGGIORNATA
                                                break;


                                            case 2:
                                                System.out.println("                    -------------\n" +
                                                        "      ////\\\\\\\\     /             \n" +
                                                        "      |      |    <  Perfetto, ecco a te la card aggiornata\n" +
                                                        "     @  ^  ^  @    \\              \n" +
                                                        "      |  ~   |      -------------\n" +
                                                        "       \\ -- /          | p |\n" +
                                                        "     ___|  |___        | o |\n" +
                                                        "    /          \\      /|_s_|\n" +
                                                        "   /            \\    / /\\ /\n" +
                                                        "  /  /|      |\\  \\  / /  \n" +
                                                        " /  / |      | \\  \\/ /\n" +
                                                        "-------------------------------\n" +
                                                        "\n" +
                                                        " _______________________________________\n" +
                                                        "|                                       |\n" +
                                                        "|   || NOMEMAIUSC      ||COGNOMEMAIUSC  |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "|          || ABBONAMENTO MENSILE       |\n" +
                                                        "|                                       |\n" +
                                                        "|      .DATAEMISSIONE / .DATASCADENZA   |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "(  " + seller2.getSellerId() + " )\n" +
                                                        "|_______________________________________|");
                                                // FINE ABBONAMENTO MENSILE CARD AGGIORNATA
                                                break;
                                        }

                                    case 2:
                                        System.out.println("                    -------------\n" +
                                                "      ////\\\\\\\\     /             \n" +
                                                "      |      |    <   Okay, dimmi nome e cognome e te la creo io..\n" +
                                                "     @  T  T  @    \\              \n" +
                                                "      |  ~   |      -------------\n" +
                                                "       \\ O  /          | p |\n" +
                                                "     ___|  |___        | o |\n" +
                                                "    /          \\      /|_s_|\n" +
                                                "   /            \\    / /\\ /\n" +
                                                "  /  /|      |\\  \\  / /  \n" +
                                                " /  / |      | \\  \\/ /\n" +
                                                "-------------------------------");
                                        scan.nextLine();
                                        System.out.println("Inserisci il tuo nome");
                                        String scanSelection7 = scan.nextLine();
                                        System.out.println("Inserisci il tuo cognome");
                                        String scanSelection8 = scan.nextLine();
                                        System.out.println("                    -------------\n" +
                                                "      ////\\\\\\\\     /             \n" +
                                                "      |      |    <   Ok, quale abbonamento vuoi caricare?\n" +
                                                "     @  -  -  @    \\              \n" +
                                                "      |  ~   |      -------------\n" +
                                                "       \\ -- /          | p |\n" +
                                                "     ___|  |___        | o |\n" +
                                                "    /          \\      /|_s_|\n" +
                                                "   /            \\    / /\\ /\n" +
                                                "  /  /|      |\\  \\  / /  \n" +
                                                " /  / |      | \\  \\/ /\n" +
                                                "-------------------------------\n" +
                                                "\n" +
                                                "1. Settimanale\n" +
                                                "\n" +
                                                "2. Mensile");
                                        int scanSelection9 = scan.nextInt();
                                        switch (scanSelection9) {
                                            case 1:
                                                System.out.println("                     -------------\n" +
                                                        "      ////\\\\\\\\     /             \n" +
                                                        "      |      |    <  Perfetto, ecco la tua nuova card\n" +
                                                        "     @  ^  ^  @    \\              \n" +
                                                        "      |  ~   |      -------------\n" +
                                                        "       \\ -- /          | p |\n" +
                                                        "     ___|  |___        | o |\n" +
                                                        "    /          \\      /|_s_|\n" +
                                                        "   /            \\    / /\\ /\n" +
                                                        "  /  /|      |\\  \\  / /  \n" +
                                                        " /  / |      | \\  \\/ /\n" +
                                                        "-------------------------------\n" +
                                                        "\n" +
                                                        " _______________________________________\n" +
                                                        "|                                       |\n" +
                                                        "|   ||" + scanSelection7 + "  ||" + scanSelection8 + "  |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "|        ||ABBONAMENTO SETTIMANALE      |\n" +
                                                        "|                                       |\n" +
                                                        "|      .DATAEMISSIONE / .DATASCADENZA   |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "(  " + seller2.getSellerId() + " )\n" +
                                                        "|_______________________________________|");
                                                break;
                                            // FINE ABBONAMENTO SETTIMANALE CARD CREATA
                                            case 2:
                                                System.out.println("                     -------------\n" +
                                                        "      ////\\\\\\\\     /             \n" +
                                                        "      |      |    <  Perfetto, ecco la tua nuova card\n" +
                                                        "     @  ^  ^  @    \\              \n" +
                                                        "      |  ~   |      -------------\n" +
                                                        "       \\ -- /          | p |\n" +
                                                        "     ___|  |___        | o |\n" +
                                                        "    /          \\      /|_s_|\n" +
                                                        "   /            \\    / /\\ /\n" +
                                                        "  /  /|      |\\  \\  / /  \n" +
                                                        " /  / |      | \\  \\/ /\n" +
                                                        "-------------------------------\n" +
                                                        "\n" +
                                                        " _______________________________________\n" +
                                                        "|                                       |\n" +
                                                        "|   ||" + scanSelection7 + "  ||" + scanSelection8 + "  |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "|          ||ABBONAMENTO MENSILE        |\n" +
                                                        "|                                       |\n" +
                                                        "|      .DATAEMISSIONE / .DATASCADENZA   |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "(  " + seller2.getSellerId() + " )\n" +
                                                        "|_______________________________________|");
                                                break;
                                            // FINE ABBONAMENTO MENSILE CARD CREATA
                                        }
                                        break;
                                    default:
                                        System.out.println("Hai selezionato un carattere sbagliato...");
                                        break;


                                }
                                break;
                            default:
                                System.out.println("Hai selezionato un carattere sbagliato...");
                                break;

                        }
                        break;
                    case 3:
                    default:
                        System.out.println("Hai selezionato un carattere sbagliato...");
                        break;
                }

                break;


            case 2:
                System.out.println(" ________________________________________\n" +
                        "|                                       |\n" +
                        "|          Benvenuto! Automat n#        |\n" +
                        "|              @sellerid                |\n" +
                        "|                                       |\n" +
                        "|                                       |\n" +
                        "|            +----------------+         |\n" +
                        "|            |   1. Acquista  |         |\n" +
                        "|            |   Abbonamento  |         |\n" +
                        "|            +----------------+         |\n" +
                        "|                                       |\n" +
                        "|                                       |\n" +
                        "|                                       |\n" +
                        "|            +----------------+         |\n" +
                        "|            |   2.Rinnova    |         |\n" +
                        "|            |   Abbonamento  |         |\n" +
                        "|            +----------------+         |\n" +
                        "|                                       |\n" +
                        "|                                       |\n" +
                        "|                                       |\n" +
                        "|            +----------------+         |\n" +
                        "|            |   3. Acquista  |         |\n" +
                        "|            |   Biglietto    |         |\n" +
                        "|            +----------------+         |\n" +
                        "|                                       |\n" +
                        "|                                       |\n" +
                        "|            +----------------+         |\n" +
                        "|            |    0.Indietro  |         |\n" +
                        "|            +----------------+         |\n" +
                        "|                                       |\n" +
                        "|_______________________________________|");
                int scanSelection10 = scan.nextInt();
                switch (scanSelection10) {
                    case 1:
                        System.out.println(" ________________________________________\n" +
                                "|                                       |\n" +
                                "|                                       |\n" +
                                "|        Quale abbonamento vuoi         |\n" +
                                "|               acquistare?             |\n" +
                                "|                                       |\n" +
                                "|            +----------------+         |\n" +
                                "|            |   1. Acquista  |         |\n" +
                                "|            |   Settimanale  |         |\n" +
                                "|            +----------------+         |\n" +
                                "|                                       |\n" +
                                "|                                       |\n" +
                                "|            +----------------+         |\n" +
                                "|            |   2. Acquista  |         |\n" +
                                "|            |      Mensile   |         |\n" +
                                "|            +----------------+         |\n" +
                                "|                                       |\n" +
                                "|                                       |\n" +
                                "|            +----------------+         |\n" +
                                "|            |    0.Annulla   |         |\n" +
                                "|            +----------------+         |\n" +
                                "|                                       |\n" +
                                "|_______________________________________|");
                        int scanSelection11 = scan.nextInt();
                        switch (scanSelection11) {
                            case 1:
                            case 2:
                                System.out.println(" _______________________________________\n" +
                                        "|                                       |\n" +
                                        "|            Crea la tua card           |\n" +
                                        "|                personale              |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|            +----------------+         |\n" +
                                        "|            |      Nome      |         |\n" +
                                        "|            +----------------+         |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|            +----------------+         |\n" +
                                        "|            |     Cognome    |         |\n" +
                                        "|            +----------------+         |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|            +----------------+         |\n" +
                                        "|            |    0.Annulla   |         |\n" +
                                        "|            +----------------+         |\n" +
                                        "|                                       |\n" +
                                        "|_______________________________________|\n" +
                                        "\n");
                                scan.nextLine();
                                System.out.println("Inserisci il tuo nome");
                                String scanSelection12 = scan.nextLine();
                                System.out.println("Inserisci il tuo cognome");
                                String scanSelection13 = scan.nextLine();
                                System.out.println("          ||ECCO LA TUA CARD||\n" +
                                        "\n" +
                                        " _______________________________________\n" +
                                        "|                                       |\n" +
                                        "|  || " + scanSelection12 + "  ||" + scanSelection13 + "  |\n" +
                                        "|                                       |\n" +
                                        "|          || ABBONAMENTO               |\n" +
                                        "|          || " + subscription2.getSubType() + "          |\n" +
                                        "|                                       |\n" +
                                        "| " + subscription2.getDateOfEmission() + " / " + subscription2.getDateOfExpiration() + "   |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "(  " + seller.getSellerId() + " )\n" +
                                        "|_______________________________________|");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Hai selezionato un carattere sbagliato.. ");
                        }
                        break;

                    case 2:
                        System.out.println(" ________________________________________\n" +
                                "|                                       |\n" +
                                "|                                       |\n" +
                                "|          Quale abbonamento vuoi       |\n" +
                                "|                rinnovare?             |\n" +
                                "|                                       |\n" +
                                "|            +----------------+         |\n" +
                                "|            |   1. Rinnova   |         |\n" +
                                "|            |   Settimanale  |         |\n" +
                                "|            +----------------+         |\n" +
                                "|                                       |\n" +
                                "|                                       |\n" +
                                "|            +----------------+         |\n" +
                                "|            |   2. Rinnova   |         |\n" +
                                "|            |      Mensile   |         |\n" +
                                "|            +----------------+         |\n" +
                                "|                                       |\n" +
                                "|                                       |\n" +
                                "|            +----------------+         |\n" +
                                "|            |    0.Annulla   |         |\n" +
                                "|            +----------------+         |\n" +
                                "|                                       |\n" +
                                "|_______________________________________|\n");
                        int scanSelection14 = scan.nextInt();
                        switch (scanSelection14) {
                            case 1:
                            case 2:
                                System.out.println("________________________________________\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|           Inserisci il codice         |\n" +
                                        "|              della tua card           |\n" +
                                        "|                                       |\n" +
                                        "|            +----------------+         |\n" +
                                        "|                  . . . .              |\n" +
                                        "|            +----------------+         |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|            +----------------+         |\n" +
                                        "|            |    0.Annulla   |         |\n" +
                                        "|            +----------------+         |\n" +
                                        "|                                       |\n" +
                                        "|_______________________________________|");
                                scan.nextLine();
                                String scanSelection15 = scan.nextLine();
                                System.out.println("     ||CARD AGGIORNATA CON SUCCESSO||\n" +
                                        "\n" +
                                        " _______________________________________\n" +
                                        "|                                       |\n" +
                                        "|   || NOMEMAIUSC      ||COGNOMEMAIUSC  |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|          || TIPOABBONAMENTO           |\n" +
                                        "|                                       |\n" +
                                        "|      .DATAEMISSIONE / .DATASCADENZA   |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "(  " + seller.getSellerId() + " )\n" +
                                        "|_______________________________________|\n");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Hai selezionato un carattere sbagliato..");
                        }
                        break;
                    case 3:
                        System.out.println(" _______________________________________\n" +
                                "(                                       )\n" +
                                "(  JAVAUTOBUS                           )\n" +
                                "(                                       )\n" +
                                "(                                       )\n" +
                                "(          " + tickets.getDateOfEmission() + "                   )\n" +
                                "(                                       )\n" +
                                "(                                       )\n" +
                                "(  " + seller.getSellerId() + " )\n" +
                                "(_______________________________________)");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Hai selezionato un carattere sbagliato.. ");
                }


                break;
            default:
                System.out.println("Hai selezionato un carattere sbagliato.. ");
                break;
        }


    }
}
