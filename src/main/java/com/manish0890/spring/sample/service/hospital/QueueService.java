package com.manish0890.spring.sample.service.hospital;

import com.manish0890.spring.sample.model.hospital.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class QueueService {

    /**
     * ConcurrentLinkedQueue is used for supporting concurrent access over queue
     */
    private final ConcurrentLinkedQueue<Patient> patientQueue;

    @Autowired
    public QueueService() {
        patientQueue = new ConcurrentLinkedQueue<>();
    }

    public ConcurrentLinkedQueue<Patient> getPatientQueue() {
        return patientQueue;
    }
}
