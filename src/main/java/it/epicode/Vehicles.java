package it.epicode;

import it.epicode.enums.VehicleType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "vehicle_number", nullable = false)
    private Long vehicleNumber;

    @Column(name = "type_of_vehicle", nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(nullable = false)
    private int capacity;


    @Column(name = "in_maintenance", nullable = false)
    private boolean inMaintenance;

    private int routesCompleted;

    @OneToMany(mappedBy = "vehicles", orphanRemoval = true)

    private Set<Tickets> tickets = new LinkedHashSet<>();


    @Column(name = "maintenance_start_date")
    private LocalDate maintenanceStartDate;

    @Column(name = "maintenance_end_date")
    private LocalDate maintenanceEndDate;


    public Set<Tickets> getTickets() {
        return tickets;
    }


    public void setTickets(Tickets tickets) {
        tickets.setValidated(true);
        tickets.setValidationDate(LocalDate.now());
        tickets.setVehicles(this);
        this.tickets.add(tickets);
    }

    public Vehicles() {
    }


    public Vehicles(VehicleType vehicleType, int capacity) {
        this.vehicleType = vehicleType;
        this.capacity = capacity;
        this.inMaintenance = false;
    }

    public Long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isInMaintenance() {
        return inMaintenance;
    }

    public void setInMaintenance(boolean inMaintenance) {
        this.inMaintenance = inMaintenance;
    }

    public int getRoutesCompleted() {
        return routesCompleted;
    }

    public void setRoutesCompleted(int routesCompleted) {
        this.routesCompleted = routesCompleted;
    }

    public LocalDate getMaintenanceStartDate() {
        return maintenanceStartDate;
    }

    public void setMaintenanceStartDate(LocalDate maintenanceStartDate) {
        this.maintenanceStartDate = maintenanceStartDate;
    }

    public LocalDate getMaintenanceEndDate() {
        return maintenanceEndDate;
    }

    public void setMaintenanceEndDate(LocalDate maintenanceEndDate) {
        this.maintenanceEndDate = maintenanceEndDate;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vehicleNumber=" + vehicleNumber +
                ", vehicleType=" + vehicleType +
                ", capacity=" + capacity +
                ", inMaintenance=" + inMaintenance +
                '}';
    }
}
