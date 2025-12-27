package com.example.asankawebapp.service;

import com.example.asankawebapp.model.Sales;
import com.example.asankawebapp.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    private static final LocalDate currentDate = LocalDate.now();
    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository){
        this.salesRepository = salesRepository;
    }

    public List<Sales> getAll(){
        List<Sales> sales = new ArrayList<>();
        sales = salesRepository.findAll();
        return sales;
    }

    public void addSale(Sales sale) {
        salesRepository.save(sale);
    }

    public void deleteSale(int saleId){
        salesRepository.deleteById(saleId);
    }

    public double totalDaily(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate salesDate = getAll().get(i).getDateOfSale();

            if(currentDate.equals(salesDate)) {
                double price = getAll().get(i).getPrice();
                total += price;
            }
        }
        return total;
    }

    public double totalMonthly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate saleDate = getAll().get(i).getDateOfSale();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, saleDate);

            if(dateInterval >= 30) {
                double price = getAll().get(i).getPrice();
                total += price;
            }
        }
        return total;
    }

    public double totalYearly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate saleDate = getAll().get(i).getDateOfSale();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, saleDate);

            if(dateInterval >= 365) {
                double price = getAll().get(i).getPrice();
                total += price;
            }
        }
        return total;
    }
}
