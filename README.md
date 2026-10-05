# Java Parking Lot System — OOP, Spot Allocation & Fees

[![Java](https://img.shields.io/badge/Java-OOP-ED8B00?logo=openjdk&logoColor=white)](https://www.java.com/)
[![Stars](https://img.shields.io/github/stars/AlakhiarovSalekh/Parking-Lot-System?style=social)](https://github.com/AlakhiarovSalekh/Parking-Lot-System/stargazers)

A console-based parking lot simulation built with Java and object-oriented design. It models vehicles, parking spot sizes, automatic allocation, entry time tracking, and time-based parking fees.

## Features

- Park and remove vehicles
- Bike and car vehicle types
- Small, medium, and large parking spots
- Automatic spot allocation based on vehicle size
- Entry-time tracking with `LocalDateTime`
- Time-based fee calculation
- Fast vehicle lookup with `HashMap`

## OOP Design

```text
Vehicle (abstract)
├── Bike
└── Car

ParkingLot
├── List<ParkingSpot>
└── HashMap<VehicleNumber, ParkingSpot>

ParkingSpot
├── SpotSize
├── Vehicle
└── EntryTime
```

The project demonstrates abstraction, inheritance, encapsulation, enums, collections, and date/time calculations.

## Repository Structure

```text
Bike.java
Car.java
Main.java
ParkingLot.java
ParkingSpot.java
SpotSize.java
Vehicle.java
VehicleType.java
```

## Run Locally

```bash
git clone https://github.com/AlakhiarovSalekh/Parking-Lot-System.git
cd Parking-Lot-System
javac *.java
java Main
```

## Parking Fee Logic

The system calculates the parking duration from the recorded entry time and applies an hourly rate, with a minimum billable duration of one hour.

## Possible Extensions

- Multi-floor parking
- Dynamic pricing
- Parking tickets
- Database persistence
- REST API
- Automated tests

## Contributing

Issues and focused pull requests are welcome for correctness, tests, documentation, and design improvements.

## More Projects by Salekh

- [University Room Booking Application](https://github.com/AlakhiarovSalekh/University-Room-Booking-Application) — Java Swing/MVC booking system.
- [Marks Manager](https://github.com/AlakhiarovSalekh/Marks-Manager) — Java marks-management app with console and GUI interfaces.
- [ATM System C++](https://github.com/AlakhiarovSalekh/ATM-System-CPP) — banking/ATM system-design implementations.

## Author

**Salekh Alakhiarov** · [GitHub](https://github.com/AlakhiarovSalekh)
