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
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_seq")
    @SequenceGenerator(name = "sale_seq", sequenceName = "SALE_seq", allocationSize = 1)
    private int saleId;
    private Date registrationDate;
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "CLOTHE_id_clothe", referencedColumnName = "clotheId")
    private Clothe clothe;

    // Getters and Setters
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Clothe getClothe() {
        return clothe;
    }

    public void setClothe(Clothe clothe) {
        this.clothe = clothe;
    }
}
