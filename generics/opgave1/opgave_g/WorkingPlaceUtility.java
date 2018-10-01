package opgave1.opgave_g;

import opgave1.Motorized;
import opgave1.Vehicle;

public class WorkingPlaceUtility {
    public static <T extends Vehicle & Motorized> int getScore(WorkingPlace<T> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
