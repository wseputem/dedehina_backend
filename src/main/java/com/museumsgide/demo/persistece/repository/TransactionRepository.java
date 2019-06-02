package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
