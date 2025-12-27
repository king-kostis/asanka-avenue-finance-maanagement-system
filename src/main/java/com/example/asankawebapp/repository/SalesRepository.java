package com.example.asankawebapp.repository;

import com.example.asankawebapp.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
