package io.orkes.demo.banking.controller;

import io.orkes.demo.banking.pojos.DepositDetail;
import io.orkes.demo.banking.service.FraudCheckService;
import io.orkes.demo.banking.service.WorkflowService;
import io.orkes.demo.banking.workers.FraudCheckResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
public class BankingApiController {

    private final FraudCheckService fraudCheckService;

    private final WorkflowService workflowService;

    @PostMapping(value = "/checkForFraud", produces = "application/json")
    public ResponseEntity<FraudCheckResult> checkForFraud(@RequestBody DepositDetail depositDetail) {
        log.info("Checking for fraud: {}", depositDetail);
        return ResponseEntity.ok(fraudCheckService.checkForFraud(depositDetail));
    }


    // docs-marker-start-1
    @PostMapping(value = "/triggerDepositFlow", produces = "application/json")
    public ResponseEntity<Map<String, Object>> triggerDepositFlow(@RequestBody DepositDetail depositDetail) {
        log.info("Starting deposit flow for: {}", depositDetail);
        return ResponseEntity.ok(workflowService.startDepositWorkflow(depositDetail));
    }

    // docs-marker-end-1

}
