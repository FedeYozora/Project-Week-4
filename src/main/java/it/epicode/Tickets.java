package it.epicode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
public class Tickets extends TravelDocument{
    private boolean validated;

    private UUID validatedOn;
    private LocalDate validationDate;

    public Tickets() {
    }

    public Tickets(Integer sold_from, LocalDate dateOfEmission, Double price, Card card, boolean validated) {
        super(sold_from, dateOfEmission, price, card);
        this.validated = validated;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
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
