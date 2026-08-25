public abstract class Vehicle {
    protected String vehicleNumber;
    protected VehicleType type;

    public Vehicle(String vehicleNumber, VehicleType type) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public abstract SpotSize requiredSpotSize();
}
