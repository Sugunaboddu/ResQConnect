package com.resqconnect.incident_service.repository;


import com.resqconnect.incident_service.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {
}
