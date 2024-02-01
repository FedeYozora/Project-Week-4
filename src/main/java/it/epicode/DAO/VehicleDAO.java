package it.epicode.DAO;

import it.epicode.Routes;
import it.epicode.Vehicles;
import it.epicode.enums.VehicleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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

    public Vehicles findVehicleByUUID(UUID uuid) {
        return em.find(Vehicles.class, uuid);
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

    public void findVehiclesInMaintenanceDuringPeriod(LocalDate maintenanceStartDate, LocalDate maintenanceEndDate) {
        List<Vehicles> vehiclesInMaintenance = em.createQuery("SELECT v FROM Vehicles v WHERE (v.maintenanceStartDate BETWEEN :startDate AND :endDate) OR (v.maintenanceEndDate BETWEEN :startDate AND :endDate) AND v.inMaintenance = true", Vehicles.class)
                .setParameter("startDate", maintenanceStartDate)
                .setParameter("endDate", maintenanceEndDate)
                .getResultList();
        if (vehiclesInMaintenance.isEmpty()) {
            System.out.println("Nessun veicolo in manutenzione trovato");
        } else {
            System.out.printf("Veicoli in manutenzione trovati: %s", vehiclesInMaintenance);
        }
    }

    public void findVehiclesInService(LocalDate maintenanceStartDate, LocalDate maintenanceEndDate) {
        List<Vehicles> vehiclesInService = em.createQuery("SELECT v FROM Vehicles v WHERE (v.maintenanceStartDate BETWEEN :startDate AND :endDate) OR (v.maintenanceEndDate BETWEEN :startDate AND :endDate) AND v.inMaintenance = false", Vehicles.class)
                .setParameter("startDate", maintenanceStartDate)
                .setParameter("endDate", maintenanceEndDate)
                .getResultList();
        if (vehiclesInService.isEmpty()) {
            System.out.println("Nessun veicolo in servizio trovato");
        } else {
            System.out.println("Veicoli in servizio trovati: ");
        }
    }

//    public void doRoute(Routes route, Vehicles vehicle) {
//        vehicle.setRoutesCompleted(vehicle.getRoutesCompleted() + 1);
//        Random random = new Random();
//        int travelTime = random.nextInt(route.getAverageTravelTime() - 20, route.getAverageTravelTime() + 20);
//    }


}
