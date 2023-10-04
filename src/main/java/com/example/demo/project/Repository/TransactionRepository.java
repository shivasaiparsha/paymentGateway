package com.example.demo.project.Repository;

import com.example.demo.project.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


    @Query(value="delete * from trasaction where status=false",nativeQuery = true )
  public  List<Transaction> findAllTransaction(boolean status);

}
