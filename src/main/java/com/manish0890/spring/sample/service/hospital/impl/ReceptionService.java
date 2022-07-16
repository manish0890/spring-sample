package com.manish0890.spring.sample.service.hospital.impl;

import com.manish0890.spring.sample.model.hospital.Patient;
import com.manish0890.spring.sample.service.hospital.Hospital;
import com.manish0890.spring.sample.service.hospital.QueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class ReceptionService implements Hospital {

    private final ConcurrentLinkedQueue<Patient> queue;

    @Autowired
    public ReceptionService(QueueService queueService) {
        queue = queueService.getPatientQueue();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionService.class);

    /**
     * Admits one patient at a time
     * Adds message in queue
     *
     * @param patient {@link Patient}
     */
    @Override
    public void admitOne(Patient patient) {
        LOGGER.info("Patient: {} request added to queue at {}", patient.getFirstName(), new Date());
        queue.offer(patient);
    }
}
