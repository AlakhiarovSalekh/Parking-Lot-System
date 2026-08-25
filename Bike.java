public class Bike extends Vehicle {

    public Bike(String vehicleNumber) {
        super(vehicleNumber, VehicleType.BIKE);
    }

    @Override
    public SpotSize requiredSpotSize() {
        return SpotSize.SMALL;
    }
}
