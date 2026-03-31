package cab_booking;

class Ride {
    int rideId;
    User user;
    Driver driver;
    double distance;
    double fare;

    Ride(int rideId, User user, Driver driver, double distance, double fare) {
        this.rideId = rideId;
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
    }

    void displayRide() {
        System.out.println("Ride ID: " + rideId +" | User: " + user.name +" | Driver: " + driver.name +" | Distance: " + distance +" | Fare: ₹" + fare);
    }
}
