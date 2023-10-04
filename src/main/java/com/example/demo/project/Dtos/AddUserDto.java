package com.example.demo.project.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddUserDto {
    private String userName;

    private String email;

    private Integer AccountNUmber;
}
