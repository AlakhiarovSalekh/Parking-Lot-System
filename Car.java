public class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }

    @Override
    public SpotSize requiredSpotSize() {
        return SpotSize.MEDIUM;
    }
}
