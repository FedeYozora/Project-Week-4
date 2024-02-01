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

public class App {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transport Agency");


    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        UserDAO userDAO = new UserDAO(em);
        CardDAO cardDAO = new CardDAO(em);
        TravelDAO travelDAO = new TravelDAO(em);
        SellerDAO sellerDAO = new SellerDAO(em);
        VehicleDAO vehicleDAO = new VehicleDAO(em);
        RoutesDAO routesDAO = new RoutesDAO(em);
        Scanner scan = new Scanner(System.in);

        User user = new User("gianni", "cabiddu");
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

        Tickets ticket = new Tickets(seller, LocalDate.now(), 2.00);
        travelDAO.save(ticket);

        Card card = new Card(user, LocalDate.now(), subscription);
        cardDAO.save(card);
        user.setCard(card);


        Vehicles vehicle = new Vehicles(VehicleType.BUS, 30);
        vehicle.setTickets(ticket);
        vehicleDAO.save(vehicle);


        Routes route = new Routes("Roma", "Milano", 30, vehicle);
        Routes route2 = new Routes("Roma", "Napoli", 20, vehicle);
        routesDAO.save(route);
        routesDAO.save(route2);
//        sellerDAO.filterByService(SellerType.AUTOMATIC);
//        cardDAO.delete(card);
//        travelDAO.checkValidityByCardId(UUID.fromString("220a7147-2b2d-44da-8a93-60307b1a9d2a"));
//        System.out.println();
//        travelDAO.findSubByUserId(UUID.fromString("e523079c-7656-434f-a8ba-9de5ff74af05"));
//        vehicleDAO.findByVehicleType(VehicleType.BUS);
//        vehicleDAO.findByVehicleType(VehicleType.TRAM);

        //  vehicleDAO.sendVehicleToMaintenance(1L);
        // vehicleDAO.returnVehicleFromMaintenance(1L, 7);

        vehicleDAO.doRoute(route, 1L);


        travelDAO.findUserByCardId(UUID.fromString("2fc9fe08-9a02-45fb-bf1f-7b22c3b5649e"));
        System.out.println("Dove vuoi andare?");
        System.out.println("1. Rivenditore autorizzato");
        System.out.println("2. Distributore automatico");
        System.out.println("3. MiniGame");

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
                                "(          " + ticket.getDateOfEmission() + "                   )\n" +
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
                                        scan.nextLine();
                                        String scanSelection5 = scan.nextLine();
                                        if (!travelDAO.checkUserByCardId(UUID.fromString(scanSelection5))) {
                                            System.out.println("Hai inserito un numero di carta invalido o inesistente," +
                                                    "devi ricominciare d'accapo x.x");
                                            System.exit(0);
                                        }
                                        User fu1 = travelDAO.findUserByCardId(UUID.fromString(scanSelection5));
                                        Subscriptions fs1 = travelDAO.findSubByUserId(fu1.getId());


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
                                                        "|   ||" + fu1.getName() + "      ||" + fu1.getSurname() + "  |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "|       || ABBONAMENTO SETTIMANALE      |\n" +
                                                        "|                                       |\n" +
                                                        "|      ." + fs1.getDateOfEmission() + " / ." + fs1.getDateOfExpiration() + "   |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "(  " + seller2.getSellerId() + " )\n" +
                                                        "|_______________________________________|");


                                                Subscriptions subscriptionUser = new Subscriptions(seller2, LocalDate.now(),
                                                        24.99, SubType.WEEKLY);
                                                cardDAO.updateCardSub(UUID.fromString(scanSelection5), subscriptionUser);


                                                // FINE ABBONAMENTO SETTIMANALE CARD AGGIORNATA
                                                break;


                                            case 2:

                                                Subscriptions subscriptionUser2 = new Subscriptions(seller2, LocalDate.now(),
                                                        49.99, SubType.MONTHLY);
                                                cardDAO.updateCardSub(UUID.fromString(scanSelection5), subscriptionUser2);
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
                                                        "|   || " + fu1.getName() + "      ||" + fu1.getSurname() + "  |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "|          || ABBONAMENTO MENSILE       |\n" +
                                                        "|                                       |\n" +
                                                        "|      ." + subscriptionUser2.getDateOfEmission() + " / ." + subscriptionUser2.getDateOfExpiration() + "   |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "(  " + seller2.getSellerId() + " )\n" +
                                                        "|_______________________________________|");


                                                // FINE ABBONAMENTO MENSILE CARD AGGIORNATA
                                                break;
                                        }
                                        break;
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
                                "(          " + ticket.getDateOfEmission() + "                   )\n" +
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
            case 3:
                System.out.println("Scegli un personaggio: \n1. Gianni \n2. Daniele \n3. Federico \n");
                int scelta = scan.nextInt();
                User gianni = new User("Gianni", "Cabiddu");
                User daniele = new User("Daniele", "Cagnoni");
                User federico = new User("Federico", "Bonfiglio");
                User personaggio;

                Vehicles bus = new Vehicles(VehicleType.BUS, 30);
                Vehicles bus2 = new Vehicles(VehicleType.BUS, 80);
                Vehicles bus3 = new Vehicles(VehicleType.BUS, 70);
                Vehicles tram = new Vehicles(VehicleType.TRAM, 120);
                Vehicles tram2 = new Vehicles(VehicleType.TRAM, 120);
                Vehicles tram3 = new Vehicles(VehicleType.TRAM, 120);


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
                        System.out.println(personaggio.getName() + " Vuoi usare un bus o un tram? \n1. Bus \n2. Tram \n");
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
                                        "          `--'     ");
                                System.out.println(" ");
                                System.out.println("Quale bus vuoi prendere? \n1." + "Bus 1" + "\n2." + "Bus 2" + "\n3." + "Bus 3" + "\n");

                                int sceltaBus = scan.nextInt();
                                switch (sceltaBus) {
                                    case 1:
                                        System.out.println("Hai scelto il " + "bus 1" + " La tua tratta è:");
                                        System.out.println("Piramide - Stazione Termini");
                                        System.out.println("          ______________________\n" +
                                                "       |,----.,----.,----.,--.\\\n" +
                                                "       ||    ||    ||    ||   \\\\\n" +
                                                "       |`----'`----'|----||----\\`.\n" +
                                                "       [     23     |   -||- __|(|\n" +
                                                "       [  ,--.      |____||.--.  |\n" +
                                                "       =-(( `))-----------(( `))==\n" +
                                                "          `--'     ");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                    ______________________\n" +
                                                "                 |,----.,----.,----.,--.\\\n" +
                                                "                 ||    ||    ||    ||   \\\\\n" +
                                                "                 |`----'`----'|----||----\\`.\n" +
                                                "                 [     23     |   -||- __|(|\n" +
                                                "                 [  ,--.      |____||.--.  |\n" +
                                                "                 =-(( `))-----------(( `))==\n" +
                                                "                    `--'     ");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                              ______________________\n" +
                                                "                           |,----.,----.,----.,--.\\\n" +
                                                "                           ||    ||    ||    ||   \\\\\n" +
                                                "                           |`----'`----'|----||----\\`.\n" +
                                                "                           [     23     |   -||- __|(|\n" +
                                                "                           [  ,--.      |____||.--.  |\n" +
                                                "                           =-(( `))-----------(( `))==\n" +
                                                "                              `--'     ");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                                        ______________|\n" +
                                                "                                     |,----.,----.,--- |\n" +
                                                "                                     ||    ||    ||     ||\n" +
                                                "                     ----            |`----'`----'|----|||\n" +
                                                "                            -----    [     23     |   -||\n" +
                                                "                ----                 [  ,--.      |____||\n" +
                                                "                          ---       =-(( `))-----------|\n" +
                                                "                                        `--'     ");
                                        break;
                                    case 2:
                                        System.out.println("Hai scelto il " + "bus 2" + " La tua tratta è:");
                                        System.out.println("Aeroporto Ciampino - stazione Tiburtina");
                                        System.out.println("        ______________________\n" +
                                                "       |,----.,----.,----.,--.\\\n" +
                                                "       ||    ||    ||    ||   \\\\\n" +
                                                "       |`----'`----'|----||----\\`.\n" +
                                                "       [    123     |   -||- __|(|\n" +
                                                "       [  ,--.      |____||.--.  |\n" +
                                                "       =-(( `))-----------(( `))==\n" +
                                                "          `--'     ");

                                        break;
                                    case 3:
                                        System.out.println("Hai scelto il  " + bus3.getVehicleNumber() + "  La tua tratta è:");
                                        System.out.println("Tivoli - Stazione Termini+");
                                        System.out.println("         ______________________\n" +
                                                "       |,----.,----.,----.,--.\\\n" +
                                                "       ||    ||    ||    ||   \\\\\n" +
                                                "       |`----'`----'|----||----\\`.\n" +
                                                "       [   289      |   -||- __|(|\n" +
                                                "       [  ,--.      |____||.--.  |\n" +
                                                "       =-(( `))-----------(( `))==\n" +
                                                "          `--'     ");
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
                                System.out.println("Quale tram vuoi prendere? \n1." + "Tram 1" + "\n2." + "Tram 2" + "\n3." + "Tram 3" + "\n");
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
                                                " ,_    ______TramDom______         |=-=,_    ______           ______  jg |\n" +
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
                                        "\nSalve ha il biglietto o l'abbonamento? \n1. Mostra biglietto \n2. Mostra abbonamento \n3. *Prova a scappare*"
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
                                                "\nIl tuo biglietto è valido."
                                        );
                                        System.out.println(" ");
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
                                                "\nL'abbonamento risulta attivo."
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
                                                "    /  \\      '-.  " +

                                                "\n*provi a scappare ma il controllore ti acciuffa con il lungo braccio della legge*.\n Dove credi di andare giovanotto?\n*Sei stato multato per 60$*"
                                        );
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
            default:
                System.out.println("Hai selezionato un carattere sbagliato.. ");
                break;
        }


    }
}
