# Delivery Route Optimizer

### Overview
This solution calculates the optimal path for a delivery executive to handle multiple orders simultaneously. [cite_start]It addresses the challenge of minimizing total travel and wait time while respecting pickup and delivery constraints.

### Core Approach
The system uses a **Recursive Backtracking Algorithm** to explore all valid permutations of pickups and deliveries. [cite_start]It identifies the sequence that results in the absolute minimum time spent from the starting point to the final delivery[cite: 14].

### Key Assumptions
* [cite_start]**Travel Physics**: Travel time between geo-locations is calculated using the **Haversine formula** with a constant average speed of **20km/hr**[cite: 19].
* [cite_start]**Meal Preparation**: All restaurants are notified and start meal preparation immediately at the same time[cite: 16, 17].
* [cite_start]**Executive Wait Time**: If the executive arrives at a restaurant ($R_n$) before the meal preparation time ($pt_n$) is complete, they must wait until the preparation is finished[cite: 12, 13].
* [cite_start]**Logical Constraints**: A delivery ($C_n$) can only occur after the corresponding pickup ($R_n$) has been completed[cite: 14].

### Design Principles
* **Modularity**: Distance calculation, domain modeling, and route optimization are separated into distinct classes.
* [cite_start]**Encapsulation**: Domain models like `Order` and `Location` protect data integrity via private fields and public accessors.
* [cite_start]**Separation of Concerns**: The `RouteOptimizer` returns a `RouteOptimizationResponse` object, allowing the caller to decide how to display or process the results.