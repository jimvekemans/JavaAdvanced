package generics_oefening1.opgave_g;

import generics_oefening1.Motorized;
import generics_oefening1.Vehicle;

public class WorkingPlaceUtility {
    public static <T extends Vehicle & Motorized> int getScore(WorkingPlace<T> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
