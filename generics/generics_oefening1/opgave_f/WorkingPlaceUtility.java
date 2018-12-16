package generics_oefening1.opgave_f;

import generics_oefening1.Motorized;

public class WorkingPlaceUtility {
    public static int getScore(WorkingPlace<? extends Motorized> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
