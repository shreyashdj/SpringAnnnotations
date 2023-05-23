package com.example.springannotations.entity;

import com.example.springannotations.dto.TransactionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction_data")
public class TransactionData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trxId;
    private Integer senderAcc;
    private Integer receiverAcc;
    private Integer amount;

    public TransactionData(TransactionDTO transactionDTO) {
        this.senderAcc = transactionDTO.getSenderAcc();
        this.receiverAcc = transactionDTO.getReceiverAcc();
        this.amount = transactionDTO.getAmount();
    }
}