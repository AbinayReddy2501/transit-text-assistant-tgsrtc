package com.transit.assistant.loader;

import com.transit.assistant.domain.Stop;
import com.transit.assistant.domain.Trip;
import com.transit.assistant.domain.Route;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class GtfsDataLoader {

    private final List<Stop> stops = new ArrayList<>();
    private final List<Route> routes = new ArrayList<>();
    private final List<Trip> trips = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        loadStops();
        loadRoutes();
        loadTrips();
        System.out.println("Stops loaded: " + stops.size());
        System.out.println("Routes loaded: " + routes.size());
        System.out.println("Trips loaded: " + trips.size());


    }
private void loadStops() {
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(
                    getClass().getResourceAsStream("/stops.txt")))) {

        String line = br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");

            // Expecting exactly 5 columns
            if (tokens.length < 5) {
                continue;
            }

            Stop stop = new Stop();
            stop.setStopId(Long.parseLong(tokens[0]));
            stop.setStopName(tokens[1]);
            stop.setStopLat(Double.parseDouble(tokens[3]));
            stop.setStopLon(Double.parseDouble(tokens[4]));

            stops.add(stop);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void loadRoutes() {
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(
                    getClass().getResourceAsStream("/routes.txt")))) {

        String line = br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");

            if (tokens.length < 4) {
                continue;
            }

            Route route = new Route();
            route.setRouteId(Long.parseLong(tokens[0]));
            route.setAgencyId(tokens[2]);
            route.setRouteShortName(tokens[3]);
            route.setRouteLongName(tokens[1]);

            routes.add(route);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void loadTrips() {
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(
                    getClass().getResourceAsStream("/trips.txt")))) {

        String line = br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");

            if (tokens.length < 3) {
                continue;
            }

            Trip trip = new Trip();
            trip.setRouteId(Long.parseLong(tokens[0]));
            trip.setServiceId(tokens[1]);
            trip.setTripId(Long.parseLong(tokens[2]));

            trips.add(trip);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public List<Stop> getStops() {
        return stops;
    }

}
