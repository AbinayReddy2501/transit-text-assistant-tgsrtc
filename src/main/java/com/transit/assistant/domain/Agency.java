package com.transit.assistant.loader;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Agency {

    @Id
    private String agencyId;

    private String agencyName;
    private String agencyUrl;
    private String agencyTimezone;

    // getters & setters
    
}
