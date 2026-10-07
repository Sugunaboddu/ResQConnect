package com.resqconnect.incident_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidents")
public class IncidentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String location;
    private String severity;
    private Integer peopleAffected;
    private Boolean medicalRequired;
    private String status;
    private LocalDateTime createdTime;

    // Default constructor
    public IncidentEntity() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Integer getPeopleAffected() {
        return peopleAffected;
    }

    public void setPeopleAffected(Integer peopleAffected) {
        this.peopleAffected = peopleAffected;
    }

    public Boolean getMedicalRequired() {
        return medicalRequired;
    }

    public void setMedicalRequired(Boolean medicalRequired) {
        this.medicalRequired = medicalRequired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}