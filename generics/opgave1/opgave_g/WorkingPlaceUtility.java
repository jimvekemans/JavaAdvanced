package opgave1.opgave_g;

import opgave1.Motorized;
import opgave1.Vehicle;

public class WorkingPlaceUtility {
	public static int getScore(WorkingPlace<?> workingPlace) {
		return workingPlace.getNumberOfThingsFixed();
	}
}
