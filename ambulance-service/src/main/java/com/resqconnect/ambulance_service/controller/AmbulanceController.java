package com.resqconnect.ambulance_service.controller;

import com.resqconnect.ambulance_service.entity.AmbulanceEntity;
import com.resqconnect.ambulance_service.service.AmbulanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambulances")
public class AmbulanceController {

    private final AmbulanceService ambulanceService;

    public AmbulanceController(AmbulanceService ambulanceService) {
        this.ambulanceService = ambulanceService;
    }

    // Add ambulance
    @PostMapping
    public ResponseEntity<AmbulanceEntity> addAmbulance(
            @RequestBody AmbulanceEntity ambulance) {

        AmbulanceEntity saved =
                ambulanceService.addAmbulance(ambulance);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get all ambulances
    @GetMapping
    public ResponseEntity<List<AmbulanceEntity>> getAllAmbulances() {
        return ResponseEntity.ok(
                ambulanceService.getAllAmbulances());
    }

    // Get ambulance by ID
    @GetMapping("/{id}")
    public ResponseEntity<AmbulanceEntity> getAmbulanceById(
            @PathVariable Long id) {

        return ambulanceService.getAmbulanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update ambulance
    @PutMapping("/{id}")
    public ResponseEntity<AmbulanceEntity> updateAmbulance(
            @PathVariable Long id,
            @RequestBody AmbulanceEntity ambulance) {

        try {
            return ResponseEntity.ok(
                    ambulanceService.updateAmbulance(id, ambulance));
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete ambulance
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmbulance(
            @PathVariable Long id) {

        try {
            ambulanceService.deleteAmbulance(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}