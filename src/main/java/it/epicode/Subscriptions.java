package it.epicode;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Subscriptions extends TravelDocument{
    private Date dateOfExpiration;
    private List<UUID> validatedOn;

    public Subscriptions() {
    }

    public Subscriptions(Integer sold_from, Date dateOfEmission, Double price, Card card, Date dateOfExpiration, List<UUID> validatedOn) {
        super(sold_from, dateOfEmission, price, card);
        this.dateOfExpiration = dateOfExpiration;
        this.validatedOn = validatedOn;
    }

    public Date getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Date dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public List<UUID> getValidatedOn() {
        return validatedOn;
    }

    public void setValidatedOn(List<UUID> validatedOn) {
        this.validatedOn = validatedOn;
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "dateOfExpiration=" + dateOfExpiration +
                ", validatedOn=" + validatedOn +
                '}';
    }
}
