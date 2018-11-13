package oefening1.opgave_g;

import oefening1.Motorized;
import oefening1.Vehicle;

public class WorkingPlaceUtility {
    public static <T extends Vehicle & Motorized> int getScore(WorkingPlace<T> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
