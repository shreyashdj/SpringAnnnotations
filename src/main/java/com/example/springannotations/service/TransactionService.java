package com.example.springannotations.service;

import com.example.springannotations.dto.TransactionDTO;
import com.example.springannotations.entity.PersonData;
import com.example.springannotations.entity.TransactionData;
import com.example.springannotations.exception.CustomException;
import com.example.springannotations.repository.TransactionRepository;
import com.example.springannotations.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransactionService implements ITransactionService{

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    PersonRepository personRepository;
    @Override
    public TransactionData addTransaction(TransactionDTO transactionDTO) {
        PersonData sender = personRepository.findByAcc(transactionDTO.getSenderAcc());
        if(sender == null) throw new CustomException("Check Sender Details");
        if(sender.getBalance() - transactionDTO.getAmount() > 0) {
            sender.setBalance(sender.getBalance() - transactionDTO.getAmount());
        } else {
            throw new CustomException("Low Balance");
        };

        PersonData updatedSender = new PersonData(sender);
        updatedSender.setPersonId(sender.getPersonId());
        personRepository.save(updatedSender);

        PersonData receiver = personRepository.findByAcc(transactionDTO.getReceiverAcc());
        if(receiver == null) throw new CustomException("Check Receiver Details");
        receiver.setBalance(receiver.getBalance() + transactionDTO.getAmount());

        PersonData updatedReceiver = new PersonData(receiver);
        updatedReceiver.setPersonId(receiver.getPersonId());
        personRepository.save(updatedReceiver);

        TransactionData transactionData = new TransactionData(transactionDTO);
        return transactionRepository.save(transactionData);
    }
}
