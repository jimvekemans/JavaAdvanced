package opgave1.opgave_a;

import opgave1.Car;
import opgave1.CircularSaw;
import opgave1.Motorized;

public class TestWorkingPlace {
    public static void main(String[] args) {
        WorkingPlace<Car> carWorkingPlace = new WorkingPlace<>();
        //WorkingPlace<Bike> bikeWorkingPlace = new WorkingPlace<>();
        //WorkingPlace<Vehicle> vehicleWorkingPlace = new WorkingPlace<>();
        WorkingPlace<CircularSaw> otherWorkPlace = new WorkingPlace<>();
        WorkingPlace<Motorized> motorizedWorkingPlace = new WorkingPlace<>();
    }
}
