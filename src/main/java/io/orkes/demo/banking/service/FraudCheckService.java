package io.orkes.demo.banking.service;

import io.orkes.demo.banking.pojos.DepositDetail;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class FraudCheckService {

    public Map<String, Object> checkForFraud(DepositDetail depositDetail) {
        Map<String, Object> result = new HashMap<>();
        if(depositDetail.getAmount().compareTo(BigDecimal.valueOf(100000)) > 0) {
            result.put("fraudCheckResult", "FAIL");
            result.put("reason", "Amount too large");
        } else {
            result.put("fraudCheckResult", "PASS");
        }
        result.put("input", depositDetail);
        return result;
    }

}
