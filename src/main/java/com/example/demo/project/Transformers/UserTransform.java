package com.example.demo.project.Transformers;

import com.example.demo.project.Dtos.AddUserDto;
import com.example.demo.project.Models.User;

public class UserTransform {

    public static User Convertuser(AddUserDto addUserDto)
    {
        User user=User.builder().userName(addUserDto.getUserName()).email(addUserDto.getEmail()).AccountNUmber(addUserDto.getAccountNUmber()).build();
        return user;
    }
}
