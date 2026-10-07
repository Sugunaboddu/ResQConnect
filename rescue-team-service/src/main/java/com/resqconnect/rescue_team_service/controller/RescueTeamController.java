package com.resqconnect.rescue_team_service.controller;

import com.resqconnect.rescue_team_service.entity.RescueTeamEntity;
import com.resqconnect.rescue_team_service.service.RescueTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rescue-teams")
public class RescueTeamController {

    private final RescueTeamService rescueTeamService;

    public RescueTeamController(RescueTeamService rescueTeamService) {
        this.rescueTeamService = rescueTeamService;
    }

    @PostMapping
    public ResponseEntity<RescueTeamEntity> createRescueTeam(
            @RequestBody RescueTeamEntity rescueTeam) {

        RescueTeamEntity createdTeam =
                rescueTeamService.createRescueTeam(rescueTeam);

        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }
}