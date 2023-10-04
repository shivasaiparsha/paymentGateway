package com.example.demo.project.Controllers;


import com.example.demo.project.Dtos.AddUserDto;
import com.example.demo.project.Models.Transaction;
import com.example.demo.project.Services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private UserServices userServices;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody AddUserDto addUserDto)
    {
        try{

            userServices.addUsers(addUserDto);
            return new ResponseEntity<>("User added successfully", HttpStatus.OK);

        }
        catch (Exception e)
        {
            log.error("user already Found");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user")

    public ResponseEntity getAll(@RequestParam("userid") Integer userid)
    {
        List<Transaction> transactionList=userServices.getTransaction(userid);
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

    @GetMapping("/user")
    public Integer findUserId()
    {
        return userServices.findUser();
    }
}
