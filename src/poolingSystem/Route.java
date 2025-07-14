package poolingSystem;

public class Route {
    private String pickup_address;
    private String destination_address;
    private double trip_price;

    public Route(){

    }

    public Route(String pickup_address, String destination_address, double trip_price) {
        this.pickup_address = pickup_address;
        this.destination_address = destination_address;
        this.trip_price = trip_price;
    }

    public String getPickup_address() {
        return pickup_address;
    }

    public void setPickup_address(String pickup_address) {
        this.pickup_address = pickup_address;
    }

    public String getDestination_address() {
        return destination_address;
    }

    public void setDestination_address(String destination_address) {
        this.destination_address = destination_address;
    }

    public double getTrip_price() {
        return trip_price;
    }

    public void setTrip_price(double trip_price) {
        this.trip_price = trip_price;
    }

    @Override
    public String toString() {
        return "Route{" +
                "pickup_address='" + pickup_address + '\'' +
                ", destination_address='" + destination_address + '\'' +
                ", trip_price=" + trip_price +
                '}';
    }
}
