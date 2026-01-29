package org.lucidity.model;

public class Location {
    private final String id;
    private final double latitude;
    private final double longitude;

    public Location(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() { return id; }
    public double getLat() { return latitude; }
    public double getLon() { return longitude; }
}