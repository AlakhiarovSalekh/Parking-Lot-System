import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {

    private List<ParkingSpot> spots;
    private HashMap<String, ParkingSpot> vehicleSpotMap = new HashMap<>();

    private static final double RATE_PER_HOUR = 50.0;

    public ParkingLot(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicleSpotMap.containsKey(vehicle.getVehicleNumber())) {
            System.out.println("❌ Vehicle already parked!");
            return;
        }

        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.canFitVehicle(vehicle)) {
                spot.parkVehicle(vehicle);
                vehicleSpotMap.put(vehicle.getVehicleNumber(), spot);
                System.out.println("✅ " + vehicle.getType() +
                        " parked at spot " + spot.getSpotNumber());
                return;
            }
        }
        System.out.println("❌ No suitable spot available!");
    }

    public void removeVehicle(String vehicleNumber) {
        ParkingSpot spot = vehicleSpotMap.get(vehicleNumber);

        if (spot == null) {
            System.out.println("❌ Vehicle not found!");
            return;
        }

        long hours = Duration.between(
                spot.getEntryTime(),
                java.time.LocalDateTime.now()
        ).toHours();
        hours = Math.max(1, hours); // minimum 1 hour

        double fee = hours * RATE_PER_HOUR;

        spot.removeVehicle();
        vehicleSpotMap.remove(vehicleNumber);

        System.out.println("🚗 Vehicle removed from spot " + spot.getSpotNumber());
        System.out.println("⏱ Parked Hours: " + hours);
        System.out.println("💰 Parking Fee: ₹" + fee);
    }

    public void displayStatus() {
        System.out.println("\n📊 Parking Lot Status:");
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                System.out.println("Spot " + spot.getSpotNumber() +
                        " (" + spot.getSize() + "): Empty");
            } else {
                System.out.println("Spot " + spot.getSpotNumber() +
                        " (" + spot.getSize() + "): " +
                        spot.getVehicle().getVehicleNumber());
            }
        }
    }
}
