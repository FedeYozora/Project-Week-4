package it.epicode;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tessera", nullable = false)
    private UUID id_tessera;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "date_of_emission",nullable = false)
    private Date dateOfEmission;
    @Column(name = "date_of_expiration",nullable = false)
    private Date dateOfExpiration;

    @OneToOne
    @JoinColumn(name = "travel_document_id")
    private TravelDocument travelDocument;

    public Card() {
    }

    public Card(User user, Date dateOfEmission, Date dateOfExpiration, TravelDocument travelDocument) {
        this.user = user;
        this.dateOfEmission = dateOfEmission;
        this.dateOfExpiration = dateOfExpiration;
        this.travelDocument = travelDocument;
    }

    public UUID getId_tessera() {
        return id_tessera;
    }

    public void setId_tessera(UUID id_tessera) {
        this.id_tessera = id_tessera;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateOfEmission() {
        return dateOfEmission;
    }

    public void setDateOfEmission(Date dateOfEmission) {
        this.dateOfEmission = dateOfEmission;
    }

    public Date getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Date dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public TravelDocument getTravelDocument() {
        return travelDocument;
    }

    public void setTravelDocument(TravelDocument travelDocument) {
        this.travelDocument = travelDocument;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id_tessera=" + id_tessera +
                ", user=" + user +
                ", dateOfEmission=" + dateOfEmission +
                ", dateOfExpiration=" + dateOfExpiration +
                ", travelDocument=" + travelDocument +
                '}';
    }
}
