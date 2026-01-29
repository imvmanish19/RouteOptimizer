package org.lucidity;

import org.lucidity.model.Location;
import org.lucidity.model.Order;
import org.lucidity.model.RouteOptimizationResponse;
import org.lucidity.service.RouteOptimizer;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Location aman = new Location("Aman", 12.9345, 77.6101);

        Location r1 = new Location("R1", 12.9350, 77.6120);
        Location c1 = new Location("C1", 12.9380, 77.6200);
        Order order1 = new Order(r1, c1, 15.0);

        Location r2 = new Location("R2", 12.9310, 77.6150);
        Location c2 = new Location("C2", 12.9290, 77.6250);
        Order order2 = new Order(r2, c2, 10.0);

        List<Order> orders = Arrays.asList(order1, order2);

        RouteOptimizer optimizer = new RouteOptimizer();
        RouteOptimizationResponse response = optimizer.solve(aman, orders);

        System.out.println("--- Delivery Optimization Result ---");
        System.out.println("Total Time: " + String.format("%.2f", response.getTotalTimeMinutes()) + " minutes");
        System.out.println("Optimal Path: Aman -> " + String.join(" -> ", response.getBestPath()));
    }
}