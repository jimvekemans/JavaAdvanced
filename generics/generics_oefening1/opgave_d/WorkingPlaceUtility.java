package generics_oefening1.opgave_d;

import generics_oefening1.Bike;

public class WorkingPlaceUtility {
    public static int getScore(WorkingPlace<? extends Bike> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
