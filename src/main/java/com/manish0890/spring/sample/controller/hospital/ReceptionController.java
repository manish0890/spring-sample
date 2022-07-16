package com.manish0890.spring.sample.controller.hospital;

import com.manish0890.spring.sample.model.hospital.Patient;
import com.manish0890.spring.sample.service.hospital.impl.ReceptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import static com.manish0890.spring.sample.constants.RequestMappingConstants.Hospital.RECEPTION;

@RestController
@RequestMapping(RECEPTION)
@Tag(name = "REST Controller for Adding patients in the Hospital System")
public class ReceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionController.class);

    private final ReceptionService receptionService;

    @Autowired
    public ReceptionController(ReceptionService receptionService) {
        this.receptionService = receptionService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Add Patient")
    public void create(@RequestBody Patient patient) {
        Assert.notNull(patient, "Patient name cannot be null");
        Assert.isTrue(StringUtils.isNotBlank(patient.getFirstName()), "Patient name cannot be blank");

        receptionService.admitOne(patient);
        LOGGER.info("Received API Request for adding a patient: {}", patient.getFirstName());
    }
}
