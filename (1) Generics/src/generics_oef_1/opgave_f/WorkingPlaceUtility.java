package generics_oef_1.opgave_f;

/* -------------------------------------------------------------------------------------------------------------------
 * Zorg ervoor dat je de methode getScore uit WorkingPlaceUtility enkel kan oproepen voor WorkingPlace objecten die Motorized objecten herstellen.
 * -------------------------------------------------------------------------------------------------------------------
 * gegeven:
 *  - Utilityclass dus moet allemaal static methodes en variabelen bezitten
 *  - getScore methode moet generic zijn, niet de klasse
 */

import generics_oef_1.Motorized;
import generics_oef_1.WorkingPlace;

public class WorkingPlaceUtility {

    /* We gebruiken hier ? in plaats T, waarom is dat?
     * - Als er geen variabele lokaal wordt opgeslagen wordt ? gebruikt
     *
     * Met T ipv ? zou het er bijvoorbeeld zo uitzien:
     *  public static <T extends Motorized> int getScore(WorkingPlace<T> workingPlace){ return workingPlace.getNumberOfThingsFixed();}
     */
    public static int getScore(WorkingPlace<? extends Motorized> workingPlace) {
        return workingPlace.getNumberOfThingsFixed();
    }
}