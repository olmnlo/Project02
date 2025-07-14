package poolingSystem;

public class Subscribers extends Passenger{

    public Subscribers(String name, String id, Car car) {
        super(name, id, car, 0);
    }

    public Subscribers(String name, String id) {
        super(name, id);
    }

    @Override
    public void reserveCar(Car car){
        if(car.getMaximum_capacity()>0) {
            setCar(car);
            double price = car.getRoute().getTrip_price();
            double after_discount = price - (0.5 * price);
            setTrip_cost(after_discount);
            car.setMaximum_capacity(car.getMaximum_capacity()-1);
        }else {
            throw new RuntimeException("Sorry dear subscriber no capacity you cannot take this car");
        }
    }

    @Override
    public String toString() {
        return "Subscribers{" +
                "subscribe_trip_cost=" + getTrip_cost() +
                ", "+super.toString()+
                '}';
    }
}
