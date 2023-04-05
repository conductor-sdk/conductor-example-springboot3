package io.orkes.demo.banking.pojos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositDetail {

    private String accountId;
    private BigDecimal amount;

}
