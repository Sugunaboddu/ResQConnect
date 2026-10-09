package com.resqconnect.ambulance_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AmbulanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ambulance;
    private String location;
    private String type;
    private String status;
    private String medicalEquipment;

    public AmbulanceEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(String ambulance) {
        this.ambulance = ambulance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMedicalEquipment() {
        return medicalEquipment;
    }

    public void setMedicalEquipment(String medicalEquipment) {
        this.medicalEquipment = medicalEquipment;
    }
}