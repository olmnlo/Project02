import poolingSystem.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();
        boolean login = false;
        users.add(new User("admin", "admin", "00000000", true));
        String username, password, id;
        username = password = id = null;
        boolean subs;
        program:
        while (true) {
            login:
            if (!login) {
                while (true) {
                    System.out.println("Welcome to our pooling system");
                    System.out.println("""
                            are you new user? chose one
                            1- log in
                            2- register
                            3- exit
                            """);
                    int user_chose = scn.nextInt();
                    switch (user_chose) {
                        case 1:
                            System.out.print("Enter username: ");
                            username = scn.next();
                            System.out.print("Enter password: ");
                            password = scn.next();
                            for (User u : users) {
                                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                                    System.out.println("welcome " + u.getUsername());
                                    login = true;
                                    break login;
                                }
                            }
                            System.out.println("you do not have account: register new account:");

                        case 2:
                            System.out.print("Enter username: ");
                            username = scn.next();
                            System.out.print("Enter password: ");
                            password = scn.next();
                            System.out.print("Enter your id: ");
                            id = scn.next();
                            System.out.println("""
                                    do you want to subscribe chose number 1/2?
                                    1- yes
                                    2- no
                                    """);
                            int s = scn.nextInt();
                            subs = s == 1;
                            if (!users.contains(new User(username, password, id, subs)) && !username.equals("admin")) {
                                users.add(new User(username, password, id, subs));
                                login = true;
                                break login;
                            } else {
                                System.out.println("you cannot register please try again");
                            }
                            break;
                        case 3:
                            System.exit(1);
                            break;

                        default:
                            System.out.println("you must chose from menu");

                    }
                }
            } else {
                System.out.println("""
                        do you want to logout? chose number
                        1- yes
                        2- no
                        """);
                int n = scn.nextInt();
                if (n == 1) {
                    login = false;
                    continue; // skip rest of loop, go back to login menu
                }

            }

            if (login) {
                Route route1 = new Route("Jeddah", "Abha", 300);
                Route route2 = new Route("Dammam", "Riyadh", 250);
                Route route3 = new Route("Dammam", "Kuwait", 200);
                Route route4 = new Route("Riyadh", "Dammam", 300);
                ArrayList<Route> routes = new ArrayList<>();
                routes.add(route1);
                routes.add(route2);
                routes.add(route3);
                routes.add(route4);

                Car car1 = new Car("0001", route1, 0);
                Car car2 = new Car("0002", route2, 4);
                Car car3 = new Car("0003", route3, 5);
                Car car4 = new Car("0004", route4, 7);
                ArrayList<Car> cars = new ArrayList<>();
                cars.add(car1);
                cars.add(car2);
                cars.add(car3);
                cars.add(car4);

                Passenger user = null;
                if (username.equals("admin") && login) {
                    ArrayList<Car> add_cars = new ArrayList<>();
                    ArrayList<Route> add_routes = new ArrayList<>();
                    admin:
                    while (true) {
                        System.out.println("""
                                chose number:
                                1- add new car
                                2- add new route
                                3- add new user
                                4- show cars info
                                5- show routes info
                                6- show users info
                                7- assign route to car
                                8- show list of passengers
                                9- log out from admin
                                """);

                        int admin_chose = scn.nextInt();
                        switch (admin_chose) {
                            case 1:
                                System.out.print("Enter car code: ");
                                String code = scn.next();
                                System.out.print("Enter car capacity");
                                int capacity = scn.nextInt();
                                System.out.println("chose one route to assign new car to: ");
                                for (int i = 0; i < routes.size(); i++) {
                                    System.out.println(i + 1 + "- " + routes.get(i));
                                }
                                int chose_route = scn.nextInt();
                                cars.add(new Car(code, routes.get(chose_route - 1), capacity));
                                break;
                            case 2:
                                System.out.print("Enter pickup address: ");
                                String pickup = scn.next();
                                System.out.print("Enter destination address: ");
                                String destination = scn.next();
                                System.out.print("Enter cost trip: ");
                                double cost = scn.nextDouble();
                                routes.add(new Route(pickup, destination, cost));
                                break;
                            case 3:
                                System.out.print("Enter username: ");
                                username = scn.next();
                                System.out.print("Enter password: ");
                                password = scn.next();
                                System.out.print("Enter user id: ");
                                id = scn.next();
                                System.out.print("is subscribe: 1: yes, 2: no ::: chose number");
                                int ad = scn.nextInt();
                                subs = ad == 1;
                                users.add(new User(username, password, id, subs));
                                break;
                            case 4:
                                System.out.println("list of cars:");
                                for (Car c : cars) {
                                    System.out.println(c);
                                }
                                break;
                            case 5:
                                System.out.println("list of routes");
                                for (Route r : routes) {
                                    System.out.println(r);
                                }
                                break;
                            case 6:
                                System.out.println("list of users");
                                for (User u : users) {
                                    System.out.println(u);
                                }
                                break;
                            case 7:
                                for (int i = 0; i < cars.size(); i++) {
                                    System.out.println(i + 1 + "- " + cars.get(i));
                                }
                                System.out.println("which car you want to assign route to? chose number");
                                int carchose = scn.nextInt();
                                for (int i = 0; i < routes.size(); i++) {
                                    System.out.println(i + 1 + "- " + routes.get(i));
                                }
                                System.out.println("which route you want to assign to your car? chose number");
                                int routechose = scn.nextInt();
                                cars.get(carchose - 1).getRoute().setDestination_address(routes.get(routechose - 1).getDestination_address());
                                cars.get(carchose - 1).getRoute().setTrip_price(routes.get(routechose - 1).getTrip_price());
                                cars.get(carchose - 1).getRoute().setPickup_address(routes.get(routechose - 1).getPickup_address());
                                System.out.println("done");
                                break;
                            case 8:
                                System.out.println("list of all passengers");
                                for (Passenger p: passengers){
                                    System.out.println(p);
                                }
                                break;
                            case 9:
                                login = false;
                                break admin;
                            default:
                                System.out.println("you must chose from menu");

                        }
                    }
                } else if (login){
                    passenger_progress:
                    while (true) {
                        int count= routes.size()+1;
                        for (int i = 0; i < routes.size(); i++) {
                            System.out.println(i+1 + "- " + routes.get(i));
                        }
                        System.out.printf("""
                                where do you want to go enter %d to exit?
                                """, count);
                        int user_chose = scn.nextInt();
                        switch (user_chose) {
                            case 1:
                                for (User u : users) {
                                    if (u.getUsername().equals(username)) {
                                        if (u.isSubs()) {
                                            user = new Subscribers(u.getUsername(), u.getId());
                                        } else {
                                            user = new NonSubscribers(u.getUsername(), u.getId(), u.isSubs());
                                        }
                                    }
                                }
                                user.reserveCar(car1);
                                break passenger_progress;
                            case 2:
                                for (User u : users) {
                                    if (u.getUsername().equals(username)) {
                                        if (u.isSubs()) {
                                            user = new Subscribers(u.getUsername(), u.getId());
                                        } else {
                                            user = new NonSubscribers(u.getUsername(), u.getId(), u.isSubs());
                                        }
                                    }
                                }
                                user.reserveCar(car2);
                                break passenger_progress;
                            case 3:
                                for (User u : users) {
                                    if (u.getUsername().equals(username)) {
                                        if (u.isSubs()) {
                                            user = new Subscribers(u.getUsername(), u.getId());
                                        } else {
                                            user = new NonSubscribers(u.getUsername(), u.getId(), u.isSubs());
                                        }
                                    }
                                }
                                user.reserveCar(car3);
                                break passenger_progress;
                            case 4:
                                for (User u : users) {
                                    if (u.getUsername().equals(username)) {
                                        if (u.isSubs()) {
                                            user = new Subscribers(u.getUsername(), u.getId());
                                        } else {
                                            user = new NonSubscribers(u.getUsername(), u.getId(), u.isSubs());
                                        }
                                    }
                                }
                                user.reserveCar(car4);
                                break passenger_progress;
                            case 5:
                                break passenger_progress;
                        }
                    }

                    passengers.add(user);
                    for (Passenger p : passengers) {
                        System.out.println(p);
                    }
                }
            }
        }




    }
}