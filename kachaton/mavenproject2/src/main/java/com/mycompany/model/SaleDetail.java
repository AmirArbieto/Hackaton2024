package com.mycompany.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_detail_seq")
    @SequenceGenerator(name = "sale_detail_seq", sequenceName = "SALE_DETAIL_seq", allocationSize = 1)
    private int salesIdDetail;
    private int amount;
    private int stock;
    private BigDecimal unitAmount;

    @ManyToOne
    @JoinColumn(name = "SALE_id_venta", referencedColumnName = "saleId")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "GARMENT_id_prenda", referencedColumnName = "clotheId")
    private Clothe clothe;

    // Getters and Setters
    public int getSalesIdDetail() {
        return salesIdDetail;
    }

    public void setSalesIdDetail(int salesIdDetail) {
        this.salesIdDetail = salesIdDetail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Clothe getClothe() {
        return clothe;
    }

    public void setClothe(Clothe clothe) {
        this.clothe = clothe;
    }
}

