package it.epicode;

import it.epicode.DAO.*;
import it.epicode.enums.SellerType;
import it.epicode.enums.SubType;
import it.epicode.enums.VehicleType;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class App {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transport Agency");


    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        UserDAO userDAO = new UserDAO(em);
        CardDAO cardDAO = new CardDAO(em);
        RoutesDAO routesDAO = new RoutesDAO(em);
        TravelDAO travelDAO = new TravelDAO(em);
        SellerDAO sellerDAO = new SellerDAO(em);
        VehicleDAO vehicleDAO = new VehicleDAO(em);
        Scanner scan = new Scanner(System.in);


        User user = new User("Pippo", "Paperino");
        userDAO.save(user);

        User gianni = new User("Gianni", "Cabiddu");
        User daniele = new User("Daniele", "Cagnoni");
        User federico = new User("Federico", "Bonfiglio");
        userDAO.save(gianni);
        userDAO.save(daniele);
        userDAO.save(federico);
        User personaggio;

        Sellers seller = new Sellers(SellerType.AUTOMATIC);
        seller.setInService(true);
        sellerDAO.save(seller);

        Sellers seller2 = new Sellers(SellerType.AUTHORIZED);
        seller2.setInService(true);
        sellerDAO.save(seller2);

        Subscriptions subscription = new Subscriptions(seller, LocalDate.now(), 19.99, SubType.WEEKLY);
        travelDAO.save(subscription);

        Tickets ticket = new Tickets(seller, LocalDate.now(), 2.00);
        gianni.setTickets(ticket);
        travelDAO.save(ticket);


        Card card = new Card(user, LocalDate.now(), subscription);
        cardDAO.save(card);
        user.setCard(card);

        Vehicles vehicle1 = new Vehicles(VehicleType.BUS, 50);
        Vehicles vehicles2 = new Vehicles(VehicleType.BUS, 60);
        Vehicles vehicles3 = new Vehicles(VehicleType.BUS, 75);
        Vehicles vehicles4 = new Vehicles(VehicleType.TRAM, 130);
        Vehicles vehicles5 = new Vehicles(VehicleType.TRAM, 130);
        Vehicles vehicles6 = new Vehicles(VehicleType.TRAM, 130);
        vehicleDAO.save(vehicle1);
        vehicleDAO.save(vehicles2);
        vehicleDAO.save(vehicles3);
        vehicleDAO.save(vehicles4);
        vehicleDAO.save(vehicles5);
        vehicleDAO.save(vehicles6);

        Routes routes1 = new Routes("Piramide", "stazione Termini", 2, vehicle1);
        Routes routes2 = new Routes("Aeroporto Ciampino", "stazione Tiburtina", 6, vehicles2);
        Routes routes3 = new Routes("Tivoli", "stazione Termini", 5, vehicles3);
        Routes routes4 = new Routes("Stazione Centrale", "Viale Bligny", 2, vehicles4);
        Routes routes5 = new Routes("Duomo", "SanSiro", 2, vehicles5);
        Routes routes6 = new Routes("Piazza Castello", "Ospedale Maggiore", 4, vehicles6);
        routesDAO.save(routes1);
        routesDAO.save(routes2);
        routesDAO.save(routes3);
        routesDAO.save(routes4);
        routesDAO.save(routes5);
        routesDAO.save(routes6);

        System.out.println("\n");
//        sellerDAO.filterByService(SellerType.AUTOMATIC); //FILTRO DEI VENDITORI SE SONO DISTRIBUTORI AUTOMATICI E MOSTRA UNA LISTA DI SOLO QUELLI IN SERVIZIO
//        travelDAO.checkValidityByCardId(UUID.fromString("220a7147-2b2d-44da-8a93-60307b1a9d2a")); //CONTROLLO ABBONAMENTO SE VALIDO IN BASE A CODICE TESSERA DELL'UTENTE
//        travelDAO.findSubByUserId(UUID.fromString("e523079c-7656-434f-a8ba-9de5ff74af05")); //RICERCA DI ABBONAMENTO TRAMITE USER ID
//        vehicleDAO.findByVehicleType(VehicleType.BUS); // FILTRO VEICOLI PER TIPO BUS
//        vehicleDAO.findByVehicleType(VehicleType.TRAM); // FILTRO VEICOLI PER TIPO TRAM
//        vehicleDAO.findVehiclesInMaintenanceDuringPeriod(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1)); // RICERCA DI VEICOLI IN MANUTENZIONE DATO UN PERIODO DI TEMPO DEFINITO
//        vehicleDAO.sendVehicleToMaintenance(1L); // SET DI UN VEICOLO IN MANUTENZIONE A TEMPO INDETERMINATO
//        vehicleDAO.returnVehicleFromMaintenance(1L, 7); // RITORNO IN SERVIZIO DEL VEICOLO
//        vehicleDAO.doRoute(route, 1L); // COUNTER INCREMENTALE DI UNA ROUTE EFFETTUATA DA UN VEICOLO
//        travelDAO.findUserByCardId(UUID.fromString("2fc9fe08-9a02-45fb-bf1f-7b22c3b5649e")); // RICERCA DI UN UTENTE UTILIZZANDO IL SUO ID TESSERA
//        travelDAO.checkValidityByTicketId(UUID.fromString("0688e69f-61dd-41ee-98cd-e8165dfef492")); //CONTROLLO VALIDITA BIGLIETTO
        System.out.println("\n" +
                "                                  ^\n" +
                "                     _______     ^^^ \n" +
                "                    |xxxxxxx|  _^^^^^_\n" +
                "                    |xxxxxxx| | [][]  |\n" +
                "                 ______xxxxx| |[][][] |    \n" +
                "                |++++++|xxxx| | [][][]|     \n" +
                "                |++++++|xxxx| |[][][] |\n" +
                "                |++++++|_________ [][]|                             \n" +
                "                |++++++|=|=|=|=|=| [] |\n" +
                "       ██  █████  ██    ██  █████     |\n" +
                "       ██ ██   ██ ██    ██ ██   ██ [] |\n" +
                "       ██ ███████ ██    ██ ███████  []|\n" +
                "  ██   ██ ██   ██  ██  ██  ██   ██    |             \n" +
                "   █████  ██   ██   ████   ██   ██    | \n" +
                "     ██  ██████  ██    ██ ██████  ███    ██ ███████ ██    ██ \n" +
                "     ██ ██    ██ ██    ██ ██   ██ ████   ██ ██       ██  ██  \n" +
                "     ██ ██    ██ ██    ██ ██████  ██ ██  ██ █████     ████   \n" +
                "██   ██ ██    ██ ██    ██ ██   ██ ██  ██ ██ ██         ██    \n" +
                " █████   ██████   ██████  ██   ██ ██   ████ ███████    ██   \n" +
                "                  ██  ██████  ██    ██ ██████  ██ ██████  ███████ \n" +
                "                  ██ ██    ██  ██  ██  ██   ██ ██ ██   ██ ██      \n" +
                "                  ██ ██    ██   ████   ██████  ██ ██   ██ █████   \n" +
                "             ██   ██ ██    ██    ██    ██   ██ ██ ██   ██ ██      \n" +
                "              █████   ██████     ██    ██   ██ ██ ██████  ███████                                                                                                                                                                                                                                                                        \n" +
                "                |++++++|=|=|=|=|=|[][]|\n" +
                "     ___________|++HH++|  _HHHH__|   ________\n" +
                "              _______________   _____________\n" +
                "     __________________  ___________    ____ì");


        System.out.println("Dove vuoi andare?");
        System.out.println("1. Rivenditore autorizzato");
        System.out.println("2. Distributore automatico");
        System.out.println("3. MiniGame");
        System.out.println("4. Utilities");


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
                        "3.Vorrei controllare la data di scadenza della mia tessera, \n" +
                        "e in caso fosse scaduta rinnovarla!");


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

                        Tickets newTicket = new Tickets(seller, LocalDate.now(), 2.00);
                        System.out.println("A chi vuoi assegnare il biglietto?");
                        System.out.println("1.Gianni");
                        System.out.println("2.Daniele");
                        System.out.println("3.Federico");
                        int scanSelection26 = scan.nextInt();
                        switch (scanSelection26) {
                            case 1:
                                gianni.setTickets(newTicket);
                                travelDAO.save(newTicket);
                                break;
                            case 2:
                                daniele.setTickets(newTicket);
                                travelDAO.save(newTicket);
                                break;
                            case 3:
                                federico.setTickets(newTicket);
                                travelDAO.save(newTicket);
                                break;
                            default:
                                System.out.println("Hai selezionato un carattere sbagliato.. ");
                        }
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
                                                Subscriptions subscriptionUser = new Subscriptions(seller2, LocalDate.now(),
                                                        19.99, SubType.WEEKLY);
                                                cardDAO.updateCardSub(UUID.fromString(scanSelection5), subscriptionUser);
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
                                                        "|      ." + subscriptionUser.getDateOfEmission() + " / ." + subscriptionUser.getDateOfExpiration() + "   |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "(  " + seller2.getSellerId() + " )\n" +
                                                        "|_______________________________________|");

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
                                        User newUser = new User(scanSelection7, scanSelection8);
                                        userDAO.save(newUser);
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
                                                Subscriptions subscriptionUser = new Subscriptions(seller2, LocalDate.now(),
                                                        19.99, SubType.WEEKLY);
                                                travelDAO.save(subscriptionUser);
                                                Card newCard = new Card(newUser, LocalDate.now(), subscriptionUser);
                                                newUser.setCard(newCard);
                                                cardDAO.save(newCard);

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
                                                        "|      ." + subscriptionUser.getDateOfEmission() + " / ." + subscriptionUser.getDateOfExpiration() + "   |\n" +
                                                        "|                                       |\n" +
                                                        "|                                       |\n" +
                                                        "(  " + seller2.getSellerId() + " )\n" +
                                                        "|_______________________________________|");
                                                break;
                                            // FINE ABBONAMENTO SETTIMANALE CARD CREATA
                                            case 2:
                                                Subscriptions subscriptionUser2 = new Subscriptions(seller2, LocalDate.now(),
                                                        49.99, SubType.MONTHLY);
                                                travelDAO.save(subscriptionUser2);
                                                Card newCard2 = new Card(newUser, LocalDate.now(), subscriptionUser2);
                                                newUser.setCard(newCard2);
                                                cardDAO.save(newCard2);

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
                                                        "|      ." + subscriptionUser2.getDateOfEmission() + " / ." + subscriptionUser2.getDateOfExpiration() + "   |\n" +
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
                        scan.nextLine();
                        System.out.println("Inserisci il numero della tua tessera: ");
                        String scanSelection22 = scan.nextLine();
                        cardDAO.renewCardIfExpired(UUID.fromString(scanSelection22));
                        break;
                    default:
                        System.out.println("Hai selezionato un carattere sbagliato...");
                        break;
                }

                break;


            case 2:
                System.out.println(" ________________________________________\n" +
                        "|                                       |\n" +
                        "|          Benvenuto! Automaton#        |\n" +
                        "|  " + seller.getSellerId() + " |\n" +
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
                                SubType tipoSub;
                                if (scanSelection11 == 1) {
                                    tipoSub = SubType.WEEKLY;
                                } else {
                                    tipoSub = SubType.MONTHLY;
                                }
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
                                User newUser = new User(scanSelection12, scanSelection13);
                                userDAO.save(newUser);
                                Subscriptions subscriptionUser = new Subscriptions(seller2, LocalDate.now(),
                                        19.99, tipoSub);
                                travelDAO.save(subscriptionUser);
                                Card newCard = new Card(newUser, LocalDate.now(), subscriptionUser);
                                newUser.setCard(newCard);
                                cardDAO.save(newCard);
                                System.out.println("          ||ECCO LA TUA CARD||\n" +
                                        "\n" +
                                        " _______________________________________\n" +
                                        "|                                       |\n" +
                                        "|  || " + scanSelection12 + "  ||" + scanSelection13 + "  |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|     ||| ABBONAMENTO " + subscriptionUser.getSubType() + "       |\n" +
                                        "|                                       |\n" +
                                        "| " + subscriptionUser.getDateOfEmission() + " / " + subscriptionUser.getDateOfExpiration() + "   |\n" +
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
                                String tipoSub;
                                SubType typeSub;
                                if (scanSelection14 == 1) {
                                    tipoSub = "ABBONAMENTO SETTIMANALE";
                                    typeSub = SubType.WEEKLY;
                                } else {
                                    tipoSub = "ABBONAMENTO MENSILE";
                                    typeSub = SubType.MONTHLY;
                                }
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
                                if (!travelDAO.checkUserByCardId(UUID.fromString(scanSelection15))) {
                                    System.out.println("Hai inserito un numero di carta invalido o inesistente," +
                                            "devi ricominciare da capo x.x");
                                    System.exit(0);
                                }
                                User fu1 = travelDAO.findUserByCardId(UUID.fromString(scanSelection15));

                                Subscriptions subscriptionUser = new Subscriptions(seller2, LocalDate.now(),
                                        19.99, typeSub);
                                cardDAO.updateCardSub(UUID.fromString(scanSelection15), subscriptionUser);

                                System.out.println("     ||CARD AGGIORNATA CON SUCCESSO||\n" +
                                        "\n" +
                                        " _______________________________________\n" +
                                        "|                                       |\n" +
                                        "|   || " + fu1.getName() + "      ||" + fu1.getSurname() + "  |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|      || " + tipoSub + "           |\n" +
                                        "|                                       |\n" +
                                        "|      ." + subscriptionUser.getDateOfEmission() + " / ." + subscriptionUser.getDateOfExpiration() + "        |\n" +
                                        "|                                       |\n" +
                                        "|                                       |\n" +
                                        "|  " + seller.getSellerId() + " |\n" +
                                        "|_______________________________________|\n");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Hai selezionato un carattere sbagliato..");
                        }
                        break;
                    case 3:
                        Tickets newTicket = new Tickets(seller, LocalDate.now(), 2.00);
                        System.out.println("A chi vuoi assegnare il biglietto?");
                        System.out.println("1.Gianni");
                        System.out.println("2.Daniele");
                        System.out.println("3.Federico");
                        int scanSelection27 = scan.nextInt();
                        switch (scanSelection27) {
                            case 1:
                                gianni.setTickets(newTicket);
                                travelDAO.save(newTicket);
                                break;
                            case 2:
                                daniele.setTickets(newTicket);
                                travelDAO.save(newTicket);
                                break;
                            case 3:
                                federico.setTickets(newTicket);
                                travelDAO.save(newTicket);
                                break;
                            default:
                                System.out.println("Hai selezionato un carattere sbagliato.. ");
                        }
                        System.out.println(" _______________________________________\n" +
                                "(                                       )\n" +
                                "(  JAVAUTOBUS                           )\n" +
                                "(                                       )\n" +
                                "(                                       )\n" +
                                "(          " + newTicket.getDateOfEmission() + "                   )\n" +
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
                System.out.println("Scegli un personaggio:");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------------------------");
                System.out.println("1.GIANNI");
                System.out.println("       _______\n" +
                        "      |vvvvvvv|\n" +
                        "      | -   - |\n" +
                        "     @ (^) (^) @\n" +
                        "      |   <   |\n" +
                        "      | ///\\\\\\|\n" +
                        "       \\_____/\n" +
                        "     ____|  |____\n" +
                        "    /    \\__/    \\\n" +
                        "   /              \\\n" +
                        "  /\\_/|        |\\_/\\\n" +
                        " / /  |        |  \\ \\\n" +
                        "( <   |        |   > )\n" +
                        " \\ \\  |        |  / /\n" +
                        "  \\ \\ |________| / /\n" +
                        "   \\ \\|");
                System.out.println("-------------------------");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2.DANIELE");
                System.out.println("        ////^\\\\\\\\\n" +
                        "      //| ^   ^ |\\\\\n" +
                        "     //@  U   U  @\\\\\n" +
                        "     ///|   <   |\\\\\\\\\n" +
                        "        |  ___  |\n" +
                        "         \\_____/\n" +
                        "       ____|  |____\n" +
                        "      /    \\__/    \\\n" +
                        "     /              \\\n" +
                        "    /\\_/|        |\\_/\\\n" +
                        "   / /  |        |  \\ \\\n" +
                        "  ( <   |        |   > )\n" +
                        "   \\ \\  |        |  / /\n" +
                        "    \\ \\ |________| / /\n" +
                        "     \\ \\|");
                System.out.println("-------------------------");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3.FEDERICO");
                System.out.println("       _______\n" +
                        "      |       |\n" +
                        "  ____|_______|\n" +
                        "      | ^   ^ |\n" +
                        "     @ (o) (o) @\n" +
                        "      |   <   |\n" +
                        "      |  ___  |\n" +
                        "       \\_____/\n" +
                        "     ____|  |____\n" +
                        "    /    \\__/    \\\n" +
                        "   /              \\\n" +
                        "  /\\_/|        |\\_/\\\n" +
                        " / /  |        |  \\ \\\n" +
                        "( <   |        |   > )\n" +
                        " \\ \\  |        |  / /\n" +
                        "  \\ \\ |________| / /\n" +
                        "   \\ \\|");
                int scelta = scan.nextInt();


                if (scelta == 1) {
                    personaggio = gianni;
                } else if (scelta == 2) {
                    personaggio = daniele;
                } else if (scelta == 3) {
                    personaggio = federico;
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
                                        System.out.println("Hai scelto il " + vehicle1.getVehicleNumber() + " La tua tratta è:");
                                        System.out.println(routes1.getRouteStart() + " - " + routes1.getRouteEnd());
                                        System.out.println("          ______________________\n" +
                                                "       |,----.,----.,----.,--.\\\n" +
                                                "       ||    ||    ||    ||   \\\\\n" +
                                                "       |`----'`----'|----||----\\`.\n" +
                                                "       [            |   -||- __|(|\n" +
                                                "       [  ,--.      |____||.--.  |\n" +
                                                "       =-(( `))-----------(( `))==\n" +
                                                "          `--'             `--   ");

                                        System.out.println("Vuoi timbrare il biglietto? \n1. Si \n2. Abbonamento \n3. ??? ");
                                        int sceltatimbro = scan.nextInt();
                                        switch (sceltatimbro) {

                                            case 1:
                                                System.out.println(personaggio.getName() + " timbra il biglietto");
                                                Tickets ticketTest = personaggio.getTickets();
                                                ticketTest.setValidated(true);
                                                if (ticketTest.getValidationDate() == (null)) {
                                                    ticketTest.setValidationDate(LocalDate.now());
                                                } else {
                                                    ticketTest.setValidationDate(LocalDate.now().minusDays(1));
                                                }
                                                ticketTest.setVehicles(vehicle1);
                                                travelDAO.update(ticketTest);
                                                break;
                                            case 2:
                                                System.out.println(personaggio.getName() + " non convalida perchè ha l'abbonamento");
                                                break;
                                            case 3:
                                                System.out.println(personaggio.getName() + " è un furfante e non timbra il biglietto");
                                                break;
                                            default:
                                                System.out.println("Scelta non valida.");
                                                break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                    ______________________\n" +
                                                "                 |,----.,----.,----.,--.\\\n" +
                                                "                 ||    ||    ||    ||   \\\\\n" +
                                                "                 |`----'`----'|----||----\\`.\n" +
                                                "                 [            |   -||- __|(|\n" +
                                                "                 [  ,--.      |____||.--.  |\n" +
                                                "                 =-(( `))-----------(( `))==\n" +
                                                "                    `--'             `--'      ");

                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                              ______________________\n" +
                                                "                           |,----.,----.,----.,--.\\\n" +
                                                "                           ||    ||    ||    ||   \\\\\n" +
                                                "                           |`----'`----'|----||----\\`.\n" +
                                                "                           [            |   -||- __|(|\n" +
                                                "                           [  ,--.      |____||.--.  |\n" +
                                                "                           =-(( `))-----------(( `))==\n" +
                                                "                              `--'             `--'    ");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                                        ______________|\n" +
                                                "                                     |,----.,----.,--- |\n" +
                                                "                                     ||    ||    ||     ||\n" +
                                                "                     ----            |`----'`----'|----|||\n" +
                                                "                            -----    [            |   -||\n" +
                                                "                ----                 [  ,--.      |____||\n" +
                                                "                          ---       =-(( `))-----------|\n" +
                                                "                                        `--'     ");
                                        break;
                                    case 2:
                                        System.out.println("Hai scelto il " + vehicles2.getVehicleNumber() + " La tua tratta è:");
                                        System.out.println(routes2.getRouteStart() + " - " + routes2.getRouteEnd());
                                        System.out.println("          ______________________\n" +
                                                "       |,----.,----.,----.,--.\\\n" +
                                                "       ||    ||    ||    ||   \\\\\n" +
                                                "       |`----'`----'|----||----\\`.\n" +
                                                "       [            |   -||- __|(|\n" +
                                                "       [  ,--.      |____||.--.  |\n" +
                                                "       =-(( `))-----------(( `))==\n" +
                                                "          `--'             `--'    ");
                                        System.out.println("Vuoi timbrare il biglietto? \n1. Si \n2. Abbonamento \n3. ??? ");
                                        int sceltatimbro2 = scan.nextInt();
                                        switch (sceltatimbro2) {

                                            case 1:
                                                System.out.println(personaggio.getName() + " timbra il biglietto");
                                                Tickets ticketTest = personaggio.getTickets();
                                                ticketTest.setValidated(true);
                                                if (ticketTest.getValidationDate() == (null)) {
                                                    ticketTest.setValidationDate(LocalDate.now());
                                                } else {
                                                    ticketTest.setValidationDate(LocalDate.now().minusDays(1));
                                                }
                                                ticketTest.setVehicles(vehicles2);
                                                travelDAO.update(ticketTest);
                                                break;
                                            case 2:
                                                System.out.println(personaggio.getName() + " non convalida perchè ha l'abbonamento");
                                                break;
                                            case 3:
                                                System.out.println(personaggio.getName() + " è un furfante e non timbra il biglietto");
                                                break;
                                            default:
                                                System.out.println("Scelta non valida.");
                                                break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                    ______________________\n" +
                                                "                 |,----.,----.,----.,--.\\\n" +
                                                "                 ||    ||    ||    ||   \\\\\n" +
                                                "                 |`----'`----'|----||----\\`.\n" +
                                                "                 [            |   -||- __|(|\n" +
                                                "                 [  ,--.      |____||.--.  |\n" +
                                                "                 =-(( `))-----------(( `))==\n" +
                                                "                    `--'             `--'   ");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                              ______________________\n" +
                                                "                           |,----.,----.,----.,--.\\\n" +
                                                "                           ||    ||    ||    ||   \\\\\n" +
                                                "                           |`----'`----'|----||----\\`.\n" +
                                                "                           [            |   -||- __|(|\n" +
                                                "                           [  ,--.      |____||.--.  |\n" +
                                                "                           =-(( `))-----------(( `))==\n" +
                                                "                              `--'             `--'       ");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                                        ______________|\n" +
                                                "                                     |,----.,----.,--- |\n" +
                                                "                                     ||    ||    ||     ||\n" +
                                                "                     ----            |`----'`----'|----|||\n" +
                                                "                            -----    [            |   -||\n" +
                                                "                ----                 [  ,--.      |____||\n" +
                                                "                          ---       =-(( `))-----------|\n" +
                                                "                                       `--'     ");
                                        break;
                                    case 3:
                                        System.out.println("Hai scelto il  " + vehicles3.getVehicleNumber() + "  La tua tratta è:");
                                        System.out.println(routes3.getRouteStart() + " - " + routes3.getRouteEnd());
                                        System.out.println("          ______________________\n" +
                                                "       |,----.,----.,----.,--.\\\n" +
                                                "       ||    ||    ||    ||   \\\\\n" +
                                                "       |`----'`----'|----||----\\`.\n" +
                                                "       [            |   -||- __|(|\n" +
                                                "       [  ,--.      |____||.--.  |\n" +
                                                "       =-(( `))-----------(( `))==\n" +
                                                "          `--'             `--'       ");

                                        System.out.println("Vuoi timbrare il biglietto? \n1. Si \n2. Abbonamento \n3. ??? ");
                                        int sceltatimbro3 = scan.nextInt();
                                        switch (sceltatimbro3) {

                                            case 1:
                                                System.out.println(personaggio.getName() + " timbra il biglietto");
                                                Tickets ticketTest = personaggio.getTickets();
                                                ticketTest.setValidated(true);
                                                if (ticketTest.getValidationDate() == (null)) {
                                                    ticketTest.setValidationDate(LocalDate.now());
                                                } else {
                                                    ticketTest.setValidationDate(LocalDate.now().minusDays(1));
                                                }
                                                ticketTest.setVehicles(vehicles3);
                                                travelDAO.update(ticketTest);
                                                break;
                                            case 2:
                                                System.out.println(personaggio.getName() + " non convalida perchè ha l'abbonamento");
                                                break;
                                            case 3:
                                                System.out.println(personaggio.getName() + " è un furfante e non timbra il biglietto");
                                                break;
                                            default:
                                                System.out.println("Scelta non valida.");
                                                break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                    ______________________\n" +
                                                "                 |,----.,----.,----.,--.\\\n" +
                                                "                 ||    ||    ||    ||   \\\\\n" +
                                                "                 |`----'`----'|----||----\\`.\n" +
                                                "                 [            |   -||- __|(|\n" +
                                                "                 [  ,--.      |____||.--.  |\n" +
                                                "                 =-(( `))-----------(( `))==\n" +
                                                "                    `--'              `--'   ");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                              ______________________\n" +
                                                "                           |,----.,----.,----.,--.\\\n" +
                                                "                           ||    ||    ||    ||   \\\\\n" +
                                                "                           |`----'`----'|----||----\\`.\n" +
                                                "                           [            |   -||- __|(|\n" +
                                                "                           [  ,--.      |____||.--.  |\n" +
                                                "                           =-(( `))-----------(( `))==\n" +
                                                "                              `--'             `--'      ");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("                                        ______________|\n" +
                                                "                                     |,----.,----.,--- |\n" +
                                                "                                     ||    ||    ||     ||\n" +
                                                "                     ----            |`----'`----'|----|||\n" +
                                                "                            -----    [            |   -||\n" +
                                                "                ----                 [  ,--.      |____||\n" +
                                                "                          ---       =-(( `))-----------|\n" +
                                                "                                        `--'     ");
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
                                        System.out.println(routes4.getRouteStart() + " - " + routes4.getRouteEnd());
                                        System.out.println("   ,',                                   ,',\n" +
                                                "     ', ,'                                 ', ,'\n" +
                                                "  ,----'--------------------------.     ,----'--------------------------.\n" +
                                                "  /''|```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                " |---'---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                " ,_    ______ FakerTaxi ______     |=-=,_    ______           ______  jg |\n" +
                                                "  '---'(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }


                                        System.out.println("\n" +
                                                "\"   \n" +
                                                "\"|', ,'                                 \n" +
                                                "\"| '--------------------------.     ,----'--------------------------.\n" +
                                                "\"| ```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                "\"| ---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                "\"|  ______ FakerTaxi ______     |=-=,_    ______           ______  jg |\n" +
                                                "\"| '(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'\"");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("\n" +
                                                "\"|                                 \n" +
                                                "\"|-------------.     ,----'--------------------------.\n" +
                                                "\"|`|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                "\"|-'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                "\"|axi ______     |=-=,_    ______           ______  jg |\n" +
                                                "\"|---'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'\"");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("   " +
                                                "\"|                                 \n" +
                                                "\"|-------------.    -----    \n" +
                                                "\"|`|```|```|``|``|       ----   \n" +
                                                "\"|-'---'---'--'--|     --    \n" +
                                                "\"|    ______  jg |       --------    \n" +
                                                "\"|---'(O)(O)'---'\"  ---");


                                        System.out.println("Vuoi timbrare il biglietto? \n1. Si \n2. Abbonamento \n3. ??? ");
                                        int sceltatimbro4 = scan.nextInt();
                                        switch (sceltatimbro4) {

                                            case 1:
                                                System.out.println(personaggio.getName() + " timbra il biglietto");
                                                Tickets ticketTest = personaggio.getTickets();
                                                ticketTest.setValidated(true);
                                                if (ticketTest.getValidationDate() == (null)) {
                                                    ticketTest.setValidationDate(LocalDate.now());
                                                } else {
                                                    ticketTest.setValidationDate(LocalDate.now().minusDays(1));
                                                }
                                                ticketTest.setVehicles(vehicles4);
                                                travelDAO.update(ticketTest);

                                                break;
                                            case 2:
                                                System.out.println(personaggio.getName() + " non convalida perchè ha l'abbonamento");
                                                break;
                                            case 3:
                                                System.out.println(personaggio.getName() + " è un furfante e non timbra il biglietto");
                                                break;
                                            default:
                                                System.out.println("Scelta non valida.");
                                                break;


                                        }
                                        break;
                                    case 2:
                                        System.out.println("Hai scelto il Tram.Random La tua tratta è:");
                                        System.out.println(routes5.getRouteStart() + " - " + routes5.getRouteEnd());
                                        System.out.println("   ,',                                   ,',\n" +
                                                "     ', ,'                                 ', ,'\n" +
                                                "  ,----'--------------------------.     ,----'--------------------------.\n" +
                                                "  /''|```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                " |---'---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                " ,_    ______TramDom______         |=-=,_    ______           ______  jg |\n" +
                                                "  '---'(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'");


                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }


                                        System.out.println("\n" +
                                                "\"   \n" +
                                                "\"|', ,'                                 \n" +
                                                "\"| '--------------------------.     ,----'--------------------------.\n" +
                                                "\"| ```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                "\"| ---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                "\"|  ______ TramDom   ______     |=-=,_    ______           ______  jg |\n" +
                                                "\"| '(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'\"");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("\n" +
                                                "\"|                                 \n" +
                                                "\"|-------------.     ,----'--------------------------.\n" +
                                                "\"|`|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                "\"|-'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                "\"|om  ______     |=-=,_    ______           ______  jg |\n" +
                                                "\"|---'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'\"");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("   " +
                                                "\"|                                 \n" +
                                                "\"|-------------.    -----    \n" +
                                                "\"|`|```|```|``|``|       ----   \n" +
                                                "\"|-'---'---'--'--|     --    \n" +
                                                "\"|    ______  jg |       --------    \n" +
                                                "\"|---'(O)(O)'---'\"  ---");


                                        System.out.println("Vuoi timbrare il biglietto? \n1. Si \n2. Abbonamento \n3. ??? ");
                                        int sceltatimbro5 = scan.nextInt();
                                        switch (sceltatimbro5) {

                                            case 1:
                                                System.out.println(personaggio.getName() + " timbra il biglietto");
                                                Tickets ticketTest = personaggio.getTickets();
                                                ticketTest.setValidated(true);
                                                if (ticketTest.getValidationDate() == (null)) {
                                                    ticketTest.setValidationDate(LocalDate.now());
                                                } else {
                                                    ticketTest.setValidationDate(LocalDate.now().minusDays(1));
                                                }
                                                ticketTest.setVehicles(vehicles5);
                                                travelDAO.update(ticketTest);
                                                break;
                                            case 2:
                                                System.out.println(personaggio.getName() + " non convalida perchè ha l'abbonamento");
                                                break;
                                            case 3:
                                                System.out.println(personaggio.getName() + " è un furfante e non timbra il biglietto");
                                            default:
                                                System.out.println("Scelta non valida.");
                                                break;
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Hai scelto il SwitchTram La tua tratta è:");
                                        System.out.println(routes6.getRouteStart() + " - " + routes6.getRouteEnd());
                                        System.out.println("   ,',                                   ,',\n" +
                                                "     ', ,'                                 ', ,'\n" +
                                                "  ,----'--------------------------.     ,----'--------------------------.\n" +
                                                "  /''|```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                " |---'---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                " ,_    ______SwitchTram ______     |=-=,_    ______           ______  jg |\n" +
                                                "  '---'(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }


                                        System.out.println("\n" +
                                                "\"   \n" +
                                                "\"|', ,'                                 \n" +
                                                "\"| '--------------------------.     ,----'--------------------------.\n" +
                                                "\"| ```|```|```|```|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                "\"| ---'---'---'---'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                "\"|  ______ SwitchTram _____     |=-=,_    ______           ______  jg |\n" +
                                                "\"| '(O)(O)'---------'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'\"");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("\n" +
                                                "\"|                                 \n" +
                                                "\"|-------------.     ,----'--------------------------.\n" +
                                                "\"|`|```|```|``|` |    /''|```|```|```|```|```|```|``|``|\n" +
                                                "\"|-'---'---'--'--|   |---'---'---'---'---'---'---'--'--|\n" +
                                                "\"|ram ______     |=-=,_    ______           ______  jg |\n" +
                                                "\"|---'(O)(O)'---'     '---'(O)(O)'---------'(O)(O)'---'\"");
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("   " +
                                                "\"|                                 \n" +
                                                "\"|-------------.    -----    \n" +
                                                "\"|`|```|```|``|``|       ----   \n" +
                                                "\"|-'---'---'--'--|     --    \n" +
                                                "\"|    ______  jg |       --------    \n" +
                                                "\"|---'(O)(O)'---'\"  ---");
                                        System.out.println("Vuoi timbrare il biglietto? \n1. Si \n2. Abbonamento \n3. ??? ");
                                        int sceltatimbro6 = scan.nextInt();
                                        switch (sceltatimbro6) {

                                            case 1:
                                                if (personaggio.isTicket()) {
                                                    System.out.println(personaggio.getName() + " timbra il biglietto");
                                                    Tickets ticketTest = personaggio.getTickets();
                                                    ticketTest.setValidated(true);
                                                    if (ticketTest.getValidationDate() == (null)) {
                                                        ticketTest.setValidationDate(LocalDate.now());
                                                    } else {
                                                        ticketTest.setValidationDate(LocalDate.now().minusDays(1));
                                                    }
                                                    ticketTest.setVehicles(vehicles6);
                                                    travelDAO.update(ticketTest);
                                                }
                                                break;
                                            case 2:
                                                System.out.println(personaggio.getName() + " non convalida perchè ha l'abbonamento");
                                                break;
                                            case 3:
                                                System.out.println(personaggio.getName() + " è un furfante e non timbra il biglietto");
                                                break;
                                            default:
                                                System.out.println("Scelta non valida.");
                                                break;
                                        }
                                        break;
                                    default:
                                        System.out.println("Scelta non valida.");
                                }
                        }
                        System.out.println(" ");
                        if (userDAO.isThereTicketChecker()) {
                            System.out.println("  " +
                                    "      _.-\"` `'-.\n" +
                                    "       '._ __{}_(\n" +
                                    "         |'--.__\\\n" +
                                    "        (   -_\\-\n" +
                                    "         |  __ |\n" +
                                    "         )\\___/\n" +
                                    "     .--'`:._]\n" +
                                    "    /  \\      '-." +
                                    "\nSalve ha il biglietto o l'abbonamento? \n1. Mostra biglietto \n2. Mostra abbonamento \n3. *Prova a scappare*"
                            );

                            System.out.println();
                            int presenzaBiglietto = scan.nextInt();
                            switch (presenzaBiglietto) {
                                case 1:
                                    if (ticket.isValidated() && (ticket.getValidationDate().equals(LocalDate.now()))) {
                                        System.out.println("  " +
                                                "      _.-\"` `'-.\n" +
                                                "       '._ __{}_(\n" +
                                                "         |'--.__\\\n" +
                                                "        (   ^_\\^\n" +
                                                "         |   o |\n" +
                                                "         )\\___/\n" +
                                                "     .--'`:._]\n" +
                                                "    /  \\      '-." +
                                                "\nIl tuo biglietto " + ticket.getId() + " è valido."
                                        );
                                    } else {
                                        System.out.println("  " +
                                                "      _.-\"` `'-.\n" +
                                                "       '._ __{}_(\n" +
                                                "         |'--.__\\\n" +
                                                "        (   ^_\\^\n" +
                                                "         |   o |\n" +
                                                "         )\\___/\n" +
                                                "     .--'`:._]\n" +
                                                "    /  \\      '-.");
                                        System.out.println("Hai provato a fare il furbetto.. il biglietto è scaduto...");
                                    }

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
                                            "\nL'abbonamento " + card.getId_tessera() + " risulta attivo."
                                    );
                                    System.out.println(" ");
                                    break;
                                case 3:
                                    System.out.println("  " +
                                            "      _.-\"` `'-.\n" +
                                            "       '._ __{}_(\n" +
                                            "         |'--.__\\\n" +
                                            "        (   -_\\-\n" +
                                            "         |   0 |\n" +
                                            "         )\\___/\n" +
                                            "     .--'`:._]\n" +
                                            "    /  \\      '-.  "

                                    );
                                    userDAO.attemptEscape();
                                    System.out.println("   ");
                                    break;
                            }
                        } else {
                            System.out.println(" ");
                            System.out.println("Avrei potuto non timbrare..."
                            );
                        }
                    }
                }
            case 4:
                System.out.println("   ________________________________________________\n" +
                        "            /                                                \\\n" +
                        "           |    _________________________________________     |\n" +
                        "           |   |                                         |    |\n" +
                        "           |   |  C:\\> _                                 |    |\n" +
                        "           |   |  1.Ricerca distributori automatici      |    |\n" +
                        "           |   |              in servizio                |    |\n" +
                        "           |   |                                         |    |\n" +
                        "           |   |  2.Ricerca di veicoli in manutenzione   |    |\n" +
                        "           |   |       nei prossimi 10 giorni            |    |\n" +
                        "           |   |                                         |    |\n" +
                        "           |   |  3.Manda un veicolo in manutenzione     |    |\n" +
                        "           |   |                                         |    |\n" +
                        "           |   |  4.Fai tornare in servizio un veicolo   |    |\n" +
                        "           |   |                                         |    |\n" +
                        "           |   |                                         |    |\n" +
                        "           |   |_________________________________________|    |\n" +
                        "           |                                                  |\n" +
                        "            \\_________________________________________________/\n" +
                        "                   \\___________________________________/\n" +
                        "                ___________________________________________\n" +
                        "             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\n" +
                        "          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\n" +
                        "       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\n" +
                        "    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\n" +
                        " _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_\n" +
                        ":-------------------------------------------------------------------------:\n" +
                        "`---._.-------------------------------------------------------------._.---'");

                int scanSelection25 = scan.nextInt();
                switch (scanSelection25) {
                    case 1:
                        sellerDAO.filterByService(SellerType.AUTOMATIC);
                        break;


                    case 2:
                        LocalDate today = LocalDate.now();
                        LocalDate maxDay = today.plusDays(10);
                        vehicleDAO.findVehiclesInMaintenanceDuringPeriod(today, maxDay);
                        break;

                    case 3:
                        scan.nextLine();
                        System.out.println("Inserisci il numero di targa del veicolo: ");
                        Long scanSelection20 = Long.valueOf(scan.nextLine());
                        vehicleDAO.sendVehicleToMaintenance(scanSelection20);
                        break;


                    case 4:
                        scan.nextLine();
                        System.out.println("Inserisci il numero di targa del veicolo da far tornare in servizio: ");
                        Long scanSelection21 = Long.valueOf(scan.nextLine());
                        System.out.println("Inserisci il numero di giorni prima del suo rientro in servizio");
                        int scanSelection22 = Integer.parseInt(scan.nextLine());

                        vehicleDAO.returnVehicleFromMaintenance(scanSelection21, scanSelection22);
                        break;

                    default:
                        System.out.println("Hai selezionato un carattere sbagliato.. ");
                        break;
                }
                break;
            case 666:

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣠⠤⠤⠤⠤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠶⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠢⣄⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠁⠀⠀⠀⠀⢀⣀⡐⢄⠀⠀⠀⠀⠀⠀⠈⠳⣄⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠁⠀⠀⠀⠀⠀⡜⠁⠀⣿⡌⠀⠀⠀⠀⠀⠀⠀⠀⠈⢆⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡾⠀⠀⠀⠀⠀⠀⣸⣷⣤⣾⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠊⣼⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢤⡀⠀⠀⠀⢰⡇⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⡜⣼⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡎⠀⠉⠲⣄⣀⣼⡇⠀⠀⠀⠀⠀⠀⠻⠿⣿⣟⡼⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠉⠉⠁⠀⡏⠑⠌⠓⢬⣧⠀⠀⠀⠀⠘⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠿⡀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣇⠀⠀⠀⠇⠀⠀⠀⠀⠙⣆⠀⠀⠀⠀⠀⠈⠉⠓⠒⠲⠤⢤⣀⠀⠂⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢀⣠⠤⠖⠒⠒⠒⠦⢤⡀⠀⠀⠀⠀⠀⢸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠈⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠲⠤⠤⠒⠋⢉⠟⠀⠀⠀⠀\n" +
                        "⠀⠀⢀⡴⠋⠁⠀⠀⠀⠀⠀⠀⠀⠙⢦⠀⠀⠀⢠⡞⠹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠋⠀⠀⠀⠀⠀\n" +
                        "⠀⣠⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢇⠀⢠⡟⠀⠀⠹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⡏⠈⠑⠢⢤⣀⣀⠀⠀⠀⠀⢀⣀⡤⠖⠯⣀⠀⠀⠀⠀⠀⠀\n" +
                        "⢀⡟⠀⠀⠀⠀⠠⠴⠤⣀⠀⠀⠀⠀⠀⢸⣠⡟⠀⠀⠀⠀⢹⣄⠀⠀⠀⠀⠀⠀⢀⣼⡁⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⢻⠀⠀⠀⠀⠀⠉⠢⣄⣀⡀⠀\n" +
                        "⢸⡇⠀⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⠀⠀⢈⣿⡇⠀⠀⠀⠀⢸⠉⢢⣀⡀⢀⣀⣴⠟⠀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡆⠀⠀⠀⠀⠀⠀⠀⠀⢇⡀\n" +
                        "⠘⣇⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⢸⡇⣷⠀⠀⠀⢀⡞⠀⢰⠏⠉⠉⠁⢸⡀⠀⠀⠀⠈⠓⠶⠤⣤⣄⣀⣠⡤⠴⡇⠀⠀⠀⠀⠀⠀⠀⠀⡔⠁\n" +
                        "⠀⠹⣆⠀⠀⠀⠀⠀⢀⡼⠁⠀⠀⠀⠀⢸⠁⠸⡆⠀⣠⠞⠀⢀⡞⠀⠀⠀⠀⠘⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸⠃⠀⠀⢰⣧⣀⣀⡀⠀⢀⣀⣠⠴⠃⠀\n" +
                        "⠀⠀⠹⡓⠦⠤⠤⠖⠋⠀⠀⠀⠀⠀⠀⢸⠀⠀⠹⡴⠁⠀⢠⠞⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀⣸⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠘⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⢸⢁⡠⠴⢧⡀⠀⠀⠀⠀⣀⠔⠳⣄⠀⠀⠀⠀⠀⠀⡼⠁⠀⠀⢠⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠘⣇⣠⡿⠋⠀⠀⠀⠙⢦⣀⡠⠞⠁⠀⠀⠈⠙⠶⣤⣀⡀⣰⠃⠀⠀⣠⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠙⢦⣀⠀⠀⠀⠀⠀⠀⣸⠏⠀⠀⠀⠀⠀⠀⠈⢻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣹⠋⠉⠉⣹⠏⠙⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠲⢤⣄⣀⣠⡏⠀⠀⠀⠀⠀⠀⠀⠀⠈⣇⠀⠀⠀⠀⠀⠀⠀⠀⡰⠃⢀⣤⠞⠁⠀⠀⠘⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡽⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣻⠶⠤⠤⠤⠤⠤⢤⣞⡥⠖⠋⠀⠀⠀⠀⠀⠀⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠟⠒⠀⠀⠒⠒⠺⢯⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⠃⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⢄⣈⠆⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⢄⡀⠀⠀⠀⠀⠀⠀⢀⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣄⠀⠀⠀⠀⢀⣠⠴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢇⣀⡤⠖⢄⠀⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⠒⠒⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠈⠙⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLSSQUIRTOLS");

                break;


            default:
                System.out.println("Hai selezionato un carattere sbagliato.. ");
                break;


        }
        em.close();
        emf.close();
    }


}
