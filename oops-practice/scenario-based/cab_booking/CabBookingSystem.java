package cab_booking;

public class CabBookingSystem {
    public static void main(String[] args) {
        RideService service = new RideService();
        service.addDriver(new Driver("Ramesh"));
        service.addDriver(new Driver("Suresh"));
        User user1 = new User("Harshita");
        try {
            Ride r1 = service.bookRide(user1, 12, new NormalFare());
            r1.displayRide();
            Ride r2 = service.bookRide(user1, 8, new PeakFare());
            r2.displayRide();
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nRide History\n");
        service.showRideHistory();
    }
}
