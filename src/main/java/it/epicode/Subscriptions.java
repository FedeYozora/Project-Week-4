package it.epicode;

import it.epicode.enums.SubType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Subscriptions extends TravelDocument{
    private LocalDate dateOfExpiration;


@Enumerated(EnumType.STRING)
    private SubType subType;

    public Subscriptions() {
    }

    public Subscriptions(Integer sold_from, LocalDate dateOfEmission, Double price, Card card, LocalDate dateOfExpiration,SubType subType) {
        super(sold_from, dateOfEmission, price, card);
        this.dateOfExpiration = (subType == SubType.WEEKLY)?dateOfEmission.plusDays(7):dateOfEmission.plusDays(30);
    }



    public LocalDate getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }



    @Override
    public String toString() {
        return "Subscriptions{" +
                "dateOfExpiration=" + dateOfExpiration +

                '}';
    }
}
