package generics_oef_1.opgave_d;

/* -------------------------------------------------------------------------------------------------------------------
 * Zorg ervoor dat je de methode getScore uit WorkingPlaceUtility enkel kan oproepen voor WorkingPlace<Bike>-objecten.
 * -------------------------------------------------------------------------------------------------------------------
 * gegeven:
 *  - Utilityclass dus moet allemaal static methodes en variabelen bezitten
 *  - getScore methode moet generic zijn, niet de klasse
 */

import generics_oef_1.Bike;
import generics_oef_1.WorkingPlace;

public class WorkingPlaceUtility {

    /* We gebruiken hier ? in plaats T, waarom is dat?
     * - Als er geen variabele lokaal wordt opgeslagen wordt ? gebruikt
     *
     * Met T ipv ? zou het er bijvoorbeeld zo uitzien:
     *  public static <T extends Bike> int getScore(WorkingPlace<T> workingPlace){ return workingPlace.getNumberOfThingsFixed();}
    */
    public static int getScore(WorkingPlace<? extends Bike> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}
