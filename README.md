# ✈️ Java Airplane Simulator

A console-based airplane system simulation developed using core Java. This semester project demonstrates **Object-Oriented Programming (OOP)**, **multithreading**, **synchronization**, and **file logging** to mimic real-time aircraft behavior such as takeoff, navigation, fuel monitoring, and landing.

---

## 🚀 Introduction

This Java-based simulator models a basic aircraft system with realistic components and behaviors. It focuses on solid OOP design patterns including **inheritance**, **composition**, and **aggregation**, and incorporates **multithreading** to simulate concurrent real-world events like **fuel consumption** and **location updates**. All key actions are **logged to a file** using a custom logger.

---

## 🎯 Objectives

- Apply OOP principles in a real-world-inspired simulation  
- Demonstrate Java multithreading and synchronization  
- Handle concurrent events safely using thread control  
- Log system activities using file handling techniques  
- Build modular, testable code architecture  

---

## 🧱 System Components & Class Structure

| Class             | Responsibility                                                                 |
|------------------|---------------------------------------------------------------------------------|
| `Vehicle`         | Superclass for all transport types with shared fields like name and capacity   |
| `Engine`          | Controls airplane engine state (start/stop)                                    |
| `FuelTank`        | Monitors and manages fuel levels with alerts and thread-safe access            |
| `Navigation`      | Tracks current and destination coordinates, with synchronized methods          |
| `Cockpit`         | Orchestrates the entire flight process, managing threads and systems           |
| `Airplane`        | Main class combining all subsystems (Engine, FuelTank, Navigation, etc.)       |
| `fuelTankThread`  | Background thread that continuously decreases fuel during flight               |
| `navThread`       | Updates current location coordinates during flight in real time                |
| `Logger`          | Writes all major actions (e.g., takeoff, low fuel alerts) to `log.txt`         |
| `Main`            | Menu-driven interface for user interaction (start/stop flight, fuel check, etc.)|

---

## ⚙️ OOP Concepts Used

- **Encapsulation:** Each component exposes only necessary data via methods  
- **Inheritance:** `Airplane` inherits from `Vehicle`  
- **Composition:** `Airplane` contains Engine, Cockpit, and FuelTank  
- **Aggregation:** `Navigation` has a reference to the `Airplane` (looser coupling)  

---

## 🧵 Multithreading & Synchronization

- **fuelTankThread:** Simulates real-time fuel consumption with periodic updates  
- **navThread:** Simulates location updates during flight  
- **Synchronization:** Critical sections are synchronized to ensure thread safety

---

## 📝 Logging

Every important action is timestamped and saved to `log.txt` using the `Logger` class:
```java
Logger.log("Plane took off from A to B");
