package com.transit.assistant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Route {

    @Id
    private Long routeId;

    private String routeShortName;
    private String routeLongName;
    private String agencyId;

    // getters & setters
}
