package com.manish0890.spring.sample.service.hospital;

import com.manish0890.spring.sample.model.hospital.Patient;
import com.manish0890.spring.sample.persistance.document.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.*;

@Service
public class PatientConsumerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PatientConsumerService.class);

    @Value("${receptionist.count}")
    private int receptionistCount;

    @Value("${receptionist.speed.seconds}")
    private int receptionistSpeedInSeconds;

    private ExecutorService executorService;

    private final ConcurrentLinkedQueue<Patient> queue;

    @Autowired
    public PatientConsumerService(QueueService queueService) {
        queue = queueService.getPatientQueue();
    }

    @PostConstruct
    private void postConstruct() {
        executorService = Executors.newFixedThreadPool(receptionistCount);
        for (int i = 0; i < receptionistCount; i++) {
            CompletableFuture.runAsync(this::consumeMessage, executorService);
        }
    }

    /**
     * This method watches over a queue and consumes top message from queue
     */
    public void consumeMessage() {
        while (!executorService.isTerminated()) {
            if (!queue.isEmpty()) {
                Patient patient = queue.poll();
                LOGGER.info("Patient: {} has been submitted in the system at {}",
                        patient.getFirstName(), new Date());
                processPatient();
            }
        }
    }

    private void processPatient() {
        try {
            TimeUnit.SECONDS.sleep(receptionistSpeedInSeconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
