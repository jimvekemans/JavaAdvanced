package opgave1.opgave_f;

import opgave1.Motorized;

public class WorkingPlaceUtility {
    public static int getScore(WorkingPlace<? extends Motorized> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
