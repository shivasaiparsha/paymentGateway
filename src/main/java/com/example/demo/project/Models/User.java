package com.example.demo.project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

   // User = UserId, Name, Email, AccountNumber, List<Transaction>

    @Id
    private Integer userId;

    private String userName;

    private String email;

    private Integer AccountNUmber;
    private Integer amount;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL) // bidirectional Mapping
     List<Transaction> transactionList=new ArrayList<>();
}
