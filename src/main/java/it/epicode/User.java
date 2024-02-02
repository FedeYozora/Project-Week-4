package it.epicode;

import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private UUID id;
    private String name;
    private String surname;


    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "tickets_id")
    private Tickets tickets;

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isTicket() {
        return this.tickets != null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
