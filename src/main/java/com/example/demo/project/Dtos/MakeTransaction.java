package com.example.demo.project.Dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MakeTransaction {


    private Integer SenderAccountNumber;

    private Integer ReciverAccountNUmber;
    private Integer amount;

}
