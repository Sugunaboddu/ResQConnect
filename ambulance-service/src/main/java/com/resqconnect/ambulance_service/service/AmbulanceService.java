package com.resqconnect.ambulance_service.service;

import com.resqconnect.ambulance_service.entity.AmbulanceEntity;
import com.resqconnect.ambulance_service.repository.AmbulanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmbulanceService {

    private final AmbulanceRepository ambulanceRepository;

    public AmbulanceService(AmbulanceRepository ambulanceRepository) {
        this.ambulanceRepository = ambulanceRepository;
    }

    public AmbulanceEntity addAmbulance(AmbulanceEntity ambulance) {
        return ambulanceRepository.save(ambulance);
    }

    public List<AmbulanceEntity> getAllAmbulances() {
        return ambulanceRepository.findAll();
    }

    public Optional<AmbulanceEntity> getAmbulanceById(Long id) {
        return ambulanceRepository.findById(id);
    }

    public AmbulanceEntity updateAmbulance(
            Long id, AmbulanceEntity updatedAmbulance) {

        AmbulanceEntity existing = ambulanceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Ambulance not found: " + id));

        existing.setAmbulance(updatedAmbulance.getAmbulance());
        existing.setLocation(updatedAmbulance.getLocation());
        existing.setType(updatedAmbulance.getType());
        existing.setStatus(updatedAmbulance.getStatus());
        existing.setMedicalEquipment(
                updatedAmbulance.getMedicalEquipment());

        return ambulanceRepository.save(existing);
    }

    public void deleteAmbulance(Long id) {
        if (!ambulanceRepository.existsById(id)) {
            throw new RuntimeException("Ambulance not found: " + id);
        }

        ambulanceRepository.deleteById(id);
    }
}