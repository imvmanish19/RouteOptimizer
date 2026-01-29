package org.lucidity.model;

import org.lucidity.model.Location;

public class Order {
    private final Location restaurant;
    private final Location consumer;
    private final double prepTimeMinutes;

    public Order(Location restaurant, Location consumer, double prepTime) {
        this.restaurant = restaurant;
        this.consumer = consumer;
        this.prepTimeMinutes = prepTime;
    }

    public Location getRestaurant() { return restaurant; }
    public Location getConsumer() { return consumer; }
    public double getPrepTime() { return prepTimeMinutes; }
}