package it.epicode.DAO;

import it.epicode.Vehicles;
import it.epicode.enums.VehicleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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

//    public void doRoute(Routes route, Vehicles vehicle) {
//        vehicle.setRoutesCompleted(vehicle.getRoutesCompleted() + 1);
//        Random random = new Random();
//        int travelTime = random.nextInt(route.getAverageTravelTime() - 20, route.getAverageTravelTime() + 20);
//    }
}
