package com.example.demo.project.Controllers;

import com.example.demo.project.Dtos.MakeTransaction;
import com.example.demo.project.Services.TransactionServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@Slf4j
public class TransactionController {

    @Autowired
    private TransactionServices transactionServices;

    @PostMapping("MakeTransaction")
    public ResponseEntity makeTransaction(@RequestBody MakeTransaction makeTransaction)
    {
        try {
           String message= transactionServices.makePayment(makeTransaction);
            return new ResponseEntity<>("Transaction Successfull", HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("transaction failed");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping ("deleteAllTransactionThat are failed")
        public String deleteALlTransaction()
        {
            transactionServices.deleteall();
            return "suuccessfully Deleted All Apis";
        }
}
