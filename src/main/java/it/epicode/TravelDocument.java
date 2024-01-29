package it.epicode;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TravelDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private Integer sold_from;
    private Date dateOfEmission;
    private Double price;

    @OneToOne(mappedBy = "travelDocument")
    private Card card;

    public TravelDocument() {
    }

    public TravelDocument(Integer sold_from, Date dateOfEmission, Double price, Card card) {
        this.sold_from = sold_from;
        this.dateOfEmission = dateOfEmission;
        this.price = price;
        this.card = card;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getSold_from() {
        return sold_from;
    }

    public void setSold_from(Integer sold_from) {
        this.sold_from = sold_from;
    }

    public Date getDateOfEmission() {
        return dateOfEmission;
    }

    public void setDateOfEmission(Date dateOfEmission) {
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
