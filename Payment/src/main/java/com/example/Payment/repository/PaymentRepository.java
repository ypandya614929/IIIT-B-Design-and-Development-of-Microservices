package com.example.Payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Payment.entity.TransactionDetailsEntity;

@Repository
public interface PaymentRepository extends JpaRepository<TransactionDetailsEntity, Integer> {
}