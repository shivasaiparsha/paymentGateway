package com.example.demo.project.Models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {


//    Transaction = TransactionId, UserId, Amount, Status, AmountDeducted, Time
//            Refund = Amount, UserId,  TransactionId

    @Id
   private Integer transactionId;

    @JoinColumn
    @ManyToOne
    private Integer UserId;

    private Integer amount;
    private boolean status;
    private  boolean AmountDeducted;
     private Integer refund;

    public Transaction(boolean status, boolean AmountDeducted)
    {
        this.status=status;
        this.AmountDeducted=AmountDeducted;
    }

}
