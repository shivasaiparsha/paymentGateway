package com.example.demo.project.Services;

import com.example.demo.project.Dtos.MakeTransaction;
import com.example.demo.project.Models.Transaction;
import com.example.demo.project.Models.User;
import com.example.demo.project.Repository.TransactionRepository;
import com.example.demo.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServices {

    @Autowired
    private TransactionRepository transactionServices;

    @Autowired
    private UserRepository userRepository;

    public String makePayment(MakeTransaction makeTransaction) throws Exception
    {
        Integer sender=makeTransaction.getSenderAccountNumber();
        Integer reciver= makeTransaction.getReciverAccountNUmber();

        User usersender=userRepository.findById(sender).get();

        User reciveruser=userRepository.findById(reciver).get();

        if(reciveruser==null)
        {
            Transaction  newTransaction=new Transaction(false, true);
            throw new Exception("your transaction is failed Amount "+makeTransaction.getAmount() +" was deducted");
        }
        Transaction transaction=new Transaction(sender, makeTransaction.getAmount(), true, true, sender, 0);

      Integer amount= usersender.getAmount();
        amount-= makeTransaction.getAmount();
        usersender.setAmount(amount);
        usersender.getTransactionList().add();
        userRepository.save(usersender);

        Integer reciveamount=reciveruser.getAmount()-makeTransaction.getAmount();
        reciveruser.setAmount(reciveamount);
        userRepository.save(reciveruser);
        return "Succes";


    }

    public void deleteall()
    {
        List<Transaction> transactionList=transactionServices.findAllTransaction(false);


    }



}
