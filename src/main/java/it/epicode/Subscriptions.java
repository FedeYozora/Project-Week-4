package it.epicode;

import it.epicode.enums.SubType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Subscriptions extends TravelDocument {
    private LocalDate dateOfExpiration;

    @Column(name = "subscription_type")
    @Enumerated(EnumType.STRING)
    private SubType subType;

    public Subscriptions() {
    }

    public Subscriptions(Sellers sold_from, LocalDate dateOfEmission, Double price, SubType subType) {
        super(sold_from, dateOfEmission, price);
        this.dateOfExpiration = (subType == SubType.WEEKLY) ? dateOfEmission.plusDays(7) : dateOfEmission.plusDays(30);
        this.subType = subType;
    }


    public LocalDate getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "dateOfExpiration=" + dateOfExpiration +

                '}';
    }
}
