package generics_oef_1.opgave_g;

/* -------------------------------------------------------------------------------------------------------------------
 * Zorg ervoor dat je de methode getScore uit WorkingPlaceUtility enkel kan oproepen voor WorkingPlace objecten die Motorized Vehicle objecten herstellen.
 * -------------------------------------------------------------------------------------------------------------------
 * gegeven:
 *  - Utilityclass dus moet allemaal static methodes en variabelen bezitten
 *  - getScore methode moet generic zijn, niet de klasse
 */

import generics_oef_1.Vehicle;
import generics_oef_1.Motorized;
import generics_oef_1.WorkingPlace;

public class WorkingPlaceUtility {

    /* We gebruiken hier terug T in plaats van ?, waarom is dat?
     * - Als er meer dan 1 voorwaarde wordt ingesteld bij het generiek type is '?' niet meer toegelaten
     *
     * Je kan de volgende methode uit commentaar zetten om dit voor jezelf te testen.
     */

    //public static int getScore(WorkingPlace<? extends Vehicle & Motorized> workingPlace) { return workingPlace.getNumberOfThingsFixed(); }

    public static <T extends Vehicle & Motorized> int getScore(WorkingPlace<T> workingPlace){ return workingPlace.getNumberOfThingsFixed();}
}