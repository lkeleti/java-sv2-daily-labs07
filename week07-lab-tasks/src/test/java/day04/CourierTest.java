package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void addRideOkTest() {
        Courier courier = new Courier();
        courier.addRide(new Ride(1,1,10));
        courier.addRide(new Ride(1,2,20));
        courier.addRide(new Ride(2,1,30));

        assertEquals(3, courier.getRides().size());
    }

    @Test
    void addRideBadDayTest() {
        Courier courier = new Courier();
        courier.addRide(new Ride(2, 1, 10));
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                ()-> courier.addRide(new Ride(1, 1, 20))
        );
        assertEquals("Cannot add earlier ride!", iae.getMessage());
    }

    @Test
    void addRideBadRideNumberTest() {
        Courier courier = new Courier();
        courier.addRide(new Ride(1, 1, 10));
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                ()-> courier.addRide(new Ride(2, 2, 20))
        );
        assertEquals("The first ride of the new day must start with 1!", iae.getMessage());
    }

    @Test
    void addRideBadFirstRideNumberTest() {
        Courier courier = new Courier();
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                ()-> courier.addRide(new Ride(2, 2, 20))
        );
        assertEquals("The first ride of the new day must start with 1!", iae.getMessage());
    }
}