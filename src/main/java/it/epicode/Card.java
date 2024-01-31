package it.epicode;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tessera", nullable = false)
    private UUID id_tessera;
    @OneToOne(cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @Column(name = "date_of_emission", nullable = false)
    private LocalDate dateOfEmission;
    @Column(name = "date_of_expiration", nullable = false)
    private LocalDate dateOfExpiration;
    @OneToOne(cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "subscription_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TravelDocument travelDocument;

    public Card() {
    }

    public Card(User user, LocalDate dateOfEmission, TravelDocument travelDocument) {
        this.user = user;
        this.dateOfEmission = dateOfEmission;
        this.dateOfExpiration = dateOfEmission.plusDays(365);
        if (travelDocument instanceof Subscriptions) {
            this.travelDocument = travelDocument;
        } else {
            System.out.println("errore");
        }
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

    public LocalDate getDateOfEmission() {
        return dateOfEmission;
    }

    public void setDateOfEmission(LocalDate dateOfEmission) {
        this.dateOfEmission = dateOfEmission;
    }

    public LocalDate getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
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
