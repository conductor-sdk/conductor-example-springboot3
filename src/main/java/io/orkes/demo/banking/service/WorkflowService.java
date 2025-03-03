package io.orkes.demo.banking.service;

import com.netflix.conductor.client.http.WorkflowClient;
import com.netflix.conductor.common.metadata.workflow.StartWorkflowRequest;
import io.orkes.demo.banking.pojos.DepositDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class WorkflowService {
    private final WorkflowClient workflowClient;

    public Map<String, Object> startDepositWorkflow(DepositDetail depositDetail) {
        // docs-marker-start-1
        StartWorkflowRequest request = new StartWorkflowRequest();
        request.setName("deposit_payment");
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("amount", depositDetail.getAmount());
        inputData.put("accountId", depositDetail.getAccountId());
        request.setInput(inputData);

        String workflowId = workflowClient.startWorkflow(request);
        log.info("Workflow id: {}", workflowId);

        // docs-marker-end-1
        return Map.of("workflowId", workflowId);
    }
}
