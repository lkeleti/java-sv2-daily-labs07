package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private int lastDay;
    private int lastNumberOfRide;

    private List<Ride> rides = new ArrayList<>();

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        if (validateRide(ride)) {
            rides.add(ride);
            lastDay = ride.getNumberOfDay();
            lastNumberOfRide = ride.getNumberOfRide();
        }
    }

    private boolean validateRide(Ride ride) {
        if (ride.getNumberOfDay() < lastDay) {
            throw new IllegalArgumentException("Cannot add earlier ride!");
        }
        else if (ride.getNumberOfDay() == lastDay && ride.getNumberOfRide() <= lastNumberOfRide) {
            throw new IllegalArgumentException("Cannot add earlier ride in a same day!");
        }
        return true;
    }
}
