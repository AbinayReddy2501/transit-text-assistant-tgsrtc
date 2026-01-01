package com.transit.assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(StopTimeId.class)
public class StopTime {

    @Id
    private Long tripId;

    @Id
    private Integer stopSequence;

    private Long stopId;
    private String arrivalTime;
    private String departureTime;

    // getters & setters
}


