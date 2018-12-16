package generics_oefening1.opgave_a;

import generics_oefening1.Car;
import generics_oefening1.CircularSaw;
import generics_oefening1.Motorized;

public class TestWorkingPlace {
    public static void main(String[] args) {
        WorkingPlace<Car> carWorkingPlace = new WorkingPlace<>();
        //WorkingPlace<Bike> bikeWorkingPlace = new WorkingPlace<>();
        //WorkingPlace<Vehicle> vehicleWorkingPlace = new WorkingPlace<>();
        WorkingPlace<CircularSaw> otherWorkPlace = new WorkingPlace<>();
        WorkingPlace<Motorized> motorizedWorkingPlace = new WorkingPlace<>();
    }
}
