package it.epicode;

import org.hibernate.mapping.ToOne;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Tickets extends TravelDocument {
    private boolean validated;

    private LocalDate validationDate;


    @ManyToOne
    @JoinColumn(name = "vehicle_number")
    private Vehicles vehicles;

    @OneToOne(mappedBy = "tickets", orphanRemoval = true)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    public Tickets() {
    }

    public Tickets(Sellers sold_from, LocalDate dateOfEmission, Double price) {
        super(sold_from, dateOfEmission, price);
    }

    public boolean isValidated() {
        return validated;
    }


    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public LocalDate getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "validated=" + validated +
                ", validationDate=" + validationDate +
                '}';
    }
}
