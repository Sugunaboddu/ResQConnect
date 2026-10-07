package com.resqconnect.rescue_team_service.repository;

import com.resqconnect.rescue_team_service.entity.RescueTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RescueTeamRepository extends JpaRepository<RescueTeamEntity, Long> {
}