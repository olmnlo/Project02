package poolingSystem;

public class NonSubscribers extends Passenger{
    private boolean discount_coupon;

    public NonSubscribers(String name, String id, Car car, boolean discount_coupon) {
        super(name, id, car, 0);
        this.discount_coupon = discount_coupon;
    }

    public NonSubscribers(String name, String id, boolean discount_coupon) {
        super(name, id);
        this.discount_coupon = discount_coupon;
    }

    @Override
    public void reserveCar(Car car) {
        if(car.getMaximum_capacity()>0) {
            setCar(car);
            if (discount_coupon) {
                double price = car.getRoute().getTrip_price();
                double after_discount = price - (0.1 * price);
                setTrip_cost(after_discount);
            } else {
                setTrip_cost(car.getRoute().getTrip_price());
                System.out.println("sorry dear not-subscriber you are not have discount.");
            }
            car.setMaximum_capacity(car.getMaximum_capacity()-1);
        }else {
            throw new RuntimeException("Sorry dear not-subscriber no capacity you cannot take this car");
        }
    }

    @Override
    public String toString() {
        return "NonSubscribers{" +
                "discount_coupon=" + discount_coupon +
                ", trip_cost=" + getTrip_cost()+
                ", "+super.toString()+
                '}';
    }
}
