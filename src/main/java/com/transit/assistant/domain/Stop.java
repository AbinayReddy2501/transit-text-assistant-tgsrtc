package com.transit.assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stop {

    @Id
    private Long stopId;

    private String stopName;
    private Double stopLat;
    private Double stopLon;

    // getters & setters
}

