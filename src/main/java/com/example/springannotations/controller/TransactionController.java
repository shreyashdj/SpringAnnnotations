package com.example.springannotations.controller;

import com.example.springannotations.dto.ResponseDTO;
import com.example.springannotations.dto.TransactionDTO;
import com.example.springannotations.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    ITransactionService transactionService;
    @PostMapping("add")
    public ResponseEntity<ResponseDTO> addTransaction(@RequestBody TransactionDTO transactionDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Transaction Added Successfully", transactionService.addTransaction(transactionDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}