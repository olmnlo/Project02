package poolingSystem;

import java.util.ArrayList;

public class Car {
    private String code;
    private Route route; //fixed not changeable
    private int maximum_capacity;

    public Car(String code, int maximum_capacity) {
        this.code = code;
        this.maximum_capacity = maximum_capacity;
    }

    public Car(String code, Route route, int maximum_capacity) {
        this.code = code;
        this.route = route;
        this.maximum_capacity = maximum_capacity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Route getRoute() {
        return route;
    }

    public int getMaximum_capacity() {
        return maximum_capacity;
    }

    public void setMaximum_capacity(int maximum_capacity) {
        this.maximum_capacity = maximum_capacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "code='" + code + '\'' +
                ", route=" + route +
                ", maximum_capacity=" + maximum_capacity +
                '}';
    }
}
