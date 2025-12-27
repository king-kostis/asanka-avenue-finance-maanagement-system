package com.example.asankawebapp.service;

import com.example.asankawebapp.model.Expenses;
import com.example.asankawebapp.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpensesRepository expensesRepository;
    private static final LocalDate currentDate = LocalDate.now();

    public ExpenseService(ExpensesRepository expensesRepository){
        this.expensesRepository = expensesRepository;
    }

    public List<Expenses> getAll(){
        List<Expenses> expenses = new ArrayList<>();
        expenses = expensesRepository.findAll();
        return expenses;
    }

    public void add(Expenses expense){

        expensesRepository.save(expense);
    }

    public void delete(int expenseId){
        expensesRepository.deleteById(expenseId);
    }

    public double totalDaily(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate expenseDate = getAll().get(i).getExpenseDate();

            if(currentDate.equals(expenseDate)) {
                double price = getAll().get(i).getCost();
                total += price;
            }
        }
        return total;
    }

    public double totalMonthly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate expenseDate = getAll().get(i).getExpenseDate();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, expenseDate);

            if(dateInterval >= 30) {
                double price = getAll().get(i).getCost();
                total += price;
            }
        }
        return total;
    }

    public double totalYearly(){
        double total = 0;
        for(int i = 0; i < getAll().size(); i++){
            LocalDate expenseDate = getAll().get(i).getExpenseDate();

            long dateInterval = ChronoUnit.DAYS.between(currentDate, expenseDate);

            if(dateInterval >= 365) {
                double price = getAll().get(i).getCost();
                total += price;
            }
        }
        return total;
    }
}
