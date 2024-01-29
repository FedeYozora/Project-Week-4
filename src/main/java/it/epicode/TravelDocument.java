package it.epicode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TravelDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    private Sellers sold_from;
    private LocalDate dateOfEmission;
    private Double price;
    @OneToOne(mappedBy = "travelDocument")
    private Card card;

    public TravelDocument() {
    }

    public TravelDocument(Sellers sold_from, LocalDate dateOfEmission, Double price) {
        this.sold_from = sold_from;
        this.dateOfEmission = dateOfEmission;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Sellers getSold_from() {
        return sold_from;
    }

    public void setSold_from(Sellers sold_from) {
        this.sold_from = sold_from;
    }

    public LocalDate getDateOfEmission() {
        return dateOfEmission;
    }

    public void setDateOfEmission(LocalDate dateOfEmission) {
        this.dateOfEmission = dateOfEmission;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "TravelDocument{" +
                "id=" + id +
                ", sold_from=" + sold_from +
                ", dateOfEmission=" + dateOfEmission +
                ", price=" + price +
                ", card=" + card +
                '}';
    }
}
