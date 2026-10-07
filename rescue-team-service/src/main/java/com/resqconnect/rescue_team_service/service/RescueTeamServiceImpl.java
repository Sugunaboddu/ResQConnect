package com.resqconnect.rescue_team_service.service;

import com.resqconnect.rescue_team_service.entity.RescueTeamEntity;
import com.resqconnect.rescue_team_service.repository.RescueTeamRepository;
import org.springframework.stereotype.Service;

@Service
public class RescueTeamServiceImpl implements RescueTeamService {

    private final RescueTeamRepository rescueTeamRepository;

    public RescueTeamServiceImpl(RescueTeamRepository rescueTeamRepository) {
        this.rescueTeamRepository = rescueTeamRepository;
    }

    @Override
    public RescueTeamEntity createRescueTeam(RescueTeamEntity rescueTeam) {
        rescueTeam.setStatus("AVAILABLE");
        return rescueTeamRepository.save(rescueTeam);
    }
}