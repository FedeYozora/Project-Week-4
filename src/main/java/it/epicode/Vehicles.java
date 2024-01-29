package it.epicode;

import it.epicode.enums.VehicleType;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "vehicles")
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "vehicle_number",nullable = false)
    @OneToMany
    private Long vehicleNumber;
    @Column(name = "type_of_vehicle",nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Column(nullable = false)
    private int capacity;
    @Column(name = "in_maintenance",nullable = false)
    private boolean inMaintenance;

    public Vehicles() {
    }

    public Vehicles(Long vehicleNumber, VehicleType vehicleType, int capacity, boolean inMaintenance) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.capacity = capacity;
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
