package com.example.springannotations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Integer senderAcc;
    private Integer receiverAcc;
    private Integer amount;
}
