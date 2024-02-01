package it.epicode.DAO;

import it.epicode.Routes;
import it.epicode.Vehicles;
import it.epicode.enums.VehicleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class VehicleDAO {
    private static EntityManager em;


    public VehicleDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Vehicles vehicle) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(vehicle);
            transaction.commit();
            System.out.println(vehicle + "salvato correttamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void findByVehicleType(VehicleType vehicleType) {
        List<Vehicles> vehicleFound = em.createQuery("SELECT v FROM Vehicles v WHERE v.vehicleType = :vehicleType", Vehicles.class)
                .setParameter("vehicleType", vehicleType)
                .getResultList();
        if (vehicleFound.isEmpty()) {
            System.out.printf("Nessun veicolo di tipo %s trovato%n", vehicleType);
        } else {
            System.out.printf("Veicoli di tipo %s trovati: %s%n", vehicleType, vehicleFound);
        }
    }

    public void sendVehicleToMaintenance(Long vehicleID) {


        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Vehicles vehicle = em.find(Vehicles.class, vehicleID);

            vehicle.setInMaintenance(true);
            vehicle.setMaintenanceStartDate(LocalDate.now());
            System.out.println("Il veicolo è andato in manutenzione");
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public void returnVehicleFromMaintenance(Long vehicleID, int days) {

        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Vehicles vehicle = em.find(Vehicles.class, vehicleID);

            for (int i = 0; i < days; i++) {
                vehicle.setMaintenanceEndDate(vehicle.getMaintenanceStartDate().plusDays(i));
                System.out.printf("Giorno %s %n", i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            vehicle.setInMaintenance(false);
            System.out.println("Il veicolo è tornato in servizio! HP recuperati : +32 [♡][♡][♡][♡][♡][][][]");
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    public void doRoute(Routes route, Long vehicleID) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            int average = route.getAverageTravelTime();

            Vehicles vehicle = em.find(Vehicles.class, vehicleID);
            vehicle.setRoutesCompleted(vehicle.getRoutesCompleted() + 1);
            Random random = new Random();
            System.out.println(average);
            int travelTime = (average - 5) + random.nextInt((average + 5) - (average - 5) + 1);

            transaction.commit();

            System.out.printf("Il %s numero %s ha completato la tratta %s - %s in %s minuti"
                    , vehicle.getVehicleType(), vehicle.getVehicleNumber(), route.getRouteStart(), route.getRouteEnd(), travelTime);


        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
