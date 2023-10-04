package com.example.demo.project.Services;

import com.example.demo.project.Dtos.AddUserDto;
import com.example.demo.project.Models.Transaction;
import com.example.demo.project.Models.User;
import com.example.demo.project.Repository.TransactionRepository;
import com.example.demo.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.project.Transformers.UserTransform.Convertuser;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void addUsers(AddUserDto addUserDto) throws  Exception
    {
        User user = userRepository.findById(addUserDto.getAccountNUmber()).get();

        if(user!=null)
        {
            throw new Exception("User With Bank account Allready present");
        }
        User u=Convertuser(addUserDto);
        userRepository.save(u);
    }

    public List<Transaction> getTransaction(Integer userid)
    {
        User user=userRepository.findById(userid).get();

       List<Transaction> userTransactionList=user.getTransactionList();
       List<Transaction>  userList=new ArrayList<>();

         for(Transaction transaction : userTransactionList)
         {
             if(transaction.isStatus()==true)
             {
                 userList.add(transaction);
             }
         }
         return userList;
    }

    public Integer findUser()
    {
        List<Transaction>  transactionList=transactionRepository.findAll();

       int amount=Integer.MIN_VALUE;
       Integer userid=null;

       for(Transaction transaction: transactionList)
       {
           if(transaction.getRefund()>amount)
           {
               amount=transaction.getRefund();
               userid=transaction.getUserId();
           }
       }
            return userid;

    }
}
