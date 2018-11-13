package oefening1.opgave_f;

import oefening1.Motorized;

public class WorkingPlaceUtility {
    public static int getScore(WorkingPlace<? extends Motorized> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
