package io.orkes.demo.banking.workers;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FraudCheckResult {

    public enum Result {
        PASS, FAIL;
    }

    private Result result;
    private String reason;
}
