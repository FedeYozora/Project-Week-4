package it.epicode;

import it.epicode.enums.SellerType;
import it.epicode.enums.VehicleType;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seller_id", nullable = false)
    private UUID sellerId;
    @Column(name = "type_of_seller",nullable = false)
    @Enumerated(EnumType.STRING)
    private SellerType sellerType;
    @Column(name = "selling_machine_in_service",nullable = false)
    private boolean inService;

    public Sellers() {
    }

    public Sellers(SellerType sellerType, boolean inService) {
        this.sellerType = sellerType;
        this.inService = inService;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }

    public SellerType getSellerType() {
        return sellerType;
    }

    public void setSellerType(SellerType sellerType) {
        this.sellerType = sellerType;
    }

    public boolean isInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    @Override
    public String toString() {
        return "Sellers{" +
                "sellerId=" + sellerId +
                ", sellerType=" + sellerType +
                ", inService=" + inService +
                '}';
    }
}
