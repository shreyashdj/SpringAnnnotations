package com.example.springannotations.service;

import com.example.springannotations.dto.TransactionDTO;
import com.example.springannotations.entity.TransactionData;

public interface ITransactionService {
    TransactionData addTransaction(TransactionDTO transactionDTO);
}
