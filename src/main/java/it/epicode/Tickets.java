package it.epicode;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@Entity
public class Tickets extends TravelDocument{
    private boolean validated;
    private UUID validatedOn;
    private Date validationDate;

    public Tickets() {
    }

    public Tickets(Integer sold_from, Date dateOfEmission, Double price, Card card, boolean validated, UUID validatedOn, Date validationDate) {
        super(sold_from, dateOfEmission, price, card);
        this.validated = validated;
        this.validatedOn = validatedOn;
        this.validationDate = validationDate;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public UUID getValidatedOn() {
        return validatedOn;
    }

    public void setValidatedOn(UUID validatedOn) {
        this.validatedOn = validatedOn;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "validated=" + validated +
                ", validatedOn=" + validatedOn +
                ", validationDate=" + validationDate +
                '}';
    }
}
