package edu.dcccd.trans.controller;

import edu.dcccd.trans.entity.Transaction;
import edu.dcccd.trans.service.JokeService;
import edu.dcccd.trans.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RESTController {

    @Autowired
    private JokeService jokeService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = ("/joke"))
    public String getJoke(){
        return jokeService.getJoke("Craig", "Walls");
    }

    @GetMapping(value = ("/download"))
    public ResponseEntity<List<Transaction>> getTrans() {
      List<Transaction> transactions = new ArrayList<>();
      transactionService.getAllTransaction().forEach(transactions :: add);
      if(!transactions.isEmpty())
          return new ResponseEntity(transactions, HttpStatus.OK);
      else
          return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
