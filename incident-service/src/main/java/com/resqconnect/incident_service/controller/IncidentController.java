package com.resqconnect.incident_service.controller;
import com.resqconnect.incident_service.entity.IncidentEntity;
import com.resqconnect.incident_service.service.IncidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    public ResponseEntity<IncidentEntity> createIncident(
            @RequestBody IncidentEntity incident) {

        IncidentEntity createdIncident =
                incidentService.createIncident(incident);

        return new ResponseEntity<>(
                createdIncident,
                HttpStatus.CREATED
        );
    }
}