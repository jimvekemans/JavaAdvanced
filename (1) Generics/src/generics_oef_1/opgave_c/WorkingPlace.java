package generics_oef_1.opgave_c;

/* --------------------------------------------------------------------------------------------------------------------------------------
 * Pas de generieke klasse WorkingPlace aan zodat je WorkingPlace-objecten kan maken om Motorized-Vehicle-objecten te herstellen.
 * --------------------------------------------------------------------------------------------------------------------------------------
 * Wat wordt er gegeven:
 *  -> 'generieke klasse' dus moet in de header van de klasse worden ingesteld
 *  -> Het generiek type moet 'Motorized' EN 'Vehicle' zijn
 *  !!! LET OP! Als er meer dan 1 vereiste is voor het type dan eerst het object extenden en daarna alle interfaces.
 *      In dit geval is Vehicle de superklasse en wordt er ook nog de interface Motorized gebruikt.
 *      De klasse MOET ALTIJD eerst staan omdat er maximum 1 superklasse kan zijn maar er kunnen tientallen interfaces worden overgeerfd.
 */

import generics_oef_1.Motorized;
import generics_oef_1.Vehicle;

// Aan de hand van wat er gegeven is weten we dat hier het type moet ingesteld worden voor de hele klasse
// Het type moet ook 'Motorized' EN 'Vehicle' zijn dus <T extends Vehicle & Motorized> voldoet die vereiste (check polymorphism als onduidelijk is waarom)
public class WorkingPlace<T extends Vehicle & Motorized> {
    private T thingToFix;
    private int numberOfThingsFixed = 0;

    /* Het valt ook op dat hier geen contructor staat, hoe werkt dat dan?
     * Java maakt een constuctor zonder parameters aan als er zelf geen wordt aangegeven.
     * Zelf uittypen wat Java genereert zou er zoals volgt uitzien:
     *
     * public WorkingPlace(){}
     *
     * Soms wordt er geen constuctor ingesteld als
     * - er geen berekeningen moeten gebeuren tijdens aanmaken van het object
     * - alle waardes via setters worden ingesteld
     */

    public boolean isEmpty() {
        return thingToFix == null;
    }

    // T is hier gelijk aan het volledige type T (dus <T extends Vehicle & Motorized>) dat bovenaan wordt ingesteld.
    public void startFixing(T vehicle) {
        if (!isEmpty()) {
            System.out.println("Already busy.");
        } else {
            this.thingToFix = vehicle;
        }
    }

    public void finished() {
        thingToFix = null;
        numberOfThingsFixed++;
    }

    public int getNumberOfThingsFixed() {
        return numberOfThingsFixed;
    }

}
