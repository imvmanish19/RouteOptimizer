package org.lucidity.service;

import org.lucidity.model.Location;
import org.lucidity.model.Order;
import org.lucidity.model.RouteOptimizationResponse;

import java.util.*;

public class RouteOptimizer {
    private static final double EARTH_RADIUS_KM = 6371.0;
    private static final double AVG_SPEED_KMH = 20.0;

    private double minTime = Double.MAX_VALUE;
    private List<String> bestPath = new ArrayList<>();

    public RouteOptimizationResponse solve(Location start, List<Order> orders) {
        backtrack(start, new ArrayList<>(), 0.0, new boolean[orders.size()], new boolean[orders.size()], orders);
        return new RouteOptimizationResponse(minTime, bestPath);
    }

    private void backtrack(Location current, List<String> path, double time,
                           boolean[] picked, boolean[] deliv, List<Order> orders) {

        if (path.size() == orders.size() * 2) {
            if (time < minTime) {
                minTime = time;
                bestPath = new ArrayList<>(path);
            }
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            if (!picked[i]) {
                double arrival = time + calculateTime(current, o.getRestaurant());
                double actualTime = Math.max(arrival, o.getPrepTime());
                picked[i] = true;
                path.add(o.getRestaurant().getId());
                backtrack(o.getRestaurant(), path, actualTime, picked, deliv, orders);
                path.removeLast();
                picked[i] = false;
            }
            if (picked[i] && !deliv[i]) {
                double arrival = time + calculateTime(current, o.getConsumer());
                deliv[i] = true;
                path.add(o.getConsumer().getId());
                backtrack(o.getConsumer(), path, arrival, picked, deliv, orders);
                path.removeLast();
                deliv[i] = false;
            }
        }
    }

    private double calculateTime(Location l1, Location l2) {
        double dLat = Math.toRadians(l2.getLat() - l1.getLat());
        double dLon = Math.toRadians(l2.getLon() - l1.getLon());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(l1.getLat())) * Math.cos(Math.toRadians(l2.getLat())) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double dist = EARTH_RADIUS_KM * (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
        return (dist / AVG_SPEED_KMH) * 60.0;
    }
}