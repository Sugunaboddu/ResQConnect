package com.resqconnect.incident_service.service;

import com.resqconnect.incident_service.entity.IncidentEntity;
import com.resqconnect.incident_service.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public IncidentEntity createIncident(IncidentEntity incident) {

        incident.setStatus("REPORTED");
        incident.setCreatedTime(LocalDateTime.now());

        return incidentRepository.save(incident);
    }
}