package org.lucidity.model;

import java.util.List;

public class RouteOptimizationResponse {
    private final double totalTimeMinutes;
    private final List<String> bestPath;

    public RouteOptimizationResponse(double totalTimeMinutes, List<String> bestPath) {
        this.totalTimeMinutes = totalTimeMinutes;
        this.bestPath = bestPath;
    }

    public double getTotalTimeMinutes() { return totalTimeMinutes; }
    public List<String> getBestPath() { return bestPath; }
}