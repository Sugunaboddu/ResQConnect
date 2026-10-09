package com.resqconnect.ambulance_service.repository;

import com.resqconnect.ambulance_service.entity.AmbulanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanceRepository
        extends JpaRepository<AmbulanceEntity, Long> {
}