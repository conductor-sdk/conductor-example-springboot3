package io.orkes.demo.banking.workers;

import com.netflix.conductor.sdk.workflow.task.WorkerTask;
import org.springframework.stereotype.Component;

@Component
public class ConductorWorkers {

    /**
        Note: Using this setting, up to 5 tasks will run in parallel, with tasks being polled every 200ms
     */
    @WorkerTask(value = "fraud-check", threadCount = 5, pollingInterval = 200)
    public void checkForFraudTask() {

    }

}
