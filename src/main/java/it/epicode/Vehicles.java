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

    @ElementCollection
    @CollectionTable(
            name = "maintenance_records",
            joinColumns = @JoinColumn(name = "transport_means_id")
    )
    @OrderColumn(name = "maintenance_order")
    private List<MaintenanceRecord> maintenanceRecords;


    @Column(name = "service_start_date")
    private LocalDate serviceStartDate;
    @Column(name = "service_end_date")
    private LocalDate serviceEndDate;

    @Column(name = "in_maintenance", nullable = false)
    private boolean inMaintenance;

    private int routesCompleted;

    @OneToMany(mappedBy = "vehicles", orphanRemoval = true)

    private Set<Tickets> tickets = new LinkedHashSet<>();

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

    public Vehicles(VehicleType vehicleType, int capacity, boolean inMaintenance) {
        this.vehicleType = vehicleType;
        this.capacity = capacity;
        this.inMaintenance = false;
    }

    public Vehicles(VehicleType vehicleType, int capacity, LocalDate serviceStartDate, LocalDate serviceEndDate, boolean inMaintenance) {
        this.vehicleType = vehicleType;
        this.capacity = capacity;
        this.serviceStartDate = serviceStartDate;
        this.serviceEndDate = serviceEndDate;
        this.inMaintenance = inMaintenance;
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
