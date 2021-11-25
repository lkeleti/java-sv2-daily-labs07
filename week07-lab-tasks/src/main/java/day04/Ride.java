package day04;

public class Ride {
    private int numberOfDay;
    private int numberOfRide;
    private int distance;

    public Ride(int numberOfDay, int numberOfRide, int distance) {
        this.numberOfDay = numberOfDay;
        this.numberOfRide = numberOfRide;
        this.distance = distance;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public int getNumberOfRide() {
        return numberOfRide;
    }

    public int getDistance() {
        return distance;
    }
}
