package com.transit.assistant.domain;

public class Trip {

    private Long tripId;
    private Long routeId;
    private String serviceId;

    // human-facing fields (VERY IMPORTANT later)
    private String tripHeadsign;
    private String busClass;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public String getBusClass() {
        return busClass;
    }

    public void setBusClass(String busClass) {
        this.busClass = busClass;
    }
}
