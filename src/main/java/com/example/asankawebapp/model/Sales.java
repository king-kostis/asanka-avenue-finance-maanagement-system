package com.example.asankawebapp.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@Table(name="sales")
public class Sales {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="item_name")
    private String itemName;

    @Column(name="sale_date")
    private LocalDate dateOfSale = LocalDate.now();

    @Column(name="price")
    private double price;

    public Sales(int id, String itemName, double price){
        this.id = id;
        this.itemName = itemName;
        this.price = price;
    }

    public Sales() {}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public LocalDate getDateOfSale(){
        return dateOfSale;
    }

    public void setDateOfSale(LocalDate dateOfSale){
        this.dateOfSale = dateOfSale;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
