package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideTest {

    Ride ride;
    @BeforeEach
    void setUp() {
        ride = new Ride(1,1,10);
    }

    @Test
    void getNumberOfDayTest() {
        assertEquals(1, ride.getNumberOfDay());
    }

    @Test
    void getNumberOfRideTest() {
        assertEquals(1, ride.getNumberOfRide());
    }

    @Test
    void getDistanceTest() {
        assertEquals(10, ride.getDistance());
    }
}