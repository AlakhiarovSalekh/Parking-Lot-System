import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;

class ParkingLotTest {

    @Test
    void shouldAllocateBikeToSmallSpot() {
        ParkingSpot smallSpot = new ParkingSpot(1, SpotSize.SMALL);
        ParkingLot parkingLot = new ParkingLot(List.of(smallSpot));
        Bike bike = new Bike("BIKE-101");

        parkingLot.parkVehicle(bike);

        assertFalse(smallSpot.isAvailable());
        assertSame(bike, smallSpot.getVehicle());
    }

    @Test
    void shouldAllocateCarToMediumSpot() {
        ParkingSpot mediumSpot = new ParkingSpot(1, SpotSize.MEDIUM);
        ParkingLot parkingLot = new ParkingLot(List.of(mediumSpot));
        Car car = new Car("CAR-202");

        parkingLot.parkVehicle(car);

        assertFalse(mediumSpot.isAvailable());
        assertSame(car, mediumSpot.getVehicle());
    }

    @Test
    void shouldChargeMinimumOneHourFeeWhenVehicleIsRemovedImmediately() {
        ParkingSpot spot = new ParkingSpot(1, SpotSize.SMALL);
        ParkingLot parkingLot = new ParkingLot(List.of(spot));
        Bike bike = new Bike("BIKE-101");

        parkingLot.parkVehicle(bike);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;
        System.setOut(new PrintStream(output));

        try {
            parkingLot.removeVehicle("BIKE-101");
        } finally {
            System.setOut(originalOutput);
        }

        String result = output.toString();

        assertTrue(result.contains("Parked Hours: 1"));
        assertTrue(result.contains("Parking Fee: ₹50.0"));
    }

    @Test
    void shouldFreeSpotWhenVehicleIsRemoved() {
        ParkingSpot spot = new ParkingSpot(1, SpotSize.SMALL);
        ParkingLot parkingLot = new ParkingLot(List.of(spot));
        Bike bike = new Bike("BIKE-101");

        parkingLot.parkVehicle(bike);
        parkingLot.removeVehicle("BIKE-101");

        assertTrue(spot.isAvailable());
        assertNull(spot.getVehicle());
        assertNull(spot.getEntryTime());
    }
}
