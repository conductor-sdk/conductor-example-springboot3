package io.orkes.demo.banking.pojos;

import lombok.Data;

@Data
public class FraudCheckResult {
    public enum Result {
        PASS, FAIL;
    }
    private Result result;
    private String reason;
}
