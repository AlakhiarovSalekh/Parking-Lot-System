import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new ParkingSpot(1, SpotSize.SMALL));
        spots.add(new ParkingSpot(2, SpotSize.MEDIUM));
        spots.add(new ParkingSpot(3, SpotSize.LARGE));

        ParkingLot parkingLot = new ParkingLot(spots);

        parkingLot.parkVehicle(new Bike("BIKE-101"));
        parkingLot.parkVehicle(new Car("CAR-202"));

        parkingLot.displayStatus();

        parkingLot.removeVehicle("BIKE-101");
        parkingLot.displayStatus();
    }
}
