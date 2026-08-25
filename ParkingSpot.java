import java.time.LocalDateTime;

public class ParkingSpot {
    private int spotNumber;
    private SpotSize size;
    private Vehicle vehicle;
    private LocalDateTime entryTime;

    public ParkingSpot(int spotNumber, SpotSize size) {
        this.spotNumber = spotNumber;
        this.size = size;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return size.ordinal() >= vehicle.requiredSpotSize().ordinal();
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle removeVehicle() {
        Vehicle temp = vehicle;
        vehicle = null;
        entryTime = null;
        return temp;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public SpotSize getSize() {
        return size;
    }
}
