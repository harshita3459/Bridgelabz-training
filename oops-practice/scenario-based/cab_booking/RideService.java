package cab_booking;
import java.util.ArrayList;
import java.util.List;

class RideService {

    private List<Ride> rides = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private int rideCounter = 1;

    // Add Driver (CREATE)
    void addDriver(Driver driver) {
        drivers.add(driver);
    }

    // Book Ride (CREATE)
    Ride bookRide(User user, double distance, FareCalculator fareCalculator)
            throws NoDriverAvailableException {
        Driver assignedDriver = null;
        for(Driver d : drivers) {
            if(d.available) {
                assignedDriver = d;
                d.available = false;
                break;
            }
        }
        if(assignedDriver == null) {
            throw new NoDriverAvailableException("No driver available at the moment!");
        }
        double fare = fareCalculator.calculateFare(distance);
        Ride ride = new Ride(rideCounter++, user, assignedDriver, distance, fare);
        rides.add(ride);
        return ride;
    }

    // View Ride History (READ)
    void showRideHistory() {
        for(Ride r : rides) {
            r.displayRide();
        }
    }

    // Cancel Ride (DELETE)
    void cancelRide(int rideId) {
        rides.removeIf(r -> r.rideId == rideId);
        System.out.println("Ride " + rideId + " cancelled.");
    }
}
