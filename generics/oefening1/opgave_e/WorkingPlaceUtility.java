package oefening1.opgave_e;

import oefening1.Vehicle;

public class WorkingPlaceUtility {
    public static int getScore(WorkingPlace<? extends Vehicle> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
