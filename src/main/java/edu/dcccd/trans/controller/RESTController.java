package edu.dcccd.trans.controller;

import edu.dcccd.trans.entity.Transaction;
import edu.dcccd.trans.service.JokeService;
import edu.dcccd.trans.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class RESTController {
    @Autowired
    private JokeService jokeService;
    @Autowired
    private TransactionServiceImpl transactionService;

    @GetMapping(value = ("/joke"))
    public String getJoke(){	// consume a REST service
        return jokeService.getJoke("Craig", "Walls");
    }

    /*@GetMapping("/transactions")
    public List<Transaction> getAll(){
        return StreamSupport.stream(transactionService.getAllTransaction().spliterator(),false)
                .collect(Collectors.toList());
    }*/
}
