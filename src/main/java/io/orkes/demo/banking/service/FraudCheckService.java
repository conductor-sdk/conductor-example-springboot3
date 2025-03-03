package io.orkes.demo.banking.service;

import static io.orkes.demo.banking.pojos.FraudCheckResult.Result.FAIL;
import static io.orkes.demo.banking.pojos.FraudCheckResult.Result.PASS;
import io.orkes.demo.banking.pojos.DepositDetail;
import io.orkes.demo.banking.pojos.FraudCheckResult;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class FraudCheckService {
    public FraudCheckResult checkForFraud(DepositDetail depositDetail) {
        FraudCheckResult fcr = new FraudCheckResult();
        if (depositDetail.getAmount().compareTo(BigDecimal.valueOf(100_000)) > 0) {
            fcr.setResult(FAIL);
            fcr.setReason("Amount too large");
        } else {
            fcr.setResult(PASS);
            fcr.setReason("All good!");
        }
        return fcr;
    }
}
