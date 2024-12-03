package com.mycompany.model;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PurchaseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_detail_seq")
    @SequenceGenerator(name = "purchase_detail_seq", sequenceName = "PURCHASE_DETAIL_seq", allocationSize = 1)
    private int purchaseDetailId;
    private Date registrationDate;
    private int amount;
    private BigDecimal unitAmount;

    @ManyToOne
    @JoinColumn(name = "CLOTHE_id_clothe", referencedColumnName = "clotheId")
    private Clothe clothe;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_id_compra", referencedColumnName = "purchaseId")
    private Purchase purchase;

    // Getters and Setters
    public int getPurchaseDetailId() {
        return purchaseDetailId;
    }

    public void setPurchaseDetailId(int purchaseDetailId) {
        this.purchaseDetailId = purchaseDetailId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public Clothe getClothe() {
        return clothe;
    }

    public void setClothe(Clothe clothe) {
        this.clothe = clothe;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
