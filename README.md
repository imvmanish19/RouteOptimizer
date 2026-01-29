# Delivery Route Optimizer

### Approach
The solution uses a backtracking algorithm to find the absolute shortest path for a batch of N orders. It evaluates every valid permutation of pickups and deliveries while respecting the logical constraint that a pickup at a restaurant must occur before its corresponding delivery to a consumer.

### Assumptions
* **Travel Calculation**: Distances are calculated using the Haversine formula.
* **Speed**: An average speed of 20km/hr is used to determine travel time between locations.
* **Preparation Time**: All restaurants start meal preparation immediately at the same time.
* **Wait Logic**: If the executive arrives at a restaurant before the preparation time ($pt$) is complete, the total time includes the wait duration.

### Modularity
The code is organized into distinct domain models (Location, Order) and a calculation engine (RouteOptimizer) to ensure it is easy to read, maintain, and extend.