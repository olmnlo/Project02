package poolingSystem;

public abstract class Passenger {
    private String name;
    private String id;
    private Car car;
    private double trip_cost;


    public Passenger(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Passenger(String name, String id, Car car, double trip_cost) {
        this.name = name;
        this.id = id;
        this.car = car;
        this.trip_cost = trip_cost;
    }

    public abstract void reserveCar(Car car);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getTrip_cost() {
        return trip_cost;
    }

    public void setTrip_cost(double trip_cost) {
        this.trip_cost = trip_cost;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", car=" + car +
                ", trip_cost=" + trip_cost +
                '}';
    }
}
