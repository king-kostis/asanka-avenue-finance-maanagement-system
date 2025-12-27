package com.example.asankawebapp.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@Table(name="inventory")
public class Stocks {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product_name")
    private String productName;

    @Column(name="stock_date")
    private LocalDate stockDate = LocalDate.now();

    @Column(name="quantity")
    private int quantity;

    public Stocks(int id, String productName, int quantity){
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Stocks(){}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public LocalDate getStockDate(){
        return stockDate;
    }

    public void setStockDate(LocalDate stockDate){
        this.stockDate = stockDate;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
